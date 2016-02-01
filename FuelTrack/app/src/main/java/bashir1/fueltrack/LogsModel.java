package bashir1.fueltrack;

import java.util.ArrayList;

/**
 * Created by bashir1 on 1/28/16.
 */

/* https://github.com/b26/FillerCreepForAndroid/blob/master/app/src/main/java/es/softwareprocess/fillercreep/FModel.java */

public class LogsModel<View extends LogView> {
    ArrayList<View> views;

    public LogsModel() {
        views = new ArrayList<View>();
    }

    /* add view */

    public void addView(View view) {
        if (!views.contains(view)) {
            views.add(view);
        }
    }

    /* remove view */

    public void removeView(View view) {
        views.remove(view);
    }

    /* notifies all views */

    public void notifyViews() {
        for (View view: views) {
            view.update(this);
        }
    }
}
