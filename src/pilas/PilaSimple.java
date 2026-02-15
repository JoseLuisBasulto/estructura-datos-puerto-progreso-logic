package pilas;
import listas.Nodo;

public class PilaSimple implements Stack {
    protected Nodo tope;
    protected int size;

    public PilaSimple() { // Constructor
        this.tope = null;
        this.size = 0;
    }

    @Override
    public void push(Object dato) { // Mete un dato a la pila
        Nodo nuevo = new Nodo(dato);
        if (!isEmpty()) {
            nuevo.setSiguiente(tope);
        }
        tope = nuevo;
        size++;
    }

    @Override
    public Object pop() { // Saca un dato de la pila
        if (isEmpty()) {
            return null;
        }
        Object dato = tope.getDato();
        tope = tope.getSiguiente();
        size--;
        return dato;
    }

    @Override
    public Object top() { // Deuvelve el dato que está en la cima de la pila
        if (isEmpty()) {
            return null;
        }
        return tope.getDato();
    }

    @Override
    public int size() { // Devuelve el tamaño actual de la pila
        return size;
    }

    @Override
    public boolean isEmpty() { // Si el tope es null, es que no hay ningún elemento en la pila
        return tope == null;
    }

    public void imprimirElementos() { // Imprime los objetos contenidos en la pila
        Nodo actual = tope;
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos en la pila (desde el tope):");
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
}
