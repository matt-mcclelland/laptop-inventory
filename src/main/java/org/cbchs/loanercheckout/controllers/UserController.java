package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.User;
import org.cbchs.loanercheckout.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

@Autowired
private UserDao userDao;


    // TODO check validation
    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add-user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String processAddUserFrom(@ModelAttribute @Valid User newUser, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add-user";
        }

        userDao.save(newUser);
        return "redirect:";
    }
}
