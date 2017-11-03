package com.mpe.pc.webmonitoring.controllers;

import com.mpe.pc.webmonitoring.component.AuthenticationFacade;
import com.mpe.pc.webmonitoring.domains.User;
import com.mpe.pc.webmonitoring.domains.UserRoles;
import com.mpe.pc.webmonitoring.services.UserService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public UserController(UserService userService, AuthenticationFacade authenticationFacade) {
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping("showForm")
    public String userRegistrationForm(Model model) {

        model.addAttribute("user", new User());
        return "user-registration";
    }


    @GetMapping("loadTable")
    public String loadUsers(Model model, Pageable pageable, Sort sort){

        Page<User> users = userService.getAllUsers(pageable);
        Long totalUsers = users.getTotalElements();

        model.addAttribute("users", users);
        model.addAttribute("totalUsers", totalUsers);
        return"users-table";
    }

    @PostMapping("addNewUser")
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if(result.hasErrors())
            return "user-registration";

        UserRoles userRoles = new UserRoles(user.getEmployeeId(),"ROLE_USER");
        userService.saveUser(user, userRoles);

        return "redirect:loadTable";
    }

    @GetMapping("{employeeId}")
    public String deleteUser(@PathVariable("employeeId") User user) {
        UserRoles userRoles = userService.getUserRole(user.getEmployeeId());
        userService.deleteUser(user, userRoles);

        return "redirect:loadTable";
    }

    @GetMapping("download")
    public String downloadExcel(Model model) {
        model.addAttribute("userList", userService.getUserList());

        return "usersExcelView";
    }

    @GetMapping("denied")
    public String deniedAccess() {
        return "403";
    }

    @ModelAttribute
    public void loginDetails(Model model, final RedirectAttributes redirectAttributes) {
        Authentication authentication = authenticationFacade.getAuth();
        User userLoginDetails = userService.getUserDetails(authentication.getName());
        model.addAttribute("userLoginDetails", userLoginDetails);
        redirectAttributes.addFlashAttribute("userLoginDetails", userLoginDetails);
    }

}
