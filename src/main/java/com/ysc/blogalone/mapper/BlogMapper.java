package com.ysc.blogalone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysc.blogalone.entity.article.Blog;
import com.ysc.blogalone.entity.article.dto.BlogPageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    Page<Blog> getList(Page<Blog> page, @Param("blog") BlogPageDTO blogPageDTO);
}
