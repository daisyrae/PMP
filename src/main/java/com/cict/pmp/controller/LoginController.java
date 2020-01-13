package com.cict.pmp.controller;

import cn.hutool.core.util.ObjectUtil;
import com.cict.pmp.base.web.ApiResult;
import com.cict.pmp.base.web.BaseController;
import com.cict.pmp.entity.Emp;
import com.cict.pmp.service.IEmpService;
import com.cict.pmp.util.Constant;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author huyang
 * @date 2019-09-24
 */
@RestController
public class LoginController extends BaseController {

    @Resource
    private IEmpService empService;

    @PostMapping("/loginCheck")
    public ApiResult loginCheck(@RequestBody Emp emp, HttpSession session) {
        Emp empLogin = empService.checkEmpLogin(emp.getUserName(), emp.getUserPwd());
        if (ObjectUtil.isEmpty(empLogin)) {
            return fail("用户名或密码错误");
        }
        session.setAttribute(Constant.Session.KEY, empLogin);
        return success(empLogin);
    }
}
