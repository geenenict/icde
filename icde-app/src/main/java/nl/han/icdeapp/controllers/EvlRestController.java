package nl.han.icdeapp.controllers;

import nl.han.icdeapp.exceptions.*;
import nl.han.icdeapp.models.*;
import java.util.Optional;

import javax.validation.Valid;

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
import nl.han.icdeapp.services.ServiceInterface;

@RestController
public class EvlRestController implements BaseRestControllerInterface<Evl> {
	
	@Autowired
	private ServiceInterface<Evl> evlService;
	
	@GetMapping("/evls")
	public List<Evl> findAll() {
		return evlService.findAll();
	}
	
	@GetMapping("/evls/{id}")
	public Optional<Evl> findById(@PathVariable long id) {
		Optional<Evl> evl = evlService.findById(id);

		if (!evl.isPresent())
			throw new EvlNotFoundException();

		return evl;
	}
	
	@PostMapping("/evls")
	public ResponseEntity<Object> add(@RequestBody @Valid Evl evl) {
		Evl savedEvl = evlService.add(evl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEvl.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/evls/{id}")
	public ResponseEntity<Object> update(@RequestBody @Valid Evl evl, @PathVariable long id) {

		Optional<Evl> evlOptional = evlService.findById(id);

		if (!evlOptional.isPresent())
			return ResponseEntity.notFound().build();

		evl.setId(id);
		
		evlService.update(evl);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/evls/{id}")
	public void delete(@PathVariable long id) {
		evlService.delete(id);
	}
    
}