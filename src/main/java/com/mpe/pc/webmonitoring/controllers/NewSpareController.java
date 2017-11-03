package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.NewSparePC;
import com.mpe.pc.webmonitoring.domains.User;
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

@Controller
@RequestMapping("newSpare")
public class NewSpareController {

    private final PCSpareService pcSpareService;
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public NewSpareController(PCSpareService pcSpareService, UserService userService, AuthenticationFacade authenticationFacade) {
        this.pcSpareService = pcSpareService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping("showForm")
    public String showForm(Model model, @ModelAttribute("newSparePC") NewSparePC newSparePC) {

        model.addAttribute("newSparePC", new NewSparePC());

        return "new-spare";
    }

    @GetMapping("loadTable")
    public String loadTable(Model model, Pageable pageable, Sort sort) {

        Page<NewSparePC> newSparePage = pcSpareService.newSpareRecords(1,pageable);
        Long newSparesTotal = newSparePage.getTotalElements();
        model.addAttribute("newSparePage", newSparePage);
        model.addAttribute("newSparesTotal", newSparesTotal);

        return "new-spare-table";
    }

    @GetMapping("withdrawTable")
    public String showWithdrawTable(Model model, Pageable pageable, Sort sort) {

        Page<NewSparePC> newSparePage = pcSpareService.newSpareRecords(0,pageable);
        Long newSparesTotal = newSparePage.getTotalElements();
        model.addAttribute("newSparePage", newSparePage);
        model.addAttribute("newSparesTotal", newSparesTotal);

        return "new-spare-withdrawal-table";
    }

    @PostMapping("addNewSparePC")
    public String addNewSparePC(@ModelAttribute("newSparePC") @Valid NewSparePC newSparePC, BindingResult result) {

        if(result.hasErrors()) {
            return "new-spare";
        }

        if(newSparePC.getDateWithdrawn().equals("")){
            newSparePC.setFlag(1);
        } else {
            if(newSparePC.getWithdrawnBy().equals("")) {
                result.rejectValue("withdrawnBy", "Empty.withdrawnBy");
                return "new-spare";
            }
            if(newSparePC.getUseFor().equals("")) {
                result.rejectValue("useFor", "Empty.useFor");
                return "new-spare";
            }
            if(newSparePC.getLineInstalled().equals("")) {
                result.rejectValue("lineInstalled", "Empty.lineInstalled");
                return "new-spare";
            }
            newSparePC.setFlag(0);
        }

        pcSpareService.addNewSparePC(newSparePC);

        return "redirect:/newSpare/loadTable";
    }

    @GetMapping("downloadSpares")
    public String download(Model model) {
        model.addAttribute("newSpareList", pcSpareService.getAllNewSpare(1));

        return "pcNewSpareExcelView";
    }

    @GetMapping("downloadWithdrawals")
    public String downloadWithdrawals(Model model) {
        model.addAttribute("newSpareList", pcSpareService.getAllNewSpare(0));

        return "pcNewSpareExcelView";
    }

    @GetMapping("loadForm")
    public String loadForm() {

        return "redirect:/newSpare/showForm";
    }

    @GetMapping("/{mac}")
    public String updateByControlNumber(@PathVariable("mac") NewSparePC newSparePC, final RedirectAttributes redirectAttributes){

        System.out.println("New Spare PC : " + newSparePC.getControlNum());
        redirectAttributes.addFlashAttribute("newSparePC", newSparePC);
        return "redirect:/newSpare/loadIntoForm";
    }

    @GetMapping("/{mac}/delete")
    public String deleteByMac(@PathVariable("mac") NewSparePC newSparePC){
        pcSpareService.deleteNewSparePc(newSparePC);
        return "redirect:/newSpare/loadTable";
    }

    @GetMapping("loadIntoForm")
    public String loadIntoForm(Model model, @ModelAttribute("newSparePC") final NewSparePC newSparePC) {

        if(newSparePC == null)
            model.addAttribute("newSparePC",new NewSparePC());
        else
            model.addAttribute("newSparePC",newSparePC);

        return "new-spare";
    }

    @ModelAttribute
    public void loginDetails(Model model) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
    }
}
