package com.jph.servimed.service;

import com.jph.servimed.model.Doctor;
import com.jph.servimed.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){

        return doctorRepository.getAll();
    }

    public Optional<Doctor> getDoctor(int id) {

        return doctorRepository.getDoctor(id);
    }

    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return doctorRepository.save(doctor);
        }else{
            Optional<Doctor> d=doctorRepository.getDoctor(doctor.getId());
            if(d.isEmpty()){
                return doctorRepository.save(doctor);
            }else{
                return doctor;
            }
        }
    }

    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> d=doctorRepository.getDoctor(doctor.getId());
            if(!d.isEmpty()){
                if(doctor.getName()!=null){
                    d.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    d.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    d.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    d.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    d.get().setSpecialty(doctor.getSpecialty());
                }
                doctorRepository.save(d.get());
                return d.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }


    public boolean deleteDoctor(int id) {
        Boolean aB = getDoctor(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
        return aB;
    }
}
