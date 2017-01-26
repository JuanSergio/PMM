package juanser.mati.shapedrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mati on 7/11/16.
 */

public class ClaseAMedida extends View {

    private ShapeDrawable midrawable;

    public ClaseAMedida(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public ClaseAMedida(Context context){
        super(context);

    }

    protected void onDraw(Canvas canvas){

        int x=10, y=10;
        int ancho=300, alto=50;
        midrawable = new ShapeDrawable(new OvalShape());
        midrawable.getPaint().setColor(0xff0000ff);
        midrawable.setBounds(x,y,x+ancho,y+alto);

        midrawable.draw(canvas);
    }
}


