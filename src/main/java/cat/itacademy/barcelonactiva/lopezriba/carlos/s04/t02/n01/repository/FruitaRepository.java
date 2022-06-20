package cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.domain.Fruita;

public interface FruitaRepository extends JpaRepository<Fruita, Long>{
	List<Fruita> findByNomContaining(String nom);
}
