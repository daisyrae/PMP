package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Role;
import com.cict.pmp.mapper.RoleMapper;
import com.cict.pmp.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private HttpSession session;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        LambdaQueryWrapper<Role> wrapper = new QueryWrapper<Role>().lambda();
        wrapper.eq(Role::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Role selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean saveRole(Role role) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(role.getId())) {
            role.setRoleNo(generateRoleNo());
            role.setCreateEmp(emp.getUserName());
            role.setCreateTime(DateUtil.now());
        }
        role.setUpdateEmp(emp.getUserName());
        role.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(role);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public IPage<Role> pageRole(Page<Role> page, Role role) {
        LambdaQueryWrapper<Role> wrapper = new QueryWrapper<Role>().lambda();
        if (StrUtil.isNotBlank(role.getRoleNo())) {
            wrapper.like(Role::getRoleNo, role.getRoleNo());
        }
        if (StrUtil.isNotBlank(role.getRoleName())) {
            wrapper.like(Role::getRoleName, role.getRoleName());
        }
        return this.page(page, wrapper);
    }

    private String generateRoleNo() {
        return String.format("%03d", Integer.parseInt(roleMapper.generateRoleNo()) + 1);
    }
}
