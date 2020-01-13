package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.mapper.EmpMapper;
import com.cict.pmp.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Resource
    private HttpSession session;

    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> selectAll() {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Emp selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public Emp selectByEmpNo(String empNo) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getEmpNo, empNo);
        return this.getOne(wrapper);
    }

    @Override
    public Emp selectByUserName(String userName) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getUserName, userName);
        return this.getOne(wrapper);
    }

    @Override
    public List<Emp> selectByOrgId(Integer orgId) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getOrgId, orgId);
        return this.list(wrapper);
    }

    @Override
    public List<Emp> selectByPositionId(Integer positionId) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getPositionId, positionId);
        return this.list(wrapper);
    }

    @Override
    public List<Emp> selectByRoleId(Integer roleId) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getRoleId, roleId);
        return this.list(wrapper);
    }

    @Override
    public boolean saveEmp(Emp emp) {
        Emp empSession = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(emp.getId())) {
            emp.setUserPwd(emp.getUserName());
            emp.setEmpNo(generateEmpNo());
            emp.setCreateEmp(empSession.getUserName());
            emp.setCreateTime(DateUtil.now());
        }
        emp.setUpdateEmp(empSession.getUserName());
        emp.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(emp);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public Emp checkEmpLogin(String userName, String userPwd) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        wrapper.eq(Emp::getUserName, userName);
        wrapper.eq(Emp::getUserPwd, userPwd);
        return this.getOne(wrapper);
    }

    @Override
    public IPage<Emp> pageEmp(Page<Emp> page, Emp emp) {
        LambdaQueryWrapper<Emp> wrapper = new QueryWrapper<Emp>().lambda();
        if (StrUtil.isNotBlank(emp.getEmpNo())) {
            wrapper.like(Emp::getEmpNo, emp.getEmpNo());
        }
        if (StrUtil.isNotBlank(emp.getEmpName())) {
            wrapper.like(Emp::getEmpName, emp.getEmpName());
        }
        if (ObjectUtil.isNotEmpty(emp.getEmpSex())) {
            wrapper.eq(Emp::getEmpSex, emp.getEmpSex());
        }
        if (ObjectUtil.isNotEmpty(emp.getOrgId())) {
            wrapper.eq(Emp::getOrgId, emp.getOrgId());
        }
        if (ObjectUtil.isNotEmpty(emp.getPositionId())) {
            wrapper.eq(Emp::getPositionId, emp.getPositionId());
        }
        return this.page(page, wrapper);
    }

    private String generateEmpNo() {
        return String.format("%03d", Integer.parseInt(empMapper.generateEmpNo()) + 1);
    }
}
