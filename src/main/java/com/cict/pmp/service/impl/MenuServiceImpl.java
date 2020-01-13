package com.cict.pmp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Menu;
import com.cict.pmp.entity.RoleMenu;
import com.cict.pmp.mapper.MenuMapper;
import com.cict.pmp.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.service.IRoleMenuService;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private HttpSession session;

    @Resource
    private IRoleMenuService roleMenuService;

    @Override
    public List<Menu> selectAll() {
        LambdaQueryWrapper<Menu> wrapper = new QueryWrapper<Menu>().lambda();
        wrapper.eq(Menu::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Menu selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public List<Menu> selectByRoleId(Integer roleId) {
        List<RoleMenu> roleMenuList = roleMenuService.selectByRoleId(roleId);
        List<Integer> menuIds = roleMenuList.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(menuIds)) {
            LambdaQueryWrapper<Menu> wrapper = new QueryWrapper<Menu>().lambda();
            wrapper.in(Menu::getId, menuIds);
            return this.list(wrapper);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveMenu(Menu menu) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(menu.getId())) {
            menu.setCreateEmp(emp.getUserName());
            menu.setCreateTime(DateUtil.now());
        }
        menu.setUpdateEmp(emp.getUserName());
        menu.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(menu);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }
}
