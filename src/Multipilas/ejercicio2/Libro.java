package Multipilas.ejercicio2;

public class Libro {
    private String titulo,autor;
    private int idLibro,stock;

    public Libro(String titulo, String autor, int idLibro, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLibro = idLibro;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getstock() {
        return stock;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idLibro=" + idLibro +
                ", stock=" + stock +
                '}';
    }
}
