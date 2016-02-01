package bashir1.fueltrack;

import android.app.Application;
import android.content.Context;

/**
 * Created by bashir1 on 1/28/16.
 */

public class FuelTrackApplication extends Application {

    /* https://github.com/b26/FillerCreepForAndroid/blob/master/app/src/main/java/es/softwareprocess/fillercreep/FillerCreepApplication.java */

    /* create and initialize Logs */
    transient public static Logs app = null;
    private static Context appContext;
    /*
    http://stackoverflow.com/questions/21994612/get-application-context-returns-null/21994789#21994789
    */
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            appContext = getApplicationContext();

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static Context getContext() {
        return appContext;
    }

    /* create and initialize Logs and name it app */
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
