package bashir1.fueltrack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;


/**
 * Created by bashir1 on 1/28/16.
 */
public class FuelTrackController implements ControllerInterface {
    Logs app;
    private static final String FILENAME = "file.sav";

    public void init() {
        app = FuelTrackApplication.getApp();
    }

    @Override
    public void save(Entry entry, Context context) {

    }

    @Override
    public void sort() {

    }

    @Override
    public Entry getEntry(Entry entry) {
        return null;
    }

    @Override
    public Logs get() {
        return null;
    }

    @Override
    public void load(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        } catch (FileNotFoundException e) {
            /* create a new array list? */
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
