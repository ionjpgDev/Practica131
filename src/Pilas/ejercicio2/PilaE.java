package Pilas.ejercicio2;

public class PilaE {

    
        private int max = 50;
        private Examen v[] = new Examen[max + 1];
        private int tope;

        PilaE() {
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

        void adicionar(Examen e) {
            if (esLlena()) {
                System.out.println("Pila llena");
            } else {
                tope++;
                v[tope] = e;
            }
        }

        Examen eliminar() {
            Examen e = null;
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
                PilaE aux = new PilaE();
                while (!esVacia()) {
                    Examen x = eliminar();
                    System.out.println(x);
                    aux.adicionar(x);
                }
                vaciar(aux);
            }

        }

        void vaciar(PilaE z) {
            while (!z.esVacia()) {
                adicionar(z.eliminar());
            }
        }

    

}
