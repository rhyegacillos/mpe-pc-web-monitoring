package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.PCRepair;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.services.PCRepairService;
import com.mpe.pc.webmonitoring.services.PCSpareService;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("pcRepair")
public class PCRepairController {

    UserService userService;
    AuthenticationFacade authenticationFacade;
    PCRepairService pcRepairService;
    PCSpareService pcSpareService;

    @Autowired
    public PCRepairController(UserService userService, AuthenticationFacade authenticationFacade, PCRepairService pcRepairService, PCSpareService pcSpareService) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
        this.pcRepairService = pcRepairService;
        this.pcSpareService = pcSpareService;
    }

    @RequestMapping("showForm")
    public String pcRepairForm(Model model, @ModelAttribute("pcRepair") PCRepair pcRepair) {

        if(pcRepair == null) {
            model.addAttribute("pcRepair", new PCRepair());
        } else {
            model.addAttribute("pcRepair", pcRepair);
        }

        return "pc-repair-form";
    }

    @GetMapping("/pcRepairTable")
    public String pcRepairTable(Model model, Pageable pageable, Sort sort) {
        Page<PCRepair> pcRepairList = pcRepairService.getAllRecords(pageable);
        Long total = pcRepairList.getTotalElements();

        model.addAttribute("sort", (sort != null) ? sort.iterator().next().getProperty() : "");
        model.addAttribute("page", pcRepairList);
        model.addAttribute("size", total);
        return "pc-repair-table";
    }

    @PostMapping("/updatePcRepairInfo")
    public String updatePcRepair(Model model, @ModelAttribute("pcRepair") @Valid PCRepair pcRepair, BindingResult result) {

        if(result.hasErrors()) {
            return "pc-repair-form";
        }

        if(pcRepair.getPmDate().equals("")) {
            pcRepair.setPmDate(null);
        }

        if(pcRepair.getDateEndorsed().equals("")) {
            pcRepair.setDateEndorsed(null);
        } else {
            if(pcRepair.getDateRepairEnd().equals("")) {
                result.rejectValue("dateRepairEnd", "Empty.dateRepairEnd");
                return "pc-repair-form";
            }
        }

        if(pcRepair.getDateRepairStart().equals("")) {
            pcRepair.setDateRepairStart(null);
        }
//        else {
//            if(pcRepair.getDateRepairEnd().equals("")) {
//                result.rejectValue("dateRepairEnd", "Empty.dateRepairEnd");
//                return "pc-repair-form";
//            }
//        }

        if(pcRepair.getDateRepairEnd().equals("")) {
            pcRepair.setDateRepairEnd(null);
        } else {
            if(pcRepair.getRepairedBy().equals("")) {
                result.rejectValue("repairedBy", "Empty.repairedBy");
                return "pc-repair-form";
            }
            if(pcRepair.getDateRepairStart() == null) {
                result.rejectValue("dateRepairStart", "Empty.dateRepairStart");
                return "pc-repair-form";
            }
            PCSpare pcSpare = new PCSpare(pcRepair.getControlNumber(), pcRepair.getRepairedBy(), pcRepair.getDateRepairEnd(), "No Location Specified", 1);
            System.out.println("Date Endorsed: " + pcRepair.getDateEndorsed());
            if(pcRepair.getDateEndorsed() == null) {
                pcSpare.setDateWithdrawn(pcRepair.getDateEndorsed());
            } else {
                pcSpare.setDateWithdrawn(pcRepair.getDateEndorsed());
                pcSpare.setFlag(0);
            }
            pcSpareService.addSparePC(pcSpare);
        }

        pcRepairService.saveOrUpdate(pcRepair);

        return "redirect:pcRepairTable";
    }

    @GetMapping("/{controlNumber}")
    public String updatePCbyControlNumber(@PathVariable("controlNumber") PCRepair pcRepair, final RedirectAttributes redirectAttributes){

        System.out.println("PC Repair: " + pcRepair.getControlNumber());
        redirectAttributes.addFlashAttribute("pcRepair", pcRepair);
        return "redirect:showForm";
    }

    @GetMapping("download")
    public String download(Model model) throws IOException {
        model.addAttribute("pcRepairList", pcRepairService.getAllRecords());
        return "pcRepairTableExcelView";
    }

    @GetMapping("/searchControlNo")
    public String searchControlNo(@RequestParam("controlNum")String controlNo, Model model){
        PCRepair pcRepair = pcRepairService.findByControlNum(controlNo.trim());

        if(pcRepair == null){
            model.addAttribute("noRecord", "The PC has no repair records...");
            model.addAttribute("pcRepair", new PCRepair());
        } else {
            if(pcRepair.getNgOccurrence() >= 2){
                model.addAttribute("occurrenceAlert", "ALERT! NG Occurrence : " + pcRepair.getNgOccurrence() + ", PC is for Disposal...");
            }
            model.addAttribute("pcRepair", pcRepair);
        }

        return "pc-repair-form";
    }

    @GetMapping("loadForm")
    public String loadForm() {
        return "redirect:showForm";
    }

    @GetMapping("/{controlNumber}/delete")
    public String deletePcRepair(@PathVariable("controlNumber") PCRepair pcRepair){

        PCSpare pcSpare = pcSpareService.getSparePC(pcRepair.getControlNumber());

        if(pcSpare != null)
            pcSpareService.deleteSparePC(pcRepair.getControlNumber());

        pcRepairService.deletePcRepair(pcRepair);
        return "redirect:/pcRepair/pcRepairTable";
    }

    @ModelAttribute
    public void loginDetails(Model model) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
    }

    @ModelAttribute
    public void dropdownLists(Model model) {
        List<String> hddOrientations = new ArrayList<String>();
        hddOrientations.add("Horizontal");
        hddOrientations.add("Vertical");

        List<String> hddInstalledList = new ArrayList<String>();
        hddInstalledList.add("2.5 HDD");
        hddInstalledList.add("3.5 HDD");

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayList<String> monthList = new ArrayList<String>(Arrays.asList(months));

        model.addAttribute("hddOrientations", hddOrientations);
        model.addAttribute("hddInstalledList", hddInstalledList);
        model.addAttribute("monthList", monthList);
    }
}
