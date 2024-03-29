/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccfs_gui.Registrar;

import ccfs_gui.Admin.AdminOptionsController;
import ccfs_gui.LayoutProperties;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Imran ; Paul
 */
public class RegistrarOptionsController implements Initializable {
    
    @FXML
    private Label schyr;
    @FXML
    private BorderPane outer_borderpane;
    @FXML
    private AnchorPane left_outer_pane;
    @FXML
    private AnchorPane bottom_outer_pane;
    @FXML
    private ButtonBar bottom_inner_pane;
    @FXML
    private Button logout_button;
    @FXML
    private GridPane inner_borderpane;
    @FXML
    private Button registerStud_Btn;
    @FXML
    private Button enrollContStud_Btn;
    @FXML
    private Button viewStudList_Btn;
    @FXML
    private Button viewArchive_Btn;
    @FXML
    private Button attendance_Btn;
    @FXML
    private Button studGrades_Btn;
    @FXML
    private Button studDiscount_Btn;
    @FXML
    private Button studSponsorship_Btn;
    @FXML
    private Button studChecklist_Btn;
    @FXML
    private Button generateReports_Btn;
    @FXML
    private AnchorPane right_outer_pane;
    @FXML
    private AnchorPane container;
    
    private void setSchoolYear() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccfs?"
                + "user=root&password=");        
        ResultSet rs = con.createStatement().executeQuery("SELECT CONCAT(yearstart, '-', yearend) FROM `schoolyear` WHERE Status='active'");
        while (rs.next()) {
            schyr.setText(rs.getString("CONCAT(yearstart, '-', yearend)"));
        }
    }

    @FXML
    private void registrarOptionsButtons(ActionEvent event) throws IOException {
        AnchorPane root = null;

        if (event.getSource() == registerStud_Btn) {
            root = FXMLLoader.load(getClass().getResource("/ccfs_gui/Enrollment/RegistrationPageOneFXML.fxml"));
        } else if (event.getSource() == enrollContStud_Btn) {
            root = FXMLLoader.load(getClass().getResource("/ccfs_gui/Enrollment/EnrollmentContinuingFXML.fxml"));
        } else if (event.getSource() == viewStudList_Btn) {
            root = FXMLLoader.load(getClass().getResource("ViewListOfStudent.fxml"));
        } else if (event.getSource() == viewArchive_Btn) {
            root = FXMLLoader.load(getClass().getResource("ViewStudentArchive.fxml"));
        } else if (event.getSource() == attendance_Btn) {
            root = FXMLLoader.load(getClass().getResource("/ccfs_gui/Grades/ViewAttendanceOfStudent.fxml"));
        } else if (event.getSource() == studGrades_Btn) {
            root = FXMLLoader.load(getClass().getResource("/ccfs_gui/Grades/SubjectSelection.fxml"));
        } else if (event.getSource() == studDiscount_Btn) {
            root = FXMLLoader.load(getClass().getResource("/ccfs_gui/DiscountSponsor/DiscountOptionsFXML.fxml"));
        } else if (event.getSource() == studSponsorship_Btn) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ccfs_gui/DiscountSponsor/SponsorshipSelection.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            return;
        } else if (event.getSource() == studChecklist_Btn) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ccfs_gui/Grades/ViewChecklistSelection.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            return;
        } else if (event.getSource() == generateReports_Btn) {
            root = FXMLLoader.load(getClass().getResource("RegistrarReports.fxml"));
        }

        container.getChildren().setAll(root);
        LayoutProperties.anchorPaneConstraints(root);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setSchoolYear();
        } catch (Exception ex) {
            Logger.getLogger(AdminOptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }

}
