package bashir1.fueltrack;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by X on 16-01-28.
 */
public class EntryTest extends ActivityInstrumentationTestCase2 {

    public EntryTest() {
        super(MainActivity.class);
    }
/*TODO better description include testing of init values */

    /* test if the object exists and is not null */
    public void testEntry() {
        Entry entry = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        /* needs review...*/
        assertNotNull(entry);
    }


    /* uses both get and set date */
    public void testDate() {
        Date dateInit = new Date();
        Entry entry = new Entry(dateInit, "Shell", 8888.8, 45.2, 64.2, "Regular");
        /* testing the initialized date value*/
        assertEquals(dateInit, entry.getDate());
        Date date = new Date();
        /* testing setting a new date */
        entry.setDate(date);
        assertEquals(date, entry.getDate());

    }

    /* tests both get and set station */
    public void testStation() {
        String stationInit = "Shell";
        Entry entry = new Entry(new Date(), stationInit, 8888.8, 45.2, 64.2, "Regular");
        assertEquals(stationInit, entry.getStation());
        String station = "Huskey";
        entry.setStation(station);
        assertEquals(station, entry.getStation());
    }

    /* uses both get and set date */
    public void testOdometer() {
        double odoInit = 4200.2;
        Entry entry = new Entry(new Date(), "Shell", odoInit, 45.2, 64.2, "Regular");
        assertEquals(odoInit, entry.getOdometer());
        double odo = 8200.2;
        entry.setOdometer(odo);
        assertEquals(odo, entry.getOdometer());
    }

    /* uses both get and set fuel amount */
    public void testFuelAmount() {
        double fuelInit = 42.2;
        Entry entry = new Entry(new Date(), "Shell", 888.9, fuelInit, 64.2, "Regular");
        assertEquals(fuelInit, entry.getFuelAmount());
        double fuel = 8200.2;
        entry.setFuelAmount(fuel);
        assertEquals(fuel, entry.getFuelAmount());

    }

    /* uses both get and set fuel unit cost */
    public void testFuelUnitCost() {
        double costInit = 4200.2;
        Entry entry = new Entry(new Date(), "Shell", 999.2, 45.2, costInit, "Regular");
        assertEquals(costInit, entry.getFuelUnitCost());
        double cost = 72.1;
        entry.setFuelUnitCost(cost);
        assertEquals(cost, entry.getFuelUnitCost());
    }

    /* uses both get and set fuel grade */
    public void testFuelGrade() {
        String gradeInit = "Medium";
        Entry entry = new Entry(new Date(), "Shell", 82828.1, 45.2, 64.2, gradeInit);
        assertEquals(gradeInit, entry.getFuelGrade());
        String grade = "Premium";
        entry.setFuelGrade(grade);
        assertEquals(grade, entry.getFuelGrade());
    }

    /* tests fuel cost*/
    public void testFuelCost() {
        double fuelAmount = 45.2;
        double fuelUnitCost = 64.2;
        double fuelCost = Math.round(fuelAmount * (fuelUnitCost/100));
        Entry entry = new Entry(new Date(), "Shell", 82828.1, fuelAmount, fuelUnitCost, "Regular");
        assertEquals(fuelCost, entry.fuelCost());
    }
}


