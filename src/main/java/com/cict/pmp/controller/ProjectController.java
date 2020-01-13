package com.cict.pmp.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Project;
import com.cict.pmp.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/project")
@Api(value = "项目接口", tags = {"项目接口"})
@ApiSort(7)
public class ProjectController extends BaseController {

    @Resource
    private IProjectService projectService;

    @PostMapping("/pageProject/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询职位")
    public ApiResult pageProject(@RequestBody Project project, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Project> page = new Page<>(pageIndex, pageSize);
        return success(projectService.pageProject(page, project));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有项目")
    public ApiResult selectAll() {
        return success(projectService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询项目")
    public ApiResult selectById(Integer id) {
        return success(projectService.selectById(id));
    }

    @PostMapping("/saveProject")
    @ApiOperation(value = "保存项目")
    public ApiResult saveProject(@RequestBody Project project) {
        return success(projectService.saveProject(project));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除项目")
    public ApiResult deleteById(Integer id) {
        return success(projectService.deleteById(id));
    }
}
