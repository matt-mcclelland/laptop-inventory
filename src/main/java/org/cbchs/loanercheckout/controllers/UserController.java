package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.User;
import org.cbchs.loanercheckout.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

//    @Autowired
//    private UserDao userDao;


    // TODO check validation
    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add-user";
    }
}
