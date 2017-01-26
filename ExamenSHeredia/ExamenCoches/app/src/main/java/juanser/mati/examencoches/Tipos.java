package juanser.mati.examencoches;

import java.io.Serializable;

public class Tipos implements Serializable{
    String nombre, clase, precio;


    public Tipos(String nombre, String clase, String precio) {
        this.nombre = nombre;
        this.clase = clase;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tipos{" +
                "nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", precio=" + precio +
                '}';
    }
}
