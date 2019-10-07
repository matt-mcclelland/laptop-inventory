package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.Laptop;
import org.cbchs.loanercheckout.models.data.LaptopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;

@Controller
public class LaptopController {

    @Autowired
    private LaptopDao laptopDao;

    @RequestMapping(value="add-laptop", method = RequestMethod.GET)
    public String displayAddLaptopForm(Model model) {
        model.addAttribute("title", "Add Laptop");
        model.addAttribute(new Laptop());
        return "laptop/add-laptop";
    }

    @RequestMapping(value="/add-laptop", method = RequestMethod.POST)
    public String processAddLaptopForm(@ModelAttribute @Valid Laptop newLaptop,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Laptop");
            return "laptop/add-laptop";
        }

        laptopDao.save(newLaptop);
        return "redirect:";
    }

    @RequestMapping(value = "remove-laptop", method = RequestMethod.GET)
    public String displayRemovelaptopForm(Model model) {
        model.addAttribute("title", "Remove laptop");
        model.addAttribute("laptops", laptopDao.findAll());
        return "laptop/remove-laptop";

    }

    @RequestMapping(value = "remove-laptop", method = RequestMethod.POST)
    public String processRemovelaptopForm(@RequestParam int[] ids) {

        for (int id : ids) {
            laptopDao.deleteById(id);
        }

        return "redirect:";
    }

}
