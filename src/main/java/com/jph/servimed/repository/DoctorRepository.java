package com.jph.servimed.repository;

import com.jph.servimed.model.Doctor;
import com.jph.servimed.repository.crudRepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }

    public Doctor save(Doctor doctor){
        return doctorCrudRepository.save(doctor);
    }

    public void delete(Doctor doctor){
        doctorCrudRepository.delete(doctor);
    }
}
