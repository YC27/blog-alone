package com.ysc.blogalone.controller;


import com.ysc.blogalone.entity.article.Blog;
import com.ysc.blogalone.entity.article.dto.BlogPageDTO;
import com.ysc.blogalone.service.BlogService;
import com.ysc.blogalone.util.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
@Api(tags = "博客文章接口")
@RestController
@RequestMapping("/blog/article")
@RequiredArgsConstructor
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/addOrUpdateArticle")
    public R addOrUpdateArticle(@RequestBody Blog blog) {
        return blogService.addOrUpdateArticle(blog);
    }

    @GetMapping("/getArticleById/{blogId}")
    public R getArticleById(@PathVariable("blogId") Long blogId) {
        return blogService.getArticleById(blogId);
    }

    @PostMapping("/getList")
    public R getList(@RequestBody BlogPageDTO blogPageDTO) {
        return blogService.getList(blogPageDTO);
    }

    @GetMapping("/getListByUserId/{userId}")
    public R getListByUserId(@PathVariable Long userId) {
        return blogService.getListByUserId(userId);
    }

    @GetMapping("/getListByTagId/{userId}/{tagId}")
    public R getListByTagId(@PathVariable("userId") Long userId, @PathVariable("tagId") Long tagId) {
        return blogService.getListByTagId(userId, tagId);
    }

    @DeleteMapping("/deleteById/{id}")
    public R deleteById(@PathVariable Long id) {
        boolean b = blogService.removeById(id);
        if ( b ) {
            return R.ok();
        }
        return R.error();
    }
}
