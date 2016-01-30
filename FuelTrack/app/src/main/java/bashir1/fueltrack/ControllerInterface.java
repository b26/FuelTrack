package bashir1.fueltrack;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    void save(Context context);
    void load(Context context);
    void initLogs();
    void set(ArrayList<Entry> logs);
    void sort();
    boolean hasEntry(Entry entry);
    Entry getEntry(Entry entry);
    ArrayList<Entry> get();

/*    + sort(): void
    + viewAll(): void
    + getEntry(Entry: entry): Entry
    + getLogs(): Log*/
}
