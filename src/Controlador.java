import colas.ColaCamiones;
import listas.ListaSimple;

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


    //Bloque de clase Contenedor
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
        System.out.println("Escriba el nombre de su ruta");
        String idRuta = sc.nextLine();
        Ruta ruta = (Ruta)rutas.buscarElemento(idRuta);
        if(ruta == null){
            System.out.println("La ruta \"" + idRuta +"\" no existe");
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
}
