package com.example.mati.primerosejercicioslayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        final Button color1 =(Button) findViewById(R.id.button3);
        final Button color2 =(Button) findViewById(R.id.button4);
        final Button color3 =(Button) findViewById(R.id.button5);
        final Button borrar =(Button) findViewById(R.id.button6);

        final TextView texto =(TextView) findViewById(R.id.textView2);

        final Context context=this;



        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setBackgroundColor(ContextCompat.getColor(context,R.color.rojo));
            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setBackgroundColor(ContextCompat.getColor(context,R.color.yellow));
            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setBackgroundColor(ContextCompat.getColor(context,R.color.blue));
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
            }
        });

    }
}
