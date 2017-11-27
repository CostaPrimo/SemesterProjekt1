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
import javafx.beans.InvalidationListener;
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
    Image mapDowntoImage = new Image(getClass().getResource("downtown us.png").toExternalForm());
    Image mapDowntownMSImage = new Image(getClass().getResource("downtown ms.png").toExternalForm());
    Image mapEntranceLockedImage = new Image(getClass().getResource("yard entrance låst ms.png").toExternalForm());
    Image mapEntranceOpenImage = new Image(getClass().getResource("yard entrance åben ms.png").toExternalForm());
    Image mapSouthImage = new Image(getClass().getResource("yard south ms.png").toExternalForm());
    Image mapNorthEastImage = new Image(getClass().getResource("yard northeast ms.png").toExternalForm());
    Image mapNorthWestImage = new Image(getClass().getResource("yard northvest ms.png").toExternalForm());
    Image mapSouthEastImage = new Image(getClass().getResource("yard southeast ms.png").toExternalForm());
    Image mapSouthWestImage = new Image(getClass().getResource("yard southvest ms.png").toExternalForm());
    
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
    private Pane MapPane;
    @FXML
    private Pane MenuPane;
    @FXML
    private Pane MerchantsPane;
    @FXML
    private ListView<Item> MerchantListViewBuy;
    private ObservableList<Item> merchantItems;
    private ObservableList<Item> gamestopItems;
    private ObservableList<Item> playerInventory;
    private ObservableList<Item> roomInventory;
    @FXML
    private Button BuyItemsButton;
    @FXML
    private Button ExitStoreButton;
    @FXML
    private ListView<Item> MerchantListViewSell;
    @FXML
    private Button SellitemsButton;
    @FXML
    private Pane InspectPane;
    @FXML
    private ListView<Item> PlayerInventoryListview;
    @FXML
    private ListView<Item> RoomInventoryListview;
    @FXML
    private Button PickupButton;
    @FXML
    private Button DropButton;
    @FXML
    private Button CloseButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = UI.getInstance().getBusiness();
        this.playerInventory = FXCollections.observableArrayList(game.getItemPlayer());
        this.roomInventory = FXCollections.observableArrayList(game.getItemRoom());
        MerchantListViewSell.setItems(playerInventory);
        RoomInventoryListview.setItems(roomInventory);
        PlayerInventoryListview.setItems(playerInventory);
        MoneyLabel.setText("Money: " + (Integer.toString(game.wallet())));
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
        if(game.getCurrentRoom().getShortDescription() == "at your home"){
            MapView.setImage(image1);
            MinimapView.setImage(minimapHomeImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at downtown"){
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
        }
        else if (game.getCurrentRoom().getShortDescription()== "at the entrance to the scrapyard" && game.getCurrentRoom().getIsLocked() == true){//Næste rum ikke current
            MapView.setImage(mapEntranceLockedImage);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getIsLocked()==false){
            MapView.setImage(mapEntranceOpenImage);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the merchant"){
            MinimapView.setImage(minimapMerchantImage);
            this.merchantItems = FXCollections.observableArrayList(game.getItemMerchant());
            MerchantListViewBuy.setItems(merchantItems);
            MerchantsPane.toFront();
        }
        else if (game.getCurrentRoom().getShortDescription() == "at gamestop"){
            MinimapView.setImage(minimapGamestopImage);
            this.gamestopItems = FXCollections.observableArrayList(game.getItemGamestop());
            MerchantListViewBuy.setItems(gamestopItems);
            MerchantsPane.toFront();
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
            MinimapView.setImage(minimapScrapyardMiddleImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
            MapView.setImage(mapNorthWestImage);
            MinimapView.setImage(minimapScrapyardWestImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
            MapView.setImage(mapNorthEastImage);
            MinimapView.setImage(minimapScrapyardEastImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
            MapView.setImage(mapSouthImage);
            MinimapView.setImage(minimapScrapyardSouthImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
            MapView.setImage(mapSouthEastImage);
            MinimapView.setImage(minimapScrapyardSouthEastImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
            MapView.setImage(mapSouthWestImage);
            MinimapView.setImage(minimapScrapyardSouthWestImage);
        }
    }

    @FXML
    private void UseButtonHandler(ActionEvent event) {
        game.use(0);
        playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void BuyItemsButtonHandler(ActionEvent event) {
        //MerchantListView.getSelectionModel().getSelectedIndices();
        int i= MerchantListViewBuy.getSelectionModel().getSelectedIndex();
            game.buyItem(i);
            playerInventory.setAll(game.getItemPlayer());
            MoneyLabel.setText(Integer.toString(game.wallet()));
    }

    @FXML
    private void ExitStoreButtonHandler(ActionEvent event) {
        if(game.getCurrentRoom().getShortDescription() == "at the merchant"){
            game.goRoom("west");
            MinimapView.setImage(minimapDowntownImage);
        }
        else{
            game.goRoom("east");
            MinimapView.setImage(minimapDowntownImage);
            
        }
        MapPane.toFront();
    }

    @FXML
    private void SellitemsButtonHandler(ActionEvent event) {
        int i= MerchantListViewSell.getSelectionModel().getSelectedIndex();
            game.sellItem(i);
            playerInventory.setAll(game.getItemPlayer());
            MoneyLabel.setText(Integer.toString(game.wallet()));
    }

    @FXML
    private void InspectButtonHandler(ActionEvent event) {
        roomInventory.setAll(game.getItemRoom());
        playerInventory.setAll(game.getItemPlayer());
        InspectPane.toFront();
        
        
        
    }

    @FXML
    private void PickupButtonHandler(ActionEvent event) {
        int i= RoomInventoryListview.getSelectionModel().getSelectedIndex();
            game.addItem(i);
            roomInventory.setAll(game.getItemRoom());
            playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void DropButtonHandler(ActionEvent event) {
        int i= PlayerInventoryListview.getSelectionModel().getSelectedIndex();
            game.dropItem(i);
            playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void CloseButtonHandler(ActionEvent event) {
        MapPane.toFront();
    }
}
