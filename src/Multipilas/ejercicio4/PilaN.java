package Multipilas.ejercicio4;

public class PilaN {
    private int max = 50;
    private int v[] = new int[max + 1];
    private int tope;

    PilaN() {
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

    void adicionar(int e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    int eliminar() {
        Integer e = null;
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
            PilaN aux = new PilaN();
            while (!esVacia()) {
                int x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }

    void vaciar(PilaN z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }
}
