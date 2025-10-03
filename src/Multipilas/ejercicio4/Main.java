package Multipilas.ejercicio4;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        MultipilaN multipila = new MultipilaN();
        multipila.setNp(4);

        multipila.adicionar(0, 1);
        multipila.adicionar(0, 2);
        multipila.adicionar(0, 9);

        multipila.adicionar(1, 3);
        multipila.adicionar(1, 7);

        multipila.adicionar(2, 5);
        multipila.adicionar(2, 8);

        multipila.adicionar(3, 4);
        multipila.adicionar(3, 6);

        System.out.println("EJERCICIO A");
        PilaN resultado = solucionA(multipila);
        System.out.print("Pila RESULTADO: ");
        resultado.mostrar();

        System.out.println("EJERCICIO B");
        solucionB(multipila);
    }

    public static PilaN solucionA(MultipilaN M) {
        PilaN resultado = new PilaN();

        while (!M.esVacia(0) && !M.esVacia(1) && !M.esVacia(2) && !M.esVacia(3)) {
            int A = M.eliminar(0);
            int B = M.eliminar(1);
            int C = M.eliminar(2);
            int D = M.eliminar(3);

            int operacion = (A + B) * (C + D);
            resultado.adicionar(operacion);
        }

        return resultado;
    }

    public static void solucionB(MultipilaN M) {
        int[] sumas = new int[M.getNp()];

        for (int i = 0; i < M.getNp(); i++) {
            PilaN aux = new PilaN();
            int suma = 0;

            while (!M.esVacia(i)) {
                int num = M.eliminar(i);
                suma += num;
                aux.adicionar(num);
            }

            sumas[i] = suma;
            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }

        int maxSuma = 0;
        int pilaGanadora = 0;
        for (int i = 0; i < M.getNp(); i++) {
            if (sumas[i] > maxSuma) {
                maxSuma = sumas[i];
                pilaGanadora = i;
            }
            System.out.println("Pila " + (i + 1) + ": " + sumas[i]);
        }

        System.out.println("Pila ganadora: " + (pilaGanadora + 1) + " con suma: " + maxSuma);

        PilaN pares = new PilaN();
        PilaN aux = new PilaN();

        while (!M.esVacia(pilaGanadora)) {
            int num = M.eliminar(pilaGanadora);
            if (num % 2 == 0) {
                pares.adicionar(num);
            }
            aux.adicionar(num);
        }

        while (!aux.esVacia()) {
            M.adicionar(pilaGanadora, aux.eliminar());
        }

        System.out.print("Pila de pares: ");
        pares.mostrar();
    }
}

