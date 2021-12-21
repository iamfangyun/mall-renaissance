package com.renaissance.admin.controller;

import com.renaissance.admin.service.CmsPrefrenceAreaService;
import com.renaissance.entity.CmsPrefrenceArea;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述
 *
 * @author weishanyuan
 * @since 2021-10-14
 */
@RestController
@Api
@RequestMapping("/prefrenceArea")
@Setter(onMethod=@__({@Autowired}))
public class CmsPrefrenceAreaController {

    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaService.listAll();
    }

}
