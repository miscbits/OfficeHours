package com.miscbits.officehours.models;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Appointment {
    @NotNull
    @Size(min = 5)
    private String time;

    @ManyToMany
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Appointment(String time) {
        this();
        this.time = time;
    }

    protected Appointment() {
        super();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
