package com.cict.pmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cict.pmp.entity.Report;
import com.cict.pmp.mapper.ReportMapper;
import com.cict.pmp.service.IReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 汇报表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

    @Override
    public List<Report> selectAll() {
        QueryWrapper<Report> wrapper = new QueryWrapper<>();
        wrapper.eq("flag",1);
        return this.list(wrapper);
    }

    @Override
    public Report selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean saveReport(Report report) {
        return this.saveOrUpdate(report);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }
}
