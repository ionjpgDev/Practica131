package Pilas.ejercicio3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PilaCaja pilaCajas = new PilaCaja();

        pilaCajas.adicionar(new Caja(25, "Rojo", "Libros"));
        pilaCajas.adicionar(new Caja(40, "Rojo", "Ropa"));
        pilaCajas.adicionar(new Caja(15, "Rojo", "Electrónicos"));
        pilaCajas.adicionar(new Caja(40, "Verde", "Juguetes"));
        pilaCajas.adicionar(new Caja(30, "Azul", "Herramientas"));
        pilaCajas.adicionar(new Caja(10, "Rojo", "Documentos"));
        pilaCajas.adicionar(new Caja(35, "Azul", "Deportes"));
        pilaCajas.adicionar(new Caja(40, "Rojo", "Muebles"));
        pilaCajas.adicionar(new Caja(20, "Verde", "Alimentos"));
        pilaCajas.adicionar(new Caja(15, "Rojo", "Medicinas"));

        System.out.println("=== EJERCICIO A ===");
        solucionA(pilaCajas);

        System.out.println("\n=== EJERCICIO B ===");
        int resultadoB = solucionB(pilaCajas);
        System.out.println("Pares de cajas con áreas iguales: " + resultadoB);

        System.out.println("\n=== EJERCICIO C ===");
        solucionC(pilaCajas);

        System.out.println("\n=== EJERCICIO D ===");
        boolean resultadoD = solucionD(pilaCajas);
        System.out.println("¿Existen 3 cajas consecutivas del mismo color? " + resultadoD);
    }

    public static void solucionA(PilaCaja A) {
        System.out.println("A)");
        int max = 0;
        PilaCaja aux = new PilaCaja();
        while (!A.esVacia()) {
            Caja a = A.eliminar();
            if (a.getArea() > max) {
                max = a.getArea();
            }
            aux.adicionar(a);
        }
        int min = max;
        while (!aux.esVacia()) {
            Caja a = aux.eliminar();
            if (a.getArea() < min) {
                min = a.getArea();
            }
            A.adicionar(a);
        }

        PilaCaja aux2 = new PilaCaja();
        while (!A.esVacia()) {
            Caja a = A.eliminar();
            if (a.getArea() == min) {
                System.out.println("El contenido de la caja con el menor tamaño es " + a.getContenido());
            }
            if (a.getArea() == max) {
                System.out.println("El contenido de la caja con el mayor tamaño es " + a.getContenido());
            }
            aux2.adicionar(a);
        }
        A.vaciar(aux2);
    }

    public static int solucionB(PilaCaja A) {

        System.out.println("B)");
        A.mostrarAreas();
        int cont = 0;
        PilaCaja aux = new PilaCaja();
        List<Integer> areas = new ArrayList<>();

        while (!A.esVacia()) {
            Caja a = A.eliminar();
            areas.add(a.getArea());
            aux.adicionar(a);
        }
        A.vaciar(aux);

        for (int i = 0; i < areas.size(); i++) {
            for (int j = i + 1; j < areas.size(); j++) {
                if (areas.get(i).equals(areas.get(j))) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void solucionC(PilaCaja A) {
        System.out.println("C)");
        List<String> noms = new ArrayList<>();
        List<Integer> cants = new ArrayList<>();
        PilaCaja aux = new PilaCaja();
        while (!A.esVacia()) {
            Caja a = A.eliminar();
            if (noms.contains(a.getColor())) {
                int ind = noms.indexOf(a.getColor());
                cants.set(ind, cants.get(ind) + 1);
            } else {
                noms.add(a.getColor());
                cants.add(1);
            }
            aux.adicionar(a);
        }
        A.vaciar(aux);
        int max = 0;
        for (int i = 0; i < noms.size(); i++) {
            if (cants.get(i) > max) {
                max = cants.get(i);
            }
            System.out.println(noms.get(i) + ": " + cants.get(i));
        }
        for (int i = 0; i < noms.size(); i++) {
            if (cants.get(i) == max) {
                System.out.println("El con mayor cantidad es el " + noms.get(i)+": "+cants.get(i));
            }
        }
    }

    public static boolean solucionD(PilaCaja A) {
        System.out.println("D)");
        PilaCaja aux = new PilaCaja();
        boolean flag = false;
        int cont = 1;
        String actual = "", anterior = "";
        while (!A.esVacia()) {
            Caja a = A.eliminar();
            aux.adicionar(a);
            actual = a.getColor();
            if (anterior == "") {
                anterior = actual;
            } else if (actual.equals(anterior)) {
                cont++;
                if (cont == 3) {
                    flag = true;
                }
            } else {
                cont = 1;
                anterior = actual;
            }

        }
        A.vaciar(aux);
        A.mostrarColor();
        return flag;
    }
}
