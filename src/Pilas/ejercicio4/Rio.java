package Pilas.ejercicio4;

public class Rio {
    private String nombre,municipio;
    private double alturaActual, alturaNormal;

    public Rio(String nombre, String municipio, double alturaActual, double alturaNormal) {
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

    public double getAlturaActual() {
        return alturaActual;
    }

    public void setAlturaActual(double alturaActual) {
        this.alturaActual = alturaActual;
    }

    public double getAlturaNormal() {
        return alturaNormal;
    }

    public void setAlturaNormal(double alturaNormal) {
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
