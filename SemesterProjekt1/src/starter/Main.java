package starter;

import acquaintance.IBusiness;
import acquaintance.IData;
import business.BusinessFacade;
import business.BusinessFacade;
import data.DataFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import acquaintance.IUI;
import presentation.UI;

public class Main{
    
    public static void main(String[] args) {
        //Creating Game object and running play method from the game object
//        Game game = new Game();
//        game.play();
        IData data = new DataFacade();
        IBusiness business = new BusinessFacade();
        business.injectData(data);
        IUI ui = new UI();
        ui.injectBusiness(business);
        System.out.println("Ready to launch");
        ui.startApplication(args);
    }
}