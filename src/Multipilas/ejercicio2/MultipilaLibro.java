package Multipilas.ejercicio2;

public class MultipilaLibro {
    private int np;
    private PilaLibro p[] = new PilaLibro[100];

    MultipilaLibro() {
        for (int i = 0; i < 100; i++) {
            p[i] = new PilaLibro();
        }
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }

    public boolean esVacia(int i) {
        return p[i].esVacia();
    }

    public boolean esLlena(int i) {
        return p[i].esLlena();
    }

    public int nroElem(int i) {
        return p[i].nroelem();
    }
    public void adicionar(int i, Libro elem) {
        p[i].adicionar(elem);
    }

    public Libro eliminar(int i) {
        return p[i].eliminar();
    }

    public void mostrar(int i) {
        System.out.println("Pila " + (i + 1));
        p[i].mostrar();
    }

    public void mostrar() {
        for (int i = 0; i <= np - 1; i++) {
            System.out.println("Pila " + (i + 1));
            p[i].mostrar();

        }
    }

    public void vaciar(int i, PilaLibro x) {
        p[i].vaciar(x);
    }

    public void vaciar(int i, int j) {
        p[i].vaciar(p[j]);
    }
}
