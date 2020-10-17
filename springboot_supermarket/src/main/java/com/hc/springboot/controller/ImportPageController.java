package com.hc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImportPageController {

    @RequestMapping("/top")
    public String top(){
        return "admin_top";
    }

    @RequestMapping("/left")
    public String left(){
        return "admin_left";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcomePage";
    }

}
