package com.cict.pmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cict.pmp.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 职位表 服务类
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface IPositionService extends IService<Position> {

    /**
     * 查询所有职位
     * @return 职位信息
     */
    List<Position> selectAll();

    /**
     * 主键查询职位
     * @param id 主键id
     * @return 职位信息
     */
    Position selectById(Integer id);

    /**
     * 保存职位
     * @param position 职位
     * @return 标识
     */
    boolean savePosition(Position position);

    /**
     * 主键删除职位
     * @param id 主键id
     * @return 标识
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询职位
     *
     * @param page 分页
     * @param position  参数
     * @return 结果集
     */
    IPage<Position> pagePosition(Page<Position> page, Position position);
}
