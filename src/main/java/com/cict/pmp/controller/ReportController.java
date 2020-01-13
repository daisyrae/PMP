package com.cict.pmp.controller;


import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Report;
import com.cict.pmp.service.IReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 汇报表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/report")
@Api(value = "汇报接口", tags = {"汇报接口"})
@ApiSort(10)
public class ReportController extends BaseController {

    @Resource
    private IReportService reportService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有汇报")
    public ApiResult selectAll() {
        return success(reportService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询汇报")
    public ApiResult selectById(Integer id) {
        return success(reportService.selectById(id));
    }

    @PostMapping("/saveReport")
    @ApiOperation(value = "保存汇报")
    public ApiResult saveReport(@RequestBody Report report) {
        return success(reportService.saveReport(report));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除汇报")
    public ApiResult deleteById(Integer id) {
        return success(reportService.deleteById(id));
    }
}
