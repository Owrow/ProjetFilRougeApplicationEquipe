package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.PlatDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Plat;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.PlatService;

@RestController
@CrossOrigin
@RequestMapping("/plats")
public class PlatRest {

    @Autowired
    private PlatService service;


    @GetMapping
    public ResponseEntity<Iterable<PlatDTO>>  findAll() { return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }
}