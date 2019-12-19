package nl.han.icdeapp.models;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Evl {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    
    // Constructors
    
	public Evl() {
		super();
	}

	public Evl(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
    // Getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}