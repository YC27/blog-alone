package com.ysc.blogalone.controller;


import com.ysc.blogalone.entity.article.dto.TagDto;
import com.ysc.blogalone.service.ArticleTagService;
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
 * @since 2023-12-16
 */
@Api(tags = "文章标签接口")
@RestController
@RequestMapping("/blog/tag")
@RequiredArgsConstructor
@CrossOrigin
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    @PostMapping("/addOrUpdateTag")
    public R addOrUpdateTag(@RequestBody TagDto tagDto) {
        return articleTagService.addOrUpdateTag(tagDto);
    }

    @GetMapping("/getList")
    public R getList() {
        return articleTagService.getList();
    }
}
