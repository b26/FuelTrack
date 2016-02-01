package bashir1.fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements ActivityHelpers, LogView<Logs> {

    private ListView listView;
    private ArrayAdapter<Entry> adapter;
    private Logs logs = FuelTrackApplication.getApp();
    private FuelTrackController fc = FuelTrackApplication.getController();
    private TextView totalCost;
    private Context context;
    private Button addButton;

    /* used to save the position of the listView that is passed to EditEntryActivity*/
    public final static String POSITION = "bashir1.fueltrack.POSITION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onCreateSetup();
        this.onCreateListeners();

    }

    @Override
    public void onStart() {
        super.onStart();
        this.onStartData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*
        * Clear the previous activities and reload the current activity.
        * the only way to exit this application is by pressing the home button.
        * http://stackoverflow.com/questions/6330260/finish-all-previous-activities
        * */
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onStartData() {
        /* load our data */
        fc.load(context);
        /* notify listView of changes */
        updateData();
    }

    @Override
    public void onCreateSetup() {
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("bashir1-FuelTrack");
        listView = (ListView) findViewById(R.id.list);
        totalCost = (TextView) findViewById(R.id.totalCost);
        /* add this view to the model, so the model could tell the view when
        * to update
        * */
        logs.addView(this);
    }

    /*
    * the update method gets called from LogsModel. LogsModel Class
    * implements notifyViews which is called by Logs Class
    * this process is started by FuelTrackController Class
    * the update calls updateData()
    * */
    @Override
    public void update(Logs logs) {
        updateData();
    }

    /*
    * notify listView of changes
    * */
    public void updateData() {
        totalCost.setText(" " + fc.totalCost());
        adapter = new ArrayAdapter<Entry>(this, R.layout.list_item, logs.getLogs());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        /* this will only be called when the activity is destroyed or
         * android decides to free up some memory or when finish() is called by the system
         * */
        logs.removeView(this);
    }

    @Override
    public void onCreateListeners() {
        addButton = (Button) findViewById(R.id.add_new_entry);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, AddEntryActivity.class);
                startActivity(intent);
            }
        });
        /* handles clicking on a listView item. If you click on an item
        * it passes the position number to EditEntryActivity
        * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, EditEntryActivity.class);
                intent.putExtra(POSITION, position);
                startActivity(intent);
            }
        });
    }
}
