package nl.han.icdeapp.controllers;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

public interface BaseControllerInterface<T> {
	
    public String list(Model model);
    public String addForm(T t, Model model);
    public String add(@Valid T t, BindingResult result, Model model);
    public String updateForm(@PathVariable("id") long id, Model model);
    public String update(@PathVariable("id") long id, @Valid T t, BindingResult result, Model model);
    public String delete(@PathVariable("id") long id, Model model);
	
}