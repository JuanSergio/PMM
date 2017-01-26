package com.example.mati.holamundo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText texto = (EditText) findViewById(R.id.editText);
        final Button boton = (Button) findViewById(R.id.button);
        final TextView saludo = (TextView) findViewById(R.id.textView2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override//SI FALLA ES PORQUE FALTA ESTO
            
            public void onClick(View v) {
                String mensaje ="Te saludo " + texto.getText();
                saludo.setText(mensaje);
            }
        });


    }



}


