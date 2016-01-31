package bashir1.fueltrack;

import android.content.Context;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<FuelTrackApplication> {
    String ping = "pong";

    public ApplicationTest() {
        super(FuelTrackApplication.class);
    }

    public void testCreateApp () {
        Logs app = FuelTrackApplication.getApp();
        assertNotNull(app);
        assertEquals(ping, app.pong());
    }


    public void testCreateController() {
        FuelTrackController fc = FuelTrackApplication.getController();
        assertNotNull(fc);
        assertEquals(ping, fc.pong());
    }

    public void testCreateContext() {
        Context context;
        context = FuelTrackApplication.getContext();
        assertNotNull(context);
    }
}