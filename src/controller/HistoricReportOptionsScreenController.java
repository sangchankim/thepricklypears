package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Valerie on 11/7/2016.
 */
public class HistoricReportOptionsScreenController {

    private MainFXApplication mainApplication;

    private User currUser;

    private Location pseudoLocation;


    /*  **********************
            References to the FXML widgets in the .fxml file
        */
    @FXML
    private TextField locationTextField;

    @FXML
    private TextField latitudeTextField;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button cancelButton;

    @FXML
    private Button viewGraphButton;

    /**
     * sets main application
     * @param main main application
     */
    public void setMainApp (MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * called when the user clicks Create
     */
    @FXML
    public void onViewGraphPressed() {
        if (startDatePicker.getValue() == null || endDatePicker.getValue() == null
                || latitudeTextField.getText().equals("") || longitudeTextField.getText().equals("")
                || locationTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing data fields");
            alert.showAndWait();
        } else {
            List<WaterQualityReport> qualityReports = mainApplication.getWaterQualityReports();
            List<WaterQualityReport> thisLocQualityReports = new ArrayList<>();
            Location thisLoc = new Location(
                    Double.parseDouble(latitudeTextField.getText()),
                    Double.parseDouble(longitudeTextField.getText()),
                    locationTextField.getText().toString());
            Date startDate = Date.from(startDatePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(endDatePicker.getValue().atStartOfDay().plusDays((long)1).atZone(ZoneId.systemDefault()).toInstant());
            for (WaterQualityReport report : qualityReports) {
                if (thisLoc.equals(report.getLocation())) {
                    if (report.getDate().after(startDate) && report.getDate().before(endDate)) {
                        thisLocQualityReports.add(report);
                    }
                }
            }
            if (thisLocQualityReports.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("There are no Water Quality Reports for this location and time period");

                alert.showAndWait();
            } else {
                mainApplication.showWaterQualityHistoryGraph(startDate, endDate, thisLocQualityReports);
            }
        }
    }

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        endDatePicker.setValue(LocalDate.now());
    }

    /**
     * called when the user clicks Cancel
     */
    @FXML
    public void onCancelPressed() {
        mainApplication.showMapScreen();
    }

    /**
     * passes current user value to this controller
     * @param auth current user
     */
    public void setUser(User auth) {
        currUser = auth;
    }

    /**
     * sets the pseudo location
     * @param pseudo the pseudo location
     */
    public void setPseudoLocation(Location pseudo) {
        pseudoLocation = pseudo;
        if (pseudoLocation != null) {
            latitudeTextField.setText("" + pseudoLocation.getLatitude());
            longitudeTextField.setText("" + pseudoLocation.getLongitude());
            locationTextField.setText("" + pseudoLocation.getTitle());
        }
    }
}