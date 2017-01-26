package com.example.mati.proysumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1=(EditText)findViewById(R.id.editText);
        final EditText num2=(EditText)findViewById(R.id.editText2);

        final RadioButton suma=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton resta=(RadioButton)findViewById(R.id.radioButton2);
        final RadioGroup rg =(RadioGroup)findViewById(R.id.grupo);

        final TextView resultado=(TextView)findViewById(R.id.textView);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(suma.isChecked() == true){
                    int sumar=Integer.valueOf(num1.getText().toString())+Integer.valueOf(num2.getText().toString());
                    String resul=String.valueOf(sumar);
                    resultado.setText(resul);
                }
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resta.isChecked() == true){
                    int sumar=Integer.valueOf(num1.getText().toString())-Integer.valueOf(num2.getText().toString());
                    String resul=String.valueOf(sumar);
                    resultado.setText(resul);
                }
            }
        });



    }


}
