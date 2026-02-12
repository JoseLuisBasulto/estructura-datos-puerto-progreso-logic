import colas.ColaCamiones;
import listas.ListaSimple;

public class Controlador {
    private ColaCamiones colaRecepcion;
    private Patio patio;
    private ListaSimple ListaRutas; // Implementar la clase de ListaRutas
    private Contenedor contenedorSeleccionado;

    // Inicialización de los atributos
    public Controlador(){
        colaRecepcion = new ColaCamiones();
        patio = new Patio();
        ListaRutas = new ListaSimple();
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

    // Getters
    public ColaCamiones getColaRecepcion() {
        return colaRecepcion;
    }

    public Patio getPatio() {
        return patio;
    }

    public ListaSimple getListaRutas() {
        return ListaRutas;
    }

    public Contenedor getContenedorSeleccionado() {
        return contenedorSeleccionado;
    }
}
