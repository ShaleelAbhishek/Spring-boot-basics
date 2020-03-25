package com.appointment.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private Integer patientId;
    private Integer doctorId;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private String appointmentDate;
    private String appointmentStartTime;
    private AppointmentStatus status = AppointmentStatus.Booked;
    @Transient
    private Doctor doctor;
    @Transient
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
