public class Camion {
    private String placa;

    public Camion(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Placa: " + placa;
    }
}
