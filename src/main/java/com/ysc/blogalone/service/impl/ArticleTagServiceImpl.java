package com.ysc.blogalone.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysc.blogalone.entity.article.ArticleTag;
import com.ysc.blogalone.entity.article.dto.TagDto;
import com.ysc.blogalone.mapper.ArticleTagMapper;
import com.ysc.blogalone.service.ArticleTagService;
import com.ysc.blogalone.util.R;
import com.ysc.blogalone.util.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yc
 * @since 2023-12-16
 */
@Service
@RequiredArgsConstructor
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    private final ArticleTagMapper articleTagMapper;

    @Override
    public R getList() {
        Long userId = UserContext.getUser();
        List<ArticleTag> articleTagList = articleTagMapper.selectList(new LambdaQueryWrapper<ArticleTag>()
                .eq(ArticleTag::getUserId, userId));
        return R.ok().data("articleTagList", articleTagList);
    }

    @Override
    public R addOrUpdateTag(TagDto tagDto) {
        ArticleTag articleTag = new ArticleTag();
        BeanUtil.copyProperties(tagDto, articleTag);
        if (ObjUtil.isEmpty(tagDto.getTagId()) ) {
            articleTagMapper.insert(articleTag);
        } else {
            articleTagMapper.updateById(articleTag);
        }
        return R.ok();
    }
}
