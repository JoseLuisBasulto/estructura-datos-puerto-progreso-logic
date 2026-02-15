import listas.ListaSimple;
import listas.Nodo;
import pilas.PilaContenedores;

import java.util.Scanner;

public class Patio {
    private ListaSimple almacen;

    public Patio() { almacen = new ListaSimple();}

    // Se agrega una nueva columna al almacén por medio de una inserción de una nueva pila a la lista de pilas
    // La función no recibe argumentos ni devuelve la referencia de algún objeto
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

    // Elimina una pila vacía de la lista de pilas. La función no recibe ni devuelve ningún argumento.
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

    // Para facilitar la modificación de una columna, esta función le permite al usuario escoger una pila en específico
    // La función no recibe ningún parámetro, pero devuelve la referencia de la pila elegida por el usuario
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

    // Se agrega un contenedor a la pila seleccionada anteriormente, este contenedor ya debió pasar por recepción (módulo A)
    // La función recibe el contenedor elegido y la pila específica que se está modificando. No devuelve nada la función
    public void agregarContenedor(PilaContenedores pilaActual, Contenedor contenedor) {
        if (almacen.vacio()) {
            System.out.println("\nNo hay pilas registradas.");
        } else if (!validarPila(pilaActual)) {
            System.out.println("\nEsta pila de contenedores llegó a su límite. Registra una nueva pila.");
        } else { // TODO
            pilaActual.push(contenedor);
        }
    }

    //  Retira del almacén un contenedor particular y le asigna una parada dentro de una ruta existente
    // La función recibe la pila que se seleccionó anteriormente y no devuelve el contenedor que se quiere sacar
    public Contenedor retirarContenedor(PilaContenedores pilaActual) {
        Scanner sc = new Scanner(System.in);
        Contenedor contenedorDeseado = null;

        if (pilaActual.isEmpty()) {
            System.out.println("\nNo hay contenedores disponibles para retirar en esta pila.");
        } else {
            PilaContenedores pilaAuxiliar = new PilaContenedores();

            System.out.println("\nContenedores disponibles:");
            pilaActual.mostrarContenedores();
            System.out.println("\nEscribe el contenedor que quieres retirar.");

            String cadenaUsuario = sc.nextLine();

            while (!pilaActual.isEmpty() && !pilaActual.top().equals(cadenaUsuario)) {
                pilaAuxiliar.push(pilaActual.pop());
            }

            if (!pilaActual.isEmpty() && pilaActual.top().equals(cadenaUsuario)) {
                contenedorDeseado = (Contenedor) pilaActual.pop();
                System.out.println("\nEl contenedor " + contenedorDeseado + "fue extraído exitosamente!");
            } else {
                System.out.println("\nEl contenedor " + cadenaUsuario + " no se encuentra en esta pila de contenedores.");
            }

            while (!pilaAuxiliar.isEmpty()) {
                pilaActual.push(pilaAuxiliar.pop());
            }
        }
        return contenedorDeseado;
    }

    public void mostrarPilas() {
        if (almacen.vacio()) {
            System.out.println("\nNo hay pilas registradas en el Patio..");
        }  else {
            System.out.println("\n=== Tope de las Pilas ===");
            Nodo actual = almacen.getInicio();
            while (actual != null){
                Object temp = actual.getDato();
                PilaContenedores pilaActual = (PilaContenedores) temp;
                if (pilaActual.top() == null) {
                    System.out.println("Nombre: " + pilaActual + ", Tope: Sin tope");
                } else {
                    System.out.println("Nombre: " + pilaActual + ", Tope: " + pilaActual.top());
                }
                actual = actual.getSiguiente();
            }
        }
    }

    // Función que valida si la pila seleccionada (entrada) ya ha llegado a su límite y hay que crear otra (5 contenedores)
    public boolean validarPila(PilaContenedores pilaActual) {
        if (pilaActual.size() > 4) {
            return false;
        }
        return true;
    }

}
