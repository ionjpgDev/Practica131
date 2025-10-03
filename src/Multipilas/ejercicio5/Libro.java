package Multipilas.ejercicio5;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int numPaginas;

    public Libro(String codigo, String titulo, String autor, int numPaginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getNumPaginas() { return numPaginas; }
}