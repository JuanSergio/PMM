package com.example.mati.spinnersimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, semana);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0,View arg1, int position, long id) {
                String mensaje="";
                mensaje = "Item clicked => " +semana[position];
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void showToast(String text){

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }
}

