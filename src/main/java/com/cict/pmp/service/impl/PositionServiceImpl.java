package com.cict.pmp.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.entity.Position;
import com.cict.pmp.mapper.PositionMapper;
import com.cict.pmp.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cict.pmp.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 职位表 服务实现类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Resource
    private HttpSession session;

    @Resource
    private PositionMapper positionMapper;

    @Override
    public List<Position> selectAll() {
        LambdaQueryWrapper<Position> wrapper = new QueryWrapper<Position>().lambda();
        wrapper.eq(Position::getFlag, 1);
        return this.list(wrapper);
    }

    @Override
    public Position selectById(Integer id) {
        return this.getById(id);
    }

    @Override
    public boolean savePosition(Position position) {
        Emp emp = (Emp) session.getAttribute(Constant.Session.KEY);
        if(ObjectUtil.isEmpty(position.getId())){
            position.setPositionNo(generatePositionNo());
            position.setCreateEmp(emp.getUserName());
            position.setCreateTime(DateUtil.now());
        }
        position.setUpdateEmp(emp.getUserName());
        position.setUpdateTime(DateUtil.now());
        return this.saveOrUpdate(position);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.removeById(id);
    }

    @Override
    public IPage<Position> pagePosition(Page<Position> page, Position position) {
        LambdaQueryWrapper<Position> wrapper = new QueryWrapper<Position>().lambda();
        if (StrUtil.isNotBlank(position.getPositionNo())) {
            wrapper.like(Position::getPositionNo, position.getPositionNo());
        }
        if (StrUtil.isNotBlank(position.getPositionName())) {
            wrapper.like(Position::getPositionName, position.getPositionName());
        }
        return this.page(page, wrapper);
    }

    private String generatePositionNo(){
        return String.format("%03d", Integer.parseInt(positionMapper.generatePositionNo())+1);
    }
}
