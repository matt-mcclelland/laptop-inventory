package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.User;
import org.cbchs.loanercheckout.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

@Autowired
private UserDao userDao;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String userIndex(Model model) {
        model.addAttribute("title", "Students");
        model.addAttribute("users", userDao.findAll());

        return "user/users";
    }

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

    @RequestMapping(value = "remove-user", method = RequestMethod.GET)
    public String displayRemoveuserForm(Model model) {
        model.addAttribute("title", "Remove User");
        model.addAttribute("users", userDao.findAll());
        return "user/remove-user";

    }

    @RequestMapping(value = "remove-user", method = RequestMethod.POST)
    public String processRemoveuserForm(@RequestParam int[] ids) {


        for (int id : ids) {
            userDao.deleteById(id);
        }
        return "redirect:";
    }

    @RequestMapping(value="/edit-user/{id}", method = RequestMethod.GET)
    public String processEdituserForm(Model model, @PathVariable int id) {

        User user = userDao.findById(id).get();
        model.addAttribute("title", "Edit user");
        model.addAttribute("user", user);

        return "user/edit";

    }

    @RequestMapping(value="/edit-user", method = RequestMethod.POST)
    public String processEditUserForm(@ModelAttribute @Valid User newuser, @RequestParam(value="userId") int userId,
                                        Errors errors, Model model) {

  
        User student = userDao.findById(userId).get();
        student.setStudentIDNumber(newuser.getStudentIDNumber());
        student.setLastName(newuser.getLastName());
        student.setFirstName(newuser.getFirstName());
        userDao.save(student);
        return "redirect:";
    }
    
    
}
