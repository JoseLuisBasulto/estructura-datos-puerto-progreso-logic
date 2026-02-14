import java.util.Scanner;

import modelo.Camion;

public class Menus {
    protected static Controlador controlador = new Controlador();

    public static void menuPrincipal() {
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
                default -> System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("5"));
    }

    public static void menuZonaRecepcion() {
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
                case "1" -> controlador.registrarLlegadaCamion(); // Enqueue
                case "2" -> controlador.darIngresoPatio(); // Dequeue
                case "3" -> controlador.verProximoCamion();// Peek
                case "4" -> controlador.listarCamionesEnEspera(); // Listar la cola
                case "5" -> {return;}
                default -> System.out.println("Opción inválida.");
            }
        } while (true); // Bucle infinito que solo se sale con el return
    }

    public static void menuPatioContenedores() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Ingresar Contenedor desde Recepción");
            System.out.println("[2] Retirar Contenedor para Ruta");
            System.out.println("[3] Ver el tope de las Pilas");
            System.out.println("[4] Inspeccionar Contenedor");
            System.out.println("[5] Registrar Pila de Contenedores");
            System.out.println("[6] Eliminar Pila de Contenedores");
            System.out.println("[7] Volver al Menú Principal");

            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    controlador.seleccionarPila();
                    if (controlador.getPilaSeleccionada() != null) {
                        controlador.agregarContenedor();
                    }
                }
                case "2" -> {
                    controlador.seleccionarPila();
                    if (controlador.getPilaSeleccionada() != null) {
                        controlador.retirarContenedor();
                    }
                }
                case "3" -> controlador.topePilas();
                case "4" -> submenuInspeccionarContenedor();
                case "5" -> controlador.agregarPila();
                case "6" -> controlador.eliminarPila();
                case "7" -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }

    public static void menuDistribucion() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Crear nueva ruta");
            System.out.println("[2] Modificar ruta");
            System.out.println("[3] Eliminar ruta");
            System.out.println("[4] Regresar al menu principal");

            System.out.println("\nSeleccione una opción");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("Asigne un identificador a su ruta:");
                    String idRuta = sc.nextLine();
                    if (controlador.getRutas().getListaRutas().buscarElemento(idRuta) == null) {
                        System.out.println("Ruta creada exitosamente!");
                        controlador.getRutas().crearRuta(idRuta);
                    } else {
                        System.out.println("Identificador de ruta existente.");
                    }
                }

                case "2" -> {
                    System.out.println("Seleccione la ruta escribiendo su identificador:");
                    Ruta ruta = controlador.getRutas().ElegirRutas();
                    if (ruta != null) {
                        System.out.println("Ruta encontrada!");
                        modificarRuta(ruta);
                    }
                }
                case "3" -> {
                    System.out.println("Seleccione la ruta a eliminar escribiendo su identificador:");
                    Ruta ruta = controlador.getRutas().ElegirRutas();
                    if (ruta != null) {
                        System.out.println("Ruta encontrada!");
                        controlador.getRutas().eliminarRuta(ruta);
                    }
                } // Delete Ruta
                case "4" -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }

    public static void modificarRuta(Ruta ruta) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] Agregar nueva parada al final");
            System.out.println("[2] Insertar parada entre destinos");
            System.out.println("[3] Cancelar parada");
            System.out.println("[4] Simular recorrido");
            System.out.println("[5] Regresar");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> ruta.agregarParadaFinal(); // Append
                case "2" -> ruta.agregarEntreParadas();// Insert
                case "3" -> ruta.eliminarParada(); // Delete node
                case "4" -> ruta.simular(); // Navegación anterior/siguiente
                case "5" -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }

    public static void menuReporteGeneral() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n[ESTADO DE RECEPCIÓN]:");
        System.out.println(">> Camiones en espera: ");
        System.out.println(">> Próximo en turno: Placa \n"); // Placa o identificador supongo
        System.out.println("[ESTADO DE INVENTARIO]:");
        //LOGICA PARA MOSTRAR LAS PILAS



        //Seleccionar trackeo de ruta para la logistica
        System.out.println("Ecriba el identificador de la ruta que desea dar seguimiento");
        Ruta ruta = controlador.getRutas().ElegirRutas();
        if (ruta != null) {
            System.out.println("Ruta encontrada!");
        } else {
            System.out.println("[ESTADO DE LOGÍSTICA]:");
            System.out.println(">> Rutas activas: " + controlador.getRutas().getRutasActivas());
            System.out.println(">> Proximo Destino: " +ruta.getParadas().getInicio());
            System.out.println(">> Total de paradas programadas: " + ruta.getParadas().size());

            System.out.println("Presione Enter para volver al menú principal...");
            sc.nextLine(); //Espera la entrada y se regresa
        }

    }

    public static void submenuInspeccionarContenedor() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        controlador.seleccionarPila();
        controlador.retirarContenedor();

        if (controlador.getPilaSeleccionada() != null) {
            do {
                System.out.println("\n[1] Agregar producto");
                System.out.println("[2] Eliminar Producto");
                System.out.println("[3] Buscar Producto");
                System.out.println("[4] Calcular peso total");
                System.out.println("[5] Mostrar Productos");
                System.out.println("[6] Regresar");

                System.out.println("\nSeleccione una opción");
                opcion = sc.nextLine();

                switch (opcion) {
                    case "1" -> controlador.agregarProducto();
                    case "2" -> {
                        Producto prod = controlador.eliminarProducto();
                        if (prod == null) {
                            System.out.println("\nNo existe este producto...");
                        } else {
                            System.out.println("\nProducto con ID: (" + prod.getId() + ") eliminado");
                        }
                    }
                    case "3" -> controlador.buscarProducto();
                    case "4" -> System.out.println("Peso total: " + controlador.calcularPesoTotal());
                    case "5" -> controlador.mostrarProductos();
                    case "6" -> {
                        controlador.agregarContenedor();
                        return;
                    }
                    default -> System.out.println("Opción inválida");
                }
            } while (true);
        }
    }
}