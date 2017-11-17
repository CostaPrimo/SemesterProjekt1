package starter;

import acquaintance.IBusiness;
import acquaintance.IData;
import acquaintance.IPresentation;
import business.BusinessFacade;
import business.Game;
import data.DataFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SemesterProjektGUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("SemesterProjektGUI.fxml"));
        
        IData data = new DataFacade();
        IBusiness business = new BusinessFacade();
        business.injectData(data);
        IPresentation controller = (IPresentation)loader.getController();
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