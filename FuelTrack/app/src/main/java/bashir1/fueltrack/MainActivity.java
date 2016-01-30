package bashir1.fueltrack;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayAdapter<Entry> adapter;
    private Logs logs = FuelTrackApplication.getApp();
    private FuelTrackController fc = FuelTrackApplication.getController();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        Entry test = new Entry(new Date(), "Shell", 8888.8, 45.2, 64.2, "Regular");
        logs.add(test);
        fc.save(context);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, AddEntryActivity.class);
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
        /* adding some data for testing listView */
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
