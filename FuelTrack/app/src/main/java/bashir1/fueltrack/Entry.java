package bashir1.fueltrack;

import java.util.Date;

/**
 * Created by bashir1 on 1/28/16.
 */
public class Entry {
    private Date date;
    private String station;
    private Double odometer;
    private Double fuelAmount;
    private Double fuelUnitCost;
    private String fuelGrade;

    public Entry(Date date, String station, Double odometer,
                 Double fuelAmount, Double fuelUnitCost, String fuelGrade) {
        this.date = date;
        this.station = station;
        this.odometer = odometer;
        this.fuelAmount = fuelAmount;
        this.fuelUnitCost = fuelUnitCost;
        this.fuelGrade = fuelGrade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(Double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public Double getFuelUnitCost() {
        return fuelUnitCost;
    }

    public void setFuelUnitCost(Double fuelUnitCost) {
        this.fuelUnitCost = fuelUnitCost;
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade;
    }

    public double fuelCost() {
        return (this.getFuelUnitCost()/100) * this.getFuelAmount();
    }
}
