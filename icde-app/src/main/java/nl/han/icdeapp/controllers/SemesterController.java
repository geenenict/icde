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
	
	@Autowired
	private ServiceInterface<Evl> evlService;
	
	// Forms / Thymeleaf
	
    @GetMapping("/semester-list")
    public String list(Model model) {
        model.addAttribute("semesters", semesterService.findAll());
        return "semester-list";
    }
	
    @GetMapping("/semester-add")
    public String addForm(Semester semester, Model model) {
    	model.addAttribute("evls", evlService.findAll());
    	model.addAttribute("semesters", semesterService.findAll());
        return "semester-add";
    }
	
    @PostMapping("/semester-add")
    public String add(@Valid Semester semester, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "semester-add";
        }
        
        semesterService.add(semester);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/semester-list";
    }
    
    @GetMapping("/semester-edit/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        Semester semester = semesterService.findById(id).orElseThrow(() -> new IllegalArgumentException("#{field_id_nv.text}" + id));
        model.addAttribute("semester", semester);
    	model.addAttribute("evls", evlService.findAll());
    	model.addAttribute("semesters", semesterService.findAll());
        return "semester-edit";
    }
    
    @PostMapping("/semester-edit/{id}")
    public String update(@PathVariable("id") long id, @Valid Semester semester, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		semester.setId(id);
            return "semester-edit";
        }
    	
        semesterService.update(semester);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/semester-list";
    }
    
    @GetMapping("/semester-delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        semesterService.findById(id).orElseThrow(() -> new IllegalArgumentException("{field_id_nv.text}" + id));
        semesterService.delete(id);
        model.addAttribute("semesters", semesterService.findAll());
        return "redirect:/semester-list";
    }
    
}