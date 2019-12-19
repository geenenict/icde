package nl.han.icdeapp.controllers;
import nl.han.icdeapp.models.*;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import nl.han.icdeapp.repositories.EvlRepository;

// https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
// https://github.com/in28minutes/spring-boot-examples/tree/master/spring-boot-2-rest-service-basic

/*
@Controller
public class EvlController {
    @RequestMapping("/")
    //String index(){
    //    return "TEST";
    //}
    
	@ResponseBody
	String home() {
		return "<h1>Hallo 2</h1>";
	}
}
*/

// Heet eigenlijk EvlResource?
@RestController
public class EvlController {

	// curl -d '{"name":"Coderen2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/evls
	
	@Autowired
	private EvlRepository evlRepository;


	@GetMapping("/evls")
	public List<Evl> retrieveAllEvls() {
		return evlRepository.findAll();
	}

	@PostMapping("/evls")
	public ResponseEntity<Object> createEvl(@RequestBody Evl evl) {
		Evl savedEvl = evlRepository.save(evl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEvl.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	/*
	@GetMapping("/students/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);

		return student.get();
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
	*/
}