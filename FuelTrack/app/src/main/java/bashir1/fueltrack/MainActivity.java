package bashir1.fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayAdapter<Entry> adapter;
    private Logs logs = FuelTrackApplication.getApp();
    private FuelTrackController fc = FuelTrackApplication.getController();
    private Context context;

    /* from lonelyTwitter */
    public final static String EXTRA_MESSAGE = "bashir1.fueltrack.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("bashir1-FuelTrack");
        listView = (ListView) findViewById(R.id.list);
        Button addButton = (Button) findViewById(R.id.add_new_entry);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, AddEntryActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, EditEntryActivity.class);
                intent.putExtra(EXTRA_MESSAGE, position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        fc.load(context);
        adapter = new ArrayAdapter<Entry>(this, R.layout.list_item, logs.getLogs());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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

}
