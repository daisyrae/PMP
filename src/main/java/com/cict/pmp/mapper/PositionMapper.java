package com.cict.pmp.mapper;

import com.cict.pmp.entity.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 职位表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface PositionMapper extends BaseMapper<Position> {

    @Select("select IFNULL(MAX(position_no),'000') from t_position")
    String generatePositionNo();
}
