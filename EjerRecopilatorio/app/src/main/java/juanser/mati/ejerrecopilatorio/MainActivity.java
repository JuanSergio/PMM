package juanser.mati.ejerrecopilatorio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //CREAMOS LA LISTA DE OBJETOS DEL SPINNER
    private Destinos[] destino=new Destinos[]{
            new Destinos("A","Asia y Oceanía","30"),
            new Destinos("B","América y África","20"),
            new Destinos("C","Europa","10")

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton radio1 =(RadioButton)findViewById(R.id.radio_normal);
        final RadioButton radio2 =(RadioButton)findViewById(R.id.radio_urge);
        final RadioGroup grupo =(RadioGroup)findViewById(R.id.radio_grupo);

        final EditText peso = (EditText)findViewById(R.id.texto_peso);
        final CheckBox caja = (CheckBox)findViewById(R.id.caja_reg);
        final CheckBox tarjeta = (CheckBox)findViewById(R.id.caja_tarj);

        final Button boton = (Button)findViewById(R.id.boton_calcular);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this,Factura.class);
                Bundle objeto = new Bundle();

                TextView zona_texto=(TextView)findViewById(R.id.resultado_zona);
                TextView continente_texto=(TextView)findViewById(R.id.resultado_continente);
                TextView precio_texto=(TextView)findViewById(R.id.resultado_precio);

                String zona=zona_texto.getText().toString();
                String continente=continente_texto.getText().toString();
                String precios=precio_texto.getText().toString();

                Destinos datos = new Destinos(zona,continente,precios);


                boolean selected1 = false;
                boolean selected2 = false;

                if(caja.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.caja_reg);
                    check1.setText(caja.getText());
                }

                if(tarjeta.isChecked()){
                    selected2 = true;
                    TextView check2 = (TextView) findViewById(R.id.caja_tarj);
                    check2.setText((tarjeta.getText()));
                }

                String nombre;

                if (grupo.getCheckedRadioButtonId() == R.id.radio_normal) {
                    TextView radio1 = (TextView) findViewById(R.id.radio_normal);
                    radio1.setText(radio1.getText());
                    nombre=radio1.getText().toString();
                    ventana.putExtra("grupo", nombre);
                }

                if (grupo.getCheckedRadioButtonId() == R.id.radio_urge) {
                    TextView radio2 = (TextView) findViewById(R.id.radio_urge);
                    radio2.setText((radio2.getText()));
                    nombre=radio2.getText().toString();
                    ventana.putExtra("grupo", nombre);

                }
                //Precio del peso y pasarlo
                double preciopeso = 0;
                int coste=0;

                if (peso.getText().toString().isEmpty()){
                    peso.setText("0");
                }
                if (Double.parseDouble(peso.getText().toString()) < 6){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1;
                }
                if (Double.parseDouble(peso.getText().toString()) >= 6 && Double.parseDouble(peso.getText().toString()) < 10){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1.5;
                }
                if (Double.parseDouble(peso.getText().toString()) >= 10){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 2;
                }
                //PASO EL COSTE FIJO POR ZONA Y EL PESO INTRODUCIDO

                double total=preciopeso+Double.parseDouble(precios.toString());//SI LA TARIFA ES NORMAL SE APLICA ESTE
                double total2=(preciopeso+Double.parseDouble(precios.toString()))*1.30;// SI LA TARIFA ES URGENTE ESTE OTRO

                ventana.putExtra("total",String.valueOf(total));
                ventana.putExtra("total2",String.valueOf(total2));

                ventana.putExtra("peso", peso.getText().toString());
                ventana.putExtra("preciopeso", String.valueOf(preciopeso));

                ventana.putExtra("boolean1",selected1);
                ventana.putExtra("boolean2",selected2);
                ventana.putExtra("caja_regalo",caja.getText().toString());
                ventana.putExtra("caja_tarjeta",tarjeta.getText().toString());
                objeto.putSerializable("informacion",datos);
                ventana.putExtras(objeto);
                startActivity(ventana);
            }
        });




        final Spinner spinner=(Spinner)findViewById(R.id.spinner);

        Adaptador adaptador= new Adaptador(this);
        spinner.setAdapter(adaptador);

//seleccionar una opción de la lista desplegable,
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View view, int position, long l) {
                String mensaje="Seleccionado: Zona "+destino[position].getZona()+" continente "+destino[position].getContinente()+" Precio "+destino[position].getPrecio();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    //MENU ACERCA DE Y DIBUJAR

    //PARA QUE SE VISUALICE EL MENU
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_acerca:
                Intent acerca = new Intent(MainActivity.this, Acerca.class);
                startActivity(acerca);
                return true;
            case R.id.menu_dibujar:
                Intent dibujo = new Intent(MainActivity.this, Dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class Adaptador extends ArrayAdapter<Destinos>{
        public Activity context;

        public Adaptador(Activity Context){
            super(Context,R.layout.destino,destino);
            this.context=Context;
        }
        public View getView(int position, View convertview, ViewGroup Parent){
            LayoutInflater inflater=context.getLayoutInflater();
            final View item = inflater.inflate(R.layout.activity_factura,null);

//HAY QUE PASAR LAS ETIQUETA QUE SE USAN EN EL LAYOUT DE FACTURA Y RELACIONARLAS
            TextView zona = (TextView)item.findViewById(R.id.resultado_zona);
            TextView continente = (TextView)item.findViewById(R.id.resultado_continente);
            final TextView precio = (TextView)item.findViewById(R.id.resultado_precio);

            zona.setText(destino[position].getZona());
            continente.setText(destino[position].getContinente());
            precio.setText(String.valueOf(destino[position].getPrecio()));

            return item;
        }

        public View getDropDownView(int position, View convertview, ViewGroup Parent){
            View ver_spinner= getView(position,convertview,Parent);
            return ver_spinner;
        }


    }
}
