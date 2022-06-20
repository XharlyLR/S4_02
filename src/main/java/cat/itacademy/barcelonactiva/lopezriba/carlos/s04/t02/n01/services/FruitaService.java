package cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.domain.Fruita;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.repository.FruitaRepository;

@Service
@Transactional
public class FruitaService {

	@Autowired
    FruitaRepository fruitaRepository;

    public List<Fruita> findAllFruita(){
        return  fruitaRepository.findAll();
    }

    public Optional<Fruita> findFruitaById(long idFruita){
        return  fruitaRepository.findById(idFruita);
    }

    public List<Fruita> findFruitaByNomContaining(String nom){
        return fruitaRepository.findByNomContaining(nom);
    }

    public Fruita saveFruita(Fruita fruita){
    	return fruitaRepository.save(fruita);
    }

    public void deleteFruitaById(long idFruita){
    	fruitaRepository.deleteById(idFruita);
    }

}
