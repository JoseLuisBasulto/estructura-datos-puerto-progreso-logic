package pilas;

import listas.ListaSimple;

public class ListaSPila implements Stack{
    protected ListaSimple lst:
    protected int cont;

    public ListaSPila() {
        lst = new ListaSimple();
        cont = 0;
    }

    @Override
    public void push(Object x) {
        lst.insertarInicio(x);
        cont++;
    }

    @Override
    public Object pop() {
        if (lst.vacio()) {
            System.out.println("Pila vacía");
            return null;
        } else {
            cont--;
            return lst.eliminarInicio();
        }
    }

    @Override
    public Object top() {
        if (lst.vacio()) {
            System.out.println("Pila vacía");
            return null;
        } else {
            return lst.getInicio().getDato();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return lst.vacio();
    }
}
