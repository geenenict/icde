package nl.han.icdeapp.controllers;
import nl.han.icdeapp.exceptions.*;
import nl.han.icdeapp.models.*;

import java.util.Optional;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import nl.han.icdeapp.repositories.EvlRepository;

// https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
// https://github.com/in28minutes/spring-boot-examples/tree/master/spring-boot-2-rest-service-basic

//@RestController -> adds @Controller + @ResponseBody -> @ResponseBody does not return html files but views
@Controller
public class EvlController {
	
	@Autowired
	private EvlRepository evlRepository;
	
	// Forms
	
    @GetMapping("/add-evl")
    public String showAddEvlForm(Evl evl) {
        return "add-evl";
    }
	
    @PostMapping("/add-evl")
    public String addEvl(@Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-evl";
        }
        
        evlRepository.save(evl);
        model.addAttribute("evls", evlRepository.findAll());
        return "index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateEvlForm(@PathVariable("id") long id, Model model) {
        Evl evl = evlRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Evl id:" + id));
        model.addAttribute("evl", evl);
        return "update-evl";
    }
    
    @PostMapping("/update/{id}")
    public String updateEvl(@PathVariable("id") long id, @Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		evl.setId(id);
            return "update-evl";
        }
        		        
        evlRepository.save(evl);
        model.addAttribute("evls", evlRepository.findAll());
        return "index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEvl(@PathVariable("id") long id, Model model) {
        Evl evl = evlRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Evl id:" + id));
        evlRepository.delete(evl);
        model.addAttribute("evls", evlRepository.findAll());
        return "index";
    }
	
	// Default CRUD actions
	/*
	@GetMapping("/evls")
	public List<Evl> retrieveAllEvls() {
		return evlRepository.findAll();
	}

	@GetMapping("/evls/{id}")
	public Evl retrieveEvl(@PathVariable long id) {
		Optional<Evl> evl = evlRepository.findById(id);

		if (!evl.isPresent())
			throw new EvlNotFoundException();

		return evl.get();
	}
	
	@PostMapping("/evls")
	public ResponseEntity<Object> createEvl(@RequestBody Evl evl) {
		Evl savedEvl = evlRepository.save(evl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEvl.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/evls/{id}")
	public ResponseEntity<Object> updateEvl(@RequestBody Evl evl, @PathVariable long id) {

		Optional<Evl> evlOptional = evlRepository.findById(id);

		if (!evlOptional.isPresent())
			return ResponseEntity.notFound().build();

		evl.setId(id);
		
		evlRepository.save(evl);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/evls/{id}")
	public void deleteEvl(@PathVariable long id) {
		evlRepository.deleteById(id);
	}
	*/
    
}