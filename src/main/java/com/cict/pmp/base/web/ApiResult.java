package com.cict.pmp.base.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述
 *
 * @author huyang
 * @version 1.0
 * @date 2019/12/6 15:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="API返回对象", description="API返回对象")
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "提示")
    private String msg;
}
