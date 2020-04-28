package com.appointment.service;

import com.appointment.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Integer id);

    List<Appointment> getByUserId(Integer id);

    List<Appointment> getAllAppointments();

    Appointment deleteAppointment(Integer id);
}
