package bashir1.fueltrack;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by X on 16-01-25.
 */


public class Logs extends LogsModel<LogView> {

    private ArrayList<Entry> logs;

    public Logs() {
        this.initLogs();
    }

    public ArrayList<Entry> getLogs() {
        return logs;
    }

    public String pong() {
        return "pong";
    }

    public Entry getEntry(int index) {
        return logs.get(index);
    }

    public void setLogs(ArrayList<Entry> logs) {
        this.logs = logs;
        notifyViews();
    }

    public void initLogs () {
        this.logs = new ArrayList<Entry>();
        notifyViews();
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
        boolean result = this.logs.add(entry);
        if (result) notifyViews();
        return result;
    }

    public boolean add(Entry entry) {
        boolean result = this.logs.add(entry);
        if (result) {
            notifyViews();
        }
        return result;
    }

    public boolean editLog(int index, Entry entry) {
        if (logs.size() == 0) {
            logs.add(0, entry);
        }
        else {
            logs.remove(index);
            logs.add(index, entry);
        }
        boolean result = hasEntry(entry);
        if (result) notifyViews();
        return result;
    }

    public boolean hasEntry(Entry entry) {
        return logs.contains(entry);
    }

}
