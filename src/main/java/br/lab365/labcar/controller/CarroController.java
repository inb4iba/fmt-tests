package br.lab365.labcar.controller;

import br.lab365.labcar.model.CarroModel;
import br.lab365.labcar.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity getTodos() {
        try {
            return ResponseEntity.ok( carroService.buscarTodos() );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok( carroService.buscarPorId(id) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CarroModel carro) {
        try {
            carro.setId(null);
            return ResponseEntity.ok( carroService.salvar(carro) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody CarroModel carro) {
        try {
            carro.setId(id);
            return ResponseEntity.ok( carroService.salvar(carro) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok( carroService.apagar(id) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
