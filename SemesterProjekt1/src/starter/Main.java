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

public class Main extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SemesterProjektGUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("SemesterProjektGUI.fxml"));
        
        IData data = new DataFacade();
        IBusiness business = new BusinessFacade();
        business.injectData(data);
        IUI controller = (IUI)loader.getController();
        controller.injectBusiness(business);
        
        
       
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //Creating Game object and running play method from the game object
//        Game game = new Game();
//        game.play();
        launch(args);
    }
}