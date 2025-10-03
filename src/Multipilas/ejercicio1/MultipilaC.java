package Multipilas.ejercicio1;

public class MultipilaC {
    private int np;
    private PilaC p[] = new PilaC[100];

    MultipilaC() {
        for (int i = 0; i < 100; i++) {
            p[i] = new PilaC();
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
    public void adicionar(int i, String elem) {
        p[i].adicionar(elem);
    }

    public String eliminar(int i) {
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

    public void vaciar(int i, PilaC x) {
        p[i].vaciar(x);
    }

    public void vaciar(int i, int j) {
        p[i].vaciar(p[j]);
    }

}
