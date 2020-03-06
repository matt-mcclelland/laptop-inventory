package org.cbchs.loanercheckout.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 190000L, message = "Please enter a valid 6 digit Student ID Number.")
    @Max(value = 1000000L, message = "Please enter a valid 6 digit Student ID Number.")
    private Integer studentIDNumber;

    @NotNull
    @Size(min=3, max=24, message = "Please enter a name with between 3 and 24 characters!")
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
