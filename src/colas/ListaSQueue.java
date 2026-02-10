package colas;

import listas.ListaSimple;

public class ListaSQueue implements Queue {
    protected ListaSimple lst;
    protected int cont;

    public ListaSQueue() {
        lst = new ListaSimple();
        cont = 0;
    }

    @Override
    public void enqueue(Object dato) {
        lst.insertarFinal(dato);
        cont++;
    }

    @Override
    public Object dequeue() {
        if (lst.vacio()) {
            System.out.println("Cola vacía");
            return null;
        } else {
            cont--;
            return lst.eliminarInicio();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public Object front() {
        if (lst.vacio()) {
            System.out.println("Cola vacía");
            return null;
        } else {
            cont--;
            return lst.getInicio().getDato();
        }
    }

    @Override
    public boolean isEmpty() {
        return lst.vacio();
    }
}
