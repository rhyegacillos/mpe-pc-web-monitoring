package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.domains.HDDList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("hddPages")
@RequestMapping("pageAndSort")
public class PageAndSortController {

    @GetMapping("paging")
    public String paging(@ModelAttribute("hddPages") HDDList hddPage , Model model) {
        model.addAttribute("hddPage", hddPage.getHddPage());
        return "hdd-form-table";
    }
}
