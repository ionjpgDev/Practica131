package Pilas.ejercicio4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PilaRio pilaRios = new PilaRio();

        pilaRios.adicionar(new Rio("Río Grande", "La Paz", 5.2, 4.0));
        pilaRios.adicionar(new Rio("Río Beni", "Rurrenabaque", 8.1, 7.0));
        pilaRios.adicionar(new Rio("Río Desaguadero", "Uyuni", 3.8, 3.5));
        pilaRios.adicionar(new Rio("Río Mamoré", "Trinidad", 6.5, 6.0));
        pilaRios.adicionar(new Rio("Río Pilcomayo", "Uyuni", 2.9, 2.5));
        pilaRios.adicionar(new Rio("Río Madre de Dios", "Rurrenabaque", 7.3, 6.8));
        pilaRios.adicionar(new Rio("Río Parapetí", "Uyuni", 1.8, 1.5));

        System.out.println("=== EJERCICIO A ===");
        solucionA(pilaRios);

        System.out.println("\n=== EJERCICIO B ===");
        boolean resultadoB = solucionB(pilaRios);
        System.out.println("¿Existe algún río que atraviesa exactamente 2 municipios? " + resultadoB);

        System.out.println("\n=== EJERCICIO C ===");
        boolean resultadoC = solucionC(pilaRios);
        System.out.println("¿El municipio 'Uyuni' tiene más de un río registrado? " + resultadoC);

        System.out.println("\n=== EJERCICIO D ===");
        solucionD(pilaRios);
    }

    public static void solucionA(PilaRio A) {
        List<String> riosDesbordados = new ArrayList<>();
        PilaRio aux = new PilaRio();

        while (!A.esVacia()) {
            Rio r = A.eliminar();
            if (r.getAlturaActual() > r.getAlturaNormal()) {
                riosDesbordados.add(r.getNombre());
            }
            aux.adicionar(r);
        }
        A.vaciar(aux);

        Collections.sort(riosDesbordados);
        System.out.println("Ríos desbordados en orden alfabético:");
        for (String rio : riosDesbordados) {
            System.out.println("- " + rio);
        }
    }

    public static boolean solucionB(PilaRio A) {
        Map<String, Integer> contadorMunicipios = new HashMap<>();
        PilaRio aux = new PilaRio();

        while (!A.esVacia()) {
            Rio r = A.eliminar();
            contadorMunicipios.put(r.getNombre(), contadorMunicipios.getOrDefault(r.getNombre(), 0) + 1);
            aux.adicionar(r);
        }
        A.vaciar(aux);

        for (int cantidad : contadorMunicipios.values()) {
            if (cantidad == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean solucionC(PilaRio A) {
        int contUyuni = 0;
        PilaRio aux = new PilaRio();

        while (!A.esVacia()) {
            Rio r = A.eliminar();
            if (r.getMunicipio().equalsIgnoreCase("Uyuni")) {
                contUyuni++;
            }
            aux.adicionar(r);
        }
        A.vaciar(aux);

        return contUyuni > 1;
    }

    public static void solucionD(PilaRio A) {
        Rio rioMenorDiferencia = null;
        double menorDiferencia = Double.MAX_VALUE;
        PilaRio aux = new PilaRio();

        while (!A.esVacia()) {
            Rio r = A.eliminar();
            double diferencia = Math.abs(r.getAlturaActual() - r.getAlturaNormal());
            if (diferencia < menorDiferencia) {
                menorDiferencia = diferencia;
                rioMenorDiferencia = r;
            }
            aux.adicionar(r);
        }
        A.vaciar(aux);

        if (rioMenorDiferencia != null) {
            System.out.println("Río con menor diferencia entre altura actual y normal:");
            System.out.println("Nombre: " + rioMenorDiferencia.getNombre());
            System.out.println("Altura Actual: " + rioMenorDiferencia.getAlturaActual());
            System.out.println("Altura Normal: " + rioMenorDiferencia.getAlturaNormal());
            System.out.println("Diferencia: " + menorDiferencia);
        }
    }
}