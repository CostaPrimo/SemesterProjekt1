package business;

import acquaintance.INPC;

/**
 *<h1>NPC class!</h1>
 * @author gruppe 20
 */
public abstract class NPC implements INPC{
    private String description;
    private String name;
    /**
     * The NPC constructor. This class is abstract and will not get instiatiated, but the name and description will be used in other subclasses. 
     * @param name The name of the NPC.
     * @param description The description of the NPC.
     */
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
    /**
     * This method will not be invoked since this class is abstract, but it is here as this class implements the INPC interface.
     * @return 
     */
    @Override
    public String encounterMessage() {
        return "Generic NPC encounter message";
    }
    
}
