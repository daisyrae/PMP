package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface IProjectService extends IService<Project> {

    /**
     * 查询所有项目
     *
     * @return 项目信息
     */
    List<Project> selectAll();

    /**
     * 主键查询项目
     *
     * @param id 主键
     * @return 项目信息
     */
    Project selectById(Integer id);

    /**
     * 保存项目
     *
     * @param project 项目信息
     * @return 标识
     */
    boolean saveProject(Project project);

    /**
     * 主键删除项目
     *
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询项目
     *
     * @param page    分页
     * @param project 参数
     * @return 结果集
     */
    IPage<Project> pageProject(Page<Project> page, Project project);
}
