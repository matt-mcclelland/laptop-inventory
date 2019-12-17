package org.cbchs.loanercheckout.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Loan {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private int id;

    public Loan(Laptop laptop, User user, LocalDate checkIn, LocalDate checkOut){
        this.laptop = laptop;
        this.user = user;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }

    public Loan(){}

    @ManyToOne
    private Laptop laptop;

    @ManyToOne
    private User user;

    private LocalDate checkOut;

    private LocalDate checkIn;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

}
