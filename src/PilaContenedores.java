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

    // La pila ha llegado a su límite de contenedores? False si es menor que 5, True de otro modo
    public boolean validarPila() {
        return this.size < LIMITE;
    }

}
