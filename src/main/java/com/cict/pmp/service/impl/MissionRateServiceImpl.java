package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.MissionRate;
import com.cict.pmp.mapper.MissionRateMapper;
import com.cict.pmp.service.IMissionRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 任务考评表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MissionRateServiceImpl extends ServiceImpl<MissionRateMapper, MissionRate> implements IMissionRateService {

    @Resource
    private HttpSession session;

    @Override
    public List<MissionRate> selectByMissionId(Integer missionId) {
        LambdaQueryWrapper<MissionRate> wrapper = new QueryWrapper<MissionRate>().lambda();
        wrapper.eq(MissionRate::getMissionId,missionId);
        return this.list(wrapper);
    }

    @Override
    public boolean saveMissionRate(MissionRate missionRate) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(missionRate.getId())) {
            missionRate.setCreateEmp(emp.getUserName());
            missionRate.setCreateTime(DateUtil.now());
        }
        missionRate.setUpdateEmp(emp.getUserName());
        missionRate.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(missionRate);
    }

    @Override
    public boolean deleteByMissionId(Integer missionId) {
        LambdaUpdateWrapper<MissionRate> wrapper = new UpdateWrapper<MissionRate>().lambda();
        wrapper.eq(MissionRate::getMissionId, missionId);
        return this.remove(wrapper);
    }
}
