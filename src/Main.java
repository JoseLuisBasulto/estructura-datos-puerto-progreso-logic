public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        contenedor.agregarProducto();
        contenedor.agregarProducto();
        contenedor.agregarProducto();

        contenedor.mostrarProductos();

        contenedor.calcularPeso();

        contenedor.buscarProducto();
    }
}