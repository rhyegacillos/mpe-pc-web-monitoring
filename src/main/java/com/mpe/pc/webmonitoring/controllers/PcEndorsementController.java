package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.PcEndorse;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.services.PcEndorsementService;
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


@Controller
@RequestMapping("pcEndorse")
public class PcEndorsementController {

    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;
    private final PcEndorsementService pcEndorsementService;

    @Autowired
    public PcEndorsementController(UserService userService, AuthenticationFacade authenticationFacade, PcEndorsementService pcEndorsementService) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
        this.pcEndorsementService = pcEndorsementService;
    }

    @GetMapping("showForm")
    public String showPcEndorsementForm(Model model, @ModelAttribute PcEndorse pcEndorse) {
        if(pcEndorse == null){
            model.addAttribute("pcEndorse", new PcEndorse());
            model.addAttribute("noRecord", "No Record Found");
        } else {
            model.addAttribute("pcEndorse", pcEndorse);
        }

        return "pc-endorsement-form";
    }

    @GetMapping("searchControlNo")
    public String searchByControlNo(@RequestParam("controlNo") String controlNo, RedirectAttributes redirectAttributes) {
        PcEndorse pcEndorse = pcEndorsementService.getPcEndorse(controlNo.trim());
        redirectAttributes.addFlashAttribute("pcEndorse", pcEndorse);

        return "redirect:showForm";
    }

    @GetMapping("pcEndorsementTable")
    public String loadPcEndorsementTable(Model model, Pageable pageable, Sort sort){
        Page<PcEndorse> pcEndorsePage = pcEndorsementService.getAllPcEndorseRecords(pageable);
        Long pcEndorseTotal = pcEndorsePage.getTotalElements();

        model.addAttribute("pcEndorsePage", pcEndorsePage);
        model.addAttribute("pcEndorseTotal", pcEndorseTotal);

        return "pc-endorsement-table";

    }

    @PostMapping("addAndUpdatePcEndorse")
    public String addAndUpdatePcEndorse(@ModelAttribute("pcEndorse") @Valid PcEndorse pcEndorse, BindingResult result) {
        if(result.hasErrors())
            return "pc-endorsement-form";

        pcEndorsementService.save(pcEndorse);

        return "redirect:pcEndorsementTable";
    }

    @GetMapping("/{controlNo}")
    public String updatePcEndorseByControlNo(@PathVariable("controlNo") PcEndorse pcEndorse, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("pcEndorse", pcEndorse);

        return "redirect:showForm";
    }

    @GetMapping("/{controlNo}/delete")
    public String deletePcEndorse(@PathVariable("controlNo") PcEndorse pcEndorse) {

        pcEndorsementService.delete(pcEndorse);

        return "redirect:/pcEndorse/pcEndorsementTable";
    }

    @GetMapping("download")
    public String downloadExcel(Model model) {
        model.addAttribute("pcEndorseList", pcEndorsementService.getPcEndorseList());

        return "pcEndorsementExcelView";
    }


    @ModelAttribute
    public void loginDetails(Model model, final RedirectAttributes redirectAttributes) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
        redirectAttributes.addFlashAttribute("userLoginDetails", userLoginDetails);

    }
}
