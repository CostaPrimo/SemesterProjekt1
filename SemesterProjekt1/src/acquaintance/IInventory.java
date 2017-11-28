package acquaintance;

import java.util.ArrayList;
/**
 *
 * @author Jeppe Enevold
 */
public interface IInventory {
    ArrayList<IItem> getInventoryComputer();
    ArrayList<IItem> getInventoryPlayer();
    ArrayList<IItem> getInventoryHouse();
    ArrayList<IItem> getInventoryRoom();
}
