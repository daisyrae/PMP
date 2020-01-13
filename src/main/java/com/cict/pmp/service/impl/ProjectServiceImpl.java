package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Project;
import com.cict.pmp.mapper.ProjectMapper;
import com.cict.pmp.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Resource
    private HttpSession session;

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> selectAll() {
        LambdaQueryWrapper<Project> wrapper = new QueryWrapper<Project>().lambda();
        wrapper.eq(Project::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Project selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean saveProject(Project project) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(project.getId())) {
            project.setProjectNo(generateProjectNo());
            project.setCreateEmp(emp.getUserName());
            project.setCreateTime(DateUtil.now());
        }
        project.setUpdateEmp(emp.getUserName());
        project.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(project);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public IPage<Project> pageProject(Page<Project> page, Project project) {
        LambdaQueryWrapper<Project> wrapper = new QueryWrapper<Project>().lambda();
        if (StrUtil.isNotBlank(project.getProjectNo())) {
            wrapper.like(Project::getProjectNo, project.getProjectNo());
        }
        if (StrUtil.isNotBlank(project.getProjectName())) {
            wrapper.like(Project::getProjectName, project.getProjectName());
        }
        if (ObjectUtil.isNotEmpty(project.getProjectType())) {
            wrapper.eq(Project::getProjectType, project.getProjectType());
        }
        if (ObjectUtil.isNotEmpty(project.getProjectLevel())) {
            wrapper.eq(Project::getProjectLevel, project.getProjectLevel());
        }
        if (ObjectUtil.isNotEmpty(project.getProjectStatus())) {
            wrapper.eq(Project::getProjectStatus, project.getProjectStatus());
        }
        if (StrUtil.isNotBlank(project.getProjectStartDate())) {
            wrapper.ge(Project::getProjectStartDate, project.getProjectStartDate());
        }
        if (StrUtil.isNotBlank(project.getProjectEndDate())) {
            wrapper.le(Project::getProjectEndDate, project.getProjectEndDate());
        }
        return this.page(page, wrapper);
    }

    private String generateProjectNo() {
        return String.format("%03d", Integer.parseInt(projectMapper.generateProjectNo()) + 1);
    }
}
