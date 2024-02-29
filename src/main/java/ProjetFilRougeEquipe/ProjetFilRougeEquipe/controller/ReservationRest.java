package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.ReservationDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ReservationService;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationRest {
	private static final Logger log = LoggerFactory.getLogger(ReservationRest.class);
    @Autowired
    private ReservationService service;

    @GetMapping
    public ResponseEntity<Iterable<ReservationDTO>> findAllResaDTO() {
        return new ResponseEntity<>(service.findAllResaDTO(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReservationDTO> findResaDTOById(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findResaDTOById(id), HttpStatus.OK);
    }

    @PutMapping("/accept")
    public ResponseEntity<ReservationDTO>  AcceptReservation(@RequestParam int id_reservation,@RequestParam int id_table){
    	service.acceptReservation(id_reservation, id_table);
        ReservationDTO resaDTO = service.findResaDTOById(id_reservation);
        return  new ResponseEntity<>(resaDTO, HttpStatus.OK);
    }
    
    @PutMapping("/refuse")
    public ResponseEntity<ReservationDTO>  RefuseReservation(@RequestParam int id_reservation){
    	Reservation reservation = service.refuseReservation(id_reservation);
    	
    	if (reservation==null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
    	ReservationDTO resaDTO = service.findResaDTOById(id_reservation);
        return new ResponseEntity<>(resaDTO, HttpStatus.OK);
    }    

    @PutMapping("/present")
    public ResponseEntity<ReservationDTO> estPresent(@RequestParam int id_reservation){
       	service.EstPresent(id_reservation);
    	ReservationDTO resaDTO = service.findResaDTOById(id_reservation);
        return new ResponseEntity<>(resaDTO, HttpStatus.OK );
    }
    
    
}
