package com.example.mati.objetosentrepantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView saludo = (TextView)findViewById(R.id.textView);

        Bundle object= getIntent().getExtras();
        Persona persona = (Persona) object.getSerializable("Texto");
        saludo.setText("Nombre: "+persona.getNombre()+"Apellido: "+persona.getApellido()+"Edad:"+persona.getEdad());

    }
}
