import listas.Nodo;
import pilas.PilaSimple;

public class PilaContenedores extends PilaSimple {
    protected String nombre;
    private final int LIMITE = 5;

    public PilaContenedores(String nombre) { // Constructor
        super(); // Constructor de PilaSimple
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    // Agrega un contenedor a su inventario si la pila no está llena.
    public void agregarContenedor(Contenedor contenedor) {
        if (validarPila()) {
            this.push(contenedor);
            System.out.println("Contenedor apilado en " + nombre);
        } else {
            System.out.println("Error: La pila " + nombre + " está llena.");
        }
    }

    // Extrae un contenedor de su inventario si este coincide con la cadena ingresada por el usuario
    public Contenedor extraerContenedor(String cadenaUsuario) {
        if (this.isEmpty()) return null;

        PilaSimple auxiliar = new PilaSimple();
        Contenedor contenedorDeseado = null;

        while (!this.isEmpty()) {
            Contenedor actual = (Contenedor) this.pop();
            if (actual.toString().equals(cadenaUsuario)) {
                contenedorDeseado = actual;
                break;
            }
            auxiliar.push(actual);
        }

        while (!auxiliar.isEmpty()) {
            this.push(auxiliar.pop());
        }

        return contenedorDeseado;
    }

    public void visualizarPila() {
        StringBuilder texto = new StringBuilder("[");

        for (int i = 0; i < LIMITE; i++) {
            if (i < size) {
                texto.append("|");
            } else {
                texto.append(" ");
            }
        }
        texto.append("]");

        double pesoPila = calcularPesoTotal();

        String status = String.format(">> Pila %s: %s (%d/%d) - Peso Total: %,.0f kg",
                nombre, texto, size, LIMITE, pesoPila);

        if (size == LIMITE) {
            status += " - ¡CRÍTICO: LLENA!";
        }

        System.out.println(status);
    }

    private double calcularPesoTotal() {
        double total = 0.0;
        Nodo actual = tope;

        while (actual != null) {
            Contenedor contenedorActual = (Contenedor) actual.getDato();
            total += contenedorActual.calcularPeso();
            actual = actual.getSiguiente();
        }

        return total;
    }

    // La pila ha llegado a su límite de contenedores? False si es menor que 5, True de otro modo
    public boolean validarPila() {
        return this.size < LIMITE;
    }

}
