import listas.ListaSimple;
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

    public void seleccionarPila() { // El usuario eligirá qué pila quiere manipular
        // TODO
    }

    public void agregarContenedor() { // Agregar contenedor a una pila ya elegida
        // TODO
    }

    public Object retirarContenedor() { // Eliminar contenedor de una pila ya elegida
        // TODO
        // Solo se puede retirar el contenedor de la cima. Si se requiere otro, pasar los elementos momentaneamente a
        // una pila auxiliar. Se debe validar el máximo de contenedores por pila.
    }

    public Object contenedorTope() { // Mostrar el tope de la pila
        // TODO
    }

    public boolean validarPila() { // Revisar si la pila ya llegó al límite: 5
        // TODO
    }
}
