package org.cbchs.loanercheckout.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Loan> loans = new ArrayList<>();

    @NotNull
    //@Size(min=6, max=6, message = "Please enter a 6 digit student number!")
    private Integer studentIDNumber;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min=3, max=24, message = "Please enter a name with between 3 and 24 characters!")
    private String firstName;

    public Integer getStudentIDNumber() {
        return studentIDNumber;
    }

    public void setStudentIDNumber(Integer studentIDNumber) {
        this.studentIDNumber = studentIDNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
