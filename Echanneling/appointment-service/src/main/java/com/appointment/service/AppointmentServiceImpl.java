package com.appointment.service;

import com.appointment.model.Appointment;
import com.appointment.model.Doctor;
import com.appointment.model.Patient;
import com.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.Exchanger;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Integer id) {
        Optional<Appointment> employees = appointmentRepository.findByAppointmentId(id);
        if (employees.isPresent())
            return employees.get();
        return null;
    }


    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        Appointment appointment = this.getAppointment(appointmentId);

        ResponseEntity<Doctor> resultDoctor=restTemplate.exchange("http://localhost:8082/doctor/getDoctor/"+appointment.getDoctorId(),
                HttpMethod.GET,httpEntity, Doctor.class);
        appointment.setDoctor(resultDoctor.getBody());

        ResponseEntity<Patient> resultPatient=restTemplate.exchange("http://localhost:8081/patient/getPatientById/"+appointment.getPatientId(),
                HttpMethod.GET,httpEntity, Patient.class);
        appointment.setPatient(resultPatient.getBody());

        return appointment;
    }
}
