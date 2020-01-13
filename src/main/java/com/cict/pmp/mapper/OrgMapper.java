package com.cict.pmp.mapper;

import com.cict.pmp.entity.Org;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织表 Mapper 接口
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
public interface OrgMapper extends BaseMapper<Org> {

    @Select("select IFNULL(MAX(org_no),'000') from t_org")
    String generateOrgNo();

    @Select("select distinct (org_type) as `key`,case when org_type=0 then '公司' else CONCAT(org_type,'级部门') end as title from t_org order by org_type")
    List<Map<Integer, String>> getOrgTypeDict();
}
