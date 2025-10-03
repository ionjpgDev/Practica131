package Pilas.ejercicio5;


public class PilaComida {

    private int max = 50;
    private Comida v[] = new Comida[max + 1];
    private int tope;

    PilaComida() {
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

    void adicionar(Comida e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    Comida eliminar() {
        Comida e = null;
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
            PilaComida aux = new PilaComida();
            while (!esVacia()) {
                Comida x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }


    void vaciar(PilaComida z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }
}
