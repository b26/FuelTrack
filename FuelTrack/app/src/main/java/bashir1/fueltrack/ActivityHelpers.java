package bashir1.fueltrack;

/**
 * Created by X on 16-01-30.
 */

/* The point of this interface is to make our activity
* cleaner. onStart() now has 2-3 lines of code versus 15+.
* */

public interface ActivityHelpers {
     /* holds onStart statements*/
     void onStartData();
     /* runs onCreate statements */
     void onCreateSetup();
     /* runs onCreate statements */
     void onCreateListeners();
}
