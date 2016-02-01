package bashir1.fueltrack;

/**
 * Created by bashir1 on 1/28/16.
 */

/* https://github.com/b26/FillerCreepForAndroid/blob/master/app/src/main/java/es/softwareprocess/fillercreep/FView.java */
public interface LogView<Model> {
    /* gets called by the model in notifyViews*/
    void update(Model model);
}
