package nl.han.icdeapp.controllers;
import nl.han.icdeapp.exceptions.*;
import nl.han.icdeapp.models.*;

import java.util.Optional;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/evls/{id}")
	public Evl retrieveEvl(@PathVariable long id) {
		Optional<Evl> evl = evlRepository.findById(id);

		if (!evl.isPresent())
			throw new EvlNotFoundException();

		return evl.get();
	}

	@DeleteMapping("/evls/{id}")
	public void deleteEvl(@PathVariable long id) {
		evlRepository.deleteById(id);
	}
	
	/*
	@PutMapping("/evls/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
	*/
	/*

	// curl -d '{"name":"Coderen2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/evls

	 * @Autowired
    private IFooService service;
    @GetMapping
    public List<Foo> findAll() {
return service.findAll(); }
@GetMapping(value = “/{id}”)
public Foo findById(@PathVariable(“id”) Long id) {
return RestPreconditions.checkFound(service.findById(id)); }
@PostMapping @ResponseStatus(HttpStatus.CREATED)
public Long create(@RequestBody Foo resource) {
Preconditions.checkNotNull(resource);
return service.create(resource); }
@PutMapping(value = “/{id}”)
@ResponseStatus(HttpStatus.OK)
public void update(@PathVariable( “id” ) Long id, @RequestBody
Foo resource) {
Preconditions.checkNotNull(resource); RestPreconditions.checkNotNull(service.getById(resource.
getId())); service.update(resource);
}
@DeleteMapping(value = “/{id}”) @ResponseStatus(HttpStatus.OK)
public void delete(@PathVariable(“id”) Long id) {
service.deleteById(id); }

curl --header “Accept: application/json” http://localhost:8080/spring-boot-rest/foos/1 

curl -i -X PUT -H “Content-Type: application/json” -d ‘{“id”:”83”,”name”:”klik”}’ http://localhost:8080/spring- boot-rest/foos/1 

curl -i \ -H “Accept: application/json” \ -H “Content-Type:application/json” \ -X POST --data 
‘{“username”: “johnny”, “password”: “password”}’ “https:// localhost:8080/.../request” 

@GetMapping(value = “/{id}”) public Foo findById(@PathVariable(“id”) Long id, HttpServletResponse response) { 
try { Foo resourceById = RestPreconditions. 
checkFound(service.findOne(id)); 
eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response)); 
        return resourceById;
     }
    catch (MyResourceNotFoundException exc) {
         throw new ResponseStatusException(
} } 



*/







}