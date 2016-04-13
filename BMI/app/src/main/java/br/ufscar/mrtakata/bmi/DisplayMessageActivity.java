package br.ufscar.mrtakata.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DisplayMessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // message is message from another activity
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // bmi result
        float bmi_value = Float.parseFloat(message);

        // message that follows bmi value
        String bmiMessageString = getBMIMessage(bmi_value);

        // message and result color
        int messageColor = getBMITextColor(bmi_value);

        TextView bmi = (TextView) findViewById(R.id.BMI_number),
                 bmiMessage = (TextView) findViewById(R.id.BMI_message_result);

        // show result and set text color
        bmi.setText(message);
        bmi.setTextColor(messageColor);

        // show diagnosis message and set text color
        bmiMessage.setText(bmiMessageString);
        bmiMessage.setTextColor(messageColor);
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);

//        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
//        layout.addView();
    }

    protected String getBMIMessage(float value){
        String returnMessage;
        if(value <= 15){
            returnMessage = "You are very severely underweight!";
        }
        else if(value <= 16.5){
            returnMessage = "You are severely underweight!";
        }
        else if(value <= 18){
            returnMessage = "You might be a little underweight!";
        }
        else if(value <= 25){
            returnMessage = "Relax! You are healthy!";
        }
        else if(value <= 30){
            returnMessage = "You might be a little overweight!";
        }
        else if(value <= 35){
            returnMessage = "You are classified as Obese Class I!";
        }
        else if(value <= 40){
            returnMessage = "You are classified as Obese Class II!";
        }
        else{
            returnMessage = "You are classified as Obese Class III!";
        }
        return returnMessage;
    }

    protected int getBMITextColor(float value){
        int c;
        if(value <= 16.5){
            c = Color.RED;
        }
        else if(value <= 18){
            c = Color.rgb(222, 161, 55);
        }
        else if(value <= 25){
            c = Color.rgb(50, 205, 50);
        }
        else if(value <= 30){
            c = Color.rgb(222, 161, 55);
        }
        else{
            c = Color.RED;
        }
        return c;
    }
}
