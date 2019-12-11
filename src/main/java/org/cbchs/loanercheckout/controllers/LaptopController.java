package org.cbchs.loanercheckout.controllers;

import org.cbchs.loanercheckout.models.Laptop;
import org.cbchs.loanercheckout.models.data.LaptopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;

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

        var indexLength = newLaptop.getSerialNumber().length();

        if (indexLength > 8) {
            var newSerial = newLaptop.getSerialNumber();
            var startIndexRange = newSerial.length() - 8;
            var fixedSerialNumber = newSerial.substring(startIndexRange, indexLength);

            newLaptop.setSerialNumber(fixedSerialNumber);
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
    @RequestMapping(value="/edit-laptop/{id}", method = RequestMethod.GET)
    public String processEditLaptopForm(Model model, @PathVariable int id) {

        Laptop laptop = laptopDao.findById(id).get();
        model.addAttribute("title", "Edit Laptop");
        model.addAttribute("laptop", laptop);

        return "laptop/edit";

    }
    @RequestMapping(value="/edit-laptop", method = RequestMethod.POST)
    public String processEditLaptopForm(@ModelAttribute @Valid Laptop newLaptop, @RequestParam(value="laptopId") int laptopId,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Laptop");
            model.addAttribute("laptop", laptopDao.findById(laptopId).get());
            return "laptop/edit";
        }

        var indexLength = newLaptop.getSerialNumber().length();

        if (indexLength > 8) {
            var newSerial = newLaptop.getSerialNumber();
            var startIndexRange = newSerial.length() - 8;
            var fixedSerialNumber = newSerial.substring(startIndexRange, indexLength);

            newLaptop.setSerialNumber(fixedSerialNumber);
        }
        Laptop lp = laptopDao.findById(laptopId).get();
        lp.setSerialNumber(newLaptop.getSerialNumber());
        lp.setComputerName(newLaptop.getComputerName());
        laptopDao.save(lp);
        return "redirect:";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String searchResults(@RequestParam(value="search") String search, Model model){

        ArrayList<Laptop> searchResults = new ArrayList<Laptop>();

        for(Laptop laptop :laptopDao.findAll()){
            if(laptop.getComputerName().toLowerCase().contains(search.toLowerCase())){
                searchResults.add(laptop);
            }
            else if(laptop.getSerialNumber().toLowerCase().contains(search.toLowerCase())) {
                searchResults.add(laptop);
            }
        }
        model.addAttribute("laptops", searchResults);
        return "laptop/search-results";

    }





}
