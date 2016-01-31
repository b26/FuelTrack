package bashir1.fueltrack;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by X on 16-01-25.
 */

/*
* @params good for documentation!!!
* */
    /* FIXME you need extends LogsInterface */
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

    public void setLogs(ArrayList<Entry> logs) {
        this.logs = logs;
    }

    public void initLogs () {
        this.logs = new ArrayList<Entry>();
    }
    
    public Double totalCost() {
        double cost = 0;
        for(Entry log: logs) {
            cost += log.fuelCost();
        }
        return cost;
    }


    public boolean addNewEntry(Date date, String station, Double odometer, String fuelGrade,
                          Double fuelAmount, Double fuelUnitCost) {
        Entry entry = new Entry(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);

        return this.logs.add(entry);
    }

    public boolean add(Entry entry) {
        return this.logs.add(entry);
    }

    public boolean editLog(int index, Entry entry) {
        if (logs.size() == 0) {
            logs.add(0, entry);
            return hasEntry(entry);
        }
        else {
            logs.remove(index);
            logs.add(index, entry);
            return hasEntry(entry);
        }

    }

    public boolean hasEntry(Entry entry) {
        return logs.contains(entry);
    }

}
