package com.miscbits.officehours.services.appointments;

import com.miscbits.officehours.daos.AppointmentDao;
import com.miscbits.officehours.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Iterable<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    @Override
    public Appointment findOne(Long id) {
        return appointmentDao.findOneById(id);
    }

    @Override
    public void save(Appointment appointment) {
        appointmentDao.save(appointment);
    }
}
