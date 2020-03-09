package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.Laptop;
import org.cbchs.loanercheckout.models.Loan;
import org.cbchs.loanercheckout.models.data.LaptopDao;
import org.cbchs.loanercheckout.models.data.LoanDao;
import org.cbchs.loanercheckout.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CheckoutController {


    @Autowired
    private UserDao userDao;

    @Autowired
    private LaptopDao laptopDao;

    @Autowired
    private LoanDao loanDao;

    @RequestMapping(value = "checked-in", method = RequestMethod.GET)
    public String checkout(Model model) {

        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Check In");
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("loans", loanDao.findAll());

        return "checkout/checkout";
    }

    @RequestMapping(value="checkin", method = RequestMethod.POST)
    public String checkout(@RequestParam(value="loanId") int loanId, Model model){

        Loan loan = loanDao.findById(loanId).get();
        Laptop laptop = loan.getLaptop();
        loan.setCheckIn(LocalDate.now());
        loan.setCheckOut(null);
        laptop.setCheckedOut(false);
        loanDao.save(loan);
        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Loaner Laptop Checkout");
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("loans", loanDao.findAll());
        return "laptop/index";
    }

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String histoy(Model model) {

        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "History");
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("loans", loanDao.findAll());

        return "checkout/history";
    }



}



