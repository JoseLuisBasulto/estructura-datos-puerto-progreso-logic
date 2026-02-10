package colas;

import java.util.ArrayList;

public class ArrayLQueue implements Queue {
    protected ArrayList cola;

    public ArrayLQueue() {
        cola = new ArrayList();
    }

    @Override
    public void enqueue(Object dato) {
        cola.add(dato);
    }

    @Override
    public Object dequeue() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
        }
        else {
            return cola.remove(0);
        }
        return null;
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public Object front() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        else {
            return cola.get(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }
}
