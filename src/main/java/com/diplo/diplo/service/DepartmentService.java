package com.diplo.diplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplo.diplo.model.Department;
import com.diplo.diplo.model.Room;
import com.diplo.diplo.repository.DepartmentRepository;
import com.diplo.diplo.repository.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, RoomRepository roomRepository) {
        this.departmentRepository = departmentRepository;
        this.roomRepository = roomRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> findByCity(String city) {
        return departmentRepository.findByCity(city);
    }

    @Transactional
    public Room addRoomToDepartment(Long departmentId, Room room) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        room.setDepartment(department);
        department.addRoom(room);

        roomRepository.save(room);
        return room;
    }
}
