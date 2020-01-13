package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IOrgService extends IService<Org> {

    /**
     * 查询所有部门
     *
     * @return 部门信息
     */
    List<Org> selectAll();

    /**
     * 主键查询部门
     *
     * @param id 主键id
     * @return 部门信息
     */
    Org selectById(Integer id);

    /**
     * 保存部门
     *
     * @param org 部门信息
     * @return 标识
     */
    boolean saveOrg(Org org);

    /**
     * 主键删除部门
     *
     * @param id 主键id
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询部门
     *
     * @param page 分页
     * @param org  参数
     * @return 结果集
     */
    IPage<Org> pageOrg(Page<Org> page, Org org);

    /**
     * 得到部门类别字典
     *
     * @return 集合
     */
    List<Map<Integer, String>> getOrgTypeDict();
}
