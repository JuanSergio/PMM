package juanser.mati.variosdibujos2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable;
        public VistaAMedida(Context context){
            super(context);
            int x=10, y =10;
            int ancho=300, alto=50;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,+ancho,y+alto);
        }
        protected void onDraw(Canvas canvas){
            miDrawable.draw(canvas);
        }
    }
}
