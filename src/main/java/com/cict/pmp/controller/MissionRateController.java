package com.cict.pmp.controller;


import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.MissionRate;
import com.cict.pmp.service.IMissionRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 任务考评表 前端控制器
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/missionRate")
@Api(value = "任务考评接口", tags = {"任务考评接口"})
@ApiSort(9)
public class MissionRateController extends BaseController {

    @Resource
    private IMissionRateService missionRateService;

    @GetMapping("/selectByMissionId")
    @ApiOperation(value = "查询任务考评")
    public ApiResult selectByMissionId(Integer missionId) {
        return success(missionRateService.selectByMissionId(missionId));
    }

    @PostMapping("/saveMissionRate")
    @ApiOperation(value = "保存任务考评")
    public ApiResult saveMissionRate(@RequestBody MissionRate missionRate) {
        return success(missionRateService.saveMissionRate(missionRate));
    }

    @DeleteMapping("/deleteByMissionId")
    @ApiOperation(value = "删除任务考评")
    public ApiResult deleteByMissionId(Integer missionId) {
        return success(missionRateService.deleteByMissionId(missionId));
    }
}
