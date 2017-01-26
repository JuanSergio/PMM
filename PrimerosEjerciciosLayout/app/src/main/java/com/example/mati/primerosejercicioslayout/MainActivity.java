package com.example.mati.primerosejercicioslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton = (Button) findViewById(R.id.button);
        final Button boton2 = (Button) findViewById(R.id.button2);
        final Button boton3 = (Button) findViewById(R.id.button12);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miintent = new Intent(MainActivity.this,LinearLayout.class);

                startActivity(miintent);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miinten = new Intent(MainActivity.this,TableLayout.class);
                startActivity(miinten);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miinten = new Intent(MainActivity.this,RelativeLayout.class);
                startActivity(miinten);
            }
        });
    }

}
