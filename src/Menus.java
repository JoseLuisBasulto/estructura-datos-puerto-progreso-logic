import java.util.Scanner;
import Colas.ColaCamiones;
public class Menus {
private static ColaCamiones cola = new ColaCamiones();
    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("  PUERTO PROGRESO LOGIC SYSTEM v1.0 - GESTIÓN PORTUARIA");
            System.out.println("=========================================================");
            System.out.println("[1] ZONA DE RECEPCIÓN");
            System.out.println("[2] PATIO DE CONTENEDORES");
            System.out.println("[3] LOGÍSTICA Y RUTAS");
            System.out.println("[4] REPORTE GENERAL");
            System.out.println("[5] SALIR");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> menuZonaRecepcion();
                case "2" -> menuPatioContenedores();
                case "3" -> menuDistribucion();
                case "4" -> menuReporteGeneral();
                case "5" -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        }while(!opcion.equals("5"));
    }

    public static void menuZonaRecepcion(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Registrar llegada de camión");
            System.out.println("[2] Dar ingreso a patio");
            System.out.println("[3] Ver próximo camión a atender");
            System.out.println("[4] Listar todos los camiones en espera");
            System.out.println("[5] Volver al Menú Principal");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese placa del camión: ");
                    String placa = sc.nextLine();

                    Camion camion = new Camion(placa);
                    cola.enqueue(camion);

                    System.out.println("Camión registrado correctamente.");
                } // Enqueue
                case "2" -> {
                    Camion atendido = (Camion) cola.dequeue();

                    if (atendido != null) {
                        System.out.println("Camión ingresando al patio: " + atendido);
                    }
                } // Dequeue
                case "3" -> {
                    Camion siguiente = (Camion) cola.front();

                    if (siguiente != null) {
                        System.out.println("Próximo camión: " + siguiente);
                    } else {
                        System.out.println("No hay camiones en espera.");
                    }
                } // Peek
                case "4" -> cola.listar(); // Listar la cola
                case "5" -> { return ;}
                default -> System.out.println("Opción inválida");
            }
        } while (true); // Bucle infinito que solo se sale con el return
    }

    public static void menuPatioContenedores(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Ingresar contenedor desde Recepción");
            System.out.println("[2] Retirar contenedor para Ruta");
            System.out.println("[3] Ver tope de las pilas");
            System.out.println("[4] Inspeccionar contenedor");
            System.out.println("[5] Volver al Menú Principal");

            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> System.out.println("Uno"); // Push a una pila
                case "2" -> System.out.println("Dos");// Pop de una pila
                case "3" -> System.out.println("Tres"); // Peek
                case "4" -> submenuInspeccionarContenedor();
                case "5" -> { return; }
                default -> System.out.println("Opción inválida");
            }
        }while (true);
    }

    public static void menuDistribucion(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Agregar nueva parada al final");
            System.out.println("[2] Insertar parada entre destinos ");
            System.out.println("[3] Cancelar parada");
            System.out.println("[4] Simular recorrido");
            System.out.println("[5] Volver al Menú Principal");

            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();

          switch (opcion) {
                case "1" -> System.out.println("Uno"); // Append
                case "2" -> System.out.println("Dos");// Insert
                case "3" -> System.out.println("Tres"); // Delete node
                case "4" -> System.out.println("Cuatro"); // Navegación anterior/siguiente
                case "5" -> { return; }
                default -> System.out.println("Opción inválida");
          }
        }while (true);
    }

    public static void menuReporteGeneral(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n[ESTADO DE RECEPCIÓN]:");
        System.out.println(">> Camiones en espera: "); // Espera un valor
        System.out.println(">> Próximo en turno: Placa \n"); // Placa o identificador supongo
        System.out.println("[ESTADO DE INVENTARIO]:");
        //LOGICA PARA MOSTRAR LAS PILAS
        System.out.println("[ESTADO DE LOGÍSTICA]:");
        System.out.println(">> Rutas activas: "); // Espera valor
        System.out.println(">> Proximo Destino: "); // Espera valor
        System.out.println(">> Total de paradas programadas: \n"); // Espera valor

        System.out.println("Presione Enter para volver al menú principal...");
        sc.nextLine(); //Espera la entrada y se regresa
    }

    public static void submenuInspeccionarContenedor(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Agregar producto");
            System.out.println("[2] Calcular peso total");
            System.out.println("[3] Regresar");

            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> System.out.println("Uno"); //Instancia contenedor para agregar producto
                case "2" -> System.out.println("Dos");//Instancia contenedor para calcular su peso total
                case "3" -> { return; }
                default -> System.out.println("Opción inválida");
            }

        }while (true);
    }
}
