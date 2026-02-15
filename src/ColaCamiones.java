import java.util.Scanner;

import colas.ColaSimple;
import listas.Nodo;

public class ColaCamiones extends ColaSimple {

    public ColaCamiones(){}

    public void registrarLlegadaCamion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese placa del camión: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese id del contenedor: ");
        String id = sc.nextLine();
        Contenedor contenedor = new Contenedor(id);

        System.out.println("\nCuántos productos existen en el contenedor?");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++){
            contenedor.agregarProducto();
        }

        Camion camion = new Camion(placa, contenedor);
        enqueue(camion);
        System.out.println("\nCamión registrado correctamente!");
    }

    public Camion darIngresoPatio() {
        if (isEmpty()) {
            System.out.println("\nNo hay camiones en espera...");
            return null;
        }

        Camion atendido = (Camion) dequeue();

        if (atendido != null) {
            System.out.println("\nCamión ingresando al patio: " + atendido);
        }

        return atendido;
    }

    public void verProximoCamion() {
        Camion siguiente = (Camion) front();

        if (siguiente != null) {
            System.out.println("\nPróximo camión: " + siguiente);
        } else {
            System.out.println("\nNo hay camiones en espera...");
        }
    }

    @Override
    public void listar() {
        if (isEmpty()) {
            System.out.println("\nNo hay camiones en espera...");
        } else {
            System.out.println("\nCamiones en espera:");
            Nodo actual = inicio;
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
}
