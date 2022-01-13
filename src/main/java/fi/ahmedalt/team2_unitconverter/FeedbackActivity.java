package fi.ahmedalt.team2_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {
    public static final String TAG = "AHMED_DATA";
    private SharedPreferences sharedPreferences;
    private Counter yesCounter;
    private Counter noCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sharedPreferences = getSharedPreferences("feedback_activity_prefs", MODE_PRIVATE);
        yesCounter = new Counter(sharedPreferences.getInt("Yes", 0));
        noCounter = new Counter(sharedPreferences.getInt("No",0 ));
        myLog("is created");


        TextView textView3 = findViewById(R.id.cancelfeedback);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        Button sbutton = findViewById(R.id.sendbutton);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

                int checkedId = rg.getCheckedRadioButtonId();
                if(checkedId == -1){
                    Message.message(getApplicationContext(), "Please select yes or no " );

                }else {
                    findRadioButton(checkedId);
                }

            }
        });
    }

    private void findRadioButton(int checkedId) {
        if (checkedId == R.id.yesRadioButton ) {
            yesCounter.increment();
            Message.message(getApplicationContext(), "Feedback sent");
        }
        if(checkedId == R.id.noRadioButton ){
            noCounter.increment();
            Message.message(getApplicationContext(), "Feedback sent");
        }
    }
    public void saveData(){

        sharedPreferences = getSharedPreferences("feedback_activity_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Yes", yesCounter.getValueOfCounter());
        editor.putInt("No", noCounter.getValueOfCounter());

        // write to disk
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        myLog( "is resumed");


        int i = -1;
        try {
            i = Integer.parseInt("123");
        }catch (NumberFormatException parseException){
            Log.e(TAG, parseException.getMessage());
        }catch (Exception pokemon){
            Log.e(TAG, pokemon.getMessage(), pokemon);
        }
        myLog(" goes on resume: " + i);

        //read from preferences..................
        Log.i(TAG, "read from prefer, key: " + "Yes" + ", value: " + sharedPreferences.getInt("Yes", 100 ));
        Log.i(TAG, "read from prefer, key: " + "NO" + ", value: " + sharedPreferences.getInt("No", 100 ));

    }
    @Override
    protected void onPause() {
        super.onPause();
        myLog( "is paused");
        saveData();


    }
    private void myLog(String msg){
        Log.d(TAG, "MainActivity" + msg);
    }
}