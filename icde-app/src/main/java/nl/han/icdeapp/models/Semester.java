package nl.han.icdeapp.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Semester {
    	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 200)
    private String name;
    
    @Size(min = 2, max = 200)
    private String targetGroup;

    @Size(min = 2, max = 2000)
    private String description;
    
    @Size(min = 2, max = 500)
    private String startingDemands;
    
    @Size(min = 2, max = 200)
    private String teachingMethod;
    
    // External relations to Evl
    @ManyToOne(optional = true)
    private Evl firstEvlOfSemester;

    @ManyToOne(optional = true)
    private Evl secondEvlOfSemester;
    
    @ManyToOne(optional = true)
    private Semester nextSemester;
            
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