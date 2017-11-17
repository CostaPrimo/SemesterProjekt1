/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogicGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nikolaj Frank-Jensen
 */
public class SemesterProjektGUIController implements Initializable {

    @FXML
    private Button InventoryButton;
    @FXML
    private Button MenuButton;
    @FXML
    private Button InspectButton;
    @FXML
    private Pane HomePane;
    @FXML
    private TextArea TextAreaStatus;
    @FXML
    private ImageView MapView;
    @FXML
    private ImageView MinimapView;
    @FXML
    private Button GoNorthButton;
    @FXML
    private Button GoWestButton;
    @FXML
    private Button goSouthButton;
    @FXML
    private Button GoEastButton;
    @FXML
    private Label MoneyLabel;
    @FXML
    private Pane DowntownPane;
    @FXML
    private TextArea TextAreaStatus1;
    @FXML
    private ImageView MapView1;
    @FXML
    private ImageView MinimapView1;
    @FXML
    private Button GoNorthButton1;
    @FXML
    private Button GoWestButton1;
    @FXML
    private Button goSouthButton1;
    @FXML
    private Button GoEastButton1;
    @FXML
    private Label MoneyLabel1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goNorthButtonHandler(ActionEvent event) {
    }

    @FXML
    private void GoWestButtonHandler(ActionEvent event) {
    }

    @FXML
    private void GoSouthButtonHandler(ActionEvent event) {
            
    }

    @FXML
    private void GoEastButtonHandler(ActionEvent event) {
    }

    @FXML
    private void goSouthButtonClicked(MouseEvent event) {
        if(event.getSource() == goSouthButton){
            HomePane.setVisible(false);
            DowntownPane.setVisible(true);
            
        }
    }
    
}
