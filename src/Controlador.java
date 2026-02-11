import listas.ListaSimple;

public class Controlador {
    private Camion camion;
    private Patio patio;
    private Contenedor contenedorSeleccionado;
    private ListaSimple rutas;
    private ListaSimple camiones;

    // Setters y Getters
    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Contenedor getContenedorSeleccionado() {
        return contenedorSeleccionado;
    }

    public void setContenedorSeleccionado(Contenedor contenedorSeleccionado) {
        this.contenedorSeleccionado = contenedorSeleccionado;
    }

    public ListaSimple getRutas() {
        return rutas;
    }

    public void setRutas(ListaSimple rutas) {
        this.rutas = rutas;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public ListaSimple getCamiones() {
        return camiones;
    }

    public void setCamiones(ListaSimple camiones) {
        this.camiones = camiones;
    }
}
