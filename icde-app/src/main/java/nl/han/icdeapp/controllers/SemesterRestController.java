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
public class SemesterRestController implements BaseRestControllerInterface<Semester> {
	
	@Autowired
	private ServiceInterface<Semester> semesterService;
		
	@GetMapping("/semesters")
	public List<Semester> findAll() {
		return semesterService.findAll();
	}
	
	@GetMapping("/semesters/{id}")
	public Optional<Semester> findById(@PathVariable long id) {
		Optional<Semester> semester = semesterService.findById(id);

		if (!semester.isPresent())
			throw new SemesterNotFoundException();

		return semester;
	}
	
	@PostMapping("/semesters")
	public ResponseEntity<Object> add(@RequestBody @Valid Semester semester) {
		Semester savedSemester = semesterService.add(semester);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSemester.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/semesters/{id}")
	public ResponseEntity<Object> update(@RequestBody @Valid Semester semester, @PathVariable long id) {

		Optional<Semester> semesterOptional = semesterService.findById(id);

		if (!semesterOptional.isPresent())
			return ResponseEntity.notFound().build();

		semester.setId(id);
		
		semesterService.update(semester);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/semesters/{id}")
	public void delete(@PathVariable long id) {
		semesterService.delete(id);
	}
    
}