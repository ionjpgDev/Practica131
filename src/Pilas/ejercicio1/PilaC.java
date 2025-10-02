package Pilas.ejercicio1;

public class PilaC {
    private int max = 50;
    private String v[] = new String[max + 1];
    private int tope;

    PilaC() {
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

    void adicionar(String e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    String eliminar() {
        String e = null;
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
            PilaC aux = new PilaC();
            while (!esVacia()) {
                String x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }

    void vaciar(PilaC z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }

}
