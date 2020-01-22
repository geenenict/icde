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
public class SemesterController implements BaseControllerInterface<Semester> {
	
	@Autowired
	private ServiceInterface<Semester> semesterService;
	
	// Forms / Thymeleaf
	
    @GetMapping("/gui-list-semester")
    public String list(Model model) {
        model.addAttribute("semesters", semesterService.findAll());
        return "gui-list-semester";
    }
	
    @GetMapping("/gui-add-semester")
    public String addForm(Semester semester) {
        return "gui-add-semester";
    }
	
    @PostMapping("/gui-add-semester")
    public String add(@Valid Semester semester, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "gui-add-semester";
        }
        
        semesterService.add(semester);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/gui-list-semester";
    }
    
    @GetMapping("/gui-edit-semester/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        Semester semester = semesterService.findById(id).orElseThrow(() -> new IllegalArgumentException("#{field_id_nv.text}" + id));
        model.addAttribute("semester", semester);
        return "gui-edit-semester";
    }
    
    @PostMapping("/gui-edit-semester/{id}")
    public String update(@PathVariable("id") long id, @Valid Semester semester, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		semester.setId(id);
            return "gui-edit-semester";
        }
        		        
        semesterService.update(semester);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/gui-list-semester";
    }
    
    @GetMapping("/gui-delete-semester/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        semesterService.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
        semesterService.delete(id);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/gui-list-semester";
    }
    
}