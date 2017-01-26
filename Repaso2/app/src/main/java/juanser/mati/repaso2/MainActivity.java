package juanser.mati.repaso2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText n1;
    private EditText n2;
    private TextView resul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById enlaza con el xml
        n1=(EditText)findViewById(R.id.numero1);
        n2=(EditText)findViewById(R.id.numero2);
        resul=(TextView)findViewById(R.id.resultado);

    }
    //Metodo a ejecutar al pulsa el boton sumar
    public void sumar (View view){
        //Leer el valor primero en un String
        String valor1 = n1.getText().toString();
        String valor2 = n2.getText().toString();
        //Convertir el valor string en valor int
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        int sumar = nro1 + nro2;
        //Se crea resu como variable de introduccion del valor suma
        String resul = String.valueOf(sumar);



    }
}
