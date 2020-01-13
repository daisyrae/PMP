package com.cict.pmp.mapper;

import com.cict.pmp.entity.Mission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 任务表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface MissionMapper extends BaseMapper<Mission> {

    @Select("select IFNULL(MAX(mission_no),'000') from t_mission")
    String generateMissionNo();
}
