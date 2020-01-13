package com.cict.pmp.controller;


import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Menu;
import com.cict.pmp.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/menu")
@Api(value = "菜单接口", tags = {"菜单接口"})
@ApiSort(1)
public class MenuController extends BaseController {

    @Resource
    private IMenuService menuService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有菜单")
    public ApiResult selectAll() {
        return success(menuService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询菜单")
    public ApiResult selectById(Integer id) {
        return success(menuService.selectById(id));
    }

    @GetMapping("/selectByRoleId")
    @ApiOperation(value = "角色查询菜单")
    public ApiResult selectByRoleId(Integer roleId) {
        return success(menuService.selectByRoleId(roleId));
    }

    @PostMapping("/saveMenu")
    @ApiOperation(value = "保存菜单")
    public ApiResult saveMenu(@RequestBody Menu menu) {
        return success(menuService.saveMenu(menu));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除菜单")
    public ApiResult deleteById(Integer id) {
        return success(menuService.deleteById(id));
    }
}
