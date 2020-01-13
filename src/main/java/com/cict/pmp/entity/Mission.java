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
 * 任务表
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_mission")
@ApiModel(value="Mission对象", description="任务表")
public class Mission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "项目id")
    private Integer projectId;

    @ApiModelProperty(value = "编号")
    private String missionNo;

    @ApiModelProperty(value = "优先级(1-高；2-中；3-低)")
    private Integer missionLevel;

    @ApiModelProperty(value = "主题")
    private String missionTitle;

    @ApiModelProperty(value = "内容")
    private String missionContent;

    @ApiModelProperty(value = "完成度")
    private String missionStage;

    @ApiModelProperty(value = "状态(1-未开始；2-进行中；3-已完成；4-已超期)")
    private Integer missionStatus;

    @ApiModelProperty(value = "执行人")
    private String dutyEmp;

    @ApiModelProperty(value = "预计完成时间")
    private String dutyPlanDate;

    @ApiModelProperty(value = "实际完成时间")
    private String dutyOverDate;

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
