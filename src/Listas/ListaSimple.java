package Listas;

public class ListaSimple extends Lista{

    @Override
    public void insertaInicio(String id, String nombre, double peso) {
        if(vacio()){
            inicio = ultimo = new Producto(id,nombre,peso);
        }else{
            inicio = new Producto(id, nombre, peso, inicio);
        }
    }

    @Override
    public void insertaFinal(String id, String nombre, double peso) {
        if(vacio()){
            inicio = ultimo = new Producto(id,nombre,peso);
        }else{
            Producto nuevo = new Producto(id,nombre,peso);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    @Override
    public Producto eliminaInicio() {
        Producto eliminado = null;

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
    public Producto eliminaFinal() {
        Producto eliminado = null;

        if(vacio()){
            System.out.println("No hay productos");
        }else{
            if(inicio == ultimo){
                eliminado = ultimo;
                inicio = ultimo = null;
            }else{
                eliminado = ultimo;
                Producto actual = inicio;
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
