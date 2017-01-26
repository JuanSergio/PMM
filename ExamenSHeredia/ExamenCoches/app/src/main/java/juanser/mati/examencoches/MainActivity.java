package juanser.mati.examencoches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import static juanser.mati.examencoches.R.id.grupo;

public class MainActivity extends AppCompatActivity {
    //Lista para el spinner
    private Tipos[] datos = new Tipos[]{
            new Tipos("Megane ", "Seat", "20"),
            new Tipos("X-11 ", "Ferrari", "100"),
            new Tipos("Fiesta ", "Ford", "40"),
    };

    private Object[] calculos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcular = (Button) findViewById(R.id.precio);
        final RadioGroup tarifas = (RadioGroup) findViewById(grupo);
        final Button sin = (Button) findViewById(R.id.sin);
        final Button riesgo = (Button) findViewById(R.id.riesgo);
        final EditText hora = (EditText) findViewById(R.id.hora);
        final CheckBox gps = (CheckBox) findViewById(R.id.gps);
        final CheckBox aire = (CheckBox) findViewById(R.id.aire);
        final CheckBox radioDVD = (CheckBox) findViewById(R.id.radioDvD);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this,Factura.class);
                Bundle objeto = new Bundle();

                TextView nombre_texto =(TextView)findViewById(R.id.nombre);
                TextView clase_texto=(TextView)findViewById(R.id.clase);
                TextView precio_texto=(TextView)findViewById(R.id.precio);

                String nombre=nombre_texto.getText().toString();
                String clase=clase_texto.getText().toString();
                String precios=precio_texto.getText().toString();

                Tipos datos = new Tipos(nombre,clase,precios);

                boolean selected1 = false;
                boolean selected2 = false;
                boolean selected3 = false;
                boolean selected4 = false;

                if(gps.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.gps);
                    check1.setText(gps.getText());
                }
                if(aire.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.aire);
                    check1.setText(aire.getText());
                }
                if(radioDVD.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.radioDvD);
                    check1.setText(radioDVD.getText());
                }

                String nombres;

                if (tarifas.getCheckedRadioButtonId() == R.id.sin) {
                    TextView radio1 = (TextView) findViewById(R.id.sin);
                    radio1.setText(radio1.getText());
                    nombres=radio1.getText().toString();
                    ventana.putExtra("grupo", nombres);
                }

                if (tarifas.getCheckedRadioButtonId() == R.id.riesgo) {
                    TextView radio2 = (TextView) findViewById(R.id.riesgo);
                    radio2.setText((radio2.getText()));
                    nombres=radio2.getText().toString();
                    ventana.putExtra("grupo", nombres);

                }
            }
        });

    }
}
