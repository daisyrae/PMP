package com.cict.pmp.service;

import com.cict.pmp.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询所有菜单
     * @return 菜单信息
     */
    List<Menu> selectAll();

    /**
     * 主键查询菜单
     * @param id 主键
     * @return 标识
     */
    Menu selectById(Integer id);

    /**
     * 根据角色id查询菜单
     * @param roleId 角色id
     * @return 菜单信息
     */
    List<Menu> selectByRoleId(Integer roleId);

    /**
     * 保存菜单
     * @param menu 菜单
     * @return 标识
     */
    boolean saveMenu(Menu menu);

    /**
     * 删除菜单
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);
}
