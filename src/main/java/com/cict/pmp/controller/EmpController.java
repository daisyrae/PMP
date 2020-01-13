package com.cict.pmp.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.service.IEmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/emp")
@Api(value = "员工接口", tags = {"员工接口"})
@ApiSort(4)
public class EmpController extends BaseController {

    @Resource
    private IEmpService empService;

    @PostMapping("/pageEmp/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询员工")
    public ApiResult pageEmp(@RequestBody Emp emp, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Emp> page = new Page<>(pageIndex, pageSize);
        return success(empService.pageEmp(page, emp));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有员工")
    public ApiResult selectAll() {
        return success(empService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询员工")
    public ApiResult selectById(Integer id) {
        return success(empService.selectById(id));
    }

    @GetMapping("/selectByEmpNo")
    @ApiOperation(value = "工号查询员工")
    public ApiResult selectByEmpNo(String empNo) {
        return success(empService.selectByEmpNo(empNo));
    }

    @GetMapping("/selectByUserName")
    @ApiOperation(value = "用户名查询员工")
    public ApiResult selectByUserName(String userName) {
        return success(empService.selectByUserName(userName));
    }

    @GetMapping("/selectByOrgId")
    @ApiOperation(value = "查询部门员工")
    public ApiResult selectByOrgId(Integer orgId) {
        return success(empService.selectByOrgId(orgId));
    }

    @GetMapping("/selectByPositionId")
    @ApiOperation(value = "职位查询员工")
    public ApiResult selectByPositionId(Integer positionId) {
        return success(empService.selectByPositionId(positionId));
    }

    @GetMapping("/selectByRoleId")
    @ApiOperation(value = "角色查询员工")
    public ApiResult selectByRoleId(Integer roleId) {
        return success(empService.selectByRoleId(roleId));
    }

    @PostMapping("/saveEmp")
    @ApiOperation(value = "保存员工")
    public ApiResult saveEmp(@RequestBody Emp emp) {
        if (ObjectUtil.isEmpty(emp.getId()) && ObjectUtil.isNotEmpty(empService.selectByUserName(emp.getUserName()))) {
            return fail("已存在用户名为：" + emp.getUserName() + " 的员工");
        }
        return success(empService.saveEmp(emp));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除员工")
    public ApiResult deleteById(Integer id) {
        return success(empService.deleteById(id));
    }
}
