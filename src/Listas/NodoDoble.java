package Listas;

public class NodoDoble extends Nodo {
    protected NodoDoble siguiente;
    protected NodoDoble anterior;
    public NodoDoble() {}
    public NodoDoble(Object dato) {
        this.dato = dato;
        siguiente = anterior = null;
    }
    public NodoDoble(Object dato, NodoDoble anterior, NodoDoble siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    @Override
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
