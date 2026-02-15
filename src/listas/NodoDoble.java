package listas;

public class NodoDoble extends Nodo {
    protected NodoDoble siguiente;
    protected NodoDoble anterior;

    /*
    -Recibe un dato tipo Object
    -Es un constructor
    -Constructor Para elementos que no se necesitan forzosamente apuntar a otro NodoDoble
     */
    public NodoDoble(Object dato) {
        this.dato = dato;
        siguiente = anterior = null;
    }

    /*
    -Recibe un dato tipo Object, Un NodoDoble anterior, NodoDoble siguiente
    -Es un constructor
    -Constructor Para NodosDobles que al momento de instanciarse se neceista que apunten a sus NodosDobles vecinos
     */
    public NodoDoble(Object dato, NodoDoble anterior, NodoDoble siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    //Getters y Setters
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
