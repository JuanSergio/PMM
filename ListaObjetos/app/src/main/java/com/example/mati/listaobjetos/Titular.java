package com.example.mati.listaobjetos;

import android.widget.ImageView;

public class Titular {

    private String titulo, subtitulo;
    private int view;

    public Titular(String tit, String sub,int mg){
        titulo=tit;
        subtitulo=sub;
        view = mg;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }


    public int getView() {
        return view;
    }
}
