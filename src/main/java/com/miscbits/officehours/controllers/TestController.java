package com.miscbits.officehours.controllers;

import com.miscbits.officehours.daos.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;

public class TestController {

    @Autowired
    private AppointmentDao appointmentDao;
}
