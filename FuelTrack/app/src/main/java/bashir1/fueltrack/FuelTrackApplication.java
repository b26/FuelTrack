package bashir1.fueltrack;

import android.app.Application;
import android.content.Context;

/**
 * Created by bashir1 on 1/28/16.
 * TODO note that you got the idea from FillerCreep
 */
public class FuelTrackApplication extends Application {

    /* create and initialize Logs */
    transient public static Logs app = null;

    public static Logs getApp() {
        if (app == null) {
            app = new Logs();
        }
        return app;
    }

    /* create and initialize FuelTrackController */

    transient static public FuelTrackController controller = null;

    public static FuelTrackController getController() {
        if (controller == null) {
            controller = new FuelTrackController();
        }
        return controller;
    }

}
