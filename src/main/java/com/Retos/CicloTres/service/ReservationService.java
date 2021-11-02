/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Reservation;
import com.Retos.CicloTres.reportes.ContadorClientes;
import com.Retos.CicloTres.reportes.StatusReservas;
import com.Retos.CicloTres.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Status;

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
    //servicio creado el miercocles johan
    public StatusReservas getReservationStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");
        return new StatusReservas(completed.size(),cancelled.size());
    }
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate = new Date();
        Date bDate = new Date();
        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch (ParseException evt){
            evt.printStackTrace();
        }
        if (aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate,bDate);
        }else {
            return new ArrayList<>();
        }
    }
    public List<ContadorClientes> getTopClients(){
        return reservationRepository.getTopClients();
    }
}
