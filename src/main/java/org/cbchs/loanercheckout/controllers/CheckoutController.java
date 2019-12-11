package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.data.LaptopDao;
import org.cbchs.loanercheckout.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {


    @Autowired
    private UserDao userDao;

    @Autowired
    private LaptopDao laptopDao;

    @RequestMapping(value="checkout", method = RequestMethod.GET)
    public String checkout(Model model) {

        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Checkout");

        return "checkout/checkout";
    }
}

