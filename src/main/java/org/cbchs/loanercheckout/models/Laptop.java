package org.cbchs.loanercheckout.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message = "Computer name must be between 3 and 16 characters")
    private String computerName;

    @NotNull
    @Size(min=8, max=9, message = "Please enter the 8 character serial number.")
    private String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public int getId() {
        return id;
    }

    public Laptop() { }

    public Laptop(String computerName, String serialNumber) {
        this.computerName = computerName;
        this.serialNumber = serialNumber;
    }





}
