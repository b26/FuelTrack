package bashir1.fueltrack;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    void save(Context context);
    void load(Context context);
    void initLogs();
    void add(Date date, String station, Double odometer,
             Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    Entry newEntry(Date date, String station, Double odometer,
                   Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    void set(ArrayList<Entry> logs);
    void add(Entry entry, int index);
    void sort();
    boolean hasEntry(Entry entry);
    Entry getEntry(Entry entry);
    Entry getAtIndex(int index);
    ArrayList<Entry> get();

/*    + sort(): void
    + viewAll(): void
    + getEntry(Entry: entry): Entry
    + getLogs(): Log*/
}
