package cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.domain.Fruita;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.services.FruitaService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	FruitaService fruitaService;
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
		try {
			Fruita _fruita = fruitaService.saveFruita(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
			return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita) {
		Optional<Fruita> fruitaData = fruitaService.findFruitaById(id);
		if (fruitaData.isPresent()) {
			Fruita _fruita = fruitaData.get();
			_fruita.setNom(fruita.getNom());
			_fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
			return new ResponseEntity<>(fruitaService.saveFruita(_fruita), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id) {
		try {
			fruitaService.deleteFruitaById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getOneFruita(@PathVariable("id") long id) {
		Optional<Fruita> fruitaData = fruitaService.findFruitaById(id);
		if (fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruita(@RequestParam(required = false) String nom) {
		try {
			List<Fruita> fruita = new ArrayList<Fruita>();
			if (nom == null)
				fruitaService.findAllFruita().forEach(fruita::add);
			else
				fruitaService.findFruitaByNomContaining(nom).forEach(fruita::add);
			if (fruita.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(fruita, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
