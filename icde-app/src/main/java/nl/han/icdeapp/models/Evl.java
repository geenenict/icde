package nl.han.icdeapp.models;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Evl {
    
	// https://www.baeldung.com/spring-boot-crud-thymeleaf
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 200, message = "Tijdelijke foutmelding tussen 2-200 karakters naam-veld")
    private String name;
    
    /*
    @AssertTrue
    @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    @Email(message = "Email should be valid")
    @NotEmpty
    
    List<@NotBlank String> preferences;
    
    public Optional<@Past LocalDate> getDateOfBirth() {
    return Optional.of(dateOfBirth);
}
    
    @Past and @PastOrPresent – validate that a date value is in the past or the past including the present; can be applied to date types including those added in Java 8
@Future and @FutureOrPresent – validates that a date value is in the future, or in the future including the present
     * */
    
    // Constructors
    
	public Evl() {
		super();
	}

    public Evl(String name) {
        this.name = name;
    }
        
    // Getters and setters

	public void setId(long id) {
		this.id = id;
	}
    
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return "Evl{" + "id=" + id + ", name=" + name + "}";
    }
}