import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;

import java.util.Scanner;

public class Ruta {
    private ListaDoble paradas;
    private String idRuta;
    private boolean activa;
    private ListaSimple contenedoresAsignados;

    /*
    -Recibe un String, el identificador de la ruta
    -Es un constructor
    -Constructor para crear una ruta con su identificador, su ListaDoble de paradas, e indicar que no esta activa
     */
    public Ruta(String idRuta){ //Crear ruta
        this.paradas = new ListaDoble();
        this.contenedoresAsignados = new ListaSimple();
        this.idRuta = idRuta;
        this.activa = false;
    }

    /*
    -Sin parametros
    -No retorna
    -Agrega una parada (String) al final de la ListaDoble de paradas
     */
    public void agregarParadaFinal () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la nueva parada: ");
        String parada = sc.nextLine();

        if(valido(parada)) {
            paradas.insertaFinal(parada);}
    }

    /*
    -Sin parametros
    -No retorna
    -Agrega una parada (String) entre otras dos paradas que ya existen en la ListaDoble de paradas
     */
    public void agregarEntreParadas () {
        Scanner sc = new Scanner(System.in);
        if(paradas.vacio()) {
            System.out.println("No hay paradas registradas.");
        } else{
            System.out.print("Ingrese el nombre de la nueva parada: ");
            String nuevaParada = sc.nextLine();
            if(!valido(nuevaParada)) { return; }


            System.out.println("Identifique entre que destinos se integrará la nueva parada. (No importa el orden de los destinos)");
            System.out.print("Destino 1: ");
            String parada1 = sc.nextLine();
            System.out.print("Destino 2: ");
            String parada2 = sc.nextLine();

            paradas.insertaEntreNodos(parada1, parada2, nuevaParada);
        }

    }
    /*
    -Sin parametros
    -No retorna
    -Elimina una parada (String) que existe en la ListaDoble de paradas
     */
    public void eliminarParada () {
        Scanner sc = new Scanner(System.in);
        if(paradas.vacio()) {
            System.out.println("No hay paradas registradas para eliminar.");
            return;
        }
        System.out.println("Ingrese el nombre de la parada a cancelar: ");
        String paradaEliminada = sc.nextLine();
        if(paradaEliminada.isEmpty()) {System.out.println("Nombre no valido");return; }

        if(paradaEliminada.equals(paradas.getInicio().getDato())) {
            System.out.println("Parada \""+ paradas.eliminaInicio()+"\" Cancelada");
        } else if (paradaEliminada.equals(paradas.getUltimo().getDato())) {
            System.out.println("Parada \""+ paradas.eliminaFinal()+"\" Cancelada");
        } else {
            if(paradas.eliminarEntreNodos(paradaEliminada)!= null) {
                System.out.println("Parada \""+paradaEliminada+"\" Cancelada");
            } else {
                System.out.println("Para no existente, acción cancelada");
            }
        }
    }
    /*
    -Sin parametros
    -No retorna
    -Permite "iterar" la ListaDoble de paradas mostrando los datos de los NodosDobles de esta. Permite ir hacia adelante y hacia atrás, siempre iniciando en el primer NodoDoble
     */
    public void simularRecorrido () {
        Scanner sc = new Scanner(System.in);
        if(paradas.vacio()) {
            System.out.println("No hay nigúin destino trazado");
            return;
        }
        NodoDoble actual = paradas.getInicio();
        String op;
        System.out.println("Simulación de rutas");
        boolean fin = false;
        boolean inicio = true;
        do {
            if(actual.getSiguiente() == null) { fin = true; }
            if(actual.getAnterior() == null) { inicio = true; }
            if(!fin || inicio) {
                System.out.println("Parada actual -> " + actual.getDato() + ((inicio) ? " (Inicio) ":""));
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
                case "3" -> System.out.println("Saliando ...");
                default -> System.out.println("Ingrese una opción válida");
            }
        } while (!op.equals("3"));

    }
    /*
    -Recibe un String, el nombre de la Parada designada por el usuario
    -Retorna true si el nombre es valido, false de lo contrario
    -Verifica si el nombre de la parada dada por el usuario es válida para el sistema
     */
    public boolean valido (String nombreParada) {
        if (nombreParada.isEmpty()) {
            System.out.println("Nombre no válido");
            return false;
        } else if (paradas.existeNodo(nombreParada)) {
            System.out.println("El nombre de la parada ya existe");
            return false;
        }
        return true;
    }
    /*
    -Sin parametros
    -Retorna un String
    -Para darle una representación textual a la instancia Ruta, por su identificador (String) propio.
     */
    @Override
    public String toString() {
        return idRuta;
    }

    //Getters y Setters
    public ListaDoble getParadas() {
        return paradas;
    }

    public ListaSimple getContenedoresAsignados() {
        return contenedoresAsignados;
    }

    public boolean esActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}