package juansergio.aplicacionfinal;

import android.app.Activity;
import android.content.Context;
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



public class FragmentComics extends Fragment {


    private OnFragmentInteractionListener mListener;
    private Button aceptar, cancelar, compra;
    private Activity activity;
    private RelativeLayout layout;
    private TextView titulo, genero, precio, radioButton, checkBox;
    private UsuarioSQLiteHelper usuarioSQL;

    public FragmentComics() {


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Para poder usar etiquetas
        View view = inflater.inflate(R.layout.fragment_fragment_comics, container, false);

        aceptar=(Button)view.findViewById(R.id.aceptar_compra);
        cancelar=(Button)view.findViewById(R.id.cancelar_compra);
        compra=(Button)view.findViewById(R.id.botonCompra);
        layout=(RelativeLayout)view.findViewById(R.id.idframe);



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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
