package nl.han.icdeapp.controllers;

import nl.han.icdeapp.models.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import nl.han.icdeapp.services.ServiceInterface;

@Controller
public class EvlController implements BaseControllerInterface<Evl> {
	
	@Autowired
	private ServiceInterface<Evl> evlService;
	
	// Forms / Thymeleaf
	
    @GetMapping("/gui-list-evl")
    public String list(Model model) {
        model.addAttribute("evls", evlService.findAll());
        return "gui-list-evl";
    }
	
    @GetMapping("/gui-add-evl")
    public String addForm(Evl evl) {
        return "gui-add-evl";
    }
	
    @PostMapping("/gui-add-evl")
    public String add(@Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "gui-add-evl";
        }
        
        evlService.add(evl);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/gui-list-evl";
    }
    
    @GetMapping("/gui-edit-evl/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        Evl evl = evlService.findById(id).orElseThrow(() -> new IllegalArgumentException("#{field_id_nv.text}" + id));
        model.addAttribute("evl", evl);
        return "gui-edit-evl";
    }
    
    @PostMapping("/gui-edit-evl/{id}")
    public String update(@PathVariable("id") long id, @Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		evl.setId(id);
            return "gui-edit-evl";
        }
        		        
        evlService.update(evl);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/gui-list-evl";
    }
    
    @GetMapping("/gui-delete-evl/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        evlService.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
        evlService.delete(id);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/gui-list-evl";
    }
    
}