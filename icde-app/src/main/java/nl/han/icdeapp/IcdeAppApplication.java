package nl.han.icdeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.han.icdeapp.controllers.*;

@Controller
@SpringBootApplication
public class IcdeAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(IcdeAppApplication.class, args);
	}
}
