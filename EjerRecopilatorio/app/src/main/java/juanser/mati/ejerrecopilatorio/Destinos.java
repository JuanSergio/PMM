package juanser.mati.ejerrecopilatorio;



import java.io.Serializable;


public class Destinos implements Serializable {
    private String zona,continente;
    private String precio;

    public Destinos (String zona, String continente, String precio){
        this.zona=zona;
        this.continente=continente;
        this.precio=precio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "zona='" + zona + '\'' +
                ", continente='" + continente + '\'' +
                ", precio=" + precio +
                '}';
    }
}