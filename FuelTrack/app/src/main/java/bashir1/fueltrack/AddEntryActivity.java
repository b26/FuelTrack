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

public class AddEntryActivity extends ActionBarActivity {
    private EditText dateText;
    private EditText stationText;
    private EditText odometerText;
    private EditText fuelUnitCostText;
    private EditText fuelGradeText;
    private EditText fuelAmountText;
    private Context context;


    private FuelTrackController fc = FuelTrackApplication.getController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        context = getApplicationContext();

        stationText = (EditText) findViewById(R.id.station);
        fuelGradeText = (EditText) findViewById(R.id.fuel_grade);
        odometerText = (EditText) findViewById(R.id.odometer);
        fuelUnitCostText = (EditText) findViewById(R.id.fuel_unit_cost);
        dateText = (EditText) findViewById(R.id.date);
        fuelAmountText = (EditText) findViewById(R.id.fuel_amount);


        System.out.println(fuelGradeText);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add New Entry");
        Button saveButton = (Button) findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                String dateString = stationText.getText().toString();
                /* http://stackoverflow.com/questions/4216745/java-string-to-date-conversion */
                DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                Date date = new Date();
                try {
                    date = format.parse(dateString);

                } catch (java.text.ParseException e){
                    e.printStackTrace();
                }
                String fuelGrade = fuelGradeText.getText().toString();
                Double fuelAmount = Double.parseDouble(fuelAmountText.getText().toString());
                Double odometer = Double.parseDouble(odometerText.getText().toString());
                Double fuelUnitCost = Double.parseDouble(fuelUnitCostText.getText().toString());
                String station = stationText.getText().toString();

                fc.add(date, station, odometer, fuelAmount, fuelUnitCost, fuelGrade);

                //fc.save(context);


                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
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
