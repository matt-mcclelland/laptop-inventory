package org.cbchs.loanercheckout.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String serialNumber;

    @NotNull
    private String computerName;

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

    public Date getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Date checkedOut) {
        this.checkedOut = checkedOut;
    }


    public int getId() {
        return id;
    }

    private Date checkedOut;

    public Laptop() { }

    public Laptop(String computerName, String serialNumber) {
        this.computerName = computerName;
        this.serialNumber = serialNumber;
    }

}
