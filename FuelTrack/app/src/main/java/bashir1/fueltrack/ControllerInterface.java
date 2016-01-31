package bashir1.fueltrack;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    int save(Context context);
    int load(Context context);
    void initLogs();
    boolean add(Date date, String station, Double odometer,
             Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    Entry newEntry(Date date, String station, Double odometer,
                   Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    boolean add(Entry entry, int index);
    boolean add(Entry entry);
    Entry getAtIndex(int index);
    boolean hasEntry (Entry entry);

}
