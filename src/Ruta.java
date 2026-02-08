import Listas.ListaDoble;
import Listas.NodoDoble;

import java.util.Scanner;

public class Ruta { //Quedan casos por validar
    Scanner sc = new Scanner(System.in);
    protected ListaDoble rutas;
    public Ruta(){
        rutas = new ListaDoble();
        rutas.insertaInicio("Puerto Progreso (Inicio)");
    }
    public void agregarParadaFinal () {
        System.out.print("Ingrese el nombre de la parada: ");
        String parada = sc.nextLine();
        rutas.insertaFinal(parada);
    }
    public void agregarEntreParadas () {
        System.out.print("Ingrese el nombre de la nueva parada: ");
        String nuevaParada = sc.nextLine();
        System.out.println("Identifique entre que destinos se integrará la nueva parada. (No importa el orden de los destinos)");
        System.out.print("Destino 1: ");
        String parada1 = sc.nextLine();
        System.out.print("Destino 2: ");
        String parada2 = sc.nextLine();
        rutas.insertaEntreNodos(parada1, parada2, nuevaParada);
    }
    public void eliminarParada () {
        System.out.println("Ingrese el nombre de la parada a cancelar: ");
        String paradaEliminada = sc.nextLine();
        if(rutas.eliminarEspecifico(paradaEliminada) != null) {
            System.out.println("Parada: \"" + paradaEliminada + "\" Cancelada con éxito");
        } else {
            System.out.println("La parada no existe");
        }
    }
    public void simular () {
        NodoDoble actual = rutas.getInicio();
        String op;
        System.out.println("Simulación de rutas");
        boolean fin = false;
        boolean inicio = true;
        do {
            if(actual.getSiguiente() == null) { fin = true; }
            if(actual.getAnterior() == null) { inicio = true; }
            if(!fin || inicio) {
               System.out.println("Parada actual -> " + actual.getDato());
               System.out.print("[1] Siguiente parada\n[2] Anterior parada\n[3] Salir\nOpcion: ");
           } else {
               System.out.println("Parada actual -> " + actual.getDato() + " (Final)");
               System.out.print("[1] Siguiente parada\n[2] Anterior parada\n[3] Salir\nOpcion: ");
           }
            op = sc.nextLine();
            switch (op) {
                case "1" -> {
                    if(!fin) {
                        System.out.println("Avanzando -> ...");
                        actual = actual.getSiguiente();
                        inicio = false;
                    } else {
                        System.out.println("No es posible seguir avanzando...");
                    }
                }
                case "2"->{
                    if(inicio) {
                        System.out.println("No es posible seguir retrocediendo...");
                    } else {
                        System.out.println("Retrocediendo <- ...");
                        actual = actual.getAnterior();
                        fin = false;
                    }
                }
                case "3" -> {
                    System.out.println("Saliando ...");
                }
                default -> {
                    System.out.println("Ingrese una opción válida");
                }
            }
        } while (!op.equals("3"));
    }

}
