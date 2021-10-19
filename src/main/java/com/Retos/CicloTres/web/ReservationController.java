/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.web;

import com.Retos.CicloTres.model.Reservation;
import com.Retos.CicloTres.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
     @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserva){
        return reservationService.save(reserva);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }
}

//package com.Retos.CicloTres.web;
//
//import com.Retos.CicloTres.model.Reservation;
//import com.Retos.CicloTres.service.ReservationService;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/api/Reservation")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
//public class ReservationController {
//     @Autowired
//    private ReservationService reservationService;
//    
//    @GetMapping("/all")
//    public List<Reservation> getReservation(){
//        return reservationService.getAll();
//    }
//    @GetMapping("/{id}")
//    public Optional<Reservation> getReservation(@PathVariable("id") int id){
//        return reservationService.getReservation(id);
//    }
//
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Reservation save(@RequestBody Reservation reserva){
//        return reservationService.save(reserva);
//    }
//}
