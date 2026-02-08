package Listas;

public class ListaDoble extends ListaD{ //Podemos quitar el ifvacio() y eliminar inicio si puerto es el primer elemento
    @Override
    public void insertaInicio(Object dato) {
        if(vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble nuevo = new NodoDoble(dato, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }


    @Override
    public void insertaFinal(Object dato) {
        if(vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble temp = new NodoDoble(dato, ultimo, null);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio()) {
            System.out.println("Lista vacía");
        } else {
            eliminado = inicio.getDato();
            inicio = inicio.getSiguiente();
            inicio.setAnterior(ultimo);
        }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if(vacio()) {
            System.out.println("Lista vacía");

        } else {
            eliminado = ultimo.getDato();
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
        return  eliminado;
    }
    public void insertaEntreNodos(Object a, Object b, Object c) {
        if(vacio()) {
            System.out.println("No es posible");
        } else {
            NodoDoble actual = inicio;
            while((!actual.getDato().equals(a) && !actual.getDato().equals(b) ) && actual != null) {
                actual = actual.getSiguiente();
            }
            if(actual.getDato().equals(a) || actual.getDato().equals(b)) {
                if(actual.getSiguiente().getDato().equals(b)||actual.getSiguiente().getDato().equals(a)) {
                    NodoDoble nuevo = new NodoDoble(c);
                    NodoDoble sigActual = actual.getSiguiente();
                    actual.setSiguiente(nuevo);
                    sigActual.setAnterior(nuevo);
                    nuevo.setAnterior(actual);
                    nuevo.setSiguiente(sigActual);
                } else {
                    System.out.println("No es posible");
                }
            } else {
                System.out.println("No es posible");
            }
        }
    }

    public Object eliminarEspecifico(Object a) {
        if(ultimo.getDato().equals(a)) {
            return eliminaFinal();
        } else {
            NodoDoble actual = inicio;
            while(!actual.getDato().equals(a) && actual != null ) {
                actual = actual.getSiguiente();
            }
            if(actual.getDato().equals(a)) {
                NodoDoble anterior = actual.getAnterior();
                NodoDoble siguiente = actual.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
                actual.setSiguiente(null); //revisar si es necesario
                actual.setAnterior(null);
            } else {
                System.out.println("No es posible");
                return null;
            }
            return actual;
        }
    }


}
