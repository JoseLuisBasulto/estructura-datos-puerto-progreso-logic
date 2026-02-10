package colas;

import java.util.ArrayList;
import java.util.Collections;

public class NodoPrioridad implements Comparable {
    protected int prioridad;
    protected Object dato;

    public NodoPrioridad(int prioridad, Object dato) {
            this.prioridad = prioridad;
            this.dato = dato;
    }

    public String toString() {
        return prioridad + ":" + dato;
    }

    @Override
    public int compareTo(Object o) {
        if (this.prioridad < ((NodoPrioridad)o).prioridad) {
            return -1;
        } else if (this.prioridad > ((NodoPrioridad)o).prioridad) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public static void main(String[] args) {
        ArrayList datos = new ArrayList();
        datos.add(new NodoPrioridad(25, "Holaa"));

        datos.add(new NodoPrioridad(24, "Holaas"));

        datos.add(new NodoPrioridad(23, "Adios"));

        datos.add(new NodoPrioridad(22, "Hola"));

        Collections.sort(datos);
        System.out.println(datos);
    }
}
