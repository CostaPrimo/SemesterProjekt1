package business;

/**
 *
 * @author gruppe 20
 */
public class NPC {
    private String description;
    private String name;
    
    
    public NPC(String name, String description){
        this.name = name;
        this.description = description;
        
    }

    
        /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
