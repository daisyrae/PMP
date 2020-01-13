package com.cict.pmp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.RoleMenu;
import com.cict.pmp.mapper.RoleMenuMapper;
import com.cict.pmp.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 角色菜单表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Resource
    private HttpSession session;

    @Override
    public boolean saveRoleMenu(RoleMenu roleMenu) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(roleMenu.getId())) {
            roleMenu.setCreateEmp(emp.getUserName());
            roleMenu.setCreateTime(DateUtil.now());
        }
        roleMenu.setUpdateEmp(emp.getUserName());
        roleMenu.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(roleMenu);
    }

    @Override
    public List<RoleMenu> selectByRoleId(Integer roleId) {
        LambdaQueryWrapper<RoleMenu> wrapper = new QueryWrapper<RoleMenu>().lambda();
        wrapper.eq(RoleMenu::getRoleId, roleId);
        return this.list(wrapper);
    }

    @Override
    public boolean deleteByRoleId(Integer roleId) {
        LambdaUpdateWrapper<RoleMenu> wrapper = new UpdateWrapper<RoleMenu>().lambda();
        wrapper.eq(RoleMenu::getRoleId, roleId);
        return this.remove(wrapper);
    }

    @Override
    public boolean saveRoleMenuList(List<RoleMenu> roleMenuList) {
        if (CollectionUtil.isNotEmpty(roleMenuList)) {
            for (RoleMenu roleMenu : roleMenuList) {
                saveRoleMenu(roleMenu);
            }
        }
        return false;
    }
}
