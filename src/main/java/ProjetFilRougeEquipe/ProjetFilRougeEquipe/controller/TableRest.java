package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ReservationService;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tables")
public class TableRest {

    @Autowired
    private TableService service;


@GetMapping
    public ResponseEntity<Iterable<Table>>  findAll() { return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Table>  findById( @PathVariable int id) { return new ResponseEntity<>( service.findById(id), HttpStatus.OK);
    }
    @PutMapping("/present/table")
    public ResponseEntity<Boolean>  EstPresent(Table table){
        return new ResponseEntity<>(service.EstPresent(table), HttpStatus.OK);

    }
}
