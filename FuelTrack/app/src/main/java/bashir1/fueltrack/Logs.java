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
        return this.logs;
    }

    /* used for testing. to check if the class was created */
    public String pong() {
        return "pong";
    }

    public Entry getEntry(int index) {
        return this.logs.get(index);
    }

    /* takes an ArrayList<Entry> and replaces this.logs with it
    * then it notifies the views
    * */
    public void setLogs(ArrayList<Entry> logs) {
        this.logs = logs;
        notifyViews();
    }

    /* initializes a new set of Logs then notifies the views */
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

    /*
    * adds a new entry to logs. if succeeded it notifies the views.
    * */

    public boolean addNewEntry(Date date, String station, Double odometer, String fuelGrade,
                          Double fuelAmount, Double fuelUnitCost) {
        Entry entry = new Entry(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);
        boolean result = this.logs.add(entry);
        if (result) notifyViews();
        return result;
    }

    /* adds an entry to the list. if result is true, then it notifies MainActivity
    * then returns the result.
    * */
    public boolean add(Entry entry) {
        boolean result = this.logs.add(entry);
        if (result) {
            notifyViews();
        }
        return result;
    }

    /* if the list is empty, then insert. this will almost never be the case
    *  because when this method is called, the list has some values.
    *
    * if the list has values, then remove the entry at the given index
    * then add a new entry at that index.
    *
    * returns a boolean -> true if it added, false if it didn't.
    * */

    public boolean editLog(int index, Entry entry) {
        if (logs.isEmpty()) {
            logs.add(entry);
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
