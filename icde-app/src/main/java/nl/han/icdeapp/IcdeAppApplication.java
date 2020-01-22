package nl.han.icdeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import nl.han.icdeapp.models.Evl;

@Controller
@SpringBootApplication
public class IcdeAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(IcdeAppApplication.class, args);
	}
	
    @GetMapping("/")
    public String showHomepage() {
        return "index";
    }
}
