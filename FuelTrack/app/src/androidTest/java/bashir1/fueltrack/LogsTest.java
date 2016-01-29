package bashir1.fueltrack;

/**
 * Created by X on 16-01-28.
 */
import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

public class LogsTest extends ActivityInstrumentationTestCase2 {

    public LogsTest() {
        super(MainActivity.class);
    }

    public void testAddEntry() {
        /*TODO what about addNewEntry?*/
        Logs logs = new Logs();
        Entry entry = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry);
        assertTrue(logs.hasEntry(entry));
    }

    public void testGetEntry() {
        Logs logs = new Logs();
        Entry entry = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry);
        assertEquals(entry, logs.getEntry(0));
    }

    public void testTotalCost() {
        Logs logs = new Logs();
        Entry entry1 = new Entry(new Date(), "Shell", 8888.8, 21.0, 100.0, "Regular");
        double totalCost = 21  * (100.0/100);
        logs.add(entry1);
        assertEquals(totalCost, logs.totalCost());
        Entry entry2 = new Entry(new Date(), "Shell", 8888.8, 21.0, 100.0, "Regular");
        logs.add(entry2);
        totalCost += 21.0 * (100.0/100);
        assertEquals(totalCost, logs.totalCost());
    }
}
