import java.util.Scanner;

import colas.ColaSimple;
import listas.Nodo;

public class ColaCamiones extends ColaSimple {

    public ColaCamiones(){}

    public void registrarLlegadaCamion() {
        Scanner sc = new Scanner(System.in);
        String placa = "", id ="";
        int cantidad = -1;
        boolean placaValida = false, idValido = false, cantidadValida = false;
        while(!placaValida){
            System.out.print("\nIngrese placa del camión: ");
            placa = sc.nextLine().trim();
            if (placa.isEmpty()) {
                System.out.println("Error: La placa no puede estar vacía.");
            } else if (placa.length() < 3) {
                System.out.println("Error: La placa debe tener al menos 3 caracteres.");
            } else if (existePlaca(placa)) {
                System.out.println("Error: Ya existe un camión con esa placa en la cola.");
            } else {
                placaValida = true;
            }

        }
        while (!idValido) {
            System.out.print("Ingrese id del contenedor: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: El ID del contenedor no puede estar vacío.");
            } else {
                idValido = true;
            }
        }

        Contenedor contenedor = new Contenedor(id);

        while (!cantidadValida) {
            System.out.println("\n¿Cuántos productos existen en el contenedor?");
            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();
                sc.nextLine();
                if (cantidad < 0) {
                    System.out.println("Error: La cantidad no puede ser negativa.");
                } else {
                    cantidadValida = true;
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine();
            }
        }
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n Producto " + (i + 1) + " de " + cantidad);
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
    private boolean existePlaca(String placa) {
        if (isEmpty()) {
            return false;
        }

        Nodo actual = inicio;
        while (actual != null) {
            Camion camion = (Camion) actual.getDato();
            if (camion != null && camion.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    public void mostrarReporteRecepcion() {
        System.out.println(">> CAMIONES EN ESPERA: " + size());

        Camion proximoCamion = (Camion) front();
        if (proximoCamion != null) {
            System.out.println(">> PRÓXIMO EN TURNO: PLACA " + proximoCamion.getPlaca() + "\n");
        } else {
            System.out.println(">> PRÓXIMO EN TURNO: No hay camiones en espera\n");
        }
    }
}
