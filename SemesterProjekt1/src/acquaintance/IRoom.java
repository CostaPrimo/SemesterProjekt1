package acquaintance;

/**
 *
 * @author Gruppe 20
 */
public interface IRoom {
    
    boolean getIsLocked();
    IRoom getExit(String direction);
    String getName();
    String getShortDescription();

    public void setIsLocked(boolean b);

    public String getLongDescription();
}
