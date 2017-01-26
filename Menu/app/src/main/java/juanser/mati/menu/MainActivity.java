package juanser.mati.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    private ImageView miImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        miImagen = (ImageView) findViewById(R.id.miImagen);

        miImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarMenu(v);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem itemSubMenu)
    {
        switch (itemSubMenu.getItemId()) {
            case R.id. SubMnuOpc1:
                lblMensaje.setText("Submenu: Opcion 1!");
                return true;
            case R.id. SubMnuOpc2:
                lblMensaje.setText ("Submenu: Opcion 2!"); ;
                return true;
            default:
                return super.onOptionsItemSelected(itemSubMenu);
        }

    }
    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        switch (itemMnuContex.getItemId()) {
            case R.id.CtxLblOpc1:
                lblMensaje.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                lblMensaje.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)


    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicial, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.drawable.pablito);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    public void lanzarMenu(View view){
        registerForContextMenu(miImagen);
        openContextMenu(view);
    }
}