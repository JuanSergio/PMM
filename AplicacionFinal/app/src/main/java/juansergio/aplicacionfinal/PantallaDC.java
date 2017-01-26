package juansergio.aplicacionfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaDC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dc);

        final Button BotonVolver = (Button) findViewById(R.id.BotonDC);

        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear el enlace que al pulsar el boton vaya a registro
                Intent irVolver = new Intent(PantallaDC.this, Aplicacion.class);
                startActivity(irVolver);

            }
        });
    }
}
