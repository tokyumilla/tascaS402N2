package cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http:localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        try {
            List<Fruita> fruites = fruitaService.findAll();

            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne(@PathVariable("id") int id) {
        Optional<Fruita> fruitaData = fruitaService.findById(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        try {
            Fruita _fruita = fruitaService.save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
            return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruita) {
        Optional<Fruita> fruitaData = fruitaService.findById(id);

        if (fruitaData.isPresent()) {
            Fruita _fruita = fruitaData.get();
            _fruita.setNom((fruita.getNom()));
            _fruita.setQuantitatQuilos((fruita.getQuantitatQuilos()));
            return new ResponseEntity<>(fruitaService.save(_fruita), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
        try {
            fruitaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
