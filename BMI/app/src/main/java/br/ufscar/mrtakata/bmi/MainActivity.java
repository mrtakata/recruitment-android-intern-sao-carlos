package br.ufscar.mrtakata.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "br.ufscar.mrtakata.bmi.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText height_value = (EditText) findViewById(R.id.height_value);
        EditText weight_value = (EditText) findViewById(R.id.weight_value);

        try{
            float height = Float.valueOf(height_value.getText().toString());
            float weight = Float.valueOf(weight_value.getText().toString());
            String message = Float.toString(calculateBMI(height, weight));
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        catch(Exception e){
            Toast.makeText(this, "Campo(s) Vazio(s).", Toast.LENGTH_LONG).show();


//            LinearLayout layout = (LinearLayout) findViewById(R.id.main);
//            layout.addView(textView);
        }

    }
    private float calculateBMI(float height, float weight){
        return weight / (height * height);
    }
}
