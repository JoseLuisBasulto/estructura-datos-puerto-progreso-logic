import listas.ListaSimple;
import listas.Nodo;

import java.util.Scanner;

public class Patio {
    private ListaSimple almacen;

    public Patio() { almacen = new ListaSimple();}

    // Se registra una nueva pila de contenedores al patio.
    public void agregarPila() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el nombre de la nueva pila: ");
        String nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("\nNombre inválido.");
        } else if (almacen.buscarElemento(nombre) != null) {
            System.out.println("\nEsta pila ya está registrada en el patio.");
        } else {
            almacen.insertaFinal(new PilaContenedores(nombre));
            System.out.println("\nPila registrada con éxito!");
        }
    }

    // Elimina una pila vacía de la lista de pilas.
    public void eliminarPila() {
        Scanner sc = new Scanner(System.in);

        if (almacen.vacio()) {
            System.out.println("\nNo hay pilas registradas.");
        } else {
            System.out.println("\nPilas registradas:");
            almacen.imprimir();
            System.out.println("\nEscribe el nombre de la pila de contenedores que deseas: ");

            String cadenaUsuario = sc.nextLine();
            PilaContenedores pilaSeleccionada = (PilaContenedores) almacen.buscarElemento(cadenaUsuario);

            if (pilaSeleccionada == null ) {
                System.out.println("\nLa pila indicada no existe.");
            } else {
                if (!pilaSeleccionada.isEmpty()) {
                    System.out.println("\nLa pila seleccionada aún tiene contenedores registrados.");
                } else {
                    almacen.eliminarEntreNodos(pilaSeleccionada);
                    System.out.println("\nPila eliminada del registro con éxito.");
                }
            }
        }
    }

    // Selecciona una pila en específico del almacén para hacer modificaciones en ella, si esta existe.
    public PilaContenedores seleccionarPila() {
        Scanner sc = new Scanner(System.in);

        if (almacen.vacio()) {
            System.out.println("\nNo hay pilas registradas.");
            return null;
        } else {
            System.out.println("\nPilas registradas:");
            almacen.imprimir();
            System.out.println("\nEscribe el nombre de la pila de contenedores que deseas: ");

            String cadenaUsuario = sc.nextLine();
            PilaContenedores pilaSeleccionada = (PilaContenedores) almacen.buscarElemento(cadenaUsuario);

            if (pilaSeleccionada == null) {
                System.out.println("\nLa pila " + cadenaUsuario + " no existe.");
                return null;
            } else {
                System.out.println("\nPila " + pilaSeleccionada + " encontrada!");
                return pilaSeleccionada;
            }
        }
    }

    // Se agrega el contenedor seleccionado a la pila especificada anteriormente
    public void gestionarIngreso(Contenedor contenedor, PilaContenedores pilaSeleccionada) {
        if (pilaSeleccionada != null) {
            pilaSeleccionada.agregarContenedor(contenedor);
        }
    }

    // Se extrae el contenedor seleccionado a la pila especificada anteriormente
    public Contenedor gestionarRetiro(PilaContenedores pilaSeleccionada) {
        if (pilaSeleccionada == null || pilaSeleccionada.isEmpty()) {
            System.out.println("Operación cancelada.");
            return null;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contenedor a retirar:");
        String cadenaUsuario = sc.nextLine();

        Contenedor retirado = pilaSeleccionada.extraerContenedor(cadenaUsuario);

        if (retirado != null) {
            System.out.println("El contenedor " + retirado + " se ha retirado del patio.");
        } else {
            System.out.println("No se encontró ese nombre en la pila " + pilaSeleccionada);
        }
        return retirado;
    }

    public void mostrarPilas() { // Impresión de pilas registradas en el patio
        if (almacen.vacio()) {
            System.out.println("\nNo hay pilas registradas en el patio.");
        }  else {
            System.out.println("\n=== Tope de las Pilas ===");
            Nodo actual = almacen.getInicio();
            while (actual != null){
                Object temp = actual.getDato();
                PilaContenedores pilaActual = (PilaContenedores) temp;
                if (pilaActual.top() == null) {
                    System.out.println("Nombre: " + pilaActual + ", Tope: Ninguno");
                } else {
                    System.out.println("Nombre: " + pilaActual + ", Tope: " + pilaActual.top());
                }
                actual = actual.getSiguiente();
            }
        }
    }
}
