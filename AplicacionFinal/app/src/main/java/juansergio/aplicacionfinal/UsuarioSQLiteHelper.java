package juansergio.aplicacionfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase.*;


public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    String cadSQL = "CREATE TABLE Usuarios (nombre TEXT, password TEXT)";

    public UsuarioSQLiteHelper(Context contexto, String nombre, CursorFactory almacen,int version){
        super (contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase bd){
        //Se ejecuta la basa de datos
        bd.execSQL(cadSQL);

    }
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva){
        bd.execSQL("DROP TABLE IF EXISTS Usuarios");
        bd.execSQL(cadSQL);

    }
}
