package Pilas.ejercicio5;

import java.security.PrivateKey;

public class Comida {
    private  String nomComida;
    private  int cantidad;

    public Comida(String nomComida, int cantidad) {
        this.nomComida = nomComida;
        this.cantidad = cantidad;
    }

    public String getNomComida() {
        return nomComida;
    }

    public void setNomComida(String nomComida) {
        this.nomComida = nomComida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "nomComida='" + nomComida + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
