package com.jph.servimed.repository.crudRepository;

import com.jph.servimed.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository  extends CrudRepository<Doctor,Integer> {
}
