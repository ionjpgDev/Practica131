package Multipilas.ejercicio3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MultipliaAuxiliar multipila = new MultipliaAuxiliar();
        multipila.setNp(6);

        multipila.adicionar(0, new Auxiliar("123", "Ana Garcia", 20, 2, 2500));
        multipila.adicionar(0, new Auxiliar("124", "Carlos Lopez", 25, 3, 3000));

        multipila.adicionar(1, new Auxiliar("125", "Maria Torres", 18, 1, 2000));

        multipila.adicionar(2, new Auxiliar("126", "Pedro Sanchez", 22, 2, 2800));
        multipila.adicionar(2, new Auxiliar("127", "Laura Martinez", 30, 4, 3500));

        multipila.adicionar(3, new Auxiliar("128", "Jorge Diaz", 15, 1, 1800));

        multipila.adicionar(4, new Auxiliar("129", "Sofia Rios", 28, 3, 3200));

        multipila.adicionar(5, new Auxiliar("130", "Diego Cruz", 24, 2, 2700));
        multipila.adicionar(5, new Auxiliar("131", "Elena Vargas", 26, 3, 2900));

        System.out.println("EJERCICIO A");
        solucionA(multipila);

        System.out.println("EJERCICIO B");
        solucionB(multipila);

        System.out.println("EJERCICIO C");
        solucionC(multipila);

        System.out.println("EJERCICIO D");
        solucionD(multipila);
        multipila.mostrar();
    }

    public static void solucionA(MultipliaAuxiliar M) {
        double[] gastos = new double[M.getNp()];
        String[] carreras = {"Informatica", "Fisica", "Matematica", "Quimica", "Estadistica", "Biologia"};

        for (int i = 0; i < M.getNp(); i++) {
            PilaAuxiliar aux = new PilaAuxiliar();
            double total = 0;

            while (!M.esVacia(i)) {
                Auxiliar a = M.eliminar(i);
                total += a.getSalario();
                aux.adicionar(a);
            }

            gastos[i] = total;
            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }

        double maxGasto = 0;
        int carreraMax = 0;
        for (int i = 0; i < M.getNp(); i++) {
            if (gastos[i] > maxGasto) {
                maxGasto = gastos[i];
                carreraMax = i;
            }
            System.out.println(carreras[i] + ": " + gastos[i]);
        }
        System.out.println("Mayor inversion: " + carreras[carreraMax] + " con " + maxGasto);
    }

    public static void solucionB(MultipliaAuxiliar M) {
        int[] contadores = new int[M.getNp()];
        String[] carreras = {"Informatica", "Fisica", "Matematica", "Quimica", "Estadistica", "Biologia"};

        for (int i = 0; i < M.getNp(); i++) {
            PilaAuxiliar aux = new PilaAuxiliar();
            int cont = 0;

            while (!M.esVacia(i)) {
                cont++;
                Auxiliar a = M.eliminar(i);
                aux.adicionar(a);
            }

            contadores[i] = cont;
            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }

        int maxAux = 0;
        int carreraMax = 0;
        for (int i = 0; i < M.getNp(); i++) {
            if (contadores[i] > maxAux) {
                maxAux = contadores[i];
                carreraMax = i;
            }
            System.out.println(carreras[i] + ": " + contadores[i] + " auxiliares");
        }
        System.out.println("Mas auxiliares: " + carreras[carreraMax] + " con " + maxAux);
    }

    public static void solucionC(MultipliaAuxiliar M) {
        PilaAuxiliar aux = new PilaAuxiliar();

        while (!M.esVacia(0)) {
            Auxiliar a = M.eliminar(0);
            a.setSalario(a.getSalario() * 1.3);
            aux.adicionar(a);
        }

        while (!aux.esVacia()) {
            M.adicionar(0, aux.eliminar());
        }

        System.out.println("Salarios de Informatica incrementados 30%");
    }

    public static void solucionD(MultipliaAuxiliar M) {
        for (int i = 0; i < M.getNp(); i++) {
            List<Auxiliar> lista = new ArrayList<>();
            PilaAuxiliar aux = new PilaAuxiliar();

            while (!M.esVacia(i)) {
                lista.add(M.eliminar(i));
            }

            Collections.sort(lista, (a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));

            for (Auxiliar a : lista) {
                aux.adicionar(a);
            }

            while (!aux.esVacia()) {
                M.adicionar(i, aux.eliminar());
            }
        }
    }
}
