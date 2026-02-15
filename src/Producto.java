public class Producto {
    private String id;
    private String nombre;
    private double peso;

    public Producto(String id, String nombre, double peso){
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return getId();
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
}
