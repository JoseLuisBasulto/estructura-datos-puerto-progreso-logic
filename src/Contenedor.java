import listas.ListaSimple;
import listas.Nodo;

import java.util.Locale; //En caso de no tener el teclado en inglés ✅
import java.util.Scanner;

public class Contenedor {
    private String id;
    private Ruta ruta;
    private ListaSimple productos;

    public Contenedor(){
        productos = new ListaSimple();
    }

    public void agregarProducto(){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Ingrese id: ");
        String id = sc.nextLine();
        System.out.println("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese peso en kg: ");
        double peso = sc.nextDouble();

        productos.insertaFinal(new Producto(id,nombre,peso));
    }

    public double calcularPeso(){
        double peso = 0.0;

        Nodo actual = productos.getInicio();
        while (actual != null){
            Object temp = actual.getDato();
            Producto prod = (Producto) temp; //Casteo necesario para poder trabajar con tipo Producto

            peso += prod.getPeso();

            actual = actual.getSiguiente();
        }

        return peso;
    }

    public void buscarProducto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el id del producto a buscar: ");
        String id = sc.nextLine();

        Nodo actual = productos.getInicio();
        while (actual != null){
            Object temp = actual.getDato();
            Producto prod = (Producto) temp; //Casteo necesario para poder trabajar con tipo Producto

            if(prod.getId().equals(id)){
                System.out.println("\nProducto Econtrado!");
                System.out.println(prod);
                break;
            }

            actual = actual.getSiguiente();
        }

        if(actual == null){
            System.out.println("\nProducto no econtrado...");
        }
    }

    public void mostrarProductos(){
        System.out.println("\nProductos del contenedor: ");

        Nodo actual = productos.getInicio();
        while (actual != null){
            Object temp = actual.getDato();
            Producto prod = (Producto) temp; // Casteo necesario para poder trabajar con tipo Producto

            System.out.println(prod);
            actual = actual.getSiguiente();
        }
    }

    // Setters y Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public ListaSimple getProductos() {
        return productos;
    }

    public void setProductos(ListaSimple productos) {
        this.productos = productos;
    }
}
