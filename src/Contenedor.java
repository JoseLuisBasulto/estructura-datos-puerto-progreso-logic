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

    //Método que no recibe parámetros, solo agrega al final un producto a la lista de productos
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

    // Método que no recibe parámetros, devuelve un valor double que es el peso del contenedor
    public double calcularPeso(){
        double peso = 0.0;

        if(!productos.vacio()){
            Nodo actual = productos.getInicio();
            while (actual != null){
                Producto prod = (Producto) actual.getDato(); //Casteo necesario para poder trabajar con tipo Producto

                peso += prod.getPeso();

                actual = actual.getSiguiente();
            }
        }

        return peso;
    }

    //Método que recibe un String (identificador) y busca dicho id en la lista de productos, devolviendo un booleano para determinar su existencia
    public boolean existeProducto(String id){
        Nodo actual = productos.getInicio();
        while (actual != null){
            Producto prod = (Producto) actual.getDato(); // Casteo necesario para poder trabajar con tipo Producto

            if(prod.getId().equals(id)){
                return true; // Se retorna true en caso de econtrar el producto
            }

            actual = actual.getSiguiente();
        }
        return false; // Se retorna false si no se encuentra el producto
    }

    // Método que busca un producto en la lista productos, no recibe parámetros y muestra un mensaje dependiendo el resultado
    public void buscarProducto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el id del producto a buscar: ");
        String id = sc.nextLine();

        if(existeProducto(id)){
            Nodo actual = productos.getInicio();
            Producto prod = (Producto) actual.getDato(); // Casteo necesario para poder trabajar con tipo Producto

            while (!prod.getId().equals(id)){ // Mientras no se encuentre el producto se avanza
                actual = actual.getSiguiente(); // Avanzamos entre los productos
                prod = (Producto) actual.getDato(); // Guardamos el id del producto
            }
            System.out.println("Producto Econtrado!");
            System.out.println(prod);
            return;
        }
        System.out.println("\nProducto no econtrado...");
    }

    //Método que elimina un producto de la lista, no tiene parámetros y devuelve el producto eliminado
    public Producto eliminarProducto(){
        Scanner sc = new Scanner(System.in);
        Producto eliminado = null; // Caso base si no existe el producto

        System.out.println("\nIngrese el id del producto a eliminar: ");
        String id = sc.nextLine();

        if(existeProducto(id)) { //Si existe el producto
            Nodo actual = productos.getInicio();
            Producto prod = (Producto) actual.getDato();

            while (!prod.getId().equals(id)){// Mientras no se ecuentre el producto avanzamos
                actual = actual.getSiguiente(); // Avanzamos entre productos
                prod = (Producto) actual.getDato(); // Guardamos el id del producto
            }

            eliminado = prod; // Se guarda el producto eliminado

            if(actual == productos.getInicio() && actual == productos.getUltimo()){
                productos.setInicio(null); // Indicando que la lista esta vacía
                productos.setUltimo(null);

            } else if(actual == productos.getInicio()){
                productos.setInicio(actual.getSiguiente()); // Se setea al segundo como nuevo inicio

            }else if(actual == productos.getUltimo()){
                Nodo anterior = productos.getInicio();
                while(anterior.getSiguiente() != productos.getUltimo()){ // Nos ubicamos en el penúltimo producto
                    anterior = anterior.getSiguiente();
                }
                anterior.setSiguiente(null); // Seteamos su aputador a null
                productos.setUltimo(anterior); // Y se convierte en el nuevo último

            }else{
                Nodo anterior = productos.getInicio();
                while (anterior.getSiguiente() != actual){ // Nos ubicamos en el anterior al producto
                    anterior = anterior.getSiguiente();
                }
                anterior.setSiguiente(actual.getSiguiente()); // Y hacemos que apunte al nodo que está a dos posiciones adelante
            }
        }
        return eliminado; //Se devuele el producto
    }

    //Método que no recibe parámetros, simplemente recorre toda la lista de productos e imprime el producto
    public void mostrarProductos(){
        System.out.println("\nProductos del contenedor: ");

        if(productos.vacio()){
            System.out.println("\nNo hay productos en el contendor...");
            return;
        }

        System.out.println("\n=== Productos del contenedor ===");
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
