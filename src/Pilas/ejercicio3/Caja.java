package Pilas.ejercicio3;

public class Caja {
    private int area;
    private String color,contenido;

    public Caja(int area, String color, String contenido) {
        this.area = area;
        this.color = color;
        this.contenido = contenido;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "area=" + area +
                ", color='" + color + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
