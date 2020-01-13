package com.cict.pmp.controller;


import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.RoleMenu;
import com.cict.pmp.service.IRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色菜单表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/roleMenu")
@Api(value = "角色菜单接口", tags = {"角色菜单接口"})
@ApiSort(3)
public class RoleMenuController extends BaseController {

    @Resource
    private IRoleMenuService roleMenuService;

    @GetMapping("/selectByRoleId")
    @ApiOperation(value = "查询角色菜单")
    public ApiResult selectByRoleId(Integer roleId) {
        return success(roleMenuService.selectByRoleId(roleId));
    }

    @PostMapping("/saveRoleMenu")
    @ApiOperation(value = "保存角色菜单")
    public ApiResult saveRoleMenu(@RequestBody RoleMenu roleMenu) {
        return success(roleMenuService.saveRoleMenu(roleMenu));
    }

    @PostMapping("/saveRoleMenuList")
    @ApiOperation(value = "保存角色菜单")
    public ApiResult saveRoleMenuList(@RequestBody List<RoleMenu> roleMenuList) {
        return success(roleMenuService.saveRoleMenuList(roleMenuList));
    }

    @DeleteMapping("/deleteByRoleId")
    @ApiOperation(value = "删除角色菜单")
    public ApiResult deleteByRoleId(Integer roleId) {
        return success(roleMenuService.deleteByRoleId(roleId));
    }
}
