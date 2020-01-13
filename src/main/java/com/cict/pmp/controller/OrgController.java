package com.cict.pmp.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Org;
import com.cict.pmp.service.IEmpService;
import com.cict.pmp.service.IOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 组织表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/org")
@Api(value = "部门接口", tags = {"部门接口"})
@ApiSort(5)
public class OrgController extends BaseController {

    @Resource
    private IOrgService orgService;

    @Resource
    private IEmpService empService;

    @PostMapping("/pageOrg/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询部门")
    public ApiResult pageOrg(@RequestBody Org org, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Org> page = new Page<>(pageIndex, pageSize);
        return success(orgService.pageOrg(page, org));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有部门")
    public ApiResult selectAll() {
        return success(orgService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询部门")
    public ApiResult selectById(Integer id) {
        return success(orgService.selectById(id));
    }

    @PostMapping("/saveOrg")
    @ApiOperation(value = "保存部门")
    public ApiResult saveOrg(@RequestBody Org org) {
        return success(orgService.saveOrg(org));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除部门")
    public ApiResult deleteById(Integer id) {
        if(CollectionUtil.isNotEmpty(empService.selectByOrgId(id))){
            return fail("该部门下存在员工");
        }
        return success(orgService.deleteById(id));
    }

    @GetMapping("/getOrgTypeDict")
    @ApiOperation(value = "查询部门类别")
    public ApiResult getOrgTypeDict() {
        return success(orgService.getOrgTypeDict());
    }
}
