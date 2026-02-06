package Listas;

public class ListaSimple extends Lista{

    @Override
    public void insertaInicio(Object dato) {
        if(vacio()){
            inicio = ultimo = new Nodo(dato);
        }else{
            inicio = new Nodo(dato, inicio);
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if(vacio()){
            inicio = ultimo = new Nodo(dato);
        }else{
            Nodo nuevo = new Nodo(dato);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;

        if(vacio()){
            System.out.println("No hay productos");
        }else{
            if(inicio == ultimo){
                eliminado = inicio;
                inicio = ultimo = null;
            }else{
                eliminado = inicio;
                inicio = inicio.siguiente;
            }
        }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;

        if(vacio()){
            System.out.println("No hay productos");
        }else{
            if(inicio == ultimo){
                eliminado = ultimo;
                inicio = ultimo = null;
            }else{
                eliminado = ultimo;
                Nodo actual = inicio;
                while (actual.siguiente != ultimo){
                    actual = actual.siguiente;
                }
                actual.setSiguiente(null);
                ultimo = actual;
            }
        }
        return eliminado;
    }
}
