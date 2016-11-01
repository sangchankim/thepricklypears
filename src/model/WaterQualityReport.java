package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.Date;

/**
 * Created by Sang on 10/24/16.
 */
public class WaterQualityReport {
    private final StringProperty username = new SimpleStringProperty();
    private final SimpleObjectProperty<Integer> reportNumber = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<Date> date = new
            SimpleObjectProperty<Date>();
    private final ObjectProperty<Location> location = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<QualityCondition> qualityCondition = new
            SimpleObjectProperty<QualityCondition>();
    private final SimpleObjectProperty<Integer> virusPPM = new SimpleObjectProperty<Integer>();
    private final SimpleObjectProperty<Integer> contaminantPPM = new SimpleObjectProperty<Integer>();

    /**
     * Make a new water source report
     * @param username          the user's name
     * @param reportNumber      the report number for this report
     * @param date              date/time of water report
     * @param location          location of water source
     * @param qualityCondition  quality condition of water
     * @param virusPPM          the virus PPM
     * @param contaminantPPM    contaminant ppm
     */
    public WaterQualityReport(String username, int reportNumber, Date date,
                             Location location, QualityCondition qualityCondition, int virusPPM, int contaminantPPM) {
        this.username.set(username);
        this.reportNumber.set(reportNumber);
        this.date.set(date);
        this.location.set(location);
        this.qualityCondition.set(qualityCondition);
        this.virusPPM.set(virusPPM);
        this.contaminantPPM.set(contaminantPPM);
    }

    public String toString() {
        return getReportNumber()
                + "\t" + getDate().toString()
                + "\t" + getLocation()
                + "\t" + qualityCondition.toString()
                + "\t" + virusPPM.toString()
                + "\t" + contaminantPPM.toString()
                + "\t" + username;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public Integer getReportNumber() {
        return reportNumber.get();
    }

    public SimpleObjectProperty<Integer> reportNumberProperty() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber.set(reportNumber);
    }

    public Date getDate() {
        return date.get();
    }

    public SimpleObjectProperty<Date> date() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public Location getLocation() {
        return location.get();
    }

    public ObjectProperty<Location> locationProperty() {
        return location;
    }

    public void setLocation(Location location) {
        this.location.set(location);
    }

    public QualityCondition getQualityCondition() {
        return qualityCondition.get();
    }

    public SimpleObjectProperty<QualityCondition> qualityConditionProperty() {
        return qualityCondition;
    }

    public void setWaterCondition(QualityCondition qualityCondition) {
        this.qualityCondition.set(qualityCondition);
    }


    public Integer getVirusPPM() {
        return virusPPM.get();
    }

    public SimpleObjectProperty<Integer> virusPPMProperty() {
        return virusPPM;
    }

    public void setVirusPPM(int virusPPM) {
        this.virusPPM.set(virusPPM);
    }

    public Integer getContaminantPPM() {
        return contaminantPPM.get();
    }

    public SimpleObjectProperty<Integer> contaminantPPMProperty() {
        return contaminantPPM;
    }

    public void setContaminantPPM(int contaminantPPM) {
        this.contaminantPPM.set(contaminantPPM);
    }

}