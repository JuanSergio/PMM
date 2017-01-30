package juansergio.aplicacionfinal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PantallaDC extends AppCompatActivity {

    private Comic[]lista;
    public ArrayList<Comic> comic = new ArrayList<Comic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dc);

        final Button BotonVolver = (Button) findViewById(R.id.BotonDC);
        //Se instancia la bd con nuevo usuario
        UsuarioSQLiteHelper usu = new UsuarioSQLiteHelper(this, "Usuario", null, 1);
        //Que la bd se pueda modificar
        SQLiteDatabase bd = usu.getWritableDatabase();

        bd.execSQL("INSERT INTO Comics (Titulo, Genero, Precio) VALUES ('Superman', 'Acción', '14.95')");

        //Mensaje como que registro completado
        Toast.makeText(getApplicationContext(),"Hecho", Toast.LENGTH_LONG).show();

        //Definir los campos
        String[] campos = new String[]{"Titulo", "Genero", "Precio"};
        //El cursor que recorrerá los campos, 5 null si no da error
        Cursor cursor = bd.query("Comics", campos, null, null, null, null, null);
        //Que cuente las columnas
        lista = new Comic[cursor.getCount()];
        //Bucle que recorra los campos
        int i=0;
        //Que empiece por el primer campo
        if(cursor.moveToFirst()){
            do{
                String titulo = cursor.getString(0);
                String genero = cursor.getString(1);
                Double precio = cursor.getDouble(2);

                lista[i] = new Comic(titulo, genero, precio);

                i++;
            }while (cursor.moveToNext());

        }

        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this);

        Spinner spinner = (Spinner)findViewById(R.id.SpinnerDC);
        spinner.setAdapter(adaptadorSpinner);

        //Acciones cuando se selecciona un elemento
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + lista[position].getTitulo() + ", Genero: " + lista[position].getGenero() + ", Precio: " + lista[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bd.close();


        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear el enlace que al pulsar el boton vaya a registro
                Intent irVolver = new Intent(PantallaDC.this, Aplicacion.class);
                startActivity(irVolver);

            }
        });
    }
    public class AdaptadorSpinner extends ArrayAdapter{

        Activity context;
        //Enlaza con los 3 textview de comic.xml
        AdaptadorSpinner(Activity context){
            super(context, R.layout.activity_comic, lista);
            this.context = context;
        }

        //Accion del spinner desplegado
        public View getDropDownView(int position, View convertView, ViewGroup parent){

            View spinnerDesplegado = getView(position, convertView, parent);
            return spinnerDesplegado;
        }

        //Inflater para meter los datos
        public View getView(int i, View convertView, ViewGroup parent){

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_comic, null);

            //Meter titulo en el campo texto1
            TextView MeterTitulo = (TextView) item.findViewById(R.id.texto1);
            MeterTitulo.setText(lista[i].getTitulo());

            //Meter genero en el campo texto2
            TextView MeterGenero = (TextView) item.findViewById(R.id.texto2);
            MeterGenero.setText(lista[i].getGenero());

            //Meter precio en el campo texto3
            TextView MeterPrecio = (TextView) item.findViewById(R.id.texto3);
            MeterPrecio.setText(String.valueOf(lista[i].getPrecio()));

            return (item);
        }

    }


}
