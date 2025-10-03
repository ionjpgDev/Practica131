package Pilas.ejercicio3;
public class PilaCaja {
    private int max = 50;
    private Caja v[] = new Caja[max + 1];
    private int tope;

    PilaCaja() {
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

    void adicionar(Caja e) {
        if (esLlena()) {
            System.out.println("Pila llena");
        } else {
            tope++;
            v[tope] = e;
        }
    }

    Caja eliminar() {
        Caja e = null;
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
            PilaCaja aux = new PilaCaja();
            while (!esVacia()) {
                Caja x = eliminar();
                System.out.println(x);
                aux.adicionar(x);
            }
            vaciar(aux);
        }

    }
    void mostrarColor() {

        if (esVacia()) {
            System.out.println("Pila Vacia");
        } else {
            int i=1;
            PilaCaja aux = new PilaCaja();
            while (!esVacia()) {
                Caja x = eliminar();
                System.out.println("Caja "+i+": "+x.getColor());
                aux.adicionar(x);
                i++;
            }
            vaciar(aux);
        }

    }
    void mostrarAreas() {

        if (esVacia()) {
            System.out.println("Pila Vacia");
        } else {
            int i=1;
            PilaCaja aux = new PilaCaja();
            while (!esVacia()) {
                Caja x = eliminar();
                System.out.println("Caja "+i+": "+x.getArea());
                aux.adicionar(x);
                i++;
            }
            vaciar(aux);
        }

    }

    void vaciar(PilaCaja z) {
        while (!z.esVacia()) {
            adicionar(z.eliminar());
        }
    }

}
