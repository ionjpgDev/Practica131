package Multipilas.ejercicio5;

public class PilaFacultades {
    private int max = 50;
    private String[] v = new String[max + 1];
    private int tope;

    public PilaFacultades() { tope = 0; }
    public boolean esVacia() { return tope == 0; }
    public boolean esLlena() { return tope == max; }

    public void adicionar(String elem) {
        if (!esLlena()) {
            tope++;
            v[tope] = elem;
        }
    }

    public String eliminar() {
        String elem = null;
        if (!esVacia()) {
            elem = v[tope];
            tope--;
        }
        return elem;
    }

    public void mostrar() {
        PilaFacultades aux = new PilaFacultades();
        while (!esVacia()) {
            String elem = eliminar();
            System.out.println(elem);
            aux.adicionar(elem);
        }
        while (!aux.esVacia()) {
            adicionar(aux.eliminar());
        }
    }
}