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
	
    @GetMapping("/evl-list")
    public String list(Model model) {
        model.addAttribute("evls", evlService.findAll());
        return "evl-list";
    }
	
    @GetMapping("/evl-add")
    public String addForm(Evl evl, Model model) {
        return "evl-add";
    }
	
    @PostMapping("/evl-add")
    public String add(@Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "evl-add";
        }
        
        evlService.add(evl);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/evl-list";
    }
    
    @GetMapping("/evl-edit/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        Evl evl = evlService.findById(id).orElseThrow(() -> new IllegalArgumentException("#{field_id_nv.text}" + id));
        model.addAttribute("evl", evl);
        return "evl-edit";
    }
    
    @PostMapping("/evl-edit/{id}")
    public String update(@PathVariable("id") long id, @Valid Evl evl, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		evl.setId(id);
            return "evl-edit";
        }
        		        
        evlService.update(evl);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/evl-list";
    }
    
    @GetMapping("/evl-delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        evlService.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
        evlService.delete(id);
        model.addAttribute("evls", evlService.findAll());
        return "redirect:/evl-list";
    }
    
}