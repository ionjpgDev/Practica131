package Multipilas.ejercicio2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MultipilaLibro multipila = new MultipilaLibro();
        multipila.setNp(4);

        multipila.adicionar(0, new Libro("Cien Anios", "Gabriel Garcia", 1, 5));
        multipila.adicionar(0, new Libro("Rayuela", "Julio Cortazar", 2, 0));
        multipila.adicionar(0, new Libro("Ficciones", "Jorge Luis Borges", 3, 3));

        multipila.adicionar(1, new Libro("1984", "George Orwell", 4, 0));
        multipila.adicionar(1, new Libro("Rebelion", "George Orwell", 5, 2));

        multipila.adicionar(2, new Libro("Don Quijote", "Miguel Cervantes", 6, 1));
        multipila.adicionar(2, new Libro("La Galatea", "Miguel Cervantes", 7, 0));

        multipila.adicionar(3, new Libro("Crimen", "Fiodor Dostoievski", 8, 4));
        multipila.adicionar(3, new Libro("Los Hermanos", "Fiodor Dostoievski", 9, 0));

        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO A");
        solucionA(multipila);
        multipila.mostrar();

        System.out.println("EJERCICIO B");
        System.out.print("Autor X: ");
        String autorX = sc.nextLine();
        solucionB(multipila, autorX);

        System.out.println("EJERCICIO C");
        System.out.print("Titulo X: ");
        String tituloX = sc.nextLine();
        System.out.print("Autor Y: ");
        String autorY = sc.nextLine();
        solucionC(multipila, tituloX, autorY);
    }

    public static void solucionA(MultipilaLibro M) {
        for (int i = 0; i < M.getNp(); i++) {
            PilaLibro aux = new PilaLibro();
            while (!M.esVacia(i)) {
                Libro libro = M.eliminar(i);
                if (libro.getstock() > 0) {
                    aux.adicionar(libro);
                }
            }
            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }
    }

    public static void solucionB(MultipilaLibro M, String autorX) {
        for (int i = 0; i < M.getNp(); i++) {
            boolean tieneAutor = false;
            PilaLibro aux = new PilaLibro();
            List<Libro> librosPila = new ArrayList<>();

            while (!M.esVacia(i)) {
                Libro libro = M.eliminar(i);
                if (libro.getAutor().equals(autorX)) {
                    tieneAutor = true;
                }
                librosPila.add(libro);
                aux.adicionar(libro);
            }

            if (tieneAutor) {
                System.out.println("Pila " + (i + 1) + ":");
                for (Libro libro : librosPila) {
                    System.out.println(libro.getTitulo() + " - " + libro.getAutor());
                }
            }

            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }
    }

    public static void solucionC(MultipilaLibro M, String tituloX, String autorY) {
        for (int i = 0; i < M.getNp(); i++) {
            PilaLibro aux = new PilaLibro();
            boolean encontrado = false;

            while (!M.esVacia(i)) {
                Libro libro = M.eliminar(i);
                if (libro.getTitulo().equals(tituloX) && libro.getAutor().equals(autorY)) {
                    System.out.println("Libro encontrado en pila: " + (i + 1));
                    encontrado = true;
                }
                aux.adicionar(libro);
            }

            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }

            if (encontrado) return;
        }
        System.out.println("Libro no encontrado");
    }
}
