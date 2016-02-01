package bashir1.fueltrack;

/**
 * Created by X on 16-01-28.
 */
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

public class LogsTest extends ActivityInstrumentationTestCase2 {

    public LogsTest() {
        super(MainActivity.class);
    }

    public void testAddEntry() {
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
        double totalCost;
        Logs logs = new Logs();
        Entry entry1 = new Entry(new Date(), "Shell", 8888.8, 21.0, 100.0, "Regular");
        totalCost = 21  * (100.0/100);
        logs.add(entry1);
        assertEquals(totalCost, logs.totalCost());
        Entry entry2 = new Entry(new Date(), "Shell", 8888.8, 21.0, 100.0, "Regular");
        logs.add(entry2);
        totalCost += 21.0 * (100.0/100);
        assertEquals(totalCost, logs.totalCost());
    }

    public void testEditLog() {
        /* create a new log and add it */
        Logs logs = new Logs();
        Entry entry1 = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry1);
        /* now edit the entry and replace it */
        Entry entry2 = entry1;
        String newStation = "BP";
        entry2.setStation(newStation);
        /* editLog returns a boolean if it successfully added or not */
        assertTrue(logs.editLog(0, entry2));
        assertEquals(newStation, logs.getEntry(0).getStation());

    }

    public void testHasEntry() {
        Logs logs = new Logs();
        Entry entry1 = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry1);
        assertTrue(logs.hasEntry(entry1));
        Entry entry2 = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        assertFalse(logs.hasEntry(entry2));

    }

    public void testAddNewEntryLong() {
        Logs logs = new Logs();
        Entry entry = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry);
        assertTrue(logs.hasEntry(entry));

    }

    public void testGetLogs() {
        Logs logs = new Logs();
        Entry entry = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(entry);
        ArrayList<Entry> logs_temp = logs.getLogs();
        assertTrue(logs_temp.contains(entry));
    }
}
