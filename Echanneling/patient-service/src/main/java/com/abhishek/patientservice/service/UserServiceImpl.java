package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.model.PatientTelephone;
import com.abhishek.patientservice.repository.PatientRepository;
import com.abhishek.patientservice.model.APIResponse;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@Data
public class UserServiceImpl implements UserDetailsService {
    public static Patient user;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private PatientRepository customerOwnerRepository;

    @Autowired
    private PatientService customerOwnerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        UserDetails userDetails=null;
//        user = customerOwnerRepository.findByUserName(userName);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + userName);
//        }
//        else if(user.getActivity()){
//            userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                    new ArrayList<>());
//        }
//        System.out.println("pppp "+userDetails);
//        return userDetails;


        user = customerOwnerService.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
//        return user;
    }


    public Patient save(Patient customerOwner) throws IllegalArgumentException {

//&& customerOwnerService.findByIdCardNumber(customerOwner.getIdCardNumber())==null)
        if (customerOwnerService.findByUserName(customerOwner.getUserName()) == null && customerOwnerService.findByEmail(customerOwner.getPatientEmail()) == null) {

            for (PatientTelephone telephone : customerOwner.getTelephones())
                telephone.setPatient(customerOwner);

            customerOwner.setJoinedDate(LocalDate.now());
            customerOwner.setActivity(true);
            customerOwner.setDlt(false);
            customerOwner.setRole("User");
            customerOwner.setPassword(bcryptEncoder.encode(customerOwner.getPassword()));
            return customerOwnerRepository.save(customerOwner);
        } else {
            throw new IllegalArgumentException();
        }

    }
}
