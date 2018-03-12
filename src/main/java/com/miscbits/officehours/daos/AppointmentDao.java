package com.miscbits.officehours.daos;

import com.miscbits.officehours.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "appointments", path = "appointments")
public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    @PreAuthorize("@appointmentRepository.findOne(#id)?.user?.username == authentication.name or HAS_ROLE('ROLE_ADMIN')")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#appointment.user?.username == authentication.name or HAS_ROLE('ROLE_ADMIN')")
    void delete(@Param("appointment") Appointment appointment);

    Appointment findOne(Long id);
}
