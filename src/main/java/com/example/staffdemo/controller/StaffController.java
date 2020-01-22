package com.example.staffdemo.controller;

import com.example.staffdemo.model.Staff;
import com.example.staffdemo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class StaffController {
    private StaffRepository staffRepository;

    @Autowired
    public StaffController(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    //create
    @PostMapping("/staffs")
    public Staff createStaff(@RequestBody Staff staff){
        return this.staffRepository.save(staff);
    }

    //View list
    @GetMapping("/staffs")
    public List<Staff> viewStaffs(){
        return this.staffRepository.findAll();
    }

    //find staff
    @GetMapping("/staffs/{id}")
    public Staff findStaff(@PathVariable(value = "id") int staffId){
        return this.staffRepository.findById(staffId).get();
    }

    //update staff
    @PutMapping("/staffs/{id}")
    public Staff updateStaff(@PathVariable(value = "id") int staffId,@RequestBody Staff staffUpdate){
        Staff staff = findStaff(staffId);
        staff.setFirstName(staffUpdate.getFirstName());
        staff.setLastName(staffUpdate.getLastName());
        staff.setDateOfBirth(staffUpdate.getDateOfBirth());
        staff.setGender(staffUpdate.getGender());
        staff.setAddress(staffUpdate.getAddress());
        staff.setMobile(staffUpdate.getMobile());
        staff.setSkype(staffUpdate.getSkype());
        staff.setEmail(staffUpdate.getEmail());
        staff.setJoinDate(staffUpdate.getJoinDate());
        staff.setDepartment(staffUpdate.getDepartment());
        return createStaff(staff);
    }

    //delete staff
    @DeleteMapping("/staffs/{id}")
    public String deleteStaff(@PathVariable(value = "id") int staffId){
        staffRepository.deleteById(staffId);
        return "delete successful";
    }
}
