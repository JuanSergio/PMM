package juanser.mati.layouts;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        Button rouge = (Button)findViewById(R.id.rouge);
        Button blanc = (Button)findViewById(R.id.blanc);
        Button bleu = (Button)findViewById(R.id.bleu);
        Button color = (Button)findViewById(R.id.color);
        Button borrar = (Button)findViewById(R.id.borrar);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rgcolor);
        final TextView texto = (TextView)findViewById(R.id.texto);
        //permitir color con content
        final Context context = this;

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R.id.rouge == radioGroup.getCheckedRadioButtonId()){
                    texto.setBackgroundColor(ContextCompat.getColor(context,R.color.rouge));
                }
                if (R.id.blanc == radioGroup.getCheckedRadioButtonId()){
                    texto.setBackgroundColor(ContextCompat.getColor(context,R.color.blanc));
                }
                if (R.id.bleu == radioGroup.getCheckedRadioButtonId()){
                    texto.setBackgroundColor(ContextCompat.getColor(context,R.color.bleu));
                }


            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.parseColor("#000000");
                texto.setBackgroundColor(color);
            }
        });
    }


}
