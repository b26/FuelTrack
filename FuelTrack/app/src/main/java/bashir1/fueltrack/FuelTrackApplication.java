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
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            sContext = getApplicationContext();

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static Context getContext() {
        return sContext;
    }


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

    /* create and initialize Application Context */
//    public static Context getContext() {
//        /* FIXME need to test for null then possibly recreate */
//        if (context == null) context = createContext();
//        return context;
//    }
}
