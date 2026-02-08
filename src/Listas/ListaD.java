package Listas;

public abstract class ListaD extends Lista {
    protected NodoDoble inicio;
    protected NodoDoble ultimo;

    @Override
    public boolean vacio() {
        return inicio == null;
    }
    @Override
    public NodoDoble getInicio() {
        return inicio;
    }

}
