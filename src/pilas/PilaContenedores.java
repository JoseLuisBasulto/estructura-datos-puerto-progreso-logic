package pilas;

import listas.ListaSimple;
import listas.Nodo;

public class PilaContenedores implements Stack {
    protected ListaSimple lst;
    protected int contador;
    protected String nombre;

    public PilaContenedores(String nombre) {
        lst = new ListaSimple();
        contador = 0;
        this.nombre = nombre;
    }

    @Override
    public void push(Object x) {
        lst.insertaInicio(x);
        contador++;
    }

    @Override
    public Object pop() {
        if (lst.vacio()) {
            System.out.println("Pila vacía");
            return null;
        } else {
            contador--;
            return lst.eliminaInicio();
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
        return contador;
    }

    @Override
    public boolean isEmpty() {
        return lst.vacio();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
