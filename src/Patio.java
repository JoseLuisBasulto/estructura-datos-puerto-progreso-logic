import listas.ListaSimple;
import pilas.PilaContenedores;

import java.util.Scanner;

public class Patio {
    private ListaSimple almacén;

    public Patio() { almacén = new ListaSimple();}

    // Se agrega una nueva columna al almacén por medio de una inserción de una nueva pila a la lista de pilas
    // La función no recibe argumentos ni devuelve la referencia de algún objeto
    public void agregarPila() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre de la nueva pila: ");
        String nombre = sc.nextLine();
        almacén.insertaFinal(new PilaContenedores(nombre));
    }

    // Para facilitar la modificación de una columna, esta función le permite al usuario escoger una pila en específico
    // La función no recibe ningún parámetro, pero devuelve la referencia de la pila elegida por el usuario
    public PilaContenedores seleccionarPila() {
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

    // Se agrega un contenedor a la pila seleccionada anteriormente, este contenedor ya debió pasar por recepción (módulo A)
    // La función recibe el contenedor elegido y la pila específica que se está modificando. No devuelve nada la función
    public void agregarContenedor(PilaContenedores pilaActual, Contenedor contenedor) {
        if (!validarPila(pilaActual)) {
            System.out.println("Esta pila de contenedores llegó a su límite. Registra una nueva pila.");
        } else {
            pilaActual.push(contenedor);
        }
    }


    //  Retira del almacén un contenedor particular y le asigna una parada dentro de una ruta existente
    // La función recibe la pila que se seleccionó anteriormente y no devuelve el contenedor que se quiere sacar

    public Contenedor retirarContenedor(PilaContenedores pilaActual) {
        Scanner sc = new Scanner(System.in);
        Contenedor contenedorDeseado = null;

        if (pilaActual.isEmpty()) {
            System.out.println("No hay contenedores disponibles para retirar.");
        } else {
            PilaContenedores pilaAuxiliar = new PilaContenedores("aux");

            System.out.println("Contenedores disponibles:");
            pilaActual.mostrarContenedores();
            System.out.println("Escribe el contenedor que quieres retirar.");

            String cadenaUsuario = sc.nextLine();

            while (!pilaActual.isEmpty() && pilaActual.top().equals(cadenaUsuario)) {
                pilaAuxiliar.push(pilaActual.pop());
            }

            if (!pilaActual.isEmpty() && pilaActual.top().equals(cadenaUsuario)) {
                contenedorDeseado = (Contenedor) pilaActual.pop();
                // Aquí se le asignaría una ruta en especial
                System.out.println("El contenedor " + contenedorDeseado + "fue extraído exitosamente!");
            } else {
                System.out.println("El contenedor " + cadenaUsuario + " no se encuentra en esta pila de contenedores.");
            }

            while (!pilaAuxiliar.isEmpty()) {
                pilaActual.push(pilaAuxiliar.pop());
            }
        }
        return contenedorDeseado;
    }

    // La función recibe la pila que está siendo modificada y devuelve el contenedor que está al tope
    public Object contenedorTope(PilaContenedores pilaActual) {
        return pilaActual.top();
    }

    // Función que valida si la pila seleccionada (entrada) ya ha llegado a su límite y hay que crear otra (5 contenedores)
    public boolean validarPila(PilaContenedores pilaActual) {
        if (pilaActual.size() > 4) {
            return false;
        }
        return true;
    }
}
