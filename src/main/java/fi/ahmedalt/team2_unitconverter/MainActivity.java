package fi.ahmedalt.team2_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;

import fi.ahmedalt.team2_unitconverter.convert.AngleConverter;
import fi.ahmedalt.team2_unitconverter.convert.AreaConverter;
import fi.ahmedalt.team2_unitconverter.convert.Converter;
import fi.ahmedalt.team2_unitconverter.convert.LengthConverter;
import fi.ahmedalt.team2_unitconverter.convert.MassConverter;
import fi.ahmedalt.team2_unitconverter.convert.SpeedConverter;
import fi.ahmedalt.team2_unitconverter.convert.TemperatureConverter;
import fi.ahmedalt.team2_unitconverter.convert.TimeConverter;
import fi.ahmedalt.team2_unitconverter.convert.VolumeConverter;

import static fi.ahmedalt.team2_unitconverter.Evaluation.eval;

public class MainActivity extends AppCompatActivity {
    int z;
    private SharedPreferences sharedPreferences;

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, AppInformationActivity.class);
        startActivity(intent);

    };
    private final View.OnClickListener onClickListener1 = view -> {
        Intent intent1 = new Intent(this, LibraryActivity.class);
        startActivity(intent1);
    };
    private final View.OnClickListener onClickListener2 = view -> {
        Intent intent1 = new Intent(this, FeedbackActivity.class);
        startActivity(intent1);
    };

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    ArrayList<String> arrayList_length, arrayList_mass, arrayList_temperature, arrayList_angle, arrayList_area,
            arrayList_speed, arrayList_time, arrayList_volume;

    ArrayAdapter<String> arrayAdapter_child;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("main_activity_prefs", MODE_PRIVATE);

        findViewById(R.id.more).setOnClickListener(onClickListener);
        findViewById(R.id.library).setOnClickListener(onClickListener1);
        findViewById(R.id.feedback).setOnClickListener(onClickListener2);


        ////////////////////// initiate the spinners////////////////////////////////
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);

        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Length");
        arrayList_parent.add("Mass");
        arrayList_parent.add("Temperature");
        arrayList_parent.add("Angle");
        arrayList_parent.add("Area");
        arrayList_parent.add("Speed");
        arrayList_parent.add("Time");
        arrayList_parent.add("Volume");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, arrayList_parent);
        spinner1.setAdapter(arrayAdapter_parent);

        //###################### Child spinners start ######################

        arrayList_length = new ArrayList<>();
        arrayList_length.add("Meter");
        arrayList_length.add("Inch");
        arrayList_length.add("Foot");
        arrayList_length.add("Mile");
        arrayList_length.add("Yard");

        arrayList_mass = new ArrayList<>();
        arrayList_mass.add("Kilogram");
        arrayList_mass.add("Gram");
        arrayList_mass.add("Pound");
        arrayList_mass.add("Ounce");

        arrayList_temperature = new ArrayList<>();
        arrayList_temperature.add("Celsius");
        arrayList_temperature.add("Fahrenheit");
        arrayList_temperature.add("Kelvin");

        arrayList_angle = new ArrayList<>();
        arrayList_angle.add("Degree");
        arrayList_angle.add("Radian");

        arrayList_area = new ArrayList<>();
        arrayList_area.add("Square meter");
        arrayList_area.add("Square inch");
        arrayList_area.add("Square foot");
        arrayList_area.add("Square yard");

        arrayList_speed = new ArrayList<>();
        arrayList_speed.add("Meter per second");
        arrayList_speed.add("Mile per hour");
        arrayList_speed.add("Foot per second");
        arrayList_speed.add("Kilometer per hour");

        arrayList_time = new ArrayList<>();
        arrayList_time.add("Second");
        arrayList_time.add("Minute");
        arrayList_time.add("Hour");
        arrayList_time.add("Day");

        arrayList_volume = new ArrayList<>();
        arrayList_volume.add("Liter");
        arrayList_volume.add("Cubic foot");
        arrayList_volume.add("Cubic inch");
        arrayList_volume.add("Cubic meter");


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_length);
                    z = 0;


                }
                if(position == 1){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_mass);
                    z = 1;
                }
                if(position == 2){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_temperature);
                    z = 2;
                }
                if(position == 3){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_angle);
                    z = 3;
                }
                if(position == 4){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_area);
                    z = 4;
                }
                if(position == 5){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_speed);
                    z = 5;
                }
                if(position == 6){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_time);
                    z = 6;
                }
                if(position == 7){
                    arrayAdapter_child  = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_volume);
                    z = 7;
                }

                spinner2.setAdapter(arrayAdapter_child);
                spinner3.setAdapter(arrayAdapter_child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //########################### Child spinners end ###########################

        /////////////////// conver button click listener /////////////////
        Button Conbtn = findViewById(R.id.convertbtn);
        Conbtn.setOnClickListener(view -> {

            unitCalcul();

        });
        /////////////////// Find esult button click listener /////////////////
        Button resultbtn = findViewById(R.id.btnFindResult);
        resultbtn.setOnClickListener(view -> {

            userResul();

        });


    }
    /////////////// calling the classes ///////////////
    public void unitCalcul(){
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        EditText qtyEditText = findViewById(R.id.editTextNumber);
        TextView resultTextView = findViewById(R.id.editTextNumber2);
        TextView usedFormula = findViewById(R.id.txtFormulaUsed);
        TextView x = (TextView) spinner2.getSelectedView();
        TextView y = (TextView) spinner3.getSelectedView();
        String beg_type = x.getText().toString();
        String end_type = y.getText().toString();

        if(!qtyEditText.getText().toString().equals("")) {
            Converter converter = null ;
            if(z == 0) {
                converter = new LengthConverter();
            }else if(z == 1) {
                converter = new MassConverter();
            }else if(z == 2) {
                converter = new TemperatureConverter();
            }else if(z == 3) {
                converter = new AngleConverter();
            }else if(z == 4) {
                converter = new AreaConverter();
            }else if(z == 5) {
                converter = new SpeedConverter();
            }else if(z == 6) {
                converter = new TimeConverter();
            }else if(z == 7) {
                converter = new VolumeConverter();
            }
            if (converter != null) {

                double beg_qty = Double.parseDouble(qtyEditText.getText().toString());
                converter.setBeg_type(beg_type);
                converter.setEnd_type(end_type);
                converter.setBeg_qty(beg_qty);

                double end_qty = converter.calculateEnd_qty();
                converter.setEnd_qty(end_qty);
                resultTextView.setText(converter.toString());
                usedFormula.setText(converter.usedFormulaMeth());
                mostUsed(converter.shortName(), beg_type, end_type);

                Log.d("AHMED", beg_type + " " + end_type + " " + beg_qty + " " + end_qty);
            }
            showMostUsed();

        }else {
            Message.message(getApplicationContext(), "Enter Value");
        }
    }


    private void mostUsed(String type, String from, String to){
        String localKey = type + "_" + from + "_" + to;
        int currentCount = sharedPreferences.getInt(localKey, 0);
        currentCount++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(localKey, currentCount);
        editor.apply();


    }
    private void showMostUsed(){
        String mostUsed = "n/a";
        int currentMax = -1;
        Map<String, ? > keys = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry: keys.entrySet()){
            Log.d("AHMED_MOST", entry.getKey() + " " + entry.getValue());
            if(!entry.getKey().startsWith("main") && Integer.parseInt(entry.getValue().toString()) > currentMax){
                mostUsed = entry.getKey();
                currentMax = Integer.parseInt(entry.getValue().toString());

            }
        }
        TextView textView = findViewById(R.id.TextViewMostUsed);
        textView.setText(mostUsed);
    }
    ////////////////// user formula /////////////////////
    public void userResul(){
        EditText editText = findViewById(R.id.edtFormula);
        String y = editText.getText().toString();

        // Log.d("AHMED", y);
        double z = eval(y);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(4);
        String fixedz = nf.format(z);
        Log.d("AHMED", String.valueOf(z));
        TextView textView = findViewById(R.id.txtResult);
        //String oo = Double.toString(z);

        textView.setText(fixedz+"");
        //return z;
    }


}