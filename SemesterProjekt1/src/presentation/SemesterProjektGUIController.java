/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import acquaintance.IBusiness;
import business.BusinessFacade;
import business.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Kim Christensen
 */
public class SemesterProjektGUIController implements Initializable {  
    private Button goSouthButton;
    @FXML
    private Button GoNorthButton;
    @FXML
    private Button GoWestButton;
    @FXML
    private Button GoEastButton;
    @FXML
    private TextArea TextAreaStatus;
    @FXML
    private Button InventoryButton;
    @FXML
    private Button MenuButton;
    @FXML
    private Button InspectButton;
    @FXML
    private ImageView MapView;
    @FXML
    private ImageView MinimapView;
    @FXML
    private Label MoneyLabel;
    private IBusiness game;
    @FXML
    private Label CurrentRoomLabel;
    /**
     * Initializes the controller class.
     */
    Image image1 = new Image(getClass().getResource("space_flight_sky_stars_82970_1920x1080.jpg").toExternalForm());
    Image image2 = new Image(getClass().getResource("downtown us.png").toExternalForm());
    Image image3 = new Image(getClass().getResource("yard entrance låst ms.png").toExternalForm());
    Image image4 = new Image(getClass().getResource("yard entrance åben ms.png").toExternalForm());
    @FXML
    private Button UseButton;
    @FXML
    private ListView<?> StoreListView;
    @FXML
    private Pane MapPane;
    @FXML
    private Button GoSouthButton;
    @FXML
    private Pane MenuPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = UI.getInstance().getBusiness();
        
    }    

    @FXML
    private void GoButtonHandler(ActionEvent event) {
        if(event.getSource() == GoNorthButton){
            game.goRoom("north");
        }
        else if(event.getSource()== GoEastButton){
            game.goRoom("east");
        }
        else if (event.getSource() == GoWestButton){
            game.goRoom("west");
        }
        else if (event.getSource() == goSouthButton){
            game.goRoom("south");
        }
        if(game.getCurrentRoom().getShortDescription() == "at downtown"){
            MapView.setImage(image2);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at your home"){
            MapView.setImage(image1);
        }
        else if (game.getCurrentRoom().getShortDescription()== "at the entrance to the scrapyard"){
            MapView.setImage(image3);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getIsLocked()==false){
            MapView.setImage(image4);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the merchant"){
            
              
        }
    }

    @FXML
    private void UseButtonHandler(ActionEvent event) {
        game.use(0);
    }
}
