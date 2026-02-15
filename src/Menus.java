import java.util.Scanner;

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
                case "3" -> menuDeRutas();
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
            System.out.println("\n[1] REGISTRAR LLEGADA DE CAMIÓN");
            System.out.println("[2] DAR INGRESO A PATIO");
            System.out.println("[3] VER PRÓXIMO CAMIÓN A ATENDER");
            System.out.println("[4] LISTAR TODOS LOS CAMIONES EN ESPERA");
            System.out.println("[5] VOLVER AL MENÚ PRINCIPAL");

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
            System.out.println("\n[1] INGRESAR CONTENEDOR DESDE RECEPCIÓN");
            System.out.println("[2] RETIRAR CONTENEDOR PARA RUTA");
            System.out.println("[3] VER EL TOPE DE LAS PILAS");
            System.out.println("[4] INSPECCIONAR CONTENEDOR");
            System.out.println("[5] REGISTRAR PILA DE CONTENEDORES");
            System.out.println("[6] ELIMINAR PILA DE CONTENEDORES");
            System.out.println("[7] VOLVER AL MENÚ PRINCIPAL");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    controlador.seleccionarPila();
                    if (controlador.getPilaSeleccionada() != null) {
                        if(controlador.getContenedorSeleccionado() != null){
                            controlador.agregarContenedor();
                            System.out.println("Contenedor agregado correctamente!");
                            controlador.setContenedorSeleccionado(null);
                        }else{
                            System.out.println("No hay un contenedor disponible.");
                        }
                    }
                }
                case "2" -> {
                    if(!controlador.getRutas().getListaRutas().vacio()) {
                        controlador.seleccionarPila();
                        if (controlador.getPilaSeleccionada() != null) {
                            controlador.retirarContenedor();
                            if(controlador.getContenedorSeleccionado() == null){return;}
                            controlador.asignarRuta(controlador.getContenedorSeleccionado(), controlador.getRutas().elegirRutas());
                        }
                    } else {
                        System.out.println("No hay rutas trazadas.");
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
    /*
    -Sin parametros
    -No retorna
    -Menú interactivo que ofrece métodos para crear/modificar/eliminar rutas
     */
    public static void menuDeRutas() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] CREAR NUEVA RUTA");
            System.out.println("[2] MODIFICAR RUTA");
            System.out.println("[3] ELIMINAR RUTA");
            System.out.println("[4] REGRESAR AL MENÚ PRINCIPAL");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("Asigne un identificador a su ruta:");
                    String idRuta = sc.nextLine();
                    if(idRuta.isEmpty()) {System.out.println("Identificador inválido");break;}
                    if (controlador.getRutas().getListaRutas().buscarElemento(idRuta) == null) {
                        System.out.println("Ruta creada exitosamente!");
                        controlador.getRutas().crearRuta(idRuta);
                    } else {
                        System.out.println("Identificador de ruta existente.");
                    }
                }

                case "2" -> {
                    System.out.println("Seleccione la ruta escribiendo su identificador:");
                    Ruta ruta = controlador.getRutas().elegirRutas();
                    if (ruta != null) {
                        System.out.println("Ruta encontrada!");
                        modificarRuta(ruta);
                    }
                }
                case "3" -> {
                    System.out.println("Seleccione la ruta a eliminar escribiendo su identificador:");
                    Ruta ruta = controlador.getRutas().elegirRutas();
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
    /*
    -Recine una instancia de Ruta
    -No retorna
    -Menú interactivo que ofrece métodos para modificar una ruta elegida por el usuario
     */
    public static void modificarRuta(Ruta ruta) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n[1] AGREGAR NUEVA PARADA AL FINAL");
            System.out.println("[2] REGISTRAR PARADA ENTRE DESTINOS");
            System.out.println("[3] CANCELAR PARADA");
            System.out.println("[4] SIMULAR RECORRIDO");
            System.out.println("[5] REGRESAR");

            System.out.println("\nSeleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> ruta.agregarParadaFinal();
                case "2" -> ruta.agregarEntreParadas();
                case "3" -> ruta.eliminarParada();
                case "4" -> ruta.simularRecorrido();
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
        controlador.mostrarReporteRecepcion();
        System.out.println("[ESTADO DE INVENTARIO]:");
        controlador.visualizarPatio();

        System.out.println("Ecriba el identificador de la ruta que desea dar seguimiento:");
        Ruta ruta = controlador.getRutas().elegirRutas();
        if (ruta != null) {
            System.out.println("Ruta encontrada!");
            System.out.println("[ESTADO DE LOGÍSTICA]:");
            System.out.println(">> RUTAS ACTIVAS: " + controlador.getRutas().getRutasActivas());
            System.out.println(">> PRÓXIMO DESTINO: " + ((!ruta.getParadas().vacio()) ? ruta.getParadas().getInicio().getDato() : "No hay destino registrado."));
            System.out.println(">> TOTAL DE PARADAS PROGRAMADAS: " + ruta.getParadas().size());

            System.out.println("Presione Enter para volver al menú principal.");
            sc.nextLine();
        }
    }

    public static void submenuInspeccionarContenedor() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        controlador.seleccionarPila();
        if (controlador.getPilaSeleccionada() != null) {
            controlador.retirarContenedor();
        }

        if (controlador.getContenedorSeleccionado() != null) {
            do {
                System.out.println("\n[1] AGREGAR PRODUCTO");
                System.out.println("[2] ELIMINAR PRODUCTO");
                System.out.println("[3] BUSCAR PRODUCTO");
                System.out.println("[4] CALCULAR PESO TOTAL");
                System.out.println("[5] MOSTRAR PRODUCTOS");
                System.out.println("[6] REGRESAR");

                System.out.println("\nSeleccione una opción:");
                opcion = sc.nextLine();

                switch (opcion) {
                    case "1" -> controlador.agregarProducto();
                    case "2" -> {
                        Producto prod = controlador.eliminarProducto();
                        if (prod == null) {
                            System.out.println("\nNo existe este producto.");
                        } else {
                            System.out.println("\nProducto con ID: (" + prod.getId() + ") eliminado.");
                        }
                    }
                    case "3" -> controlador.buscarProducto();
                    case "4" -> System.out.println("Peso total: " + controlador.calcularPesoTotal());
                    case "5" -> controlador.mostrarProductos();
                    case "6" -> {
                        controlador.agregarContenedor();
                        return;
                    }
                    default -> System.out.println("Opción inválida.");
                }
            } while (true);
        }
    }
}