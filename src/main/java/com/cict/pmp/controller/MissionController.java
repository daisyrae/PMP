package com.cict.pmp.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Mission;
import com.cict.pmp.service.IMissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 任务表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/mission")
@Api(value = "任务接口", tags = {"任务接口"})
@ApiSort(8)
public class MissionController extends BaseController {
    
    @Resource
    private IMissionService missionService;

    @PostMapping("/pageMission/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询职位")
    public ApiResult pageMission(@RequestBody Mission mission, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Mission> page = new Page<>(pageIndex, pageSize);
        return success(missionService.pageMission(page, mission));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有任务")
    public ApiResult selectAll() {
        return success(missionService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询任务")
    public ApiResult selectById(Integer id) {
        return success(missionService.selectById(id));
    }

    @GetMapping("/selectByProjectId")
    @ApiOperation(value = "项目查询任务")
    public ApiResult selectByProjectId(Integer projectId) {
        return success(missionService.selectByProjectId(projectId));
    }

    @PostMapping("/saveMission")
    @ApiOperation(value = "保存任务")
    public ApiResult saveMission(@RequestBody Mission mission) {
        return success(missionService.saveMission(mission));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除任务")
    public ApiResult deleteById(Integer id) {
        return success(missionService.deleteById(id));
    }
}
