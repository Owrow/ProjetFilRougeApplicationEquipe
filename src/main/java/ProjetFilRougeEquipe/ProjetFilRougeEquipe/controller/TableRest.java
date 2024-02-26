package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

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

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.TableDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.TableService;

@RestController
@CrossOrigin
@RequestMapping("/tables")
public class TableRest {

    @Autowired
    private TableService service;


    @GetMapping
    public ResponseEntity<Iterable<TableDTO>>  findAll() { return new ResponseEntity<>( service.findAllTableDTO(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Table>  findById( @PathVariable int id) { return new ResponseEntity<>( service.findById(id), HttpStatus.OK);
    }
    
    @PutMapping("/present/table")
    public ResponseEntity<Table>  EstPresent(int id_table){
        return new ResponseEntity<>(service.EstPresent(id_table), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{id}/etat")
    public ResponseEntity<Table>  changementEtat( @PathVariable int id, @RequestParam String etat) { return new ResponseEntity<>( service.changementEtat(id, etat), HttpStatus.OK);
    }
    
}
