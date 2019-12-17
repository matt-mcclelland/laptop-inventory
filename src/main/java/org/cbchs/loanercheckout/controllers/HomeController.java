package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.Laptop;
import org.cbchs.loanercheckout.models.Loan;
import org.cbchs.loanercheckout.models.User;
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
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private LaptopDao laptopDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoanDao loanDao;

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Loaner Laptop Checkout");
        model.addAttribute("users", userDao.findAll());

        return "laptop/index";
    }

    @RequestMapping(value="checkout", method = RequestMethod.POST)
    public String checkout(@RequestParam(value="laptopId") int laptopId, @RequestParam(value="userId") int userId, Model model){
        Laptop laptop = laptopDao.findById(laptopId).get();
        User user = userDao.findById(userId).get();
        Loan loan = new Loan(laptop, user, LocalDate.now(), null);
        laptop.setCheckedOut(true);
        laptopDao.save(laptop);
        loanDao.save(loan);
        model.addAttribute("laptops", laptopDao.findAll());
        model.addAttribute("title", "Loaner Laptop Checkout");
        model.addAttribute("users", userDao.findAll());
        return "laptop/index";
    }

}
