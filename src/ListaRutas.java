import listas.ListaSimple;

import java.util.Scanner;

public class ListaRutas {
    private ListaSimple listaRutas;
    private ListaSimple contenedoresListos;
    public ListaRutas() {
        listaRutas = new ListaSimple();
        contenedoresListos = new ListaSimple();
    }

    // Bloque de clase Rutas
    public Ruta ElegirRutas() {
        if(listaRutas.vacio()) {
            System.out.println("No hay rutas registradas");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        listaRutas.imprimir();
        System.out.println("\nEscriba el nombre de su ruta");
        String idRuta = sc.nextLine();
        Ruta ruta = (Ruta)listaRutas.buscarElemento(idRuta);
        if(ruta == null){
            System.out.println("\nLa ruta \"" + idRuta +"\" no existe");
        }
        return ruta;
    }

    public void crearRuta(String idRuta) {
        Ruta rt = new Ruta(idRuta);
        listaRutas.insertaFinal(rt);
    }

    public void eliminarRuta(Ruta ruta) {

        while(!ruta.getParadas().vacio()) {
            ruta.getParadas().eliminaInicio();
        }
        System.out.println("Ruta Eliminada Con éxito");
        listaRutas.eliminarEntreNodos(ruta);
    }

    public ListaSimple getListaRutas() {
        return listaRutas;
    }

    public ListaSimple getContenedoresListos() {
        return contenedoresListos;
    }
}