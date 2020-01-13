package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IEmpService extends IService<Emp> {

    /**
     * 查询所有员工信息
     *
     * @return 全部员工集合
     */
    List<Emp> selectAll();

    /**
     * 主键查询员工
     *
     * @param id 主键id
     * @return 员工信息
     */
    Emp selectById(Integer id);

    /**
     * 工号查询员工
     *
     * @param empNo 工号
     * @return 员工信息
     */
    Emp selectByEmpNo(String empNo);

    /**
     * 登录名查询员工
     *
     * @param userName 用户名
     * @return 员工信息
     */
    Emp selectByUserName(String userName);

    /**
     * 查询部门员工
     *
     * @param orgId 部门id
     * @return 员工信息
     */
    List<Emp> selectByOrgId(Integer orgId);

    /**
     * 根据职位查询员工
     *
     * @param positionId 职位id
     * @return 员工信息
     */
    List<Emp> selectByPositionId(Integer positionId);

    /**
     * 根据角色查询员工
     *
     * @param roleId 角色id
     * @return 员工信息
     */
    List<Emp> selectByRoleId(Integer roleId);

    /**
     * 保存员工
     *
     * @param emp 员工信息
     * @return 标识
     */
    boolean saveEmp(Emp emp);

    /**
     * 主键删除员工
     *
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 校验登录
     * @param userName 用户名
     * @param userPwd 密码
     * @return 员工
     */
    Emp checkEmpLogin(String userName, String userPwd);

    /**
     * 分页查询员工
     *
     * @param page 分页
     * @param emp  参数
     * @return 结果集
     */
    IPage<Emp> pageEmp(Page<Emp> page, Emp emp);
}
