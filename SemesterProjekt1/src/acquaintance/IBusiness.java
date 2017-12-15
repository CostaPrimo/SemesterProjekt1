package acquaintance;
import business.Room;
import java.util.ArrayList;
/**
 *<h1>IBusiness Interface!</h1>
 * @author Gruppe 20
 * This Interface makes it possible for the injected businesslayer in the presentation layer to call methods from the businessFacade.
 * These methods are those that needs to be able to be called throughout different layers. When the game needs to be saved, or when the user clicks a button.
 */
public interface IBusiness {
    void injectData(IData dataLayer);
    String addItem(int itemNumber);
    String buyItem(int itemNumber);
    String dropItem(int itemNumber);
    String goRoom(String direction2);
    String[] loadHighscore();
    void inspectRoom();
    void loadGame();
    void printHelp();
    void saveGame();
    void saveHighscore();
    String sellItem(int itemNumber);
    String sleep();
    String storeItems(int itemNumber);
    String use(int itemNumber);
    String answerQuestion(char choice);
    int wallet();
    int getDayToken();
    int getTimeToken();
    Room getCurrentRoom();
    Room getRatCurrentRoom();
    void setCurrentRoom(Room currentRoom);
    ArrayList<IItem> getItemMerchant();
    ArrayList<IItem> getItemPlayer();
    ArrayList<IItem> getItemGamestop();
    ArrayList<IItem> getItemRoom();
    ArrayList<IItem> getInventoryTotal();
    ArrayList<IItem> getInventoryComputer();
    ArrayList<IItem> getInventoryHouse();
    String addParts(int itemNumber);
    String removeparts(int itemNumber);
    String printWelcome();
    void setPlayerName(String playerName);
    String[] buildComputer();
    String[] printQuestion();
    boolean requiredPartsChecker();
    boolean timeToBuild();
    boolean questionTime();
    char getChoice();
    boolean getIsActive();
}
