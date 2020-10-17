package com.hc.springboot.controller;


import com.hc.springboot.pojo.Supplierinfo;
import com.hc.springboot.service.SupplierinfoService;
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
@RequestMapping("/supplierinfo")
public class SupplierinfoController {
    @Autowired
    SupplierinfoService supplierinfoService;

    private PrintWriter out;
    private boolean flag = false;

    @GetMapping("/supplierinfos")
    public String list(Model model, Supplierinfo supplierinfo, Page page){
        if (page.getPageSize()==null || page.getPageSize()==0){
            page.setPageSize(5);
        }
        page.setParam(supplierinfo);
        model.addAttribute("suppPage",supplierinfoService.findSupplierinfoPage(page));
        return "providerAdmin";
    }

    @GetMapping("/supp")
    public String addPage(){
        return "providerAdd";
    }

    @PostMapping("/supplierinfo")
    @ResponseBody
    public void add(Supplierinfo supplierinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        flag = supplierinfoService.save(supplierinfo);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @GetMapping("/supplierinfo/{id}")
    public String updatePage(Model model,@PathVariable("id") Integer id){
        model.addAttribute("supp",supplierinfoService.getById(id));
        return "providerModify";
    }

    @PutMapping("/supplierinfo")
    @ResponseBody
    public void update(Supplierinfo supplierinfo, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        flag = supplierinfoService.updateById(supplierinfo);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

    @DeleteMapping("/supplierinfo")
    @ResponseBody
    public void delete(Integer id, HttpServletResponse response) throws IOException {
        out = response.getWriter();
        flag = supplierinfoService.removeById(id);
        if (flag) {
            out.print(1);
        } else {
            out.print(0);
        }
    }

}

