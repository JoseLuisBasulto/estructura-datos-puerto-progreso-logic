import Listas.ListaSimple;
import Listas.Producto;

import java.util.Locale; //En caso de no tener el teclado en inglés
import java.util.Scanner;

public class Contenedor {
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

        productos.insertaFinal(id,nombre,peso);
    }

    public double calcularPeso(){
        double peso = 0.0;

        Producto actual = productos.getInicio();
        while (actual != null){
            peso += actual.getPeso();
            actual = actual.getSiguiente();
        }

        return peso;
    }

    public void buscarProducto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el id del producto a buscar: ");
        String id = sc.nextLine();

        Producto actual = productos.getInicio();
        while (actual != null){
            if(actual.getId().equals(id)){
                System.out.println("\nProducto Econtrado!");
                System.out.println(actual);
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
        Producto actual = productos.getInicio();
        while (actual != null){
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }
}
