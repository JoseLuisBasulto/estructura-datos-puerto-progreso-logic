import listas.ListaSimple;

import java.util.Scanner;

public class ListaRutas {
    private ListaSimple listaRutas;
    private int rutasActivas = 0;
    public ListaRutas() {listaRutas = new ListaSimple();}

    // Bloque de clase Rutas
    public Ruta elegirRutas() {
        if(listaRutas.vacio()) {
            System.out.println("No hay rutas registradas.");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Rutas creadas:");
        listaRutas.imprimir();
        System.out.println("\nEscriba el nombre de su ruta:");
        String idRuta = sc.nextLine();
        Ruta ruta = (Ruta)listaRutas.buscarElemento(idRuta);
        if(ruta == null){
            System.out.println("\nLa ruta \"" + idRuta +"\" no existe.");
        }
        return ruta;
    }

    public void crearRuta(String idRuta) {
        Ruta rt = new Ruta(idRuta);
        listaRutas.insertaFinal(rt);
    }

    public void eliminarRuta(Ruta ruta) {
        if(ruta.esActiva()) {rutasActivas--;}
        while(!ruta.getParadas().vacio()) {
            ruta.getParadas().eliminaInicio();
        }
        System.out.println("Ruta eliminada con éxito!");
        listaRutas.eliminarEntreNodos(ruta);
    }

    public ListaSimple getListaRutas() {
        return listaRutas;
    }

    public void setRutasActivas(int rutasActivas) {
        this.rutasActivas = rutasActivas;
    }

    public int getRutasActivas() {
        return rutasActivas;
    }
}