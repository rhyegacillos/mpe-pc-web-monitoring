package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.HDDList;
import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.services.HddService;
import com.mpe.pc.webmonitoring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hdd")
public class HDDInventoryController {

    private final HddService hddService;
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public HDDInventoryController(HddService hddService, UserService userService, AuthenticationFacade authenticationFacade) {
        this.hddService = hddService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping("showForm")
    public String showForm(Model model, @ModelAttribute("hdd")Hdd hdd){

        if(hdd == null) {
            model.addAttribute("hdd", new Hdd());
        } else {
            model.addAttribute("hdd", hdd);
        }
        return "hdd-form";
    }

    @GetMapping("searchHdd")
    public String searchHdd(@RequestParam("moduleNo") String moduleNo, Model model) {

        Hdd hdd = hddService.getHdd(moduleNo);

        if(hdd == null) {
            model.addAttribute("noRecord", "No Record found! Add HDD to Inventory...");
            model.addAttribute("hdd", new Hdd());
        } else {
            model.addAttribute("hdd", hdd);
        }
        return "hdd-form";
    }

    @PostMapping("addHdd")
    public  String addHdd(@ModelAttribute("hdd") @Valid Hdd hdd, BindingResult result){

        if(hdd.getDateWithdrawn().equals(""))
            hdd.setDateWithdrawn(null);

        if(result.hasErrors()) {
            return "hdd-form";
        }


        if(hdd.getDateWithdrawn() == null)
            hdd.setFlag(1);
        else {
            if(hdd.getWithdrawnBy().equals("")) {
                result.rejectValue("withdrawnBy", "Empty.withdrawnBy");
                return "hdd-form";
            }
            if(hdd.getUseFor().equals("")) {
                result.rejectValue("useFor", "Empty.useFor");
                return "hdd-form";
            }
            if(hdd.getLineInstalled().equals("")) {
                result.rejectValue("lineInstalled", "Empty.lineInstalled");
                return "hdd-form";
            }
            if(hdd.getMac().equals("")) {
                result.rejectValue("mac", "Empty.mac");
                return "hdd-form";
            }
            if(hdd.getHddNo().equals("")) {
                result.rejectValue("hddNo", "Empty.hddNo");
                return "hdd-form";
            }
            if(hdd.getRemarks().equals("")) {
                result.rejectValue("remarks", "Empty.remarks");
                return "hdd-form";
            }
            hdd.setFlag(0);
        }
        hddService.saveHdd(hdd);

        return "redirect:hddTable";
    }

    @GetMapping("hddTable")
    public String hddTable(Model model, Pageable pageable, Sort sort){
        //String searchSelected = searchItem;
        Page<Hdd> hddPage = hddService.getAllHddRecords(1,pageable);
        Long totalHdd = hddPage.getTotalElements();
        HDDList hddPages = new HDDList();
        hddPages.setHddPage(hddPage);

        model.addAttribute("hddPage", hddPage);
        model.addAttribute("totalHdd", totalHdd);

        return "hdd-spare-table";
    }

    @GetMapping("withdrawalTable")
    public String withdrawalTable(Model model, Pageable pageable, Sort sort){
        //String searchSelected = searchItem;
        Page<Hdd> hddPage = hddService.getAllHddRecords(0,pageable);
        Long totalHdd = hddPage.getTotalElements();
        HDDList hddPages = new HDDList();
        hddPages.setHddPage(hddPage);

        model.addAttribute("hddPage", hddPage);
        model.addAttribute("totalHdd", totalHdd);

        return "hdd-withdrawal-table";
    }

    @GetMapping("downloadSpares")
    public String download(Model model) {
        model.addAttribute("hddList", hddService.getHddList(1));

        return "hddInventoryExcelView";
    }

    @GetMapping("downloadWithdrawals")
    public String downloadWithdrawals(Model model) {
        model.addAttribute("hddList", hddService.getHddList(0));

        return "hddInventoryExcelView";
    }

    @GetMapping("/{moduleNo}")
    public String updateHdd(@PathVariable("moduleNo") Hdd hdd, final RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("hdd", hdd);
        return "redirect:showForm";
    }

    @GetMapping("/{moduleNo}/delete")
    public String deleteHdd(@PathVariable("moduleNo") Hdd hdd){

        hddService.deleteHdd(hdd);
        return "redirect:/hdd/withdrawalTable";
    }


    @ModelAttribute
    public void loginDetails(Model model, final RedirectAttributes redirectAttributes) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
        redirectAttributes.addFlashAttribute("userLoginDetails", userLoginDetails);
    }

    @ModelAttribute
    public void dropdownLists(Model model) {

        List<String> hddSize = new ArrayList<String>();
        hddSize.add("2.5 HDD");
        hddSize.add("3.5 HDD");

        List<String> searchOptions = new ArrayList<String>();
        searchOptions.add("ALL");
        searchOptions.add("SPARE ONLY");
        searchOptions.add("WITHDRAWALS ONLY");

        model.addAttribute("searchItems", searchOptions);
        model.addAttribute("hddSize", hddSize);
    }
}
