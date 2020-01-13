package com.cict.pmp.service;

import com.cict.pmp.entity.MissionRate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务考评表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface IMissionRateService extends IService<MissionRate> {

    /**
     * 查询任务考评
     * @param missionId 任务id
     * @return 考评集合
     */
    List<MissionRate> selectByMissionId(Integer missionId);

    /**
     * 保存任务考评
     * @param missionRate 考评信息
     * @return 标识
     */
    boolean saveMissionRate(MissionRate missionRate);


    /**
     * 删除任务考评
     * @param missionId 任务id
     * @return 标识
     */
    boolean deleteByMissionId(Integer missionId);
}
