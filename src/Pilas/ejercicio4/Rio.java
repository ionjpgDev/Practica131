package Pilas.ejercicio4;

public class Rio {
    private String nombre,municipio;
    private int alturaActual, alturaNormal;

    public Rio(String nombre, String municipio, int alturaActual, int alturaNormal) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.alturaActual = alturaActual;
        this.alturaNormal = alturaNormal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getAlturaActual() {
        return alturaActual;
    }

    public void setAlturaActual(int alturaActual) {
        this.alturaActual = alturaActual;
    }

    public int getAlturaNormal() {
        return alturaNormal;
    }

    public void setAlturaNormal(int alturaNormal) {
        this.alturaNormal = alturaNormal;
    }

    @Override
    public String toString() {
        return "Rio{" +
                "nombre='" + nombre + '\'' +
                ", municipio='" + municipio + '\'' +
                ", alturaActual=" + alturaActual +
                ", alturaNormal=" + alturaNormal +
                '}';
    }
}
