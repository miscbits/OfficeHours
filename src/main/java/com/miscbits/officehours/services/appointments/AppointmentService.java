package com.miscbits.officehours.services.appointments;

import com.miscbits.officehours.models.Appointment;

public interface AppointmentService {
    Iterable<Appointment> findAll();
    Appointment findOne(Long id);
    void save(Appointment task);
}
