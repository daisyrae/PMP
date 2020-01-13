package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Mission;
import com.cict.pmp.mapper.MissionMapper;
import com.cict.pmp.service.IMissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MissionServiceImpl extends ServiceImpl<MissionMapper, Mission> implements IMissionService {

    @Resource
    private HttpSession session;

    @Resource
    private MissionMapper missionMapper;

    @Override
    public List<Mission> selectAll() {
        LambdaQueryWrapper<Mission> wrapper = new QueryWrapper<Mission>().lambda();
        wrapper.eq(Mission::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Mission selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean saveMission(Mission mission) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(mission.getId())) {
            mission.setMissionNo(generateMissionNo());
            mission.setCreateEmp(emp.getUserName());
            mission.setCreateTime(DateUtil.now());
        }
        mission.setUpdateEmp(emp.getUserName());
        mission.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(mission);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public IPage<Mission> pageMission(Page<Mission> page, Mission mission) {
        LambdaQueryWrapper<Mission> wrapper = new QueryWrapper<Mission>().lambda();
        if (StrUtil.isNotBlank(mission.getMissionNo())) {
            wrapper.like(Mission::getMissionNo, mission.getMissionNo());
        }
        if (ObjectUtil.isNotEmpty(mission.getMissionLevel())) {
            wrapper.eq(Mission::getMissionLevel, mission.getMissionLevel());
        }
        if (ObjectUtil.isNotEmpty(mission.getMissionStatus())) {
            wrapper.eq(Mission::getMissionStatus, mission.getMissionStatus());
        }
        if (StrUtil.isNotBlank(mission.getDutyEmp())) {
            wrapper.like(Mission::getDutyEmp, mission.getDutyEmp());
        }
        if (StrUtil.isNotBlank(mission.getDutyPlanDate())) {
            wrapper.ge(Mission::getDutyPlanDate, mission.getDutyPlanDate());
        }
        if (StrUtil.isNotBlank(mission.getDutyOverDate())) {
            wrapper.le(Mission::getDutyOverDate, mission.getDutyOverDate());
        }
        return this.page(page, wrapper);
    }

    @Override
    public List<Mission> selectByProjectId(Integer projectId) {
        LambdaQueryWrapper<Mission> wrapper = new QueryWrapper<Mission>().lambda();
        wrapper.eq(Mission::getProjectId, projectId);
        return this.list(wrapper);
    }

    private String generateMissionNo() {
        return String.format("%03d", Integer.parseInt(missionMapper.generateMissionNo()) + 1);
    }
}
