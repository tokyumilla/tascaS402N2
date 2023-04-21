package cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.domain.Fruita;

import java.util.List;
import java.util.Optional;

public interface FruitaService {
    List<Fruita> findAll();
    Optional<Fruita> findById(int id);
    Fruita save(Fruita fruita);
    void deleteById(int id);
}