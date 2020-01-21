package nl.han.icdeapp.controllers;

import nl.han.icdeapp.models.*;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.han.icdeapp.repositories.EvlRepository;

// https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
// https://github.com/in28minutes/spring-boot-examples/tree/master/spring-boot-2-rest-service-basic
// https://www.tutorialspoint.com/spring_boot/spring_boot_rest_template.htm

//@RestController -> adds @Controller + @ResponseBody -> @ResponseBody does not return html files but views
@Controller
public class EvlController {
	
	@Autowired
	private EvlRepository evlRepository;
	
	// Forms / Thymeleaf
	
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
        Evl evl = evlRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
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
        Evl evl = evlRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
        evlRepository.delete(evl);
        model.addAttribute("evls", evlRepository.findAll());
        return "index";
    }
    
}