package com.example.mati.buttonevent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton1 =(Button) findViewById(R.id.button);
        final Button boton2 =(Button) findViewById(R.id.button2);
        final Button boton3 =(Button) findViewById(R.id.button3);
        final Button boton4 =(Button) findViewById(R.id.button4);

        final Intent intento1 = new Intent(this,LinearLatout.class);
        final Intent intento2 = new Intent(this,TableLayout.class);
        final Intent intento3 = new Intent(this,RelativeLayout.class);
        final Intent intento4 = new Intent(this,GridLayout.class);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intento1);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intento2);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intento3);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intento4);
            }
        });






    }

}
