package nl.han.icdeapp.controllers;

import nl.han.icdeapp.exceptions.*;
import nl.han.icdeapp.models.*;
import java.util.Optional;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import nl.han.icdeapp.repositories.EvlRepository;
import nl.han.icdeapp.services.EvlService;

@RestController
public class EvlRestController {
	
	@Autowired
	private EvlService evlService;
	
	// Service maken waar restcontroller mee praat, daar kan evlcontroller dan evt. ook mee praten
	// GUI maken op basis van jQuery aanvullend op thymeleaf
	
	// Default CRUD actions

	@GetMapping("/evls")
	public List<Evl> retrieveAllEvls() {
		return evlService.findAll();
	}
	
	@GetMapping("/evls/{id}")
	public Evl retrieveEvl(@PathVariable long id) {
		Optional<Evl> evl = evlService.findById(id);

		if (!evl.isPresent())
			throw new EvlNotFoundException();

		return evl.get();
	}
	
	@PostMapping("/evls")
	public ResponseEntity<Object> createEvl(@RequestBody Evl evl) {
		Evl savedEvl = evlService.add(evl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEvl.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/evls/{id}")
	public ResponseEntity<Object> updateEvl(@RequestBody Evl evl, @PathVariable long id) {

		Optional<Evl> evlOptional = evlService.findById(id);

		if (!evlOptional.isPresent())
			return ResponseEntity.notFound().build();

		evl.setId(id);
		
		evlService.update(evl);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/evls/{id}")
	public void deleteEvl(@PathVariable long id) {
		evlService.delete(id);
	}
    
}