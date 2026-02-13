package listas;

public class ListaDoble extends ListaD{

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
        if(!vacio()) {
            eliminado = inicio.getDato();
            if (inicio == ultimo) {
                inicio = ultimo = null;
            } else {
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
        }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if(!vacio()) {
            eliminado = ultimo.getDato();
            if (inicio == ultimo) {
                inicio = ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
        return  eliminado;
    }

    //Encuentra la primer coincidencia y revisa al siguiente
    public void insertaEntreNodos(Object a, Object b, Object dato) {
        if(!vacio()) {
            NodoDoble actual = inicio;
            while (actual != null && (!actual.getDato().equals(a) && !actual.getDato().equals(b))) {
                actual = actual.getSiguiente();
            }
            // Filtro de seguridad para no romper el código
            if ((actual != null && actual.getSiguiente() != null) && (actual.getSiguiente().getDato().equals(b) || actual.getSiguiente().getDato().equals(a))) {
                NodoDoble nuevo = new NodoDoble(dato);
                NodoDoble sigActual = actual.getSiguiente();
                actual.setSiguiente(nuevo);
                sigActual.setAnterior(nuevo);
                nuevo.setAnterior(actual);
                nuevo.setSiguiente(sigActual);
            } else {
                System.out.println("No es posible");
            }
        }
    }
    @Override
    public Object eliminarEntreNodos(Object a) {
        if(!vacio()) {
            NodoDoble actual = inicio;
            while (actual != null && !actual.getDato().equals(a)) {
                actual = actual.getSiguiente();
            }
            if(actual != null) {
                NodoDoble anterior = actual.getAnterior();
                NodoDoble siguiente = actual.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
            }
            return actual;
        }
        return null;
    }

    public boolean existeNodo(Object dato) {
        if(!vacio()) {
            NodoDoble actual = inicio;
            while (actual != null && !actual.getDato().equals(dato)) {
                actual = actual.getSiguiente();
            }
            return actual != null;
        }
        return false;
    }
}
