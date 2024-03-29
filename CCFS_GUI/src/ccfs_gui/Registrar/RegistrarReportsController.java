/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccfs_gui.Registrar;

import ccfs_gui.LayoutProperties;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RegistrarReportsController implements Initializable {

    @FXML
    private BorderPane innerpane;
    @FXML
    private AnchorPane container;
    @FXML
    private Button enrolledlist_Btn;
    @FXML
    private Button unenrolledlist_Btn;
    @FXML
    private Button withdrawedlist_Btn;
    @FXML
    private Button back_Btn;
    @FXML
    private TableView<?> reports_Table;
    @FXML
    private TableColumn<?, ?> idnumber_Col;
    @FXML
    private TableColumn<?, ?> name_Col;
    @FXML
    private TableColumn<?, ?> gradelvl_Col;
    
    @FXML
    private void reportsButtons(ActionEvent event) {
        if (event.getSource() == enrolledlist_Btn) {
            //TODO
        } else if (event.getSource() == unenrolledlist_Btn) {
            //TODO
        } else if (event.getSource() == withdrawedlist_Btn) {
            //TODO
        }
    }
            
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("RegistrarOptionsFXML.fxml"));
        container.getChildren().setAll(root);
        LayoutProperties.anchorPaneConstraints(root);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
