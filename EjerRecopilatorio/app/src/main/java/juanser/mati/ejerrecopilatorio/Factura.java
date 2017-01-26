package juanser.mati.ejerrecopilatorio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        TextView resultado_zona=(TextView)findViewById(R.id.resultado_zona);
        TextView resultado_continente=(TextView)findViewById(R.id.resultado_continente);
        TextView resultado_precio=(TextView)findViewById(R.id.resultado_precio);
        TextView resultado_cajas=(TextView)findViewById(R.id.resultado_cajas);
        TextView resultado_radios=(TextView)findViewById(R.id.resultado_radios);
        TextView resultado_precio_inicial=(TextView)findViewById(R.id.resultado_precio_inicial);
        TextView resultado_precio_incrementado=(TextView)findViewById(R.id.resultado_precio_incrementado);
        TextView resultado_precio_final=(TextView)findViewById(R.id.resultado_precio_final);

        Bundle miBundle = getIntent().getExtras();
        Destinos destino = (Destinos) miBundle.getSerializable("informacion");

        resultado_zona.setText(destino.getZona());
        resultado_continente.setText(destino.getContinente());
        resultado_precio.setText(destino.getPrecio());

        if(getIntent().getExtras().getBoolean("boolean1")==true){
            resultado_cajas.setText(getIntent().getStringExtra("caja_regalo"));
        }
        if(getIntent().getExtras().getBoolean("boolean2")==true){
            resultado_cajas.setText(resultado_cajas.getText()+" y " + getIntent().getStringExtra("caja_tarjeta"));
        }
        resultado_radios.setText(resultado_radios.getText() + getIntent().getStringExtra("grupo"));

        if(resultado_zona.getText().equals("A")){
            int coste=30;
            resultado_precio_inicial.setText("precio inicial "+getIntent().getExtras().getString("peso")+" , "+" precio incrementado "
                    +getIntent().getStringExtra("preciopeso")+" precio zona "+coste);
        }
        if(resultado_zona.getText().equals("B")){
            int coste=20;
            resultado_precio_inicial.setText("precio inicial "+getIntent().getExtras().getString("peso")+" , "+" precio incrementado "
                    +getIntent().getStringExtra("preciopeso")+" precio zona "+coste);
        }
        if(resultado_zona.getText().equals("C")){
            int coste=10;
            resultado_precio_inicial.setText("precio inicial "+getIntent().getExtras().getString("peso")+" , "+" precio incrementado "
                    +getIntent().getStringExtra("preciopeso")+" precio zona "+coste);
        }

        resultado_precio_incrementado.setText(" precio incrementado "+getIntent().getStringExtra("preciopeso"));

        if (resultado_radios.getText().equals("TARIFA URGENTE")) {
            resultado_precio_final.setText("TOTAL :" + String.valueOf(getIntent().getStringExtra("total2"))+ "€ ");

        }else
            resultado_precio_final.setText("TOTAL :" + String.valueOf(getIntent().getStringExtra("total")) + "€ ");
    }

}
