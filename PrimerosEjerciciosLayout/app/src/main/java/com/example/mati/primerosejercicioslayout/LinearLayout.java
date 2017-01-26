package com.example.mati.primerosejercicioslayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        final Context context=this;

        final RadioButton green = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton red = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton blue = (RadioButton) findViewById(R.id.radioButton3);

        final Button color = (Button) findViewById(R.id.button2);
        final TextView fondo = (TextView) findViewById(R.id.textView);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

                if(R.id.radioButton==rg.getCheckedRadioButtonId()){

                    fondo.setBackgroundColor(ContextCompat.getColor(context,R.color.verde));
                }

                if(R.id.radioButton2==rg.getCheckedRadioButtonId()){

                    fondo.setBackgroundColor(ContextCompat.getColor(context,R.color.rojo));
                }
                if(R.id.radioButton3==rg.getCheckedRadioButtonId()){

                    fondo.setBackgroundColor(ContextCompat.getColor(context,R.color.blue));
                }
            }
        });


    }
}

