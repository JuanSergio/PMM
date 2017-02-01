package juansergio.aplicacionfinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PantallaRegistro extends AppCompatActivity {
    private UsuarioSQLiteHelper usuarioSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        final Button BotonRegistro = (Button) findViewById(R.id.BotonRegistrar);
        final Button BotonVolver= (Button) findViewById(R.id.BotonVolver);
        final EditText RegistroNombre = (EditText) findViewById(R.id.RegistroNombre);
        final EditText RegistroPassword = (EditText) findViewById(R.id.RegistroPassword);

        usuarioSQLiteHelper = new UsuarioSQLiteHelper(this, "BDUsuario", null, 1);
        BotonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = usuarioSQLiteHelper.getWritableDatabase();
                bd.execSQL("INSERT INTO Usuarios(nombre, password) values('"+RegistroNombre.getText().toString()+"','"+RegistroPassword.getText().toString()+"')");
                bd.close();
                Intent volver = new Intent(PantallaRegistro.this, MainActivity.class);
                startActivity(volver);
            }
        });
        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(PantallaRegistro.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
