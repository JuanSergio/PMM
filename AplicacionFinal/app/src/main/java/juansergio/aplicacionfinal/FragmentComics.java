package juansergio.aplicacionfinal;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentComics extends Fragment {

    private OnFragmentInteractionListener mListener;

    Button aceptar, cancelar, compra;
    Activity activity;
    RelativeLayout layout;
    TextView titulo, genero, precio, radioButtons, box;
    UsuarioSQLiteHelper usuarioCli;

    public FragmentComics() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Para poder usar etiquetas
        View view = inflater.inflate(R.layout.fragment_fragment_comics, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_compra);
        cancelar = (Button) view.findViewById(R.id.cancelar_compra);
        compra = (Button) view.findViewById(R.id.botonCompra);
        layout = (RelativeLayout) view.findViewById(R.id.idframe);
        titulo=(TextView) view.findViewById(R.id.titulo);
        genero=(TextView) view.findViewById(R.id.genero);
        precio=(TextView) view.findViewById(R.id.precio);
        box = (TextView) view.findViewById(R.id.extras);
        radioButtons = (TextView) view.findViewById(R.id.pago);

        final Bundle bundle=this.getArguments();
        final Comic comic= (Comic) bundle.getSerializable("informacion");

        titulo.setText("Titulo: " + comic.getTitulo());
        genero.setText("Genero: " + comic.getGenero());
        precio.setText("Precio: " + comic.getPrecio() + " €/Unidad");
        box.setText("Extras: ");

        if (this.getArguments().getBoolean("boolean1") == true) {
            box.setText(box.getText() + this.getArguments().getString("regalo"));
        }
        if (this.getArguments().getBoolean("boolean2") == true) {
            box.setText(box.getText() + "  " + this.getArguments().getString("subscripcion"));
        }
        if (this.getArguments().getBoolean("boolean3") == true) {
            box.setText(box.getText() + "  " + this.getArguments().getString("figura"));
        }

        radioButtons.setText(this.getArguments().getString("grupo"));

        aceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity = getActivity();
                Toast.makeText(activity, "GRACIAS POR LA COMPRA", Toast.LENGTH_LONG).show();

                layout.setVisibility(View.INVISIBLE);
            }

        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setVisibility(View.INVISIBLE);

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}

