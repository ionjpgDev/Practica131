package Multipilas.ejercicio5;

public class MultipilaLibro {
    private int np;
    private PilaLibros[] p = new PilaLibros[100];

    public MultipilaLibro() {
        for (int i = 0; i < 100; i++) {
            p[i] = new PilaLibros();
        }
    }

    public int getNp() { return np; }
    public void setNp(int np) { this.np = np; }
    public boolean esVacia(int i) { return p[i].esVacia(); }
    public void adicionar(int i, Libro libro) { p[i].adicionar(libro); }
    public Libro eliminar(int i) { return p[i].eliminar(); }
    public void mostrar(int i) { p[i].mostrar(); }
}