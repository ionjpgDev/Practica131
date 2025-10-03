package Multipilas.ejercicio5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PilaFacultades facultades = new PilaFacultades();
        MultipilaLibro libros = new MultipilaLibro();

        facultades.adicionar("Ingenieria");
        facultades.adicionar("Medicina");
        facultades.adicionar("Derecho");
        facultades.adicionar("Economia");
        facultades.adicionar("Arquitectura");
        facultades.adicionar("Ciencias Sociales");

        libros.setNp(6);

        libros.adicionar(0, new Libro("101", "Calculo I", "Autor1", 300));
        libros.adicionar(0, new Libro("102", "Fisica I", "Autor2", 250));
        libros.adicionar(0, new Libro("103", "Programacion", "Autor3", 400));

        libros.adicionar(1, new Libro("201", "Anatomia", "Autor4", 500));
        libros.adicionar(1, new Libro("202", "Fisiologia", "Autor5", 450));

        libros.adicionar(2, new Libro("301", "Derecho Civil", "Autor6", 350));
        libros.adicionar(2, new Libro("302", "Derecho Penal", "Autor7", 320));

        libros.adicionar(3, new Libro("401", "Microeconomia", "Autor8", 280));

        libros.adicionar(4, new Libro("501", "Dibujo Tecnico", "Autor9", 200));
        libros.adicionar(4, new Libro("502", "Estructuras", "Autor10", 380));

        libros.adicionar(5, new Libro("601", "Sociologia", "Autor11", 310));

        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO A");
        System.out.print("Facultad X: ");
        String facultadX = sc.nextLine();
        solucionA(facultades, libros, facultadX);

        System.out.println("EJERCICIO B");
        System.out.print("Facultad X: ");
        String facultadY = sc.nextLine();
        solucionB(facultades, libros, facultadY);

        System.out.println("EJERCICIO C");
        solucionC(facultades, libros);

        System.out.println("EJERCICIO D");
        solucionD(facultades, libros);
        System.out.println("Facultades ordenadas:");
        facultades.mostrar();
    }

    public static void solucionA(PilaFacultades F, MultipilaLibro L, String X) {
        int indice = buscarFacultad(F, X);
        if (indice == -1) {
            System.out.println("Facultad no encontrada");
            return;
        }

        int maxPaginas = 0;
        List<Libro> librosExtensos = new ArrayList<>();
        PilaLibros aux = new PilaLibros();

        while (!L.esVacia(indice)) {
            Libro libro = L.eliminar(indice);
            if (libro.getNumPaginas() > maxPaginas) {
                maxPaginas = libro.getNumPaginas();
                librosExtensos.clear();
                librosExtensos.add(libro);
            } else if (libro.getNumPaginas() == maxPaginas) {
                librosExtensos.add(libro);
            }
            aux.adicionar(libro);
        }

        while (!aux.esVacia()) {
            L.adicionar(indice, aux.eliminar());
        }

        System.out.println("Libros mas extensos de " + X + ":");
        for (Libro libro : librosExtensos) {
            System.out.println(libro.getTitulo() + " - " + libro.getNumPaginas() + " paginas");
        }
    }

    public static void solucionB(PilaFacultades F, MultipilaLibro L, String X) {
        int indice = buscarFacultad(F, X);
        if (indice == -1) {
            System.out.println("Facultad no encontrada");
            return;
        }

        List<Libro> listaLibros = new ArrayList<>();
        PilaLibros aux = new PilaLibros();

        while (!L.esVacia(indice)) {
            Libro libro = L.eliminar(indice);
            listaLibros.add(libro);
            aux.adicionar(libro);
        }

        Collections.sort(listaLibros, (l1, l2) -> {
            if (l1.getNumPaginas() != l2.getNumPaginas()) {
                return l1.getNumPaginas() - l2.getNumPaginas();
            }
            return l1.getTitulo().compareTo(l2.getTitulo());
        });

        for (Libro libro : listaLibros) {
            L.adicionar(indice, libro);
        }

        System.out.println("Libros de " + X + " ordenados:");
        L.mostrar(indice);
    }

    public static void solucionC(PilaFacultades F, MultipilaLibro L) {
        int indiceMedicina = buscarFacultad(F, "Medicina");
        int indiceIngenieria = buscarFacultad(F, "Ingenieria");

        if (indiceMedicina == -1 || indiceIngenieria == -1) {
            System.out.println("No se encontraron las facultades");
            return;
        }

        if (!L.esVacia(indiceMedicina)) {
            Libro primerLibro = L.eliminar(indiceMedicina);
            L.adicionar(indiceIngenieria, primerLibro);
            System.out.println("Libro movido: " + primerLibro.getTitulo());
        }
    }

    public static void solucionD(PilaFacultades F, MultipilaLibro L) {
        List<String> listaFacultades = new ArrayList<>();
        PilaFacultades auxF = new PilaFacultades();
        List<List<Libro>> listasLibros = new ArrayList<>();

        for (int i = 0; i < L.getNp(); i++) {
            listasLibros.add(new ArrayList<>());
        }

        while (!F.esVacia()) {
            String facultad = F.eliminar();
            listaFacultades.add(facultad);
            auxF.adicionar(facultad);
        }

        for (int i = 0; i < L.getNp(); i++) {
            while (!L.esVacia(i)) {
                listasLibros.get(i).add(L.eliminar(i));
            }
        }

        Collections.sort(listaFacultades);

        for (String facultad : listaFacultades) {
            F.adicionar(facultad);
        }

        for (int i = 0; i < listaFacultades.size(); i++) {
            for (Libro libro : listasLibros.get(i)) {
                L.adicionar(i, libro);
            }
        }
    }

    private static int buscarFacultad(PilaFacultades F, String nombre) {
        PilaFacultades aux = new PilaFacultades();
        int indice = 0;
        boolean encontrado = false;

        while (!F.esVacia()) {
            String facultad = F.eliminar();
            if (facultad.equalsIgnoreCase(nombre)) {
                encontrado = true;
            }
            aux.adicionar(facultad);
            if (!encontrado) indice++;
        }

        while (!aux.esVacia()) {
            F.adicionar(aux.eliminar());
        }

        return encontrado ? indice : -1;
    }
}