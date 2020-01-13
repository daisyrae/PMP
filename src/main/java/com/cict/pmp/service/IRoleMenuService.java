package com.cict.pmp.service;

import com.cict.pmp.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色菜单表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * 保存角色菜单
     *
     * @param roleMenu 角色菜单
     * @return 标识
     */
    boolean saveRoleMenu(RoleMenu roleMenu);

    /**
     * 查询角色菜单
     *
     * @param roleId 角色id
     * @return 结果集
     */
    List<RoleMenu> selectByRoleId(Integer roleId);

    /**
     * 根据角色删除角色菜单
     *
     * @param roleId 角色id
     * @return 标识
     */
    boolean deleteByRoleId(Integer roleId);

    /**
     * 保存角色菜单集合
     *
     * @param roleMenuList 角色菜单集合
     * @return 标识
     */
    boolean saveRoleMenuList(List<RoleMenu> roleMenuList);
}
