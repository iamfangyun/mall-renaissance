package com.renaissance.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.renaissance.admin.service.CmsPrefrenceAreaService;
import com.renaissance.entity.CmsPrefrenceArea;
import com.renaissance.mapper.CmsPrefrenceAreaMapper;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @author weishanyuan
 * @since 2021-10-14
 */
@Service
@RequiredArgsConstructor
@Setter(onMethod=@__({@Autowired}))
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {

    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectList(new QueryWrapper<>());
    }

}
