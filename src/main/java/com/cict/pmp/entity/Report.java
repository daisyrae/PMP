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
 * 汇报表
 * </p>
 *
 * @author huyang
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_report")
@ApiModel(value="Report对象", description="汇报表")
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "汇报日期")
    private String reportDate;

    @ApiModelProperty(value = "汇报对象")
    private String reportLeader;

    @ApiModelProperty(value = "类型(1-日报；2-周报；3-月报)")
    private Integer reportType;

    @ApiModelProperty(value = "主题")
    private String reportTitle;

    @ApiModelProperty(value = "内容")
    private String reportContent;

    @ApiModelProperty(value = "说明")
    private String reportDesc;

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
