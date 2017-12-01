/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import acquaintance.IBusiness;
import acquaintance.IItem;
import acquaintance.IPlayer;
import business.Rat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
   // private ObservableList<Item> itemName;
    /**
     * Initializes the controller class.
     */
    Image mapHomeImage = new Image(getClass().getResource("images/home ms.png").toExternalForm());
    Image mapDowntoImage = new Image(getClass().getResource("images/downtown us.png").toExternalForm());
    Image mapDowntownMSImage = new Image(getClass().getResource("images/downtown ms.png").toExternalForm());
    Image mapMerchantImage = new Image(getClass().getResource("images/ali ms.png").toExternalForm());
    Image mapGamestopImage = new Image(getClass().getResource("images/gamestop ms.png").toExternalForm());
    Image mapEntranceLockedImage = new Image(getClass().getResource("images/yard entrance låst ms.png").toExternalForm());
    Image mapEntranceOpenImage = new Image(getClass().getResource("images/yard entrance åben ms.png").toExternalForm());
    Image mapMiddleImage = new Image (getClass().getResource("images/yard middle ms.png").toExternalForm());
    Image mapSouthImage = new Image(getClass().getResource("images/yard south ms.png").toExternalForm());
    Image mapNorthEastImage = new Image(getClass().getResource("images/yard northeast ms.png").toExternalForm());
    Image mapNorthWestImage = new Image(getClass().getResource("images/yard northvest ms.png").toExternalForm());
    Image mapSouthEastImage = new Image(getClass().getResource("images/yard southeast ms.png").toExternalForm());
    Image mapSouthWestImage = new Image(getClass().getResource("images/yard southvest ms.png").toExternalForm());
    
    Image minimapHomeImage = new Image(getClass().getResource("images/MiniMap_Home.png").toExternalForm());
    Image minimapDowntownImage = new Image(getClass().getResource("images/MiniMap_DownTown.png").toExternalForm());
    Image minimapGamestopImage = new Image(getClass().getResource("images/MiniMap_GameStop.png").toExternalForm());
    Image minimapMerchantImage = new Image(getClass().getResource("images/MiniMap_Merchant.png").toExternalForm());
    Image minimapScrapyardEntranceImage = new Image(getClass().getResource("images/MiniMap_ScrapyardEntrance.png").toExternalForm());
    Image minimapScrapyardMiddleImage = new Image(getClass().getResource("images/MiniMap_ScrapyardMiddle.png").toExternalForm());
    Image minimapScrapyardWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardWest.png").toExternalForm());
    Image minimapScrapyardEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardEast.png").toExternalForm());
    Image minimapScrapyardSouthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouth.png").toExternalForm());
    Image minimapScrapyardSouthWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthWest.png").toExternalForm());
    Image minimapScrapyardSouthEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthEast.png").toExternalForm());
    Image minimapScrapyardMiddleRatSouthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardMiddleRat3.png").toExternalForm());
    Image minimapScrapyardMiddleRatWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardMiddleRat2.png").toExternalForm());
    Image minimapScrapyardMiddleRatEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardMiddleRat1.png").toExternalForm());
    Image minimapScrapyardMiddleRatMiddleImage = new Image(getClass().getResource("images/MiniMap_ScrapyardMiddleRat4.png").toExternalForm());
    Image minimapScrapyardWestRatSouthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardWestRat2.png").toExternalForm());
    Image minimapScrapyardWestRatEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardWestRat1.png").toExternalForm());
    Image minimapScrapyardWestRatWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardWestRat3.png").toExternalForm());
    Image minimapScrapyardEastRatSouthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardEastRat2.png").toExternalForm());
    Image minimapScrapyardEastRatWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardEastRat1.png").toExternalForm());
    Image minimapScrapyardEastRatEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardEastRat3.png").toExternalForm());
    Image minimapScrapyardSouthRatNorthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthRat3.png").toExternalForm());
    Image minimapScrapyardSouthRatEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthRat1.png").toExternalForm());
    Image minimapScrapyardSouthRatWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthRat2.png").toExternalForm());
    Image minimapScrapyardSouthRatSouthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthRat4.png").toExternalForm());
    Image minimapScrapyardSouthEastRatNorthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthEastRat3.png").toExternalForm());
    Image minimapScrapyardSouthEastRatWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthEastRat2.png").toExternalForm());
    Image minimapScrapyardSouthEastRatSouthEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthEastRat1.png").toExternalForm());
    Image minimapScrapyardSouthWestRatNorthImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthWestRat2.png").toExternalForm());
    Image minimapScrapyardSouthWestRatEastImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthWestRat1.png").toExternalForm());
    Image minimapScrapyardSouthWestRatSouthWestImage = new Image(getClass().getResource("images/MiniMap_ScrapyardSouthWestRat3.png").toExternalForm());
    
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
    @FXML
    private StackPane Stackpane;
    @FXML
    private Label DayCounterLabel;
    @FXML
    private Label StepCounterLabel;
    @FXML
    private Pane IntroPane;
    @FXML
    private ImageView IntroScreen;
    @FXML
    private Pane OutroPane;
    @FXML
    private ImageView OutroScreen;
    @FXML
    private Button NewGameButton;
    @FXML
    private TextField PlayerNameTextField;
    @FXML
    private Label Item1BuildPCLabel;
    @FXML
    private Label Item2BuildPCLabel;
    @FXML
    private Label Item3BuildPCLabel;
    @FXML
    private Label TotalScoreBuildPCLabel;
    @FXML
    private Label WinOrLoseBuildPCLabel;
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
        MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
    }   
    @FXML
    private void GoButtonHandler(ActionEvent event) {
        String output = "";
        GoNorthButton.setDisable(false);
        GoWestButton.setDisable(false);
        GoEastButton.setDisable(false);
        GoSouthButton.setDisable(false);
         if(game.timeToBuild()){
            HomePane.toFront();
            
            GoNorthButton.setVisible(false);
            GoWestButton.setVisible(false);
            GoEastButton.setVisible(false);
            GoSouthButton.setVisible(false);
            InventoryButton.setVisible(false);
            InspectButton.setVisible(false);
            SleepButton.setVisible(false);
            BuildButton.setVisible(false);
            HomeStorageButton.setVisible(false);
            CancelBuildButton.setDisable(true);
            inventoryTotal.setAll(game.getInventoryTotal());
            inventoryComputer.setAll(game.getInventoryComputer());
            if(game.requiredPartsChecker() == false){
                OutroPane.toFront();
            }
        }
        TextAreaStatus.clear();
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
        if (game.getCurrentRoom().getExit("north") == null){
            GoNorthButton.setDisable(true);
        }
        if (game.getCurrentRoom().getExit("east") == null){
            GoEastButton.setDisable(true);
        }
        if (game.getCurrentRoom().getExit("west") == null){
            GoWestButton.setDisable(true);
        }
        if (game.getCurrentRoom().getExit("south") == null){
            GoSouthButton.setDisable(true);
        }
        if(game.getCurrentRoom().getShortDescription() == "at your home" && game.timeToBuild() == false){
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
            if(game.getRatCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardMiddleRatSouthImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
                 MinimapView.setImage(minimapScrapyardMiddleRatWestImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
                 MinimapView.setImage(minimapScrapyardMiddleRatEastImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
                MinimapView.setImage(minimapScrapyardMiddleRatMiddleImage);        
            }
            else{
                MinimapView.setImage(minimapScrapyardMiddleImage);
            }
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
            MapView.setImage(mapNorthWestImage);
            if(game.getRatCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardWestRatSouthImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
                MinimapView.setImage(minimapScrapyardWestRatEastImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardWestRatWestImage);
            }
            else{
                MinimapView.setImage(minimapScrapyardWestImage);
            }
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
            MapView.setImage(mapNorthEastImage);
            if(game.getRatCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
                MinimapView.setImage(minimapScrapyardEastRatWestImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardEastRatSouthImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardEastRatEastImage);
            }
            else{
                MinimapView.setImage(minimapScrapyardEastImage);
            }
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
            MapView.setImage(mapSouthImage);
            if(game.getRatCurrentRoom().getShortDescription() == "at the center of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthRatNorthImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthRatEastImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthRatWestImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthRatSouthImage);
            }
            else{
                MinimapView.setImage(minimapScrapyardSouthImage);
            }
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
            MapView.setImage(mapSouthEastImage);
            if(game.getRatCurrentRoom().getShortDescription() == "at the east part of the scrapyard"){
                 MinimapView.setImage(minimapScrapyardSouthEastRatNorthImage);
            }
            else if(game.getRatCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthEastRatWestImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthEastRatSouthEastImage);
            }
            else{
                MinimapView.setImage(minimapScrapyardSouthEastImage);
            }
        }
        else if (game.getCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
            MapView.setImage(mapSouthWestImage);
            if(game.getRatCurrentRoom().getShortDescription() == "at the west part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthWestRatNorthImage);
            }
            else if(game.getRatCurrentRoom().getShortDescription() == "at the south part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthWestRatEastImage);
            }
            else if (game.getRatCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard"){
                MinimapView.setImage(minimapScrapyardSouthWestRatSouthWestImage);
            }
            else{
                MinimapView.setImage(minimapScrapyardSouthWestImage);
            }
        }
        DayCounterLabel.setText(Integer.toString(game.getDayToken()));
        StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
        MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
    }

    @FXML
    private void UseButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        int i= PlayerInventoryListview.getSelectionModel().getSelectedIndex();
        String output;
            output = game.use(i);
            TextAreaStatus.appendText(output + "\n");
        if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getExit("south").getIsLocked() == false){
            MapView.setImage(mapEntranceOpenImage);
        }
        playerInventory.setAll(game.getItemPlayer());
        DayCounterLabel.setText(Integer.toString(game.getDayToken()));
        StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
    }

    @FXML
    private void BuyItemsButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= MerchantListViewBuy.getSelectionModel().getSelectedIndex();
            output = game.buyItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
            MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
    }

    @FXML
    private void ExitStoreButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        if(game.getCurrentRoom().getShortDescription() == "at the merchant"){
            game.goRoom("west");
            GoNorthButton.setDisable(false);
            GoSouthButton.setDisable(false);
            GoEastButton.setDisable(false);
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
            DayCounterLabel.setText(Integer.toString(game.getDayToken()));
            StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
        }
        else{
            TextAreaStatus.clear();
            game.goRoom("east");
            GoNorthButton.setDisable(false);
            GoSouthButton.setDisable(false);
            GoWestButton.setDisable(false);
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
            DayCounterLabel.setText(Integer.toString(game.getDayToken()));
            StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
        }
        MapPane.toFront();
    }

    @FXML
    private void SellitemsButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        int i= MerchantListViewSell.getSelectionModel().getSelectedIndex();
        String output;
        output = game.sellItem(i);
        TextAreaStatus.appendText(output + "\n");
        playerInventory.setAll(game.getItemPlayer());
        MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
    }

    @FXML
    private void InspectButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        roomInventory.setAll(game.getItemRoom());
        playerInventory.setAll(game.getItemPlayer());
        InspectPane.toFront();
    }

    @FXML
    private void PickupButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= RoomInventoryListview.getSelectionModel().getSelectedIndex();
        if(!RoomInventoryListview.getSelectionModel().isEmpty()){
            output = game.addItem(i);
            TextAreaStatus.appendText(output + "\n");
            roomInventory.setAll(game.getItemRoom());
            playerInventory.setAll(game.getItemPlayer());
        }
        else{
            TextAreaStatus.appendText("You need to select an item"); //Make this other places too tomorrow.
        }
    }

    @FXML
    private void DropButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i;
        System.out.println(Stackpane.getChildren());
        if(Stackpane.getChildren().get(Stackpane.getChildren().size()-1) == InspectPane){
            i= PlayerInventoryListview2.getSelectionModel().getSelectedIndex();
            output = game.dropItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
        }
        if(Stackpane.getChildren().get(Stackpane.getChildren().size()-1)== InventoryPane){
            TextAreaStatus.clear();
            i = PlayerInventoryListview.getSelectionModel().getSelectedIndex();
            output = game.dropItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
        }
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
        TextAreaStatus.clear();
        String output;
        int i= TotalInventoryListView.getSelectionModel().getSelectedIndex();
        output = game.addParts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }

    @FXML
    private void BuildComputerHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String[] output = new String[6];
        output = game.buildComputer();
        OutroPane.toFront();
        OutroPane.setVisible(true);
        MenuPane.setVisible(false);
        Item1BuildPCLabel.setText(output[0]);
        if(output[1] != null){
            Item2BuildPCLabel.setText(output[1]);
            Item3BuildPCLabel.setText(output[2]);
            TotalScoreBuildPCLabel.setText(output[3]);
            WinOrLoseBuildPCLabel.setText(output[4] + "\n" +  output[5]);
        }
        else{
            Item2BuildPCLabel.setVisible(false);
            Item3BuildPCLabel.setVisible(false);
            TotalScoreBuildPCLabel.setVisible(false);
            WinOrLoseBuildPCLabel.setVisible(false);
        }
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
        TextAreaStatus.clear();
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
        HomePane.toFront();
        
    }

    @FXML
    private void RemovePartButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= BuildComputerListView.getSelectionModel().getSelectedIndex();
        output = game.removeparts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }

    @FXML
    private void InventoryButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        playerInventory.setAll(game.getItemPlayer());
        InventoryPane.toFront();
    }

    @FXML
    private void HomeStorageButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
        HomeStoragePane.toFront();
    }

    @FXML
    private void AddToHomeButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= PlayerInventoryListview1.getSelectionModel().getSelectedIndex();
        output = game.storeItems(i);
        TextAreaStatus.appendText(output + "\n");
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
    }

    @FXML
    private void AddToPlayerInventoryButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= HomeStorageListView.getSelectionModel().getSelectedIndex();
        output = game.addItem(i);
        TextAreaStatus.appendText(output + "\n");
        playerInventory.setAll(game.getItemPlayer());
        houseInventory.setAll(game.getInventoryHouse());
    }

    @FXML
    private void SleepButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        output = game.sleep();
        TextAreaStatus.appendText(output + "\n");
        DayCounterLabel.setText(Integer.toString(game.getDayToken()));
        StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
    }

    @FXML
    private void NewGameButtonHandler(ActionEvent event) {
        MenuPane.setVisible(true);
        GoNorthButton.setDisable(true);
        GoWestButton.setDisable(true);
        GoEastButton.setDisable(true);
        MapPane.toFront();
        IntroPane.setVisible(false);
        game.setPlayerName(PlayerNameTextField.getText());
    }

        
}
