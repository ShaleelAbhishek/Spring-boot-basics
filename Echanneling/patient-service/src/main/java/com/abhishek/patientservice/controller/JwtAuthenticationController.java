package com.abhishek.patientservice.controller;

import com.abhishek.patientservice.config.JwtTokenUtil;
import com.abhishek.patientservice.model.JwtRequest;
import com.abhishek.patientservice.model.JwtResponse;
import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.service.PatientService;
import com.abhishek.patientservice.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PatientService customerOwnerService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println("RRRRRR"+authenticationRequest.getUserName());
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());

        final UserDetails userDetails = userServiceImpl
                .loadUserByUsername(authenticationRequest.getUserName());
        System.out.println("wwwwww    "+userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("aaaaaaaaaaaaaa "+token);
        return ResponseEntity.ok(new JwtResponse(token));





    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody Patient user) throws Exception {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

    private void authenticate(String userName, String password) throws Exception {
        try {
            System.out.println("ooo"+userName +"     "+password);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/get")
    public List<Patient> findAllPatient() {
        return customerOwnerService.getAllPatients();
    }
    @GetMapping("/getActive")
    public boolean findByActive(){
        return customerOwnerService.findByActivity(true);
    }

//    @GetMapping("/getAppointment/{empId}")
//    public List<Rent> fetchAllRent(@PathVariable Integer empId){
//        return customerOwnerService.fetchAllRent(empId);
//    }


}
