package bashir1.fueltrack;

/**
 * Created by bashir1 on 1/28/16.
 */
public class FuelTrackController implements ControllerInterface {
    Logs app;

    public void init() {
        app = FuelTrackApplication.getApp();
    }
    @Override
    public void save(Entry entry) {

    }

    @Override
    public void sort() {

    }

    @Override
    public Entry getEntry(Entry entry) {
        return null;
    }

    @Override
    public Logs getLogs() {
        return null;
    }
}
