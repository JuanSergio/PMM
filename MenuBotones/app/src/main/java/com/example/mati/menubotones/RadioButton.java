package com.example.mati.menubotones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by mati on 3/10/16.
 */
public class RadioButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView lblMensaje = (TextView)findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.gruporb);

        //2º FORMA, MUESTRA EL TEXTO DEL BOTON + EL ID

        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radio1)
                    textoOpcion +="OPCION 1 con ID:" + checkedId;
                if( group.getCheckedRadioButtonId()==R.id.radio2)
                    textoOpcion +="OPCION 2 con ID:" + checkedId ;
                lblMensaje.setText(textoOpcion);
            }
        });

        //1º FORMA, MUESTRA EL ID


        //   rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //       public void onCheckedChanged(RadioGroup group, int checkedId) {
        //           lblMensaje.setText("ID opción seleccionada: " + checkedId);
        //       }
        //   });
    }
}

