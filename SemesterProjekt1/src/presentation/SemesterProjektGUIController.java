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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * <h1>FXML Controller class!</h1>
 * @author Gruppe 20
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
    /**
     * Initializes the controller image objects
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
    Image magazineImage = new Image(getClass().getResource("images/gamemagazine.jpg").toExternalForm());
    Image PcScoreJunk = new Image(getClass().getResource("images/junk.png").toExternalForm());
    Image PcScoreNormal = new Image(getClass().getResource("images/normal.png").toExternalForm());
    Image PcScoreRare = new Image(getClass().getResource("images/rare.png").toExternalForm());
    Image PcScoreEpic = new Image(getClass().getResource("images/epic.png").toExternalForm());
    Image PcScoreLegendary = new Image(getClass().getResource("images/legendary.png").toExternalForm());
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
    @FXML
    private Pane ValutaManPane;
    @FXML
    private Button ChoiceAButton;
    @FXML
    private Button ChoiceBButton;
    @FXML
    private Button ChoiceCButton;
    @FXML
    private Button ChoiceDButton;
    @FXML
    private Button HighscoresButton;
    @FXML
    private GridPane HighscorePane;
    @FXML
    private Label HighscoreLabel9;
    @FXML
    private Label HighscoreLabel8;
    @FXML
    private Label HighscoreLabel7;
    @FXML
    private Label HighscoreLabel6;
    @FXML
    private Label HighscoreLabel5;
    @FXML
    private Label HighscoreLabel4;
    @FXML
    private Label HighscoreLabel3;
    @FXML
    private Label HighscoreLabel2;
    @FXML
    private Label HighscoreLabel1;
    @FXML
    private Label HighscoreLabel0;
    @FXML
    private Button ReturnMenubutton;
    @FXML
    private Button CloseHomeStorageButton;
    @FXML
    private Button CloseInspectButton;
    @FXML
    private Button CloseInventoryButton;
    @FXML
    private Button LoadGameButton;
    @FXML
    private Pane GameMagazinePane;
    @FXML
    private ImageView MagazineView;
    @FXML
    private TextArea TextAreaMagazine;
    @FXML
    private Button CloseMagazineButton;
    @FXML
    private Pane HelpPane;
    @FXML
    private Label HelpLabel;
    @FXML
    private Label Hint1Label;
    @FXML
    private Label Hint2Label;
    @FXML
    private Label Hint3Label;
    @FXML
    private Label Hint4Label;
    @FXML
    private Label Hint5Label;
    @FXML
    private Label Hint6Label;
    @FXML
    private TextField TextHint1;
    @FXML
    private TextField TextHint2;
    @FXML
    private TextField TextHint3;
    @FXML
    private TextField TextHint4;
    @FXML
    private TextField TextHint5;
    @FXML
    private TextField TextHint6;
    @FXML
    private Pane TutorialPane;
    @FXML
    private Label TutorialLabel;
    @FXML
    private TextField TutorialText1;
    @FXML
    private TextField TutorialText2;
    @FXML
    private TextField TutorialText3;
    @FXML
    private TextField TutorialText4;
    @FXML
    private TextField TutorialText5;
    @FXML
    private TextField TutorialText6;
    @FXML
    private TextField TutorialText7;
    @FXML
    private Button CloseTutorialButton;
    @FXML
    private Pane AboutPane;
    @FXML
    private Label AboutLabel;
    @FXML
    private TextArea AboutTextArea;
    @FXML
    private Button CloseAboutButton;
    @FXML
    private Button CloseHelpButton;
    @FXML
    private Button OutroHighscorePane;
    @FXML
    private Button HighscoresButton1;
    @FXML
    private TextField TutorialText8;
    @FXML
    private Button HighscoreQuitButton;
    /**
     * This method initializes and assigns observablelists to listviews.
     * This method also gets an instance of the business class with UI.
     * @param url
     * @param rb 
     */
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
        AboutTextArea.setText("Who are we?"
                + "\nWe're a group of 6 students, \nwho was given the task to create a simple game."
                + "\nAll we were given was the base of the game,\nwhich barely worked."
                + "\nWe all had litlle to no programming expertise at the beginning.\n"
                + "\nWe hope you like the game"
                + "\nSincerely Group 20");
    }
    /**
     * This method is invoked each time any go button is pressed.
     * It will call the go room method and assign the direction depending on which button was clicked.
     * It will also update statuses on the right buttons. 
     * It will furthermore handle most events, update maps, minimaps, panes. This is the core of the controller.
     * It will handle various events from the business layer, and show different graphical scenarious depending on what happens.
     * @param event 
     */
    @FXML
    private void GoButtonHandler(ActionEvent event) {
        String output = "";
        String[] questionOutput;
        GoNorthButton.setDisable(false);
        GoWestButton.setDisable(false);
        GoEastButton.setDisable(false);
        GoSouthButton.setDisable(false);
        InspectButton.setVisible(true);
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
        InspectButton.setVisible(true);
        InventoryButton.setVisible(true);
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
            InspectButton.setVisible(false);
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
            InspectButton.setVisible(false);
            InventoryButton.setVisible(false);
            GoNorthButton.setVisible(false);
            GoEastButton.setVisible(false);
            GoWestButton.setVisible(false);
            GoSouthButton.setVisible(false);
            this.merchantItems = FXCollections.observableArrayList(game.getItemMerchant());
            MerchantListViewBuy.setItems(merchantItems);
            MerchantsPane.toFront();
        }
        else if (game.getCurrentRoom().getShortDescription() == "at gamestop"){
            MapView.setImage(mapGamestopImage);
            MinimapView.setImage(minimapGamestopImage);
            InspectButton.setVisible(false);
            InventoryButton.setVisible(false);
            GoNorthButton.setVisible(false);
            GoEastButton.setVisible(false);
            GoWestButton.setVisible(false);
            GoSouthButton.setVisible(false);
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
            if(game.questionTime()){
                ValutaManPane.toFront();
                ValutaManPane.setVisible(true);
                questionOutput = game.printQuestion();
                TextAreaStatus.appendText(questionOutput[0]);
                ChoiceAButton.setText(questionOutput[1]);
                ChoiceBButton.setText(questionOutput[2]);
                TextAreaStatus.appendText(questionOutput[1]);
                ChoiceCButton.setText(questionOutput[3]);
                TextAreaStatus.appendText(questionOutput[2]);
                ChoiceDButton.setText(questionOutput[4]);
                TextAreaStatus.appendText(questionOutput[3]);
                TextAreaStatus.appendText(questionOutput[4]);
            
            }
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
    /**
     * This method will be invoked when the use button is pressed in the playerinventory section.
     * It will make sure a graphical change occurs corresponding to the impact from the business layer.
     * Furthermore is theree a check to make sure the player has selected an item.
     * @param event 
     */
    @FXML
    private void UseButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        if(!PlayerInventoryListview.getSelectionModel().isEmpty()){
        int i= PlayerInventoryListview.getSelectionModel().getSelectedIndex();
        String output;
            output = game.use(i);
            TextAreaStatus.appendText(output + "\n");
        if (game.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard" && game.getCurrentRoom().getExit("south").getIsLocked() == false){
            MapView.setImage(mapEntranceOpenImage);
        }
        if(output.contains("GameMagazine 13.37th. edition ’17.")){
            TextAreaStatus.clear();
            TextAreaMagazine.appendText(output);
            GameMagazinePane.toFront();
        }
        playerInventory.setAll(game.getItemPlayer());
        DayCounterLabel.setText(Integer.toString(game.getDayToken()));
        StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
    }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method will be invoked once the buy item button is pressed.
     * It will send a request to the businessfacade and that will take care of the logic performed.
     * It also makes sure an item is selected.
     * @param event 
     */
    @FXML
    private void BuyItemsButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= MerchantListViewBuy.getSelectionModel().getSelectedIndex();
        if(!MerchantListViewBuy.getSelectionModel().isEmpty()){
            output = game.buyItem(i);
            TextAreaStatus.appendText(output + "\n");
            playerInventory.setAll(game.getItemPlayer());
            MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
        }
        else
            TextAreaStatus.appendText("Please select an item");
    }
    /**
     * This method is invoked whhen the exit store button is pressed.
     * It will change the status of the right buttons and move the player out of the store depending on which store the player is in.
     * @param event 
     */
    @FXML
    private void ExitStoreButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        if(game.getCurrentRoom().getShortDescription() == "at the merchant"){
            game.goRoom("west");
            GoNorthButton.setDisable(false);
            GoNorthButton.setVisible(true);
            GoSouthButton.setDisable(false);
            GoSouthButton.setVisible(true);
            GoEastButton.setDisable(false);
            GoEastButton.setVisible(true);
            GoWestButton.setVisible(true);
            InventoryButton.setVisible(true);
            InspectButton.setVisible(true);
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
            DayCounterLabel.setText(Integer.toString(game.getDayToken()));
            StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
        }
        else{
            TextAreaStatus.clear();
            game.goRoom("east");
            GoNorthButton.setDisable(false);
            GoNorthButton.setVisible(true);
            GoSouthButton.setDisable(false);
            GoSouthButton.setVisible(true);
            GoWestButton.setDisable(false);
            GoWestButton.setVisible(true);
            GoEastButton.setVisible(true);
            InventoryButton.setVisible(true);
            InspectButton.setVisible(true);
            MapView.setImage(mapDowntownMSImage);
            MinimapView.setImage(minimapDowntownImage);
            DayCounterLabel.setText(Integer.toString(game.getDayToken()));
            StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
        }
        MapPane.toFront();
    }
    /**
     * This method is invoked once the sell item button is pressed.
     * It will sell an item and make sure an item is selected.
     * @param event 
     */
    @FXML
    private void SellitemsButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        int i= MerchantListViewSell.getSelectionModel().getSelectedIndex();
        if(!MerchantListViewSell.getSelectionModel().isEmpty()){
        String output;
        output = game.sellItem(i);
        TextAreaStatus.appendText(output + "\n");
        playerInventory.setAll(game.getItemPlayer());
        MoneyLabel.setText("$ " +(Integer.toString(game.wallet())));
        }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method is invoked when the inspect button is pressed.
     * It will show the items in the room and the player inventory.
     * @param event 
     */
    @FXML
    private void InspectButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        roomInventory.setAll(game.getItemRoom());
        playerInventory.setAll(game.getItemPlayer());
        InventoryButton.setVisible(false);
        InspectPane.toFront();
    }
    /**
     * This method is invoked when the pickup button is pressed.
     * This will pick up an item from the room by calling methods in the business-layer.
     * It also makes sure an item was selected.
     * @param event 
     */
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
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method will be invoked when the drop button is presed.
     * Two differnt panes uses the same button, inspect and inventory. Each case is made here.
     * Both cases will make sure an item was selected.
     * @param event 
     */
    @FXML
    private void DropButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i;
        int j = 0;
        if(!PlayerInventoryListview2.getSelectionModel().isEmpty()){
            if(Stackpane.getChildren().get(Stackpane.getChildren().size()-1) == InspectPane){
                i= PlayerInventoryListview2.getSelectionModel().getSelectedIndex();
                output = game.dropItem(i);
                TextAreaStatus.appendText(output + "\n");
                playerInventory.setAll(game.getItemPlayer());
                j++;
            }
        }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
        if(!PlayerInventoryListview.getSelectionModel().isEmpty()){
            if(Stackpane.getChildren().get(Stackpane.getChildren().size()-1)== InventoryPane){
                TextAreaStatus.clear();
                i = PlayerInventoryListview.getSelectionModel().getSelectedIndex();
                output = game.dropItem(i);
                TextAreaStatus.appendText(output + "\n");
                playerInventory.setAll(game.getItemPlayer());
            }
        }
        if(j!= 0){
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method will be invoked when the close button is pressed
     * It will deepend on which exact closebutton was pressed, each case has a different outcome.
     * @param event 
     */
    @FXML
    private void CloseButtonHandler(ActionEvent event) {
        MapPane.toFront();
        if(event.getSource() == CloseInventoryButton && game.getCurrentRoom().getName() != "home"){
            InspectButton.setVisible(true);
        }
        if(event.getSource() == CloseInventoryButton && game.getCurrentRoom().getName() == "home"){
            SleepButton.setVisible(true);
            HomeStorageButton.setVisible(true);
            BuildButton.setVisible(true);
        }
        if(event.getSource() == CloseHomeStorageButton){
            SleepButton.setVisible(true);
            HomeStorageButton.setVisible(true);
            BuildButton.setVisible(true);
            InventoryButton.setVisible(true);
        }
        if(event.getSource() == CloseInspectButton){
            InventoryButton.setVisible(true);
        }
    }
    /**
     * Saves the game.
     * @param event 
     */
    @FXML
    private void SaveButtonHandler(ActionEvent event) {
        game.saveGame();
    }

    @FXML
    private void HelpButtonHandler(ActionEvent event) {
        HelpPane.toFront();
        HelpPane.setVisible(true);
        MapPane.toBack();
        MenuPane.setVisible(false);
    }

    @FXML
    private void AboutButtonHandler(ActionEvent event) {
        AboutPane.toFront();
        AboutPane.setVisible(true);
        MapPane.toBack();
        MenuPane.setVisible(false);
    }

    /**
     * This method will be invoked when the add part button is pressed.
     * It will make sure an item was selecteed, and then add a part by callng the method from the businesslayer.
     * @param event 
     */
    @FXML
    private void AddPartHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        int i= TotalInventoryListView.getSelectionModel().getSelectedIndex();
        if(!TotalInventoryListView.getSelectionModel().isEmpty()){
        output = game.addParts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method will be invoked when the Build Computer button is pressed. It will build the computer and show the win or lose screen.
     * @param event 
     */
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
         if(game.wallet()<1600){
            OutroScreen.setImage(PcScoreJunk);
        }
        else if(game.wallet()<3000){
            OutroScreen.setImage(PcScoreNormal);
        }
        else if(game.wallet()<7500){
            OutroScreen.setImage(PcScoreRare);
        }
        else if(game.wallet()<12500){
            OutroScreen.setImage(PcScoreEpic);
        }
        else if(game.wallet()>=12500){
            OutroScreen.setImage(PcScoreLegendary);
        }
    }
    /**
     * This method will be invoked when the cancel button is pressed in the build computer section.
     * @param event 
     */
    @FXML
    private void CancelBuildButtonHandler(ActionEvent event) {
        MapPane.toFront();
        SleepButton.setVisible(true);
        HomeStorageButton.setVisible(true);
        BuildButton.setVisible(true);
        InventoryButton.setVisible(true);
    }
    /**
     * This method is invoked once the quit button or quit game button is pressed.
     * This method will close the application.
     * @param event 
     */
    @FXML
    private void QuitButtonHandler(ActionEvent event) {
        System.exit(0);
    }
    /**
     * This method will be invoked when the build button from the menu pane is pressed.
     * This will open the build computer pane.
     * @param event 
     */
    @FXML
    private void BuildButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
        HomePane.toFront();
        InspectButton.setVisible(false);
        SleepButton.setVisible(false);
        HomeStorageButton.setVisible(false);
        InventoryButton.setVisible(false);
        BuildButton.setVisible(false);
    }
    /**
     * This method is invoked when the remove part button is pressed. It will remove a part from the computer if allowed by the business layer. 
     * @param event 
     */
    @FXML
    private void RemovePartButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        if(!BuildComputerListView.getSelectionModel().isEmpty()){
        int i= BuildComputerListView.getSelectionModel().getSelectedIndex();
        output = game.removeparts(i);
        TextAreaStatus.appendText(output + "\n");
        inventoryTotal.setAll(game.getInventoryTotal());
        inventoryComputer.setAll(game.getInventoryComputer());
    }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method will be invoked when the inventory button is pressed.
     * It will show the inventory pane of the player where he can use or drop items.
     * @param event 
     */
    @FXML
    private void InventoryButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        playerInventory.setAll(game.getItemPlayer());
        InventoryPane.toFront();
        InspectButton.setVisible(false);
        SleepButton.setVisible(false);
        HomeStorageButton.setVisible(false);
        BuildButton.setVisible(false);
    }
    /**
     * This method is invoked if the home storage button is pressed.
     * It will show the inventory of the home and the player. The player can now transfer items as seen fit.
     * @param event 
     */
    @FXML
    private void HomeStorageButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
        HomeStoragePane.toFront();
        InspectButton.setVisible(false);
        SleepButton.setVisible(false);
        InventoryButton.setVisible(false);
        BuildButton.setVisible(false);
    }
    /**
     * This method is invoked when the add to home button is pressed in the home storage pane.
     * This method will make the player able to transfer an item from his/her inventory to the home storage.
     * @param event 
     */
    @FXML
    private void AddToHomeButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        if(!PlayerInventoryListview1.getSelectionModel().isEmpty()){
        int i= PlayerInventoryListview1.getSelectionModel().getSelectedIndex();
        output = game.storeItems(i);
        TextAreaStatus.appendText(output + "\n");
        houseInventory.setAll(game.getInventoryHouse());
        playerInventory.setAll(game.getItemPlayer());
        }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method is invoked when the add to player button is pressed.
     * This method will transfer an item from the home storage to the player.
     * @param event 
     */
    @FXML
    private void AddToPlayerInventoryButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        if(!HomeStorageListView.getSelectionModel().isEmpty()){
        int i= HomeStorageListView.getSelectionModel().getSelectedIndex();
        output = game.addItem(i);
        TextAreaStatus.appendText(output + "\n");
        playerInventory.setAll(game.getItemPlayer());
        houseInventory.setAll(game.getInventoryHouse());
        }
        else{
            TextAreaStatus.appendText("You need to select an item");
        }
    }
    /**
     * This method is invoked when the sleep button is pressed.
     * This method will simply call the sleep method from the business layer.
     * @param event 
     */
    @FXML
    private void SleepButtonHandler(ActionEvent event) {
        TextAreaStatus.clear();
        String output;
        output = game.sleep();
        TextAreaStatus.appendText(output + "\n");
        DayCounterLabel.setText(Integer.toString(game.getDayToken()));
        StepCounterLabel.setText(Integer.toString(game.getTimeToken()));
    }
    /**
     * This method is invoked whenever the new game button is pressed.
     * This method will prepare the game to look as it should graphical wise and allow the player to enter a name.
     * @param event 
     */
    @FXML
    private void NewGameButtonHandler(ActionEvent event) {
        String output = "";
        if(!PlayerNameTextField.getText().contains("\n") && !PlayerNameTextField.getText().contains(" ")){
        GoNorthButton.setDisable(true);
        GoWestButton.setDisable(true);
        GoEastButton.setDisable(true);
        MapPane.toFront();
        IntroPane.setVisible(false);
        OutroPane.setVisible(false);
        HelpPane.setVisible(false);
        AboutPane.setVisible(false);
        game.setPlayerName(PlayerNameTextField.getText());
        output = game.printWelcome();
        TextAreaStatus.appendText(output);
        TutorialPane.toFront();
        }
        else{
            PlayerNameTextField.setText("No spaces in name");
        }
    }
    /**
     * This method is invoked when the player clicks the load game button.
     * This method will call the load game method and then call the goButtonHandler to update the graphics accordingly depending on location and so on.
     * @param event 
     */
    @FXML
    private void LoadButtonHandler(ActionEvent event) {
        game.loadGame();
        GoButtonHandler(event);
        roomInventory.setAll(game.getItemRoom());
        MenuPane.setVisible(true);
        MapPane.toFront();
        IntroPane.setVisible(false);
        OutroPane.setVisible(false);
        HelpPane.setVisible(false);
        AboutPane.setVisible(false);
        TutorialPane.setVisible(false);
    }
    /**
     * This method is invoked when the player selects a choice when meeting the ludoman NPC.
     * This method will check which button was pressed and send it down to the business layer which handles the logic.
     * @param event 
     */
    @FXML
    private void ChoiceButtonHandler(ActionEvent event) {
        String output = "";
        if(event.getSource() == ChoiceAButton){
            output = game.answerQuestion('a');
            TextAreaStatus.appendText(output);
        }
        else if(event.getSource() == ChoiceBButton){
            output = game.answerQuestion('b');
            TextAreaStatus.appendText(output);
        }
        else if (event.getSource() == ChoiceCButton){
            output = game.answerQuestion('c');
            TextAreaStatus.appendText(output);
        }
        else if (event.getSource() == ChoiceDButton){
            output = game.answerQuestion('d');
            TextAreaStatus.appendText(output);
        }
        ValutaManPane.setVisible(false);
        MapPane.toFront();
        
    }
    /**
     * This method is invoked when the Highscore button is pressed.
     * This method will use a StringArray to present the scres on different labels.
     * This method makes sure only to demand scores as long as there is a score in the array.
     * @param event 
     */
    @FXML
    private void HighscoresButtonHandler(ActionEvent event) {
        HighscorePane.toFront();
        HighscoreQuitButton.setVisible(false);
        int i;
        i = game.loadHighscore().length;
        String[] output = new String[10];
        output = game.loadHighscore();
        HighscoreLabel0.setText(output[0]);
        if(i >= 2){
        HighscoreLabel1.setText(output[1]);
        }
        if(i>=3){
        HighscoreLabel2.setText(output[2]);
        }
        if(i>=4)
        HighscoreLabel3.setText(output[3]);
        if(i>=5){
        HighscoreLabel4.setText(output[4]);
        }
        if(i>=6){
        HighscoreLabel5.setText(output[5]);
        }
        if(i>=7){
        HighscoreLabel6.setText(output[6]);
        }
        if(i>=8){
        HighscoreLabel7.setText(output[7]);
        }
        if(i>=9){
        HighscoreLabel8.setText(output[8]);
        }
        if(i>=10){
        HighscoreLabel9.setText(output[9]);
        }
        if(event.getSource() == HighscoresButton1){
            ReturnMenubutton.setVisible(false);
            OutroPane.setVisible(false);
            IntroPane.toFront();
            IntroPane.setVisible(true);
            MenuPane.setVisible(false);
            HighscorePane.toFront();
            NewGameButton.setVisible(false);
            LoadGameButton.setVisible(false);
            HighscoresButton.setVisible(false);
            PlayerNameTextField.setVisible(false);
            HighscoreQuitButton.setVisible(true);
        }
    }
    /**
     * This method is invoked when the return to menu button is pressed on the Highscore pane. 
     * @param event 
     */
    @FXML
    private void ReturnMenuButtonHandler(ActionEvent event) {
        IntroPane.toFront();
    }

    @FXML
    private void CloseTutorialButtonHandler(ActionEvent event) {
        TutorialPane.toBack();
        TutorialPane.setVisible(false);
        MapPane.toFront();
        MenuPane.setVisible(true);
    }

    @FXML
    private void CloseAboutButtonHandler(ActionEvent event) {
        AboutPane.toBack();
        AboutPane.setVisible(false);
        MapPane.toFront();
        MenuPane.setVisible(true);
    }

    @FXML
    private void CloseHelpButtonHandler(ActionEvent event) {
        HelpPane.toBack();
        HelpPane.setVisible(false);
        MapPane.toFront();
        MenuPane.setVisible(true);
    }

        
}
