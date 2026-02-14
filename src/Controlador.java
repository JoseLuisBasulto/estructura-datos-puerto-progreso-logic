import colas.ColaCamiones;
import listas.ListaSimple;
import modelo.Camion;
import pilas.PilaContenedores;

public class Controlador {
    private ColaCamiones colaRecepcion;
    private PilaContenedores pilaSeleccionada;
    private Patio patio;
    private ListaRutas rutas;
    private Contenedor contenedorSeleccionado;
    protected ListaSimple almacen;

    // Inicialización de los atributos
    public Controlador(){
        colaRecepcion = new ColaCamiones();
        patio = new Patio();
        pilaSeleccionada = new PilaContenedores();
        rutas = new ListaRutas();
        contenedorSeleccionado = new Contenedor();
    }

    //Modulo A (el mas dificil por eso JB se encarga :)
    public void registrarLlegadaCamion(){colaRecepcion.registrarLlegadaCamion();}

    public void darIngresoPatio(){
        Camion camion = colaRecepcion.darIngresoPatio();

        if (camion != null){
            //Aqui es donde va el codigo del papis we papis donde solo debemos llamar a su funcion que da ingreso a patio paro como se le acabo el agua a gemini todavia no lo ha hecho
        }
    }

    public void verProximoCamion(){colaRecepcion.verProximoCamion();}

    public void listarCamionesEnEspera(){colaRecepcion.listar();}

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
    public void AsignarContenedorARuta(Contenedor contenedor, Ruta ruta) {
        ruta.getContenedoresAsignados().insertaFinal(contenedor);
        if(!ruta.esActiva()) {
            rutas.setRutasActivas(rutas.getRutasActivas() + 1);
        } else {
            ruta.setActiva(true);
        }
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

    // Getters
    public ColaCamiones getColaRecepcion() {
        return colaRecepcion;
    }

    public Patio getPatio() {
        return patio;
    }

    public ListaRutas getRutas() {
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
