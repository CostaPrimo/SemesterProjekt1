/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import acquaintance.IBusiness;
import acquaintance.IItem;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
    Image mapHomeImage = new Image(getClass().getResource("home ms.png").toExternalForm());
    Image mapDowntoImage = new Image(getClass().getResource("downtown us.png").toExternalForm());
    Image mapDowntownMSImage = new Image(getClass().getResource("downtown ms.png").toExternalForm());
    Image mapMerchantImage = new Image(getClass().getResource("ali ms.png").toExternalForm());
    Image mapGamestopImage = new Image(getClass().getResource("gamestop ms.png").toExternalForm());
    Image mapEntranceLockedImage = new Image(getClass().getResource("yard entrance låst ms.png").toExternalForm());
    Image mapEntranceOpenImage = new Image(getClass().getResource("yard entrance åben ms.png").toExternalForm());
    Image mapMiddleImage = new Image (getClass().getResource("yard middle ms.png").toExternalForm());
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
    private ListView<IItem> MerchantListViewBuy;
    private ObservableList<IItem> merchantItems;
    private ObservableList<IItem> gamestopItems;
    private ObservableList<IItem> playerInventory;
    private ObservableList<IItem> roomInventory;
    private ObservableList<IItem> inventoryTotal;
    private ObservableList<IItem> inventoryComputer;
    private ObservableList<IItem> houseInventory;
    @FXML
    private Button BuyItemsButton;
    @FXML
    private Button ExitStoreButton;
    @FXML
    private ListView<IItem> MerchantListViewSell;
    @FXML
    private Button SellitemsButton;
    @FXML
    private Pane InspectPane;
    @FXML
    private ListView<IItem> PlayerInventoryListview;
    @FXML
    private ListView<IItem> RoomInventoryListview;
    @FXML
    private Button PickupButton;
    @FXML
    private Button DropButton;
    @FXML
    private Button CloseButton;
    @FXML
    private MenuItem SaveButton;
    @FXML
    private MenuItem HelpButton;
    @FXML
    private MenuItem AboutButton;
    @FXML
    private MenuItem QuitButton;
    @FXML
    private Pane HomePane;
    @FXML
    private Button AddPartButton;
    @FXML
    private Button BuildComputerButton;
    @FXML
    private ListView<IItem> TotalInventoryListView;
    @FXML
    private ListView<IItem> BuildComputerListView;
    @FXML
    private Button CancelBuildButton;
    @FXML
    private Button BuildButton;
    @FXML
    private Button RemovePartButton;
    @FXML
    private Pane InventoryPane;
    @FXML
    private Pane HomeStoragePane;
    @FXML
    private ListView<IItem> PlayerInventoryListview1;
    @FXML
    private ListView<IItem> HomeStorageListView;
    @FXML
    private Button AddToHomeButton;
    @FXML
    private Button AddToPlayerInventoryButton;
    @FXML
    private ListView<IItem> PlayerInventoryListview2;
    @FXML
    private Button HomeStorageButton;
    @FXML
    private Button SleepButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = UI.getInstance().getBusiness();
        this.playerInventory = FXCollections.observableArrayList(game.getItemPlayer());
        this.roomInventory = FXCollections.observableArrayList(game.getItemRoom());
        this.inventoryTotal = FXCollections.observableArrayList(game.getInventoryTotal());
        this.inventoryComputer = FXCollections.observableArrayList(game.getInventoryComputer());
        this.houseInventory = FXCollections.observableArrayList(game.getInventoryHouse());
        MerchantListViewSell.setItems(playerInventory);
        RoomInventoryListview.setItems(roomInventory);
        HomeStorageListView.setItems(houseInventory);
        PlayerInventoryListview.setItems(playerInventory);
        PlayerInventoryListview1.setItems(playerInventory);
        PlayerInventoryListview2.setItems(playerInventory);
        TotalInventoryListView.setItems(inventoryTotal);
        BuildComputerListView.setItems(inventoryComputer);
        MoneyLabel.setText("Money: " + (Integer.toString(game.wallet())));
    }   
    @FXML
    private void GoButtonHandler(ActionEvent event) {
        String output = "";
        if(event.getSource() == GoNorthButton){
            output = game.goRoom("north");
            TextAreaStatus.appendText(output + "\n");
        }
        else if(event.getSource()== GoEastButton){
            output = game.goRoom("east");
            TextAreaStatus.appendText(output + "\n");
        }
        else if (event.getSource() == GoWestButton){
            output = game.goRoom("west");
            TextAreaStatus.appendText(output + "\n");
        }
        else if (event.getSource() == GoSouthButton){
            output = game.goRoom("south");
            TextAreaStatus.appendText(output + "\n");
        }
        if(game.getCurrentRoom().getShortDescription() == "at your home"){
            BuildButton.setVisible(true);
            HomeStorageButton.setVisible(true);
            SleepButton.setVisible(true);
        } 
        else {
            BuildButton.setVisible(false);
            HomeStorageButton.setVisible(false);
            SleepButton.setVisible(false);
        }
        if(game.getCurrentRoom().getShortDescription() == "at your home"){
            MapView.setImage(mapHomeImage);
            MinimapView.setImage(minimapHomeImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at downtown"){
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
        }
        else if (game.getCurrentRoom().getShortDescription()== "at the entrance to the scrapyard" && game.getCurrentRoom().getExit("south").getIsLocked() == true){
            MapView.setImage(mapEntranceLockedImage);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getIsLocked()==false){
            MapView.setImage(mapEntranceOpenImage);
            MinimapView.setImage(minimapScrapyardEntranceImage);
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the merchant"){
            MinimapView.setImage(minimapMerchantImage);
            MapView.setImage(mapMerchantImage);
            this.merchantItems = FXCollections.observableArrayList(game.getItemMerchant());
            MerchantListViewBuy.setItems(merchantItems);
            MerchantsPane.toFront();
        }
        else if (game.getCurrentRoom().getShortDescription() == "at gamestop"){
            MapView.setImage(mapGamestopImage);
            MinimapView.setImage(minimapGamestopImage);
            this.gamestopItems = FXCollections.observableArrayList(game.getItemGamestop());
            MerchantListViewBuy.setItems(gamestopItems);
            MerchantsPane.toFront();
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
            MapView.setImage(mapMiddleImage);
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
        int i= PlayerInventoryListview.getSelectionModel().getSelectedIndex();
        String output;
            output = game.use(i);
            TextAreaStatus.appendText(output + "\n");
        if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getExit("south").getIsLocked() == false){
            MapView.setImage(mapEntranceOpenImage);
        }
        playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void BuyItemsButtonHandler(ActionEvent event) {
        String output;
        int i= MerchantListViewBuy.getSelectionModel().getSelectedIndex();
            output = game.buyItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
            MoneyLabel.setText(Integer.toString(game.wallet()));
    }

    @FXML
    private void ExitStoreButtonHandler(ActionEvent event) {
        if(game.getCurrentRoom().getShortDescription() == "at the merchant"){
            game.goRoom("west");
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
        }
        else{
            game.goRoom("east");
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
        }
        MapPane.toFront();
    }

    @FXML
    private void SellitemsButtonHandler(ActionEvent event) {
        int i= MerchantListViewSell.getSelectionModel().getSelectedIndex();
        String output;
        output = game.sellItem(i);
        TextAreaStatus.appendText(output + "\n");
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
        String output;
        int i= RoomInventoryListview.getSelectionModel().getSelectedIndex();
            output = game.addItem(i);
            TextAreaStatus.appendText(output + "\n");
            roomInventory.setAll(game.getItemRoom());
            playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void DropButtonHandler(ActionEvent event) {
        String output;
        int i= PlayerInventoryListview2.getSelectionModel().getSelectedIndex();
            output = game.dropItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void CloseButtonHandler(ActionEvent event) {
        MapPane.toFront();
    }

    @FXML
    private void SaveButtonHandler(ActionEvent event) {
    }

    @FXML
    private void HelpButtonHandler(ActionEvent event) {
    }

    @FXML
    private void AboutButtonHandler(ActionEvent event) {
    }

//    @FXML
//    private boolean QuitButtonHandler(ActionEvent event) {
//       //  game.quit(true);
//    //}

    @FXML
    private void AddPartHandler(ActionEvent event) {
        String output;
        int i= TotalInventoryListView.getSelectionModel().getSelectedIndex();
        output = game.addParts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }

    @FXML
    private void BuildComputerHandler(ActionEvent event) {
        game.buildComputer();
    }

    @FXML
    private void CancelBuildButtonHandler(ActionEvent event) {
        MapPane.toFront();
    }

    @FXML
    private void QuitButtonHandler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void BuildButtonHandler(ActionEvent event) {
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
        HomePane.toFront();
        
    }

    @FXML
    private void RemovePartButtonHandler(ActionEvent event) {
        String output;
        int i= BuildComputerListView.getSelectionModel().getSelectedIndex();
        output = game.removeparts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }

    @FXML
    private void InventoryButtonHandler(ActionEvent event) {
        playerInventory.setAll(game.getItemPlayer());
        InventoryPane.toFront();
    }

    @FXML
    private void HomeStorageButtonHandler(ActionEvent event) {
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
        HomeStoragePane.toFront();
    }

    @FXML
    private void AddToHomeButtonHandler(ActionEvent event) {
        String output;
        int i= PlayerInventoryListview1.getSelectionModel().getSelectedIndex();
        output = game.storeItems(i);
        TextAreaStatus.appendText(output + "\n");
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void AddToPlayerInventoryButtonHandler(ActionEvent event) {
        String output;
        int i= HomeStorageListView.getSelectionModel().getSelectedIndex();
        output = game.addItem(i);
        TextAreaStatus.appendText(output + "\n");
        playerInventory.setAll(game.getItemPlayer());
        houseInventory.setAll(game.getInventoryHouse());
    }

    @FXML
    private void SleepButtonHandler(ActionEvent event) {
        String output;
        output = game.sleep();
        TextAreaStatus.appendText(output + "\n");
    }
        
}
