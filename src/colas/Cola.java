package colas;
import listas.Nodo;

public class Cola implements Queue{
    protected Nodo inicio;
    protected Nodo ultimo;
    protected int size;

    public Cola() {
        inicio = null;
        ultimo = null;
        size = 0;
    }

    @Override
    public void enqueue(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object dato = inicio.getDato();
        inicio = inicio.getSiguiente();

        if (inicio == null) {
            ultimo = null;
        }
        size--;
        return dato;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object front() {
        if(isEmpty()) {
            return null;
        }
        return inicio.getDato();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void listar() {
        Nodo actual = inicio;
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Elementos en la cola:");
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
}
