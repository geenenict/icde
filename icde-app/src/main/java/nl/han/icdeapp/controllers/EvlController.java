package nl.han.icdeapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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