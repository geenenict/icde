package nl.han.icdeapp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Evl {
    	
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
        
    // leeruitkomsten (gekoppeld)
    // Calculate -> aantal studiepunten
    // Aantal deeltentamens -> calculate
    
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

}