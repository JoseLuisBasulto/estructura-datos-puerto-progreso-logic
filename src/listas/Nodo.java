package listas;

public class  Nodo {
    protected Object dato;
    protected Nodo siguiente;

    public Nodo(){}

    // Constructor que setea el apuntador a null
    public Nodo(Object dato){
        this.dato = dato;
        siguiente = null;
    }

    // Constructor que setea el apuntador a un Nodo
    public Nodo(Object dato, Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    //Setters y Getters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
