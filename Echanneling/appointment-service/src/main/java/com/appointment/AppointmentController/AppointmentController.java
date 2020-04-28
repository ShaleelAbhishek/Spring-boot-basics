package com.appointment.AppointmentController;

import com.appointment.model.Appointment;
import com.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/save")
   // @ResponseStatus(HttpStatus.CREATED)
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/getAppointment/{id}")
    public Appointment getAppointmentById(@PathVariable Integer id){
        return appointmentService.getAppointmentById(id);
    }
    @GetMapping("/getAllAppointments")
    public  List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }



    @GetMapping("/getByUserId/{id}")
    public List<Appointment> getAppoimentByUserId(@PathVariable Integer id){
        return appointmentService.getByUserId(id);
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public Appointment deleteAppointment(@PathVariable Integer id){
        return appointmentService.deleteAppointment(id);
    }
}
