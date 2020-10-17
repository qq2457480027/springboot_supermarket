package com.hc.springboot.controller;


import com.hc.springboot.pojo.Billinfo;
import com.hc.springboot.service.BillinfoService;
import com.hc.springboot.service.SupplierinfoService;
import com.hc.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
@Controller
@RequestMapping("/billinfo")
public class BillinfoController {

    @Autowired
    BillinfoService billinfoService;

    @Autowired
    SupplierinfoService supplierinfoService;

    private PrintWriter out;
    private int result = 0;

    @GetMapping("/billinfos")
    public String list(Model model, Billinfo billinfo, Page page){
        if (page.getPageSize()==null || page.getPageSize()==0){
            page.setPageSize(5);
        }
        page.setParam(billinfo);
        model.addAttribute("billPage",billinfoService.findBillinfoPage(page));
        return "admin_bill_list";
    }

    @GetMapping("/bill")
    public String addPage(Model model){
        model.addAttribute("suppliers",supplierinfoService.list());
        return "add";
    }

    @PostMapping("/billinfo")
    @ResponseBody
    public void add(Billinfo billinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        billinfo.setBillDate(new Date());
        result = billinfoService.addBillinfo(billinfo);
        if (result > 0) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @GetMapping("/billinfo/{id}")
    public String updatePage(Model model,@PathVariable("id") Integer id){
        model.addAttribute("bill",billinfoService.getById(id));
        model.addAttribute("suppliers",supplierinfoService.list());
        return "modify";
    }

    @PutMapping("/billinfo")
    @ResponseBody
    public void update(Billinfo billinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        result = billinfoService.modifyBillinfo(billinfo);
        if (result > 0) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @DeleteMapping("/billinfo")
    @ResponseBody
    public void delete(Integer id, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        boolean flag = billinfoService.removeById(id);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }


}

