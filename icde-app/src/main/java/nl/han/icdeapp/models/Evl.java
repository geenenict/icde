package nl.han.icdeapp.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Evl {
    
	// https://www.baeldung.com/spring-boot-crud-thymeleaf
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 200, message = "Tijdelijke foutmelding tussen 2-200 karakters naam-veld")
    private String name;
        
    // Constructors
       
	public Evl() {
		super();
	}

    public Evl(String name) {
    	super();
        this.name = name;
    }
        
    // Logic
    
    /*
    public List<String> checkLogic() {

    	List<String> checkMessages = new ArrayList<String>(); 
    	
    	if (this.name != null) {
    		checkMessages.add("EVL (name) needs at least 1 Leeruitkomst");
    	}
    	
    	return checkMessages;
    }
    */
        	
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