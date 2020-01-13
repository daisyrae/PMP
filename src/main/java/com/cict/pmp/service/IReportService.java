package com.cict.pmp.service;

import com.cict.pmp.entity.Report;
import com.cict.pmp.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 汇报表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface IReportService extends IService<Report> {

    /**
     * 查询所有汇报
     *
     * @return 汇报信息
     */
    List<Report> selectAll();

    /**
     * 主键查询汇报
     *
     * @param id 主键
     * @return 汇报信息
     */
    Report selectById(Integer id);

    /**
     * 保存汇报
     *
     * @param report 汇报信息
     * @return 标识
     */
    boolean saveReport(Report report);

    /**
     * 主键删除汇报
     *
     * @param id 主键
     * @return 标识
     */
    boolean deleteById(Integer id);
}
