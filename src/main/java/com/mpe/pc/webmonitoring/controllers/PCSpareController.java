package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.*;
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
import java.util.List;

@Controller
@RequestMapping("pcSpare")
public class PCSpareController {

    private final PCSpareService pcSpareService;
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;
    private final PCRepairService pcRepairService;

    @Autowired
    public PCSpareController(PCSpareService pcSpareService, UserService userService, AuthenticationFacade authenticationFacade, PCRepairService pcRepairService) {
        this.pcSpareService = pcSpareService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
        this.pcRepairService = pcRepairService;
    }

    @GetMapping("showForm")
    public String showForm(Model model, @ModelAttribute("pcSpare") PCSpare pcSpare){
        if(pcSpare == null) {
            model.addAttribute("pcSpare", new PCSpare());
            model.addAttribute("noRecord", "No Record Found!..");
        }
        else
            model.addAttribute("pcSpare", pcSpare);

        return "pc-spare";
    }

    @GetMapping("loadForm")
    public String loadForm() {

        return "forward:/pcSpare/showForm";
    }

    @GetMapping("loadTable")
    public String pcSpareTable(Model model, @ModelAttribute("pcSpare") PCSpare pcSpare,Pageable pageable, Sort sort) {

        Page<PCSpare> pcSparePage = pcSpareService.repairPCSpareRecords(1,pageable);
        Long pcSparesTotal = pcSparePage.getTotalElements();

        model.addAttribute("pcSparePage", pcSparePage);
        model.addAttribute("pcSparesTotal", pcSparesTotal);

        return "pc-spare-table";
    }

    @GetMapping("withdrawalTable")
    public String withdrawalTable(Model model, @ModelAttribute("pcSpare") PCSpare pcSpare,Pageable pageable, Sort sort) {

        Page<PCSpare> pcSparePage = pcSpareService.repairPCSpareRecords(0,pageable);
        Long pcSparesTotal = pcSparePage.getTotalElements();

        model.addAttribute("pcSparePage", pcSparePage);
        model.addAttribute("pcSparesTotal", pcSparesTotal);

        return "pc-spare-withdrawal-table";
    }

    @PostMapping("addSparePC")
    public String addSparePC(@ModelAttribute("pcSpare") @Valid PCSpare pcSpare, BindingResult result) {

        if(pcSpare.getDateWithdrawn().equals("")) {
            pcSpare.setDateWithdrawn(null);
        }
        if(result.hasErrors()) {
            return "pc-spare";
        }

        if(pcSpare.getLocation().equals("")) {
            result.rejectValue("location", "Specify.location");
            return "pc-spare";
        }

        PCRepair pcRepair = pcRepairService.findByControlNum(pcSpare.getControlNumber());
//        pcRepair.setDateRepairEnd(pcSpare.getDate());
//        pcRepair.setRepairedBy(pcSpare.getRepairedBy());

        System.out.println("Date Withdrawn: " + pcSpare.getDateWithdrawn());

        // for withdrawals
        if(pcSpare.getDateWithdrawn() == null){
            pcSpare.setFlag(1);
        } else {
            if(pcSpare.getWithdrawnBy().equals("")) {
                result.rejectValue("withdrawnBy", "Empty.withdrawnBy");
                return "pc-spare";
            }
            if(pcSpare.getUseFor().equals("")) {
                result.rejectValue("useFor", "Empty.useFor");
                return "pc-spare";
            }
            pcSpare.setFlag(0);
            pcRepair.setDateEndorsed(pcSpare.getDateWithdrawn());
        }



        pcRepairService.saveOrUpdate(pcRepair);
        pcSpareService.addSparePC(pcSpare);

        return "redirect:/pcSpare/loadTable";
    }

    @GetMapping("searchSparePC")
    public String searchControlNo(@RequestParam("controlNum")String controlNo, final RedirectAttributes redirectAttributes){

        PCSpare pcSpare = pcSpareService.getSparePC(controlNo);
        redirectAttributes.addFlashAttribute("pcSpare", pcSpare);

        return "redirect:/pcSpare/showForm";
    }

    @GetMapping("downloadSpares")
    public String downloadSpares(Model model) {
        model.addAttribute("pcSpareList", pcSpareService.getAllPcSpare(1));

        return "pcRepairSpareExcelView";
    }

    @GetMapping("downloadWithdrawals")
    public String downloadWithdrawals(Model model) {
        model.addAttribute("pcSpareList", pcSpareService.getAllPcSpare(0));

        return "pcRepairSpareExcelView";
    }

    @GetMapping("/{controlNumber}")
    public String updateByControlNumber(@PathVariable("controlNumber") PCSpare pcSpare, final RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("pcSpare", pcSpare);
        return "redirect:/pcSpare/showForm";
    }

    @ModelAttribute
    public void loginDetails(Model model) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
    }
}
