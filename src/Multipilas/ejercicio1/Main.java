package Multipilas.ejercicio1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MultipilaC multipila = new MultipilaC();
        multipila.setNp(5);

        multipila.adicionar(0, "R");
        multipila.adicionar(0, "A");
        multipila.adicionar(0, "T");

        multipila.adicionar(1, "L");
        multipila.adicionar(1, "O");

        multipila.adicionar(2, "A");
        multipila.adicionar(2, "M");
        multipila.adicionar(2, "O");

        multipila.adicionar(3, "A");
        multipila.adicionar(3, "N");
        multipila.adicionar(3, "A");

        multipila.adicionar(4, "S");
        multipila.adicionar(4, "O");
        multipila.adicionar(4, "N");

        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO A");
        System.out.print("Palabra X: ");
        String palabraX = sc.nextLine();
        System.out.print("Palabra Y: ");
        String palabraY = sc.nextLine();
        solucionA(multipila, palabraX, palabraY);

        System.out.println("EJERCICIO B");
        boolean resultadoB = solucionB(multipila);
        System.out.println("Palindromo: " + resultadoB);

        System.out.println("EJERCICIO C");
        int resultadoC = solucionC(multipila);
        System.out.println("Pilas con S sin O: " + resultadoC);

        System.out.println("EJERCICIO D");
        solucionD(multipila);
        multipila.mostrar();
    }

    public static void solucionA(MultipilaC M, String X, String Y) {
        for (int i = 0; i < M.getNp(); i++) {
            PilaC aux = new PilaC();
            String palabra = "";

            while (!M.esVacia(i)) {
                String letra = M.eliminar(i);
                palabra = letra + palabra;
                aux.adicionar(letra);
            }

            if (palabra.equals(X)) {
                while (!aux.esVacia()) aux.eliminar();
                for (char c : Y.toCharArray()) {
                    aux.adicionar(String.valueOf(c));
                }
            }

            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }
    }

    public static boolean solucionB(MultipilaC M) {
        for (int i = 0; i < M.getNp(); i++) {
            PilaC aux = new PilaC();
            String palabra = "";

            while (!M.esVacia(i)) {
                String letra = M.eliminar(i);
                palabra = letra + palabra;
                aux.adicionar(letra);
            }

            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }

            if (esPalindromo(palabra)) return true;
        }
        return false;
    }

    public static int solucionC(MultipilaC M) {
        int cont = 0;
        for (int i = 0; i < M.getNp(); i++) {
            List<String> letras = new ArrayList<>();
            while (!M.esVacia(i)) {
                letras.add(M.eliminar(i));
            }

            boolean tieneS = false;
            boolean cumple = true;

            for (int j = 0; j < letras.size(); j++) {
                if (letras.get(j).equals("S")) {
                    tieneS = true;
                    if (j > 0 && letras.get(j-1).equals("O")) cumple = false;
                    if (j < letras.size()-1 && letras.get(j+1).equals("O")) cumple = false;
                }
            }

            if (tieneS && cumple) cont++;

            for (int j = letras.size()-1; j >= 0; j--) {
                M.adicionar(i, letras.get(j));
            }
        }
        return cont;
    }

    public static void solucionD(MultipilaC M) {
        for (int i = 0; i < M.getNp(); i++) {
            List<String> letras = new ArrayList<>();
            while (!M.esVacia(i)) {
                letras.add(M.eliminar(i));
            }
            Collections.sort(letras);
            for (String letra : letras) {
                M.adicionar(i, letra);
            }
        }
    }

    public static boolean esPalindromo(String palabra) {
        int ini = 0, fin = palabra.length() - 1;
        while (ini < fin) {
            if (palabra.charAt(ini) != palabra.charAt(fin)) return false;
            ini++;
            fin--;
        }
        return true;
    }
}
