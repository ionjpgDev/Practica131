package Pilas.ejercicio5;
import  java.util.*;
public class Main {
    public static void main(String[] args) {
        PilaComida pardo = new PilaComida();
        PilaComida panda = new PilaComida();
        PilaComida polar = new PilaComida();

        // Alimentos de Pardo
        pardo.adicionar(new Comida("Bayas", 5));
        pardo.adicionar(new Comida("Pescado", 8));
        pardo.adicionar(new Comida("Miel", 3));
        pardo.adicionar(new Comida("Bayas", 4));

        // Alimentos de Panda
        panda.adicionar(new Comida("Bambú", 12));
        panda.adicionar(new Comida("Bayas", 6));
        panda.adicionar(new Comida("Manzanas", 4));
        panda.adicionar(new Comida("Bambú", 8));

        // Alimentos de Polar
        polar.adicionar(new Comida("Pescado", 10));
        polar.adicionar(new Comida("Focas", 15));
        polar.adicionar(new Comida("Bayas", 2));
        polar.adicionar(new Comida("Pescado", 7));

        System.out.println("=== EJERCICIO A ===");
        solucionA(pardo, panda, polar);

        System.out.println("\n=== EJERCICIO B ===");
        solucionB(pardo, panda, polar);

        System.out.println("\n=== EJERCICIO C ===");
        boolean resultadoC = solucionC(pardo, panda, polar);
        System.out.println("¿Los tres osos recolectaron exactamente los mismos tipos de alimentos? " + resultadoC);

        System.out.println("\n=== EJERCICIO D ===");
        System.out.println("Pila de Pardo antes de invertir:");
        pardo.mostrar();
        solucionD(pardo);
        System.out.println("Pila de Pardo después de invertir:");
        pardo.mostrar();
    }

    public static void solucionA(PilaComida pardo, PilaComida panda, PilaComida polar) {
        Map<String, Integer> contadorAlimentos = new HashMap<>();

        contarAlimentosPila(pardo, contadorAlimentos);
        contarAlimentosPila(panda, contadorAlimentos);
        contarAlimentosPila(polar, contadorAlimentos);

        String alimentoMasComun = "";
        int maxCantidad = 0;

        for (Map.Entry<String, Integer> entry : contadorAlimentos.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                maxCantidad = entry.getValue();
                alimentoMasComun = entry.getKey();
            }
        }

        System.out.println("Alimento más común: " + alimentoMasComun + " (aparece " + maxCantidad + " veces)");
    }

    public static void solucionB(PilaComida pardo, PilaComida panda, PilaComida polar) {
        double totalPardo = calcularTotalKilos(pardo);
        double totalPanda = calcularTotalKilos(panda);
        double totalPolar = calcularTotalKilos(polar);

        double promedio = (totalPardo + totalPanda + totalPolar) / 3;

        System.out.println("Promedio de kilos por pila: " + promedio);
        System.out.println("Osos por encima del promedio:");

        if (totalPardo > promedio) System.out.println("- Pardo: " + totalPardo + " kg");
        if (totalPanda > promedio) System.out.println("- Panda: " + totalPanda + " kg");
        if (totalPolar > promedio) System.out.println("- Polar: " + totalPolar + " kg");
    }

    public static boolean solucionC(PilaComida pardo, PilaComida panda, PilaComida polar) {
        Set<String> alimentosPardo = obtenerTiposAlimentos(pardo);
        Set<String> alimentosPanda = obtenerTiposAlimentos(panda);
        Set<String> alimentosPolar = obtenerTiposAlimentos(polar);

        return alimentosPardo.equals(alimentosPanda) && alimentosPanda.equals(alimentosPolar);
    }

    public static void solucionD(PilaComida oso) {
        PilaComida aux1 = new PilaComida();
        PilaComida aux2 = new PilaComida();

        while (!oso.esVacia()) {
            aux1.adicionar(oso.eliminar());
        }

        while (!aux1.esVacia()) {
            aux2.adicionar(aux1.eliminar());
        }

        while (!aux2.esVacia()) {
            oso.adicionar(aux2.eliminar());
        }
    }

    // Métodos auxiliares
    private static void contarAlimentosPila(PilaComida pila, Map<String, Integer> contador) {
        PilaComida aux = new PilaComida();

        while (!pila.esVacia()) {
            Comida comida = pila.eliminar();
            contador.put(comida.getNomComida(), contador.getOrDefault(comida.getNomComida(), 0) + 1);
            aux.adicionar(comida);
        }

        pila.vaciar(aux);
    }

    private static double calcularTotalKilos(PilaComida pila) {
        double total = 0;
        PilaComida aux = new PilaComida();

        while (!pila.esVacia()) {
            Comida comida = pila.eliminar();
            total += comida.getCantidad();
            aux.adicionar(comida);
        }

        pila.vaciar(aux);
        return total;
    }

    private static Set<String> obtenerTiposAlimentos(PilaComida pila) {
        Set<String> tipos = new HashSet<>();
        PilaComida aux = new PilaComida();

        while (!pila.esVacia()) {
            Comida comida = pila.eliminar();
            tipos.add(comida.getNomComida());
            aux.adicionar(comida);
        }

        pila.vaciar(aux);
        return tipos;
    }

}