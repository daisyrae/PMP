package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询所有角色
     *
     * @return 角色信息
     */
    List<Role> selectAll();

    /**
     * 主键查询角色
     *
     * @param id 主键
     * @return 角色
     */
    Role selectById(Integer id);

    /**
     * 保存角色
     *
     * @param role 角色
     * @return 标识
     */
    boolean saveRole(Role role);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询角色
     *
     * @param page 分页
     * @param role 参数
     * @return 结果集
     */
    IPage<Role> pageRole(Page<Role> page, Role role);
}
