package com.example.tempconcerter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText t_input;
    private TextView t_output;
    private RadioButton c_buton, f_buton;
    private Button convert_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_input = (EditText) findViewById(R.id.TextInput);
        t_output = (TextView) findViewById(R.id.TextOutput);
        c_buton = (RadioButton) findViewById(R.id.C_Button);
        f_buton = (RadioButton) findViewById(R.id.F_Button);
        convert_buton = (Button) findViewById(R.id.Convert_button);

        View.OnClickListener listener = new ButtonListener();
        convert_buton.setOnClickListener(listener);
    }
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            buttonClickHandler();
        }
    }
    private void showToast(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
    private float convert_cel_to_fr( float cel){
        return ((cel * 9) / 5 + 32);
    }

    private float convert_fr_to_cel(float fr){
        return ((fr - 32) * 5 / 9 );
    }

    private void buttonClickHandler(){
        String text = t_input.getText().toString();
        if (text.length() == 0) {
            showToast ("Introdu un numar");
            return;
        }
        float valoare = Float.parseFloat(text);
        String rezultat = "";

        if (c_buton.isChecked()){
            float c = convert_fr_to_cel(valoare);
            rezultat = "" + c + " Grade Celcius";
        }
        else {
            if (f_buton.isChecked()) {
                rezultat = "" + convert_cel_to_fr(valoare) + " Grade Fahrenheit";
            } else {showToast("Selecteaza una din optiuni");}
        }
        t_output.setText(rezultat);

    }
}