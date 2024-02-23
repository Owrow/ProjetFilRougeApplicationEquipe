package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ReservationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationRest {
	private static final Logger log = LoggerFactory.getLogger(ReservationRest.class);
    @Autowired
    private ReservationService service;

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/accept")
    public ResponseEntity<Boolean>  AcceptReservation(Reservation reservation){
        return  new ResponseEntity<>(service.acceptOrRefuseReservation(reservation), HttpStatus.OK);
    }

    @PutMapping("/present")
    public ResponseEntity<Boolean> estPresent(Reservation reservation){
        return new ResponseEntity<>(service.EstPresent(reservation), HttpStatus.OK );
    }





}
