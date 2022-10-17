package com.jph.servimed.repository.crudRepository;

import com.jph.servimed.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
