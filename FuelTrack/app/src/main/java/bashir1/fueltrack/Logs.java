package bashir1.fueltrack;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by X on 16-01-25.
 */
public class Logs {
    private ArrayList<Entry> logs;


    public Logs() {
        this.logs = new ArrayList<Entry>();
    }

    public ArrayList<Entry> getLogs() {
        return logs;
    }

    public Entry getEntry(int index) {
        return logs.get(index);
    }
    
    public Double totalCost() {
        double cost = 0;
        for(Entry log: logs) {
            cost += log.fuelCost();
        }
        return cost;
    }

    /*
    * how could you return an object? instead of Date date do {}
    * */

    public void addNewEntry(Date date, String station, Double odometer, String fuelGrade,
                          Double fuelAmount, Double fuelUnitCost) {
        Entry entry = new Entry(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);
        this.logs.add(entry);
    }

    public void editLog(int index, Entry entry) {
        /*TODO
        * should you use int index or Log log?
        * how will you edit, will you need parameters?
        * */

        //Log log = logs.get(index);
        logs.remove(index);
        logs.add(index, entry);
    }

    

}
