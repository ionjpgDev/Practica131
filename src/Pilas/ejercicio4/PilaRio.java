package Pilas.ejercicio4;

import Pilas.ejercicio3.Caja;
import Pilas.ejercicio3.PilaCaja;

public class PilaRio {
    private int max = 50;
    private Rio v[] = new Rio[max + 1];
    private int tope;

    PilaRio() {
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

    void adicionar(Rio e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    Rio eliminar() {
        Rio e = null;
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
            PilaRio aux = new PilaRio();
            while (!esVacia()) {
                Rio x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }


    void vaciar(PilaRio z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }
}
