import colas.ColaCamiones;
import listas.ListaSimple;
import pilas.PilaContenedores;

import java.util.Scanner;

public class Controlador {
    private ColaCamiones colaRecepcion;
    private Patio patio;
    protected static ListaSimple rutas; // Implementar la clase de ListaRutas
    private Contenedor contenedorSeleccionado;

    // Inicialización de los atributos
    public Controlador(){
        colaRecepcion = new ColaCamiones();
        patio = new Patio();
        rutas = new ListaSimple();
        contenedorSeleccionado = new Contenedor();
    }

    //Bloque de ColaCamiones
    public void registrarLlegadaCamion(Camion camion){
        colaRecepcion.enqueue(camion);
    }

    public void darIngresoPatio(){
        //JB MOMENTO PARA DEQUEUE
    }

    // Bloque de clase Patio
    public void agregarPila(){
        patio.agregarPila();
    }

    public PilaContenedores seleccionarPila(){
        return patio.seleccionarPila();
    }



    // Bloque de clase Contenedor
    public void agregarProducto(){
        contenedorSeleccionado.agregarProducto();
    }

    public Producto eliminarProducto(){
        return contenedorSeleccionado.eliminarProducto();
    }

    public void buscarProducto(){
        contenedorSeleccionado.buscarProducto();
    }

    public double calcularPesoTotal(){
        return contenedorSeleccionado.calcularPeso();
    }

    public void mostrarProductos(){
        contenedorSeleccionado.mostrarProductos();
    }


    public Ruta ElegirRutas() {
        if(rutas.vacio()) {
            System.out.println("No hay rutas registradas");
            return null;
        }
        Scanner  sc = new Scanner(System.in);
        rutas.imprimir();
        System.out.println("\nEscriba el nombre de su ruta");
        String idRuta = sc.nextLine();
        Ruta ruta = (Ruta)rutas.buscarElemento(idRuta);
        if(ruta == null){
            System.out.println("\nLa ruta \"" + idRuta +"\" no existe");
        }
        return ruta;
    }

    // Getters
    public ColaCamiones getColaRecepcion() {
        return colaRecepcion;
    }

    public Patio getPatio() {
        return patio;
    }

    public ListaSimple getRutas() {
        return rutas;
    }

    public Contenedor getContenedorSeleccionado() {
        return contenedorSeleccionado;
    }

    // Setters
    public void setContenedorSeleccionado(Contenedor contenedorSeleccionado) {
        this.contenedorSeleccionado = contenedorSeleccionado;
    }
}
