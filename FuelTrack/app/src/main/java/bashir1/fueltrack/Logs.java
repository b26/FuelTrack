package bashir1.fueltrack;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by X on 16-01-25.
 */
public class Logs {
    private ArrayList<Log> logs;

    public Logs() {
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public Log getLog(int index) {
        return logs.get(index);
    }
    
    public Double totalCost() {
        double cost = 0;
        for(Log log: logs) {
            cost += log.fuelCost();
        }
        return cost;
    }

    /*
    * how could you return an object? instead of Date date do {}
    * */

    public void addNewLog(Date date, String station, Double odometer, String fuelGrade,
                          Double fuelAmount, Double fuelUnitCost) {
        Log log = new Log(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);
        this.logs.append(log);
    }

    public void editLog(int index, Log log) {
        /*TODO
        * should you use int index or Log log?
        * how will you edit, will you need parameters?
        * */

        //Log log = logs.get(index);
        logs.remove(index);
        logs.add(index, log);
    }

    

}
