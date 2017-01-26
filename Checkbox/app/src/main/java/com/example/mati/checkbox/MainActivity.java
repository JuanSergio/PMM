package com.example.mati.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();
    }


    public void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);

        txtHobby = (TextView) findViewById(R.id.txtHobby);

        //   btnHobby = (Button)findViewById(R.id.btnHobby);

        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());

        // btnHobby.setOnClickListener(new View.OnClickListener() {
        //     public void onClick(View v){
        //         getHobbyClick(v);
        //     }
        // });

    }

                    //1º FORMA


    // public void getHobbyClick(View v)//MARCAR DIFERENTES OPCIONES
    // {
    //     String strMessage = "";
    //     if(chkBoxCycling.isChecked())
    //     {
    //         strMessage+="Cycling ";
    //     }
    //     if(chkBoxTeaching.isChecked())
    //     {
    //         strMessage+="Teaching ";
    //     }
    //     if(chkBoxBlogging.isChecked())
    //     {
    //         strMessage+="Blogging ";
    //     }
    //     showTextNotification(strMessage);
    // }


    //   public void showTextNotification(String msgToDisplay)//MUESTRA LO QUE HAS SELECCIONADO
    //   {
    //       txtHobby.setText(msgToDisplay);
//Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    //   }

    //CLASE INTERNA
    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {//HAY QUE IMPLEMENTAR EL METODO DE LA INTERFAZ

        @Override

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {//MANIPULADORES DE LOS CHECKBOX
            if (isChecked) {
                if (buttonView == chkBoxCycling) {
                    showTextNotification("Cycling");
                }
                if (buttonView == chkBoxTeaching) {
                    showTextNotification("Teaching");
                }
                if (buttonView == chkBoxBlogging) {
                    showTextNotification("BlackBlogging");
                }
            }else showTextNotification("No hay nada seleccionado");
        }
    }

    public void showTextNotification(String msgToDisplay) {
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}

