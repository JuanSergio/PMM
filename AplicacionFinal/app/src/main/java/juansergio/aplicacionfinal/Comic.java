package juansergio.aplicacionfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Comic implements Serializable {

    private String titulo, genero;
    private double precio;


    public Comic(String titulo, String genero, double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
