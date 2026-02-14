package colas;
import java.util.Scanner;

import listas.Nodo;
import modelo.Camion;

public class ColaCamiones extends Cola {
    public ColaCamiones(){}

    public void registrarLlegadaCamion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese placa del camión: ");
        String placa = sc.nextLine();

        Camion camion = new Camion(placa);
        enqueue(camion);
        System.out.println("Camión registrado correctamente.");
    }

    public Camion darIngresoPatio() {
        if (isEmpty()) {
            System.out.println("No hay camiones en espera");
            return null;
        }

        Camion atendido = (Camion) dequeue();

        if (atendido != null) {
            System.out.println("Camión ingresando al patio: " + atendido);
        }

        return atendido;
    }

    public void verProximoCamion() {
        Camion siguiente = (Camion) front();

        if (siguiente != null) {
            System.out.println("Próximo camión: " + siguiente);
        } else {
            System.out.println("No hay camiones en espera.");
        }
    }

    @Override
    public void listar() {
        if (isEmpty()) {
            System.out.println("No hay camiones en espera.");
        } else {
            System.out.println("Camiones en espera:");
            Nodo actual = inicio;
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
}
