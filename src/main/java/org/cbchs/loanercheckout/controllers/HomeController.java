package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.data.LaptopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private LaptopDao laptopDao;

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Loaner Laptop Checkout");

        return "laptop/index";
    }

}
