package com.jph.servimed.web;

import com.jph.servimed.model.Specialty;
import com.jph.servimed.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<Specialty> getAll(){
        return specialtyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int specialtyId) {
        return specialtyService.getSpecialty(specialtyId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty) {
        return specialtyService.save(specialty);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty) {
        return specialtyService.update(specialty);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int specialtyId) {
        return specialtyService.deleteSpecialty(specialtyId);
    }
}
