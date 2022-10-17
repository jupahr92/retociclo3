package com.jph.servimed.web;

import com.jph.servimed.model.Doctor;
import com.jph.servimed.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import javax.lang.model.util.Elements;
import java.util.List;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getDoctors(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int doctorId) {
        return doctorService.getDoctor(doctorId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId){
        return doctorService.deleteDoctor(doctorId);
    }
}
