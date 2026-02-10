package listas;

public abstract class Lista {
    protected Nodo inicio;
    protected Nodo ultimo;

    public Lista(){
        inicio = ultimo = null;
    }

    public void imprimir(){
       Nodo actual = inicio;
       while (actual != null){
           System.out.println(actual.dato);
           actual = actual.siguiente;
       }
    }

    //Métodos abstractos de manipulación de lista
    public abstract void insertaInicio (Object dato);
    public abstract void insertaFinal (Object dato);
    public abstract Object eliminaInicio ();
    public abstract Object eliminaFinal ();

    public boolean vacio(){
        return inicio == null;
    }

    //Setters y Getters
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
}
