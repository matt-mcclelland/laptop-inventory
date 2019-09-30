package org.cbchs.loanercheckout.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaptopController {

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("title", "Loaner Laptop Checkout");

        return "laptop/index";
    }

}
