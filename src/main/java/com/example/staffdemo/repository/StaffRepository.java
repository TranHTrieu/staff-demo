package com.example.staffdemo.repository;

import com.example.staffdemo.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
