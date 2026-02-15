public class Camion {
    private String placa;
    private Contenedor contenedor;

    public Camion(String placa, Contenedor contenedor) {
        this.placa = placa;
        this.contenedor = contenedor;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Placa: " + placa;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }
}
