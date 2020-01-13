package com.cict.pmp.mapper;

import com.cict.pmp.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select IFNULL(MAX(role_no),'000') from t_role")
    String generateRoleNo();
}
