package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Org;
import com.cict.pmp.mapper.OrgMapper;
import com.cict.pmp.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

    @Resource
    private HttpSession session;

    @Resource
    private OrgMapper orgMapper;

    @Override
    public List<Org> selectAll() {
        LambdaQueryWrapper<Org> wrapper = new QueryWrapper<Org>().lambda();
        wrapper.eq(Org::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Org selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean saveOrg(Org org) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if (ObjectUtil.isEmpty(org.getId())) {
            org.setOrgNo(generateOrgNo());
            org.setCreateEmp(emp.getUserName());
            org.setCreateTime(DateUtil.now());
        }
        org.setUpdateEmp(emp.getUserName());
        org.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(org);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public IPage<Org> pageOrg(Page<Org> page, Org org) {
        LambdaQueryWrapper<Org> wrapper = new QueryWrapper<Org>().lambda();
        if (StrUtil.isNotBlank(org.getOrgNo())) {
            wrapper.like(Org::getOrgNo, org.getOrgNo());
        }
        if (StrUtil.isNotBlank(org.getOrgName())) {
            wrapper.like(Org::getOrgName, org.getOrgName());
        }
        if (ObjectUtil.isNotEmpty(org.getParentId())) {
            wrapper.eq(Org::getParentId, org.getParentId());
        }
        if (ObjectUtil.isNotEmpty(org.getOrgType())) {
            wrapper.eq(Org::getOrgType, org.getOrgType());
        }
        return this.page(page, wrapper);
    }

    @Override
    public List<Map<Integer, String>> getOrgTypeDict() {
        return orgMapper.getOrgTypeDict();
    }

    private String generateOrgNo() {
        return String.format("%03d", Integer.parseInt(orgMapper.generateOrgNo()) + 1);
    }
}
