public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        contenedor.agregarProducto();
        contenedor.agregarProducto();
        contenedor.agregarProducto();

        contenedor.mostrarProductos();

        double peso = contenedor.calcularPeso();
        System.out.printf("\nEl peso del contenedor es: %.2f Kg\n", peso);

        contenedor.buscarProducto();
    }
}