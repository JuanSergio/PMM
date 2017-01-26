package com.example.mati.objetosentrepantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText nombretext = (EditText) findViewById(R.id.editText);
        final EditText apellidotext = (EditText) findViewById(R.id.editText2);
        final EditText edadtext = (EditText) findViewById(R.id.editText3);

        final Button ok = (Button) findViewById(R.id.button);




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nombre=nombretext.getText().toString();
                final String apellido=apellidotext.getText().toString();
                final int edad=Integer.parseInt(edadtext.getText().toString());

                Intent miintent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle objeto = new Bundle();

                Persona person = new Persona(nombre,apellido,edad);
                objeto.putSerializable("Texto",person);
                miintent.putExtras(objeto);
                startActivity(miintent);
            }
        });
    }
}
