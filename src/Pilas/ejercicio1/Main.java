package Pilas.ejercicio1;

import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


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
            if (a == x) {
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
        PilaC aux=new PilaC();
        while (!A.esVacia()) {
            String a = A.eliminar();
            aux.adicionar(a);
            actual = esVocal(a);
            if (flag) {
                if (anterior == null) anterior = actual;
                else if (anterior==actual) {
                    flag=false;
                }
            }
        }
        A.vaciar(aux);
        return flag;
    }
    public static void solucionD(PilaC A){
        String cad="";
        System.out.println("Antes");
        A.mostrar();
        PilaC aux=new PilaC();
        PilaC aux1=new PilaC();
        aux.vaciar(A);
        aux1.vaciar(aux);
        A.vaciar(aux1);
        System.out.println("Despues");
        A.mostrar();
    }
}