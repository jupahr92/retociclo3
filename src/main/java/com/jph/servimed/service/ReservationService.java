package com.jph.servimed.service;

import com.jph.servimed.model.Reservation;
import com.jph.servimed.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> r= reservationRepository.getReservation(reservation.getIdReservation());
            if(r.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> r= reservationRepository.getReservation(reservation.getIdReservation());
            if(!r.isEmpty()){

                if(reservation.getStartDate()!=null){
                    r.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    r.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    r.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(r.get());
                return r.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aB = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aB;
    }
}
