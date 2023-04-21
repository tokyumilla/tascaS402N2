package cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.millaolaya.juan.s04.t02.n02.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FruitaServiceImpl implements FruitaService{

    @Autowired
    private FruitaRepository fruitaRepository;

    @Override
    public List<Fruita> findAll() {
        return fruitaRepository.findAll();
    }

    @Override
    public Optional<Fruita> findById(int id) {
        return fruitaRepository.findById(id);
    }

    @Override
    public Fruita save(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    @Override
    public void deleteById(int id) {
        fruitaRepository.deleteById(id);
    }
}