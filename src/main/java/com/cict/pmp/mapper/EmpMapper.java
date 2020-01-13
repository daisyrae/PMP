package com.cict.pmp.mapper;

import com.cict.pmp.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface EmpMapper extends BaseMapper<Emp> {

    @Select("select IFNULL(MAX(emp_no),'000') from t_emp")
    String generateEmpNo();
}
