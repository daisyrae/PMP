package com.cict.pmp.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Position;
import com.cict.pmp.service.IEmpService;
import com.cict.pmp.service.IPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 职位表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/position")
@Api(value = "职位接口", tags = {"职位接口"})
@ApiSort(6)
public class PositionController extends BaseController {

    @Resource
    private IPositionService positionService;

    @Resource
    private IEmpService empService;

    @PostMapping("/pagePosition/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询职位")
    public ApiResult pagePosition(@RequestBody Position position, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Position> page = new Page<>(pageIndex, pageSize);
        return success(positionService.pagePosition(page, position));
    }

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有职位")
    public ApiResult selectAll() {
        return success(positionService.selectAll());
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "主键查询职位")
    public ApiResult selectById(Integer id) {
        return success(positionService.selectById(id));
    }

    @PostMapping("/savePosition")
    @ApiOperation(value = "保存职位")
    public ApiResult savePosition(@RequestBody Position position) {
        return success(positionService.savePosition(position));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "主键删除职位")
    public ApiResult deleteById(Integer id) {
        if(CollectionUtil.isNotEmpty(empService.selectByPositionId(id))){
            return fail("该职位下存在员工");
        }
        return success(positionService.deleteById(id));
    }
}
