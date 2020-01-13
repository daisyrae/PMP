package com.cict.pmp.base.web;

import org.springframework.http.HttpStatus;

/**
 * 描述
 *
 * @author huyang
 * @version 1.0
 * @date 2019/12/6 15:22
 */
public class BaseController {

    /**
     * 请求成功
     *
     * @return 无返回数据
     */
    protected ApiResult success() {
        ApiResult result = new ApiResult();
        result.setCode(HttpStatus.OK.value());
        result.setMsg("请求成功");
        return result;
    }

    /**
     * 请求成功
     *
     * @param data 返回数据
     * @param <T>  数据泛型
     * @return 返回数据
     */
    @SuppressWarnings(value = {"unchecked"})
    protected <T> ApiResult success(T data) {
        ApiResult result = new ApiResult();
        result.setCode(HttpStatus.OK.value());
        result.setData(data);
        result.setMsg("请求成功");
        return result;
    }

    /**
     * 请求失败
     *
     * @param msg 失败消息
     * @return 返回失败消息
     */
    protected ApiResult fail(String msg) {
        ApiResult result = new ApiResult();
        result.setCode(HttpStatus.EXPECTATION_FAILED.value());
        result.setMsg(msg);
        return result;
    }

    /**
     * 请求失败
     *
     * @return 服务异常
     */
    protected ApiResult error() {
        ApiResult result = new ApiResult();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMsg("服务异常");
        return result;
    }
}
