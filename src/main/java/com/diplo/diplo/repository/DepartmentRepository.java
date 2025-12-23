package com.diplo.diplo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplo.diplo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Optional<Department> findByName(String role);
    boolean existsByName(String role);
    
    List<Department> findByCity(String city);

}
