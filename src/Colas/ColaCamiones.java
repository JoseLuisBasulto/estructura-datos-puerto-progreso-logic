package Colas;
import listas.Nodo;
public class ColaCamiones implements Queue{
    private Nodo inicio;
    private Nodo fin;
    private int size;

    public ColaCamiones() {
        inicio = null;
        fin = null;
        size = 0;
    }

    @Override
    public void enqueue(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (isEmpty()) {
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }

        fin = nuevo;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("No hay camiones en espera");
            return null;
        }

        Object dato = inicio.getDato();
        inicio = inicio.getSiguiente();

        if (inicio == null) {
            fin = null;
        }

        size--;
        return dato;
    }

    @Override
    public Object front() {
        if (isEmpty()) {
            return null;
        }
        return inicio.getDato();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public void listar() {
        Nodo actual = inicio;
        if (isEmpty()) {
            System.out.println("No hay camiones en espera.");
        } else {
            System.out.println("Camiones en espera:");
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
}
