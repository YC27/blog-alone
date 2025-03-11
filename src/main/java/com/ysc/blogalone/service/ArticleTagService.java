package com.ysc.blogalone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysc.blogalone.entity.article.ArticleTag;
import com.ysc.blogalone.entity.article.dto.TagDto;
import com.ysc.blogalone.util.R;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yc
 * @since 2023-12-16
 */
public interface ArticleTagService extends IService<ArticleTag> {

    R getList();

    R addOrUpdateTag(TagDto tagDto);
}
