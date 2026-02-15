import listas.ListaSimple;
import listas.Nodo;

import java.util.Locale; //En caso de no tener el teclado en inglés ✅
import java.util.Scanner;

public class Contenedor {
    private String id;
    private ListaSimple productos;

    public Contenedor(String id){
        this.id = id;
        productos = new ListaSimple();
    }

    public Contenedor(){
        id = null;
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

        // Se verifica que no haya un contenedor con el id ingresado, para evitar duplicados
        if(productos.buscarElemento(id) == null){
            productos.insertaFinal(new Producto(id,nombre,peso));
        }else{
            System.out.println("\nIdentificador ocupado, volver a intentar...");
        }
    }

    // Método que no recibe parámetros, devuelve un valor double que es el peso del contenedor
    public double calcularPeso(){
        double peso = 0.0; // Acumulador para el peso total

        if(!productos.vacio()){
            Nodo actual = productos.getInicio();
            while (actual != null){
                Producto prod = (Producto) actual.getDato(); //Casteo necesario para poder trabajar con tipo Producto

                peso += prod.getPeso(); // Se suman las cantidades

                actual = actual.getSiguiente();
            }
        }

        return peso;
    }

    // Método que busca un producto en la lista productos, no recibe parámetros y muestra un mensaje dependiendo el resultado
    public void buscarProducto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el id del producto a buscar: ");
        String id = sc.nextLine();

        Producto prod = (Producto) productos.buscarElemento(id); // Se usa el método buscarElemento que devuelve un objeto

        if(prod == null){
            System.out.println("\nEl producto no existe o el contenedor esta vacío...");
        }else{
            System.out.println("Producto econtrado!");
            System.out.println("ID: " + prod.getId() + ", Nombre: " + prod.getNombre() + ", Peso: " + prod.getPeso() + " Kg");
        }
    }

    //Método que elimina un producto de la lista, no tiene parámetros y devuelve el producto eliminado
    public Producto eliminarProducto(){
        Scanner sc = new Scanner(System.in);
        Producto eliminado = null; // Caso base si no existe el producto

        System.out.println("\nIngrese el id del producto a eliminar: ");
        String id = sc.nextLine();

        if(productos.buscarElemento(id) != null) { //Si existe el producto
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
        if(productos.vacio()){ //Si la lista de  productos está vacía
            System.out.println("\nNo hay productos en el contendor...");
            return;
        }

        System.out.println("\n=== Productos del contenedor ===");
        Nodo actual = productos.getInicio();
        while (actual != null){
            Object temp = actual.getDato();
            Producto prod = (Producto) temp; // Casteo necesario para poder trabajar con tipo Producto

            System.out.println("ID: " + prod.getId() + ", Nombre: " + prod.getNombre() + ", Peso: " + prod.getPeso() + " Kg");
            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        return id;
    }

    // Setters y Getters
    public String getId() {
        return id;
    }

    public void setProductos(ListaSimple productos) {
        this.productos = productos;
    }
}
