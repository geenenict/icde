package nl.han.icdeapp.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Evl {
    
	// https://www.baeldung.com/spring-boot-crud-thymeleaf
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	// VERVANGEN DOOR MESSAGES INTERNATIONALIZATION
    @NotBlank(message = "Naam is verplicht")
    private String name;
    
    // Constructors
    
	/*public Evl() {
		super();
	}*/

    public Evl() {}

    public Evl(String name) {
        this.name = name;
    }
        
    // Getters and setters

	public void setId(Long id) {
		this.id = id;
	}
    
	public Long getId() {
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