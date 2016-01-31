package bashir1.fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class EditEntryActivity extends ActionBarActivity implements ActivityHelpers {

    private Context context;
    private FuelTrackController fc = FuelTrackApplication.getController();
    private EditText dateText;
    private EditText stationText;
    private EditText odometerText;
    private EditText fuelUnitCostText;
    private EditText fuelGradeText;
    private EditText fuelAmountText;
    private Button saveButton;
    boolean valid;
    int position;


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
    public void onStartData() {
        Entry entry = fc.getAtIndex(position);
        DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
        String date = format.format(entry.getDate());
        dateText.setText(date);
        fuelAmountText.setText(entry.getFuelAmount().toString());
        fuelGradeText.setText(entry.getFuelGrade());
        stationText.setText(entry.getStation());
        odometerText.setText(entry.getOdometer().toString());
        fuelUnitCostText.setText(entry.getFuelUnitCost().toString());
    }

    @Override
    public void onCreateSetup() {
        setContentView(R.layout.activity_edit_entry);
        context = FuelTrackApplication.getContext();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Edit Entry");
        Intent intent = getIntent();
        position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        stationText = (EditText) findViewById(R.id.station_edit);
        fuelGradeText = (EditText) findViewById(R.id.fuel_grade_edit);
        odometerText = (EditText) findViewById(R.id.odometer_edit);
        fuelUnitCostText = (EditText) findViewById(R.id.fuel_unit_cost_edit);
        dateText = (EditText) findViewById(R.id.date_edit);
        fuelAmountText = (EditText) findViewById(R.id.fuel_amount_edit);
        saveButton = (Button) findViewById(R.id.save_edit);
    }

    @Override
    public void onCreateListeners() {
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                String dateString = dateText.getText().toString();
                /* http://stackoverflow.com/questions/4216745/java-string-to-date-conversion */
                DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                Date date = new Date();
                try {
                    date = format.parse(dateString);

                } catch (java.text.ParseException e){
                    e.printStackTrace();
                }

                /* validate the input */
                valid = fc.validate(stationText, dateText, fuelAmountText, fuelGradeText, odometerText, fuelUnitCostText);

                if (valid) {

                    String fuelGrade = fuelGradeText.getText().toString();
                    Double fuelAmount = Double.parseDouble(fuelAmountText.getText().toString());
                    Double odometer = Double.parseDouble(odometerText.getText().toString());
                    Double fuelUnitCost = Double.parseDouble(fuelUnitCostText.getText().toString());
                    String station = stationText.getText().toString();

                    /*
                    * create a tmp entry then add it to the position (the index) that was passed
                    * to this activity from MainActivity
                    * */
                    Entry tmp = fc.newEntry(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);
                    fc.add(tmp, position);
                    fc.save(context);


                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }


    @Override
    /* http://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar */
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}
