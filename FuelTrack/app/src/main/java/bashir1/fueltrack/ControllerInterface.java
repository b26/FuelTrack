package bashir1.fueltrack;

import android.content.Context;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bashir1 on 1/28/16.
 */
public interface ControllerInterface {
    /* saves the current list into file.sav */
    int save(Context context);
    /* loads the list in file.sav */
    int load(Context context);
    /* initializes a new Logs Class */
    void initLogs();
    /* creates a new entry and adds it to Logs */
    boolean add(Date date, String station, Double odometer,
             Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    /* returns a new Entry. This does not save anything but just returns an object */
    Entry newEntry(Date date, String station, Double odometer,
                   Double fuelAmount, Double fuelUnitCost, String fuelGrade);
    /* add an entry at position index */
    boolean add(Entry entry, int index);
    /* add a new entry to the end of the list */
    boolean add(Entry entry);
    /* get the entry at index */
    Entry getAtIndex(int index);
    /* checks if an entry is in Logs*/
    boolean hasEntry (Entry entry);
    /* Checks if the EditText fields in the UI are valid.*/
    boolean validate(EditText text1, EditText text2,EditText text3,
                     EditText text4,EditText text5, EditText text6);
    String totalCost();

}
