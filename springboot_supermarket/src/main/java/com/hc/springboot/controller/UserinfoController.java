package com.hc.springboot.controller;


import com.hc.springboot.pojo.Supplierinfo;
import com.hc.springboot.pojo.Userinfo;
import com.hc.springboot.service.UserinfoService;
import com.hc.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
@Controller
@RequestMapping("/userinfo")
public class UserinfoController {

    @Autowired
    UserinfoService userinfoService;

    private PrintWriter out;
    private boolean flag = false;

    @GetMapping("/userinfos")
    public String list(Model model, Userinfo userinfo, Page page){
        if (page.getPageSize()==null || page.getPageSize()==0){
            page.setPageSize(5);
        }
        page.setParam(userinfo);
        model.addAttribute("userPage",userinfoService.findUserinfoPage(page));
        return "userAdmin";
    }

    @GetMapping("/user")
    public String addPage(){
        return "userAdd";
    }

    @PostMapping("/userinfo")
    @ResponseBody
    public void add(Userinfo userinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        flag = userinfoService.save(userinfo);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @GetMapping("/userinfo/{id}")
    public String updatePage(Model model,@PathVariable("id") Integer id){
        model.addAttribute("user",userinfoService.getById(id));
        return "userModify";
    }

    @PutMapping("/userinfo")
    @ResponseBody
    public void update(Userinfo userinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        int result = userinfoService.modifyUserinfo(userinfo);
        if (result > 0) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @DeleteMapping("/userinfo")
    @ResponseBody
    public void delete(Integer id, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        flag = userinfoService.removeById(id);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @GetMapping("/updatePassword")
    public String updatePwdPage(Model model, Integer id){
        model.addAttribute("user",userinfoService.getById(id));
        return "userPasswordModify";
    }



}

