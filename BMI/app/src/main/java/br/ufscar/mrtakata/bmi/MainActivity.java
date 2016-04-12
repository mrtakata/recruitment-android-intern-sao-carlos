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
            if(height > 3.00){
                throw new Exception("Height out of bounds.");
            }
            if(weight > 1000){
                throw new Exception("Weight out of bounds.");
            }
            String message = String.format("%.1f", calculateBMI(height, weight) );
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        catch(Exception e){
            if( "".equals( height_value.getText().toString() ) && "".equals(weight_value.getText().toString() ) ){
                Toast.makeText(this, "Height and Weight needed", Toast.LENGTH_LONG).show();
            }
            else if( "".equals( height_value.getText().toString() ) ){
                Toast.makeText(this, "Height needed.", Toast.LENGTH_LONG).show();
            }
            else if( "".equals( weight_value.getText().toString() ) ){
                Toast.makeText(this, "Weight needed.", Toast.LENGTH_LONG).show();
            }

            if("Height out of bounds.".equals( e.getMessage() ) ){
                Toast.makeText(this, "You can't that tall unless you are not human!", Toast.LENGTH_LONG).show();
            }

            if("Weight out of bounds.".equals( e.getMessage() ) ){
                Toast.makeText(this, "You can't be that heavy (I guess).", Toast.LENGTH_LONG).show();
            }

//            LinearLayout layout = (LinearLayout) findViewById(R.id.main);
//            layout.addView(textView);
        }

    }
    private float calculateBMI(float height, float weight){
        return weight / (height * height);
    }
}
