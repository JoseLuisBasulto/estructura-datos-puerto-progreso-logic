package colas;

import java.util.ArrayList;
import java.util.Collections;

public class ColaPrioridadA implements Queue {
    protected ArrayList cola;

    public ColaPrioridadA() {
        cola = new ArrayList();
    }

    @Override
    public void enqueue(Object dato) {
        cola.add(dato);
        Collections.sort(cola);
    }

    @Override
    public Object dequeue() {
        return cola.remove(0);
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public Object front() {
        return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public static void main(String[] args) {
        ColaPrioridadA colap = new ColaPrioridadA();
        colap.enqueue(new NodoPrioridad(25, "Holaa"));
        colap.enqueue(new NodoPrioridad(20, "Holap"));
        colap.enqueue(new NodoPrioridad(85, "Adios"));
        colap.enqueue(new NodoPrioridad(4, "Chao"));
        colap.enqueue(new NodoPrioridad(9, "Holas"));

        while(!colap.isEmpty()) {
            System.out.println(colap.dequeue());
        };
    }
}
