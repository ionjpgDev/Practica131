package Multipilas.ejercicio2;

public class PilaLibro {
    private int max = 50;
    private Libro v[] = new Libro[max + 1];
    private int tope;

    PilaLibro() {
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

    void adicionar(Libro e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    Libro eliminar() {
        Libro e = null;
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
            PilaLibro aux = new PilaLibro();
            while (!esVacia()) {
                Libro x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }

    void vaciar(PilaLibro z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }
}
