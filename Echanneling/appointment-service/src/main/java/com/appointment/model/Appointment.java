package com.appointment.model;

import lombok.Data;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.TimeZone;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private Integer patientId;
    private Integer doctorId;
    private Date createdAt = new Date(System.currentTimeMillis());
    private String appointmentDate;
    private String appointmentStartTime;
    private AppointmentStatus status = AppointmentStatus.Booked;
    private  boolean isDelete = false;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

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
