/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import acquaintance.IBusiness;
import business.BusinessFacade;
import business.Item;
import business.Rat;
import business.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private Button GoSouthButton;
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
    
   // private ObservableList<Item> itemName;
    /**
     * Initializes the controller class.
     */
    Image image1 = new Image(getClass().getResource("space_flight_sky_stars_82970_1920x1080.jpg").toExternalForm());
    Image image2 = new Image(getClass().getResource("downtown us.png").toExternalForm());
    Image image3 = new Image(getClass().getResource("yard entrance låst ms.png").toExternalForm());
    Image image4 = new Image(getClass().getResource("yard entrance åben ms.png").toExternalForm());
    
    Image minimapHomeImage = new Image(getClass().getResource("MiniMap_Home.png").toExternalForm());
    Image minimapDowntownImage = new Image(getClass().getResource("MiniMap_DownTown.png").toExternalForm());
    Image minimapGamestopImage = new Image(getClass().getResource("MiniMap_GameStop.png").toExternalForm());
    Image minimapMerchantImage = new Image(getClass().getResource("MiniMap_Merchant.png").toExternalForm());
    Image minimapScrapyardEntranceImage = new Image(getClass().getResource("MiniMap_ScrapyardEntrance.png").toExternalForm());
    Image minimapScrapyardMiddleImage = new Image(getClass().getResource("MiniMap_ScrapyardMiddle.png").toExternalForm());
    Image minimapScrapyardWestImage = new Image(getClass().getResource("MiniMap_ScrapyardWest.png").toExternalForm());
    Image minimapScrapyardEastImage = new Image(getClass().getResource("MiniMap_ScrapyardEast.png").toExternalForm());
    Image minimapScrapyardSouthImage = new Image(getClass().getResource("MiniMap_ScrapyardSouth.png").toExternalForm());
    Image minimapScrapyardSouthWestImage = new Image(getClass().getResource("MiniMap_ScrapyardSouthWest.png").toExternalForm());
    Image minimapScrapyardSouthEastImage = new Image(getClass().getResource("MiniMap_ScrapyardSouthEast.png").toExternalForm());
    @FXML
    private Button UseButton;
    @FXML
    private ListView<?> StoreListView;
    @FXML
    private Pane MapPane;
    @FXML
    private Pane MenuPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = UI.getInstance().getBusiness();
        //this.itemName = FXCollections.observableArrayList();
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
        else if (event.getSource() == GoSouthButton){
            game.goRoom("south");
        }
        if(game.getCurrentRoom().getShortDescription() == "at downtown"){
            MapView.setImage(image2);
            MinimapView.setImage(minimapDowntownImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at your home"){
            MapView.setImage(image1);
            MinimapView.setImage(minimapHomeImage);
        }
        else if (game.getCurrentRoom().getShortDescription()== "at the entrance to the scrapyard"){
            MapView.setImage(image3);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getIsLocked()==false){
            MapView.setImage(image4);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the merchant"){
            MinimapView.setImage(minimapMerchantImage);
            MoneyLabel.setText(game.getItemMerchant().get(0).getName());
        }
        else if (game.getCurrentRoom().getShortDescription() == "at gamestop"){
            MinimapView.setImage(minimapGamestopImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
            MinimapView.setImage(minimapScrapyardMiddleImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
            MinimapView.setImage(minimapScrapyardWestImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
            MinimapView.setImage(minimapScrapyardEastImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
            MinimapView.setImage(minimapScrapyardSouthImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
            MinimapView.setImage(minimapScrapyardSouthEastImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
            MinimapView.setImage(minimapScrapyardSouthWestImage);
        }
    }

    @FXML
    private void UseButtonHandler(ActionEvent event) {
        game.use(0);
    }
}
