package com.ysc.blogalone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysc.blogalone.entity.article.Classification;
import com.ysc.blogalone.entity.article.dto.ClassificationDto;
import com.ysc.blogalone.entity.article.dto.UpdateClassificationDTO;
import com.ysc.blogalone.util.R;


public interface ClassificationService extends IService<Classification> {
    R addOrUpdateClassification(ClassificationDto classificationDto);

    R getList();

    R getListById(Integer id);

    R updateTitle(UpdateClassificationDTO classificationDTO);
}
