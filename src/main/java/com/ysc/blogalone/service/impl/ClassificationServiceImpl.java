package com.ysc.blogalone.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysc.blogalone.entity.article.Classification;
import com.ysc.blogalone.entity.article.dto.ClassificationDto;
import com.ysc.blogalone.entity.article.dto.UpdateClassificationDTO;
import com.ysc.blogalone.exception.YscException;
import com.ysc.blogalone.mapper.ClassificationMapper;
import com.ysc.blogalone.service.ClassificationService;
import com.ysc.blogalone.util.R;
import com.ysc.blogalone.util.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification>
        implements ClassificationService {

    private final ClassificationMapper classificationMapper;

    @Override
    public R addOrUpdateClassification(ClassificationDto classificationDto) {
        Classification classification = new Classification();
        BeanUtil.copyProperties(classificationDto, classification);
        if (ObjUtil.isEmpty(classificationDto.getClassificationId()) ) {
            int i = classificationMapper.insert(classification);
            if ( i <= 0 ) {
                throw new YscException("网络错误");
            }
        } else {
            int i = classificationMapper.updateById(classification);
            if ( i <= 0 ) {
                throw new YscException("网络错误");
            }
        }
        return R.ok();
    }

    @Override
    public R getList() {
        Long userId = UserContext.getUser();
        List<Classification> classificationList = classificationMapper.selectList(new LambdaQueryWrapper<Classification>()
                .eq(Classification::getUserId, userId));
        return R.ok().data("classificationList", classificationList);
    }

    @Override
    public R getListById(Integer id) {
        List<Classification> classificationList = classificationMapper.selectList(new LambdaQueryWrapper<Classification>()
                .eq(Classification::getUserId, id));
        return R.ok().data("classificationList", classificationList);
    }

    @Override
    public R updateTitle(UpdateClassificationDTO classificationDTO) {
        Classification classification = new Classification();
        BeanUtil.copyProperties(classificationDTO, classification);
        classificationMapper.updateById(classification);
        return R.ok();
    }
}
