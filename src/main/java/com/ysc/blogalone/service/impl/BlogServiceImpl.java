package com.ysc.blogalone.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysc.blogalone.entity.article.Blog;
import com.ysc.blogalone.entity.article.dto.BlogPageDTO;
import com.ysc.blogalone.entity.common.PageDTO;
import com.ysc.blogalone.exception.YscException;
import com.ysc.blogalone.mapper.BlogMapper;
import com.ysc.blogalone.service.BlogService;
import com.ysc.blogalone.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    private final BlogMapper blogMapper;

    @Override
    public R addOrUpdateArticle(Blog blog) {
        if (ObjUtil.isEmpty(blog.getBlogId()) ) {
            int i = blogMapper.insert(blog);
            if ( i <= 0 ) {
                throw new YscException("网络错误");
            }
        } else {
            int i = blogMapper.updateById(blog);
            if ( i <= 0 ) {
                throw new YscException("网络错误");
            }
        }
        return R.ok().data("blog", blog);
    }

    @Override
    public R getArticleById(Long blogId) {
        Blog blog = blogMapper.selectById(blogId);
        return R.ok().data("blog", blog);
    }

    @Override
    public R getList(BlogPageDTO blogPageDTO) {
        Page<Blog> page = new Page<>(blogPageDTO.getCurrentPage(), blogPageDTO.getSize());
        page = blogMapper.getList(page, blogPageDTO);
        PageDTO<Blog> pageDTO = new PageDTO<>();
        pageDTO.setList(page.getRecords());
        return R.ok().data("list", pageDTO).data("total", page.getTotal());
    }

    @Override
    public R getListByUserId(Long id) {
        return null;
    }

    @Override
    public R getListByTagId(Long userId, Long tagId) {
        return null;
    }
}
