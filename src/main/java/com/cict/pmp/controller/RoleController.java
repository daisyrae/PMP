package com.cict.pmp.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Role;
import com.cict.pmp.service.IEmpService;
import com.cict.pmp.service.IRoleMenuService;
import com.cict.pmp.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色接口", tags = {"角色接口"})
@ApiSort(2)
public class RoleController extends BaseController {

    @Resource
    private IRoleService roleService;

    @Resource
    private IEmpService empService;

    @Resource
    private IRoleMenuService roleMenuService;

    @PostMapping("/pageRole/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询角色")
    public ApiResult pageRole(@RequestBody Role role, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Role> page = new Page<>(pageIndex, pageSize);
        return success(roleService.pageRole(page, role));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有角色")
    public ApiResult selectAll() {
        return success(roleService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询角色")
    public ApiResult selectById(Integer id) {
        return success(roleService.selectById(id));
    }

    @PostMapping("/saveRole")
    @ApiOperation(value = "保存角色")
    public ApiResult saveRole(@RequestBody Role role) {
        return success(roleService.saveRole(role));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除角色")
    public ApiResult deleteById(Integer id) {
        if (CollectionUtil.isNotEmpty(empService.selectByRoleId(id))) {
            return fail("该角色下存在用户");
        }
        roleMenuService.deleteByRoleId(id);
        return success(roleService.deleteById(id));
    }
}
