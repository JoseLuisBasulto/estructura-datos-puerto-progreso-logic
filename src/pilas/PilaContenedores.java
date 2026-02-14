package pilas;

import listas.ListaSimple;

public class PilaContenedores implements Stack {
    protected ListaSimple lst;
    protected String nombre;
    protected int contador;

    public PilaContenedores(){
        this.nombre = null;
        contador = 0;
        lst = new ListaSimple();
    }

    public PilaContenedores(String nombre) {
        this.nombre = nombre;
        contador = 0;
        lst = new ListaSimple();
    }

    @Override
    public void push(Object x) {
        lst.insertaInicio(x);
        contador++;
    }

    @Override
    public Object pop() {
        if (lst.vacio()) {
            return null;
        } else {
            contador--;
            return lst.eliminaInicio();
        }
    }

    @Override
    public Object top() {
        if (lst.vacio()) {
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

    public void mostrarContenedores() {
        lst.imprimir();
    }
}
