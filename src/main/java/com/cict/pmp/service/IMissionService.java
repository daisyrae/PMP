package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Mission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cict.pmp.entity.Mission;

import java.util.List;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface IMissionService extends IService<Mission> {

    /**
     * 查询所有任务
     *
     * @return 任务信息
     */
    List<Mission> selectAll();

    /**
     * 主键查询任务
     *
     * @param id 主键
     * @return 任务信息
     */
    Mission selectById(Integer id);

    /**
     * 保存任务
     *
     * @param mission 任务信息
     * @return 标识
     */
    boolean saveMission(Mission mission);

    /**
     * 主键删除任务
     *
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询任务
     *
     * @param page    分页
     * @param mission 参数
     * @return 结果集
     */
    IPage<Mission> pageMission(Page<Mission> page, Mission mission);

    /**
     * 项目查询任务
     *
     * @param projectId 项目id
     * @return 结果集
     */
    List<Mission> selectByProjectId(Integer projectId);
}
