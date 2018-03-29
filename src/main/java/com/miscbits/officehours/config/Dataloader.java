package com.miscbits.officehours.config;

import com.miscbits.officehours.daos.AppointmentDao;
import com.miscbits.officehours.daos.RequestDao;
import com.miscbits.officehours.daos.RoleDao;
import com.miscbits.officehours.daos.UserDao;
import com.miscbits.officehours.models.Appointment;
import com.miscbits.officehours.models.Request;
import com.miscbits.officehours.models.Role;
import com.miscbits.officehours.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner{

    private UserDao userDao;
    private RoleDao roleDao;
    private AppointmentDao appointmentDao;
    private RequestDao requestDao;

    @Autowired
    public Dataloader(UserDao userDao, RoleDao roleDao, AppointmentDao appointmentDao, RequestDao requestDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.appointmentDao = appointmentDao;
        this.requestDao = requestDao;
    }

    public void run(ApplicationArguments args) {
        Role teacherRole = new Role("ROLE_TEACHER");
        Role studentRole = new Role("ROLE_STUDENT");
        teacherRole = roleDao.save(teacherRole);
        studentRole = roleDao.save(studentRole);

        User[] users = new User[] {
                new User("wilhem", "password", true, teacherRole),
                new User("nhu", "password", true, teacherRole),
                new User("anthony", "password", true, studentRole),
                new User("keith", "password", true, studentRole)
        };

        for(User user : users)
            userDao.save(user);

        Appointment[] appointments = new Appointment[] {
                new Appointment("20180328 14:00:00", users[0]),
                new Appointment("20180328 14:00:00", users[1]),
                new Appointment("20180328 14:30:00", users[0]),
                new Appointment("20180328 14:30:00", users[1]),
                new Appointment("20180328 15:00:00", users[0]),
                new Appointment("20180328 15:00:00", users[1])
        };

        for(Appointment appointment : appointments)
            appointmentDao.save(appointment);

        Request[] requests = new Request[] {
                new Request(appointments[1], users[2], "Objects"),
                new Request(appointments[2], users[3], "Loops"),
                new Request(appointments[3], users[3], "Typescript")
        };

        for (Request request : requests)
            requestDao.save(request);


    }
}
