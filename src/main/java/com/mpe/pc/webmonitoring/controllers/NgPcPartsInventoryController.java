package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.NgPcParts;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.services.NgPcPartsService;
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
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("ngPcParts")
public class NgPcPartsInventoryController {

    private final NgPcPartsService ngPcPartsService;
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public NgPcPartsInventoryController(NgPcPartsService ngPcPartsService, UserService userService, AuthenticationFacade authenticationFacade) {
        this.ngPcPartsService = ngPcPartsService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping("showForm")
    public String showForm(Model model, @ModelAttribute("ngPcParts") NgPcParts ngPcParts){

        if(ngPcParts == null) {
            model.addAttribute("ngPcParts", new NgPcParts());
            model.addAttribute("noRecord", "No Record found! Add item to Inventory...");
        } else {
            model.addAttribute("ngPcParts", ngPcParts);
        }
        return "ng-pc-parts-form";
    }

    @GetMapping("searchNgPcParts")
    public String searchHdd(@RequestParam("serialNumber") String serialNumber, final RedirectAttributes redirectAttributes) {

        NgPcParts ngPcParts = ngPcPartsService.getNgPcParts(serialNumber);
        redirectAttributes.addFlashAttribute("ngPcParts", ngPcParts);

        return "redirect:showForm";
    }

    @PostMapping("addNgPcParts")
    public  String addHdd(@ModelAttribute("ngPcParts") @Valid NgPcParts ngPcParts, BindingResult result){

        if(result.hasErrors()) {
            return "ng-pc-parts-form";
        }

        ngPcPartsService.saveNgPcParts(ngPcParts);

        return "redirect:ngPcPartsTable";
    }

    @GetMapping("ngPcPartsTable")
    public String ngPcPartsTable(Model model, Pageable pageable, Sort sort){
        Page<NgPcParts> ngPcPartsPage = ngPcPartsService.getAllNgPartsRecords(pageable);
        Long totalNgPcParts = ngPcPartsPage.getTotalElements();

        model.addAttribute("sort", (sort != null) ? sort.iterator().next().getProperty() : "");
        model.addAttribute("ngPcPartsPage", ngPcPartsPage);
        model.addAttribute("totalNgPcParts", totalNgPcParts);

        return "ng-pc-parts-table";
    }

    @GetMapping("download")
    public String download(Model model) {
        model.addAttribute("ngPcPartsList", ngPcPartsService.getNgPcPartsList());

        return "ngPcPartsExcelView";
    }

    @GetMapping("/{id}")
    public String updateNgPcParts(@PathVariable("id") NgPcParts ngPcParts, final RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("ngPcParts", ngPcParts);
        return "redirect:showForm";
    }

    @GetMapping("/{id}/delete")
    public String deleteNgPcParts(@PathVariable("id") NgPcParts ngPcParts){

        ngPcPartsService.deleteNgPcParts(ngPcParts);
        return "redirect:/ngPcParts/ngPcPartsTable";
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

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayList<String> monthList = new ArrayList<String>(Arrays.asList(months));

        model.addAttribute("months", monthList);

    }
}
