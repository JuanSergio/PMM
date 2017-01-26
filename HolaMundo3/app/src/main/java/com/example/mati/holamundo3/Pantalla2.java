package com.example.mati.holamundo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        final TextView otroSaludo= (TextView)findViewById(R.id.textView);
        final Button volver = (Button)findViewById(R.id.button);

        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarsaludo=miBundleRecoger.getString("TEXTO");


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miintent = new Intent();
                Bundle vueltaBundle=new Bundle();
                String mensajeDevuelto= "Devuelvo a Principal " + completarsaludo;
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                miintent.putExtras(vueltaBundle);
                setResult(RESULT_OK, miintent);
                finish();

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
