package Multipilas.ejercicio3;


public class PilaAuxiliar {
    private int max = 50;
    private Auxiliar v[] = new Auxiliar[max + 1];
    private int tope;

    PilaAuxiliar() {
        tope = 0;
    }

    boolean esVacia() {
        if (tope == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean esLlena() {
        if (tope == max) {
            return true;
        } else {
            return false;
        }
    }

    int nroelem() {
        return tope;
    }

    void adicionar(Auxiliar e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    Auxiliar eliminar() {
        Auxiliar e = null;
        if (esVacia()) {
            System.out.println("Pila Esta Vacia");
        } else {
            e = v[tope];
            tope--;

        }
        return e;
    }

    void mostrar() {

        if (esVacia()) {
            System.out.println("Pila Vacia");
        } else {
            PilaAuxiliar aux = new PilaAuxiliar();
            while (!esVacia()) {
                Auxiliar x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }

    void vaciar(PilaAuxiliar z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }
}
