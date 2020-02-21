package nl.han.icdeapp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Evl {
    	
	/*
	 Voorbeeld voor tijdens DEMO:
	 
	  @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
 	  @Min(value = 18, message = "Age should not be less than 18")
 	  @Max(value = 150, message = "Age should not be greater than 150")
 	  @Email(message = "Email should be valid")
 	  @NotEmpty
	
 	  List<@NotBlank String> preferences;

 	  public Optional<@Past LocalDate> getDateOfBirth() {
 	  	  return Optional.of(dateOfBirth);
	  }
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 200)
    private String name;
        
    @Size(min = 2, max = 200)
    private String evlCode;
    
    @Min(value = 1)
    @Max(value = 100)
    private Integer studyPoints;

    @Min(value = 1)
    private Integer contactTime;
        
}