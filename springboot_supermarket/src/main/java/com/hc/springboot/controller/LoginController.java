package com.hc.springboot.controller;

import com.hc.springboot.pojo.Userinfo;
import com.hc.springboot.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    UserinfoService userinfoService;

    /**
     * 登录
     * @param userinfo
     * @param request
     * @return
     */
    @PostMapping("login")
    public String login(Userinfo userinfo, HttpServletRequest request){
        userinfo = userinfoService.login(userinfo);
        if (userinfo!=null){
            request.getSession().setAttribute("user",userinfo);
            return "admin_index";
        }else {
            request.setAttribute("msg","登录失败！请重新登录");
            return "login";
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }


}
