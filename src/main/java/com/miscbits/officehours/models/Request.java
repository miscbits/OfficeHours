package com.miscbits.officehours.models;

import javax.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    private User user;

    private String subject;

    public Request(Appointment appointment, User user, String subject) {
        this.appointment = appointment;
        this.user = user;
        this.subject = subject;
    }

    public Request(User user, String subject) {
        this.user = user;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public Request() {
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
