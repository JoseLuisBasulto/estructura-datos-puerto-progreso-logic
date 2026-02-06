package Listas;

public class Producto {
    protected String id;
    protected String nombre;
    protected double peso;
    protected Producto siguiente;

    public Producto(){}

    // Constructor que setea el apuntador a null
    public Producto(String id, String  nombre, double peso){
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        siguiente = null;
    }

    // Constructor que setea el apuntador a un Nodo
    public Producto(String id, String  nombre, double peso, Producto siguiente){
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.siguiente = siguiente;
    }

    // Modificación del método toString
    @Override
    public String toString() {
        return "id: " + id + ", nombre: " + nombre+ ", peso: " + peso  + " kg";
    }

    //Setters y Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }
}
