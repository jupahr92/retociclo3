package com.jph.servimed.repository;

import com.jph.servimed.model.Reservation;
import com.jph.servimed.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){

        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){

        reservationCrudRepository.delete(reservation);
    }
}
