package com.cict.pmp.mapper;

import com.cict.pmp.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 项目表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
public interface ProjectMapper extends BaseMapper<Project> {

    @Select("select IFNULL(MAX(project_no),'000') from t_project")
    String generateProjectNo();
}
