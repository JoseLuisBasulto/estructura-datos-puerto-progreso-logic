import colas.ColaCamiones;
import listas.ListaSimple;
import pilas.PilaContenedores;

import java.util.Scanner;

public class Controlador {
    private ColaCamiones colaRecepcion;
    private PilaContenedores pilaSeleccionada;
    private Patio patio;
    protected static ListaSimple rutas; // Implementar la clase de ListaRutas
    private Contenedor contenedorSeleccionado;
    protected ListaSimple almacen;

    // Inicialización de los atributos
    public Controlador(){
        colaRecepcion = new ColaCamiones();
        patio = new Patio();
        pilaSeleccionada = new PilaContenedores();
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

    public void eliminarPila() { patio.eliminarPila();}

    public void seleccionarPila(){
        setPilaSeleccionada(patio.seleccionarPila());
    }

    public void retirarContenedor(){
        if (pilaSeleccionada == null) {
            System.out.println("No es posible realizar esta acción.");
        } else {
            setContenedorSeleccionado(patio.retirarContenedor(pilaSeleccionada));
        }
    }

    public void agregarContenedor(){
        patio.agregarContenedor(pilaSeleccionada, contenedorSeleccionado);
    }

    public void topePilas() {
        patio.mostrarPilas();
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

    // Bloque de clase Rutas
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

    public PilaContenedores getPilaSeleccionada() {
        return pilaSeleccionada;
    }

    // Setters
    public void setContenedorSeleccionado(Contenedor contenedorSeleccionado) {
        this.contenedorSeleccionado = contenedorSeleccionado;
    }

    public void setPilaSeleccionada(PilaContenedores pilaSeleccionada) {
        this.pilaSeleccionada = pilaSeleccionada;
    }
}
