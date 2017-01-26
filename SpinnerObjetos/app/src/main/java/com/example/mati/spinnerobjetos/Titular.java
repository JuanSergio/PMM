package com.example.mati.spinnerobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Titular implements Serializable{

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
