package com.dio.jornada.controller;


import com.dio.jornada.model.JornadaTrabalho;
import com.dio.jornada.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping("/list")
    public List<JornadaTrabalho> getJornadaList() {

        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {

        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchFieldError("jornada nao encontrada")));
    }

    @PutMapping
    public JornadaTrabalho updatteJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {

        try {

            jornadaService.deleteJornada(idJornada);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            // HttpStatus
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }






}
