package nl.han.icdeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class IcdeAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(IcdeAppApplication.class, args);
	}
}
