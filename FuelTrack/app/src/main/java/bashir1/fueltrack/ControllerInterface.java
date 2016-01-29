package bashir1.fueltrack;

import android.content.Context;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    void save(Entry entry, Context context);
    void load(Context context);
    void sort();
    Entry getEntry(Entry entry);
    Logs get();

/*    + sort(): void
    + viewAll(): void
    + getEntry(Entry: entry): Entry
    + getLogs(): Log*/
}
