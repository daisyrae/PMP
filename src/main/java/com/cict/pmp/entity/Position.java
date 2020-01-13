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
 * 职位表
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_position")
@ApiModel(value="Position对象", description="职位表")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "职位编码")
    private String positionNo;

    @ApiModelProperty(value = "名称")
    private String positionName;

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
