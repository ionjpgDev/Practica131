package Pilas.ejercicio1;

import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // A)
        System.out.println("A)");
        PilaC pilaA1 = new PilaC();
        pilaA1.adicionar("A");
        pilaA1.adicionar("B");
        pilaA1.adicionar("B");
        pilaA1.adicionar("A");

        PilaC pilaA2 = new PilaC();
        pilaA2.adicionar("X");
        pilaA2.adicionar("Y");
        pilaA2.adicionar("X");

        solucionA(pilaA1, pilaA2);

        // B)
        System.out.println("B)");
        PilaC pilaB = new PilaC();
        pilaB.adicionar("A");
        pilaB.adicionar("B");
        pilaB.adicionar("A");
        pilaB.adicionar("C");
        pilaB.adicionar("A");

        String buscar = "A";
        int resultadoB = solucionB(pilaB, buscar);
        System.out.println("La letra '" + buscar + "' aparece " + resultadoB + " veces");

        // C)
        System.out.println("C)");
        PilaC pilaC1 = new PilaC();
        pilaC1.adicionar("A");
        pilaC1.adicionar("B");
        pilaC1.adicionar("E");
        pilaC1.adicionar("C");

        boolean resultadoC1 = solucionC(pilaC1);
        System.out.println("Es intercalado? " + resultadoC1);

        PilaC pilaC2 = new PilaC();
        pilaC2.adicionar("A");
        pilaC2.adicionar("E");
        pilaC2.adicionar("B");

        boolean resultadoC2 = solucionC(pilaC2);
        System.out.println("es intercalado? " + resultadoC2);

        // D)
        System.out.println("D)");
        PilaC pilaD = new PilaC();
        pilaD.adicionar("1");
        pilaD.adicionar("2");
        pilaD.adicionar("3");
        pilaD.adicionar("4");

        solucionD(pilaD);
    }

    public static void solucionA(PilaC A, PilaC B) {
        PilaC aux = new PilaC();
        String cadA = "", cadB = "";
        while (!A.esVacia()) {
            String a = A.eliminar();
            cadA += a;
            aux.adicionar(a);
        }
        A.vaciar(aux);
        while (!B.esVacia()) {
            String a = B.eliminar();
            cadB += a;
            aux.adicionar(a);
        }
        B.vaciar(aux);
        if (esPalindromo(cadA) && esPalindromo(cadB)) {
            System.out.println("El palindromo mas grande es " + (cadA.length() > cadB.length() ? cadA : cadB));
        } else if (esPalindromo(cadA)) {
            System.out.println("El unico palindromo es " + cadA);
        } else if (esPalindromo(cadB)) {
            System.out.println("El unico palindromo es " + cadB);
        } else {
            System.out.println("Ninguno es palindromo");
        }
    }

    public static boolean esPalindromo(String x) {
        boolean flag = true;
        int ini = 0, fin = x.length() - 1;
        while (ini < fin) {
            if (x.charAt(ini) != x.charAt(fin)) {
                flag = false;
            }
            ini++;
            fin--;
        }
        return flag;
    }

    public static int solucionB(PilaC A, String x) {
        PilaC aux = new PilaC();
        int cont = 0;
        while (!A.esVacia()) {
            String a = A.eliminar();
            if (a.equals(x)) {
                cont++;
            }
            aux.adicionar(a);
        }
        A.vaciar(aux);
        return cont;
    }

    public static boolean esVocal(String x) {
        String vo = "AEIOU";
        return vo.contains(x.toUpperCase());
    }

    public static boolean solucionC(PilaC A) {
        boolean flag = true;
        Boolean anterior = null;
        Boolean actual = null;
        PilaC aux = new PilaC();
        while (!A.esVacia()) {
            String a = A.eliminar();
            aux.adicionar(a);
            actual = esVocal(a);
            if (anterior == null) {
                anterior = actual;
            } else {
                if (anterior == actual) {
                    flag = false;
                }
                anterior = actual;
            }
        }
        A.vaciar(aux);
        return flag;
    }

    public static void solucionD(PilaC A){
        String cad = "";
        System.out.println("Antes");
        A.mostrar();
        PilaC aux = new PilaC();
        PilaC aux1 = new PilaC();
        aux.vaciar(A);
        aux1.vaciar(aux);
        A.vaciar(aux1);
        System.out.println("Despues");
        A.mostrar();
    }
}