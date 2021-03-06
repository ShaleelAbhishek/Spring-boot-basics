package com.appointment.repository;

import com.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Optional<Appointment> findByAppointmentId(Integer id);

    List<Appointment> findByPatientId(Integer id);
    void deleteById(Integer appointmentId);
}
