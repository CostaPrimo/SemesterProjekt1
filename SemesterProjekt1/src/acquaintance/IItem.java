package acquaintance;

/**
 * <h1>IItem interface</h1>
 * @author Gruppe 20
 * This will be the interface for the items. This allows communication layers throughout.
 */
public interface IItem {
    
    String getName();
    int getBuyPrice();
    int getSellPrice();
    boolean isTooHeavy();
}
