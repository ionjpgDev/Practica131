package Multipilas.ejercicio5;

public class PilaLibros {
    private int max = 50;
    private Libro[] v = new Libro[max + 1];
    private int tope;

    public PilaLibros() { tope = 0; }
    public boolean esVacia() { return tope == 0; }
    public boolean esLlena() { return tope == max; }

    public void adicionar(Libro elem) {
        if (!esLlena()) {
            tope++;
            v[tope] = elem;
        }
    }

    public Libro eliminar() {
        Libro elem = null;
        if (!esVacia()) {
            elem = v[tope];
            tope--;
        }
        return elem;
    }

    public void mostrar() {
        PilaLibros aux = new PilaLibros();
        while (!esVacia()) {
            Libro elem = eliminar();
            System.out.println(elem.getTitulo() + " - " + elem.getNumPaginas() + " paginas");
            aux.adicionar(elem);
        }
        while (!aux.esVacia()) {
            adicionar(aux.eliminar());
        }
    }
}