package com.miscbits.officehours.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Appointment {
    @NotNull
    @Size(min = 5)
    private String time;

    @ManyToOne
    private User user;

    public Appointment() {
    }

    public Appointment(@NotNull @Size(min = 5) String time, User user) {
        this.time = time;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
