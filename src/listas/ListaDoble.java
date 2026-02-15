package listas;

public class ListaDoble extends ListaD{
    protected int size = 0;

    /*
    -Recibe un dato tipo Object
    -No retorna
    -Inserta un NodoDoble asociado con el dato  del párametro al inicio de la ListaDoble
     */
    @Override
    public void insertaInicio(Object dato) {
        if(vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble nuevo = new NodoDoble(dato, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
        size++;
    }

    /*
    -Recibe un dato tipo Object
    -No retorna
    -Inserta un NodoDoble asociado con el dato  del párametro al final de la ListaDoble
     */
    @Override
    public void insertaFinal(Object dato) {
        if(vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble temp = new NodoDoble(dato, ultimo, null);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }
        size++;
    }

    /*
    -Sin parametros
    -Retorna un Objeto
    -Elimina el primer NodoDoble de la ListaDoble y retorna su dato asociado
     */
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
        size--;
        return eliminado;
    }

    /*
    -Sin parametros
    -Retorna un Objeto
    -Elimina el ultimo NodoDoble de la ListaDoble y retorna su dato asociado
     */
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
        size--;
        return  eliminado;
    }

    /*
    -Recibe dos Objets a y b (no importa su orden) y un Object dato (el que se insertará entre a y b)
    -No retorna
    -Encuentra la primer coincidencia con los datos de los NodosDobles de ListaDoble (sea a o b) y revisa si el siguiente dato del NodoDoble dato es a o b (dependiendo de cual encontró primero)
     Solo inserta entre nodos
     */
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
                size++;
            } else {
                System.out.println("No es posible");
            }
        }
    }

    /*
    -Recibe dos Objets a y b (no importa su orden) y un Object dato (el que se insertará entre a y b)
    -No retorna
    -Encuentra la primer coincidencia con los datos de los NodosDobles de ListaDoble (sea a o b) y revisa si el siguiente dato del NodoDoble dato es a o b (dependiendo de cual encontró primero)
     Solo elimina entre nodos
     */
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
                size--;
            }
            return actual;
        }
        return null;
    }

    /*
    -Recibe un Object dato para comparar con los datos de los NodosDobles de ListaDoble
    -Retorna verdadero si ya existe el dato, falso de lo contrario
    -Encuentra la primera coindicencia de los datos de los NodosDobles de ListaDoble,
     para que no hayas NodosDobles con datos iguales, para que no haya paradas con el mismo nombre
     */
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

    //Getters
    public int size() {return size;}
}
