import listas.ListaSimple;
import listas.Nodo;
import pilas.PilaContenedores;

import java.util.Scanner;

public class Patio {
    private ListaSimple almacén;

    public Patio() { almacén = new ListaSimple();}

    public void agregarPila() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre de la nueva pila: ");
        String nombre = sc.nextLine();
        almacén.insertaFinal(new PilaContenedores(nombre));
    }

    public PilaContenedores seleccionarPila() { // El usuario eligirá qué pila quiere manipular
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilas registradas:");
        almacén.imprimir();
        System.out.println("Escribe el nombre de la pila de contenedores que deseas: ");

        String cadenaUsuario = sc.nextLine();
        PilaContenedores pilaSeleccionada = (PilaContenedores) almacén.buscarElemento(cadenaUsuario);

        if (pilaSeleccionada == null ) {
            System.out.println("La pila indicada no existe.");
            return null;
        } else {
            System.out.println("Pila encontrada!");
            return pilaSeleccionada;
        }

    }

    public void agregarContenedor(PilaContenedores pilaActual, Contenedor contenedor) { // Agregar contenedor a una pila ya elegida
        if (!validarPila(pilaActual)) {
            System.out.println("Esta pila de contenedores llegó a su límite. Registra una nueva pila.");
        } else {
            pilaActual.push(contenedor);
        }
    }

    public void retirarContenedor(PilaContenedores pilaActual) { // Eliminar contenedor de una pila ya elegida
        if (!pilaActual.isEmpty()) {
            System.out.println("No hay contenedores disponibles para retirar.");
        } else {
            pilaActual.pop();
        }
    }

    public Object contenedorTope(PilaContenedores pilaActual) { // Mostrar el tope de la pila ya elegida
        return pilaActual.top();
    }

    public boolean validarPila(PilaContenedores pilaActual) { // Revisar si la pila ya llegó al límite: 5
        if (pilaActual.size() > 4) {
            return false;
        }
        return true;
    }
}
