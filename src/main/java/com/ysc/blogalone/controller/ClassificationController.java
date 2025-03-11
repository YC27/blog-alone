package com.ysc.blogalone.controller;


import com.ysc.blogalone.entity.article.dto.ClassificationDto;
import com.ysc.blogalone.entity.article.dto.UpdateClassificationDTO;
import com.ysc.blogalone.service.ClassificationService;
import com.ysc.blogalone.util.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "分类夹接口")
@RestController
@RequestMapping("/blog/classification")
@RequiredArgsConstructor
@CrossOrigin
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @PostMapping("/addOrUpdateClassification")
    public R addOrUpdateTag(@RequestBody ClassificationDto classificationDto) {
        return classificationService.addOrUpdateClassification(classificationDto);
    }

    @GetMapping("/getList")
    public R getList() {
        return classificationService.getList();
    }

    @GetMapping("/getListById/{id}")
    public R getListById(@PathVariable Integer id) {
        return classificationService.getListById(id);
    }

    @PutMapping("/updateTitle")
    public R updateTitle(@RequestBody UpdateClassificationDTO classificationDTO) {
        return classificationService.updateTitle(classificationDTO);
    }
}
