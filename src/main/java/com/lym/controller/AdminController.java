package com.lym.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.service.AdminService;
import com.lym.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liyumin
 * @date 2022/08/09 8:19
 * 管理员Controller层
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService as;

    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        //获取管理员账号
        String name = request.getParameter("name");
        //获取管理员密码
        String password = request.getParameter("password");
        boolean flag = as.verifyPassword(name, password);
        if (flag) {
            //正确
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "登录成功");
            session.setAttribute(Consts.NAME, name);
            return jsonObject;
        }
        //错误
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "用户名或密码错误");
        return jsonObject;
    }
}
