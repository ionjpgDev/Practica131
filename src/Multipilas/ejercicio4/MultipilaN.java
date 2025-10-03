package Multipilas.ejercicio4;


public class MultipilaN {
    private int np;
    private PilaN p[] = new PilaN[100];

    MultipilaN() {
        for (int i = 0; i < 100; i++) {
            p[i] = new PilaN();
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
    public void adicionar(int i, int elem) {
        p[i].adicionar(elem);
    }

    public int eliminar(int i) {
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

    public void vaciar(int i, PilaN x) {
        p[i].vaciar(x);
    }

    public void vaciar(int i, int j) {
        p[i].vaciar(p[j]);
    }

}
