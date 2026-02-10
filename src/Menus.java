import java.util.Scanner;

public class Menus {

    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("  PUERTO PROGRESO LOGIC SYSTEM v1.0 - GESTIÓN PORTUARIA");
        System.out.println("=========================================================");
        System.out.println("[1] ZONA DE RECEPCIÓN");
        System.out.println("[2] PATIO DE CONTENEDORES");
        System.out.println("[3] LOGÍSTICA Y RUTAS");
        System.out.println("[4] REPORTE GENERAL");
        System.out.println("[5] SALIR");

        String opcion;
        do {
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
        System.out.println("[1] Registrar llegada de camión");
        System.out.println("[2] Dar ingreso a patio");
        System.out.println("[3] Ver próximo camión a atender");
        System.out.println("[4] Listar todos los camiones en espera");
        System.out.println("[5] Volver al Menú Principal");

        String opcion;
        boolean valido; //Para validar el caracter de entrada
        do {
            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();
            valido = switch (opcion) {
                case "1" -> {System.out.println("Uno"); yield true;} // Enqueue
                case "2" -> {System.out.println("Dos"); yield true;} // Dequeue
                case "3" -> {System.out.println("tres"); yield true;} // Peek
                case "4" -> {System.out.println("cuatro"); yield true;} // Falta lógica
                case "5" -> {menuPrincipal(); yield true;}
                default -> {System.out.println("Opción inválida"); yield false;}
            };
        }while (!valido);
    }

    public static void menuPatioContenedores(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Ingresar contenedor desde Recepción");
        System.out.println("[2] Retirar contenedor para Ruta");
        System.out.println("[3] Ver tope de las pilas");
        System.out.println("[4] INSPECCIONAR CONTENEDOR");
        System.out.println("[5] Volver al Menú Principal");

        String opcion;
        boolean valido; //Para validar el caracter de entrada
        do {
            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();
            valido = switch (opcion) {
                case "1" -> {System.out.println("Uno"); yield true;} // Push a una pila
                case "2" -> {System.out.println("Dos"); yield true;} // Pop de una pila
                case "3" -> {System.out.println("tres"); yield true;} // Peek
                case "4" -> {System.out.println("cuatro"); yield true;} //submenu agregar producto y calcular peso total
                case "5" -> {menuPrincipal(); yield true;}
                default -> {System.out.println("Opción inválida"); yield false;}
            };
        }while (!valido);
    }

    public static void menuDistribucion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Agregar nueva parada al final");
        System.out.println("[2] Insertar parada entre destinos ");
        System.out.println("[3] Cancelar parada");
        System.out.println("[4] SIMULAR RECORRIDO");
        System.out.println("[5] Volver al Menú Principal");

        String opcion;
        boolean valido; //Para validar el caracter de entrada
        do {
            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();
            valido = switch (opcion) {
                case "1" -> {System.out.println("Uno"); yield true;} // Append
                case "2" -> {System.out.println("Dos"); yield true;} // Insert
                case "3" -> {System.out.println("tres"); yield true;} // Delete node
                case "4" -> {System.out.println("cuatro"); yield true;} // Navegación anterior/siguiente
                case "5" -> {menuPrincipal(); yield true;}
                default -> {System.out.println("Opción inválida"); yield false;}
            };
        }while (!valido);
    }

    public static void menuReporteGeneral(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[ESTADO DE RECEPCIÓN]:");
        System.out.println(">> Camiones en espera: "); // Espera un valor
        System.out.println(">> Próximo en turno: Placa \n"); // Placa o identificador supongo
        System.out.println("[ESTADO DE INVENTARIO]:");
        //LOGICA PARA MOSTRAR LAS PILAS
        System.out.printf("[ESTADO DE LOGÍSTICA]:");
        System.out.println(">> Rutas activas: "); // Espera valor
        System.out.println(">> Proximo Destino: "); // Espera valor
        System.out.println(">> Total de paradas programadas: \n"); // Espera valor

        System.out.println("Presione cualquier tecla para volver al menú principal...");
        if(sc.nextLine() != null){
            menuPrincipal();
        }
    }
}
