package Listas;

public abstract class Lista {
    protected Producto inicio;
    protected Producto ultimo;

    public Lista(){
        inicio = ultimo = null;
    }

    public void imprimir(){
       Producto actual = inicio;
       System.out.println("Productos: ");
       while (actual != null){
           System.out.println(actual);
           actual = actual.siguiente;
       }
    }

    //Métodos abstractos de manipulación de lista
    public abstract void insertaInicio (String id, String  nombre, double peso);
    public abstract void insertaFinal (String id, String  nombre, double peso);
    public abstract Producto eliminaInicio ();
    public abstract Producto eliminaFinal ();

    public boolean vacio(){
        return inicio == null;
    }


    //Setters y Getters
    public Producto getInicio() {
        return inicio;
    }

    public void setInicio(Producto inicio) {
        this.inicio = inicio;
    }

    public Producto getUltimo() {
        return ultimo;
    }

    public void setUltimo(Producto ultimo) {
        this.ultimo = ultimo;
    }
}
