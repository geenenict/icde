package nl.han.icdeapp.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Evl {
    
	// https://www.baeldung.com/spring-boot-crud-thymeleaf
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @NotBlank(message = "{field_name_ne.text}")
    private String name;
    
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