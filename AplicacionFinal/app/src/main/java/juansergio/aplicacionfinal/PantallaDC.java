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
    private UsuarioSQLiteHelper usuarioCli;
    private Comic []comics;

    ArrayList<Comic> arrayComics = new ArrayList<Comic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dc);

        usuarioCli = new UsuarioSQLiteHelper(this, "BDUsuario", null, 1);
        SQLiteDatabase bd = usuarioCli.getWritableDatabase();
        //bd.execSQL("INSERT INTO Comics (Titulo, Genero, Precio) VALUES ('Batman AK','Aventura','14.95€')");
        //bd.execSQL("INSERT INTO Comics (Titulo, Genero, Precio) VALUES ('Superman returns','Acción','5.95€')");

        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

        String[] campos = new String[] {"Titulo", "Genero", "Precio"};
        Cursor c = bd.query("Comics", campos, null, null, null, null, null);
        comics=new Comic[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String titulo = c.getString(0);
                String genero = c.getString(1);
                Double precio = c.getDouble(2);

                comics[i] = new Comic(titulo, genero, precio);

                i++;

            } while (c.moveToNext());
        }



        AdaptadorComics adaptador = new AdaptadorComics(this);
        final Spinner spinnerDC = (Spinner) findViewById(R.id.spinnerDC);
        spinnerDC.setAdapter(adaptador);

        spinnerDC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + comics[position].getTitulo() + ", Genero: " + comics[position].getGenero()+ ", Precio: " +comics[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button BotonVolver= (Button) findViewById(R.id.BotonVolver);

        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(PantallaDC.this, Aplicacion.class);
                startActivity(volver);
            }
        });



    }

public class AdaptadorComics extends ArrayAdapter {

    Activity context;

    AdaptadorComics(Activity context) {

        super(context, R.layout.activity_comic, comics);
        this.context = context;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        View vistaDesplegada = getView(position, convertView, parent);
        return vistaDesplegada;
    }

    public View getView(int i, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_comic, null);

        TextView tit = (TextView) item.findViewById(R.id.texto1);
        tit.setText(comics[i].getTitulo());

        TextView gen = (TextView) item.findViewById(R.id.texto2);
        gen.setText(comics[i].getGenero());

        TextView pre = (TextView) item.findViewById(R.id.texto3);
        pre.setText(String.valueOf(comics[i].getPrecio()));

        return (item);
    }
}


}

