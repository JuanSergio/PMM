package juanser.mati.variosdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));
    }

    public class Dibujo extends View {
        public Dibujo(Context context){super(context);}

            protected void onDraw(Canvas canvas){

                this.setBackgroundColor(Color.BLACK);

                Paint circulo = new Paint();
                Paint cuadrado1 = new Paint();
                Paint cuadrado2 = new Paint();
                Paint cuadrado3 = new Paint();
                Paint cuadrado4 = new Paint();
                Paint punto = new Paint();


                circulo.setColor(Color.MAGENTA);
                circulo.setStrokeWidth(15);
                circulo.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(500,500,220,circulo);//canvas lo dibuja

                punto.setColor(Color.CYAN);
                punto.setStrokeWidth(10);
                punto.setStyle(Paint.Style.FILL);
                canvas.drawPoint(500,500,punto);

                cuadrado1.setColor(Color.RED);
                cuadrado1.setStrokeWidth(105);
                cuadrado1.setStyle(Paint.Style.STROKE);
                canvas.drawRect(150,150,200,200,cuadrado1);

                cuadrado2.setColor(Color.BLUE);
                cuadrado2.setStrokeWidth(105);
                cuadrado2.setStyle(Paint.Style.STROKE);
                canvas.drawRect(800,200,850,150,cuadrado2);//float left, float top, float right, float bottom

                cuadrado3.setColor(Color.GREEN);
                cuadrado3.setStrokeWidth(105);
                cuadrado3.setStyle(Paint.Style.STROKE);
                canvas.drawRect(150,900,200,850,cuadrado3);

                cuadrado4.setColor(Color.YELLOW);
                cuadrado4.setStrokeWidth(105);
                cuadrado4.setStyle(Paint.Style.STROKE);
                canvas.drawRect(800,900,850,850,cuadrado4);




            }

        }
    }

