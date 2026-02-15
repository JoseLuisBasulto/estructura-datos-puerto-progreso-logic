import listas.ListaSimple;

import java.util.Scanner;

public class ListaRutas {
    private ListaSimple listaRutas;
    private int rutasActivas = 0;

    /*
    -Sin parametros
    -Constructor
    -Constructor intanciar una nueva ListaSimple
     */
    public ListaRutas() {listaRutas = new ListaSimple();}

    /*
    -Sin parametros
    -Retorna un valor de tipo Ruta
    -Método que muestra las rutas creadas en listaRutas y permite al usuario elegir una de las que existen
     */
    public Ruta elegirRutas() {
        if(listaRutas.vacio()) {
            System.out.println("No hay rutas registradas.");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Rutas creadas:");
        listaRutas.imprimir(); // Imprime el resultado del toString de Ruta
        System.out.println("\nEscriba el nombre de su ruta:");
        String idRuta = sc.nextLine();
        Ruta ruta = (Ruta)listaRutas.buscarElemento(idRuta);
        if(ruta == null){
            System.out.println("\nLa ruta \"" + idRuta +"\" no existe.");
        }
        return ruta;
    }

    /*
    -Recibe un String que es el identificador de la ruta nueva por ser creada
    -Retorna un valor de tipo Ruta
    -Método que crea instancias de Ruta, es decir, crea una ruta y la inserta en listaRutas
      */
    public void crearRuta(String idRuta) {
        Ruta rt = new Ruta(idRuta);
        listaRutas.insertaFinal(rt);
    }
    /*
    -Recibe un String que es el identificador de la ruta nueva por ser creada
    -Retorna un valor de tipo Ruta
    -Método que elimina elementos de la listaRutas
      */
    public void eliminarRuta(Ruta ruta) {
        if(ruta.esActiva()) {rutasActivas--;}
        while(!ruta.getParadas().vacio()) {
            ruta.getParadas().eliminaInicio();
        }
        System.out.println("Ruta eliminada con éxito!");
        listaRutas.eliminarEntreNodos(ruta);
    }

    //Getters y Setters
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