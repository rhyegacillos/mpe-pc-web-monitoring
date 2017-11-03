package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.PCRepair;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.services.PCRepairService;
import com.mpe.pc.webmonitoring.services.PCSpareService;
import com.mpe.pc.webmonitoring.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

@Slf4j
@SessionAttributes("pcRepair")
@Controller()
public class AppController {

    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;
    private final PCRepairService pcRepairService;
    private final PCSpareService pcSpareService;


    @Autowired
    public AppController(UserService userService, AuthenticationFacade authenticationFacade, PCRepairService pcRepairService, PCSpareService pcSpareService) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
        this.pcRepairService = pcRepairService;
        this.pcSpareService = pcSpareService;
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }


    @RequestMapping("/")
    public String loadPcEndorseForm(){
        return"redirect:pcEndorse/showForm";
    }

    @ModelAttribute
    public void loginDetails(Model model, final RedirectAttributes redirectAttributes) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
        redirectAttributes.addFlashAttribute("userLoginDetails", userLoginDetails);
    }


}
