package com.cict.pmp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_project")
@ApiModel(value="Project对象", description="项目表")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String projectNo;

    @ApiModelProperty(value = "名称")
    private String projectName;

    @ApiModelProperty(value = "类型")
    private Integer projectType;

    @ApiModelProperty(value = "级别")
    private Integer projectLevel;

    @ApiModelProperty(value = "描述")
    private String projectDesc;

    @ApiModelProperty(value = "状态")
    private Integer projectStatus;

    @ApiModelProperty(value = "起始日期")
    private String projectStartDate;

    @ApiModelProperty(value = "截点日期")
    private String projectEndDate;

    @ApiModelProperty(value = "创建人")
    private String createEmp;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新人")
    private String updateEmp;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "标识")
    private Integer flag;


}
