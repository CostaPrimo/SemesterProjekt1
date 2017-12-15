package starter;
import acquaintance.IBusiness;
import acquaintance.IData;
import business.BusinessFacade;
import data.DataFacade;
import acquaintance.IUI;
import presentation.UI;
/**
 * <h1>Main class!</h1>
 * @author Gruppe 20 - With inspiration from Mads Due Kristensen, recommended by our professor Daniel Bjerring Jørgensen.
 * This class will act as our glue code and knows about all the layers through interfaces.
 * It will inject and create new instances of the layers.
 */
public class Main{
    
    public static void main(String[] args) {
        IData data = new DataFacade();
        IBusiness business = new BusinessFacade();
        business.injectData(data);
        IUI ui = new UI();
        ui.injectBusiness(business);
        System.out.println("Ready to launch");
        ui.startApplication(args);
    }
}