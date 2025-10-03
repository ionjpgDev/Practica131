package Pilas.ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PilaE pilaExamenes = new PilaE();

        pilaExamenes.adicionar(new Examen(1, 85, "Oso Pardo", "Español"));
        pilaExamenes.adicionar(new Examen(2, 92, "Oso Panda", "Inglés"));
        pilaExamenes.adicionar(new Examen(3, 78, "Oso Polar", "Francés"));
        pilaExamenes.adicionar(new Examen(4, 45, "Oso Pardo", "Alemán"));
        pilaExamenes.adicionar(new Examen(5, 35, "Oso Panda", "Inglés"));
        pilaExamenes.adicionar(new Examen(6, 88, "Oso Polar", "Español"));
        pilaExamenes.adicionar(new Examen(7, 92, "Oso Pardo", "Inglés"));
        pilaExamenes.adicionar(new Examen(8, 30, "Oso Grizzly", "Francés"));

        solucionA(pilaExamenes);

        solucionB(pilaExamenes);

        boolean resultadoC = solucionC(pilaExamenes);
        System.out.println("algun oso tiene misma nota en examenes diferentes? " + resultadoC);

        solucionD(pilaExamenes);
    }
    //A)
    public static void solucionA(PilaE A) {
        System.out.println("A)");
        PilaE aux = new PilaE();
        int max = 0, min = 100;

        while (!A.esVacia()) {
            Examen a = A.eliminar();
            if (a.getNotaObt() > max) max = a.getNotaObt();
            if (a.getNotaObt() < min) min = a.getNotaObt();
            aux.adicionar(a);
        }
        while (!aux.esVacia()) {
            Examen a = aux.eliminar();
            if (a.getNotaObt() == max) System.out.println("La mayor nota obtenida es " + a);
            if (a.getNotaObt() == min) System.out.println("La menor nota obtenida es " + a);
            A.adicionar(a);
        }


    }

    //B)
    public static void solucionB(PilaE A) {

        Map<String, Integer> contId = new HashMap<>();
        PilaE aux = new PilaE();
        while (!A.esVacia()) {
            Examen a = A.eliminar();
            contId.put(a.getIdiomaEva(), contId.getOrDefault(a.getIdiomaEva(), 0) + 1);
            aux.adicionar(a);
        }
        A.vaciar(aux);
        int max = 0;
        for (int nota : contId.values()) {
            if (nota > max) max = nota;
        }
        System.out.println("los idiomas tiene las siguites cantidades de examenes");
        for (Map.Entry<String, Integer> par : contId.entrySet()) {
            System.out.println("\t\"" + par.getKey() + ": " + par.getValue());

        }
        System.out.println("El idioma con la mayor cantidad de examenes es es/son");
        for (Map.Entry<String, Integer> par : contId.entrySet()) {
            if (par.getValue() == max) {
                System.out.println("\t\"" + par.getKey() + ": " + par.getValue());
            }
        }

    }
    //C)
    public static boolean solucionC(PilaE A) {
        System.out.println("C)");

        boolean flag = false;
        PilaE aux = new PilaE();
        PilaE aux1 = new PilaE();
        while (!A.esVacia()) {
            Examen a = A.eliminar();
            while (!A.esVacia()) {
                Examen b = A.eliminar();
                if (a.getNotaObt() == b.getNotaObt() && a.getNombreOso() == b.getNombreOso() && a.getIdiomaEva() != b.getIdiomaEva()) {
                    flag = true;
                }
                aux.adicionar(b);
            }
            A.vaciar(aux);
            aux1.adicionar(a);
        }
        A.vaciar(aux1);
        return flag;
    }
    //D)

    public static void solucionD(PilaE A) {
        System.out.println("D)");

        PilaE aux=new PilaE();
        while(!A.esVacia()){
            Examen a=A.eliminar();
            if (a.getNotaObt()>=40){
                aux.adicionar(a);
            }
        }
        A.vaciar(aux);
        System.out.println("Pila de examenes sin ntoas menores a 40");
        A.mostrar();
    }


}







