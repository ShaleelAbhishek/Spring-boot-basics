package com.appointment.service;

import com.appointment.model.Appointment;

public interface AppointmentService {

    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Integer id);
}
