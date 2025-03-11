package com.ysc.blogalone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysc.blogalone.entity.article.Blog;
import com.ysc.blogalone.entity.article.dto.BlogPageDTO;
import com.ysc.blogalone.util.R;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
public interface BlogService extends IService<Blog> {

    R addOrUpdateArticle(Blog blog);

    R getArticleById(Long blogId);

    R getList(BlogPageDTO blogPageDTO);

    R getListByUserId(Long id);

    R getListByTagId(Long userId, Long tagId);
}
