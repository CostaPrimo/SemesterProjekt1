package presentation;
import acquaintance.IBusiness;
import javafx.application.Application;
import acquaintance.IUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *<h1>UI class!</h1>
 * @author Gruppe 20 - With inspiration from Mads Due Kristensen, recommended by our professor Daniel Bjerring Jørgensen.
 */
public class UI extends Application implements IUI {
    private static UI ui;
    public static UI getInstance(){
        return ui;
    }
    private IBusiness business;
    /**
     * This method will set up the graphical window and load the correct FXML document.
     * This method will also place a scene on stage which is the window itself.
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SemesterProjektGUI.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * This methhod will inject thebusinesslayer into the UI through an interface to create contact with a different layer.
     * @param businessLayer 
     */
    @Override
    public void injectBusiness(IBusiness businessLayer){
        business = businessLayer;
    }
    /**
     * This method will start the application when called. It will create an instance of the UI as an object that can be used in the glue code.
     * @param args 
     */
    @Override
    public void startApplication(String[] args){
        System.out.println("Is in UI startApplication");
        ui = this;
        launch(args);
    }
    public IBusiness getBusiness(){
        return business;
    }
}
