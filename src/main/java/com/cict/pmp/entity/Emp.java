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
 * 员工表
 * </p>
 *
 * @author huyang
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_emp")
@ApiModel(value="Emp对象", description="员工表")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "工号")
    private String empNo;

    @ApiModelProperty(value = "姓名")
    private String empName;

    @ApiModelProperty(value = "性别")
    private Integer empSex;

    @ApiModelProperty(value = "电话")
    private String empPhone;

    @ApiModelProperty(value = "手机")
    private String empMobile;

    @ApiModelProperty(value = "QQ号")
    private String empQq;

    @ApiModelProperty(value = "微信号")
    private String empWechat;

    @ApiModelProperty(value = "邮箱")
    private String empEmail;

    @ApiModelProperty(value = "部门id")
    private Integer orgId;

    @ApiModelProperty(value = "职位id")
    private Integer positionId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String userPwd;

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
