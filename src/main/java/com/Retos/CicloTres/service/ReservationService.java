/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Reservation;
import com.Retos.CicloTres.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
     @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reserva){
        if(reserva.getIdReservation()==null){
            return reservationRepository.save(reserva);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(reserva.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(reserva);
            }else{
                return reserva;
            }
        }
    }
    public boolean deleteReservation(int id){
        Optional<Reservation> reserva=getReservation(id);
        if(!reserva.isEmpty()){
            reservationRepository.delete(reserva.get());
            return true;
        }
        return false;
    }
}
