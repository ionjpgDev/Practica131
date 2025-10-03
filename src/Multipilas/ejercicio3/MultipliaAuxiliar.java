package Multipilas.ejercicio3;



public class MultipliaAuxiliar {
    private int np;
    private PilaAuxiliar p[] = new PilaAuxiliar[100];

    MultipliaAuxiliar() {
        for (int i = 0; i < 100; i++) {
            p[i] = new PilaAuxiliar();
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
    public void adicionar(int i, Auxiliar elem) {
        p[i].adicionar(elem);
    }

    public Auxiliar eliminar(int i) {
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

    public void vaciar(int i, PilaAuxiliar x) {
        p[i].vaciar(x);
    }

    public void vaciar(int i, int j) {
        p[i].vaciar(p[j]);
    }
}
