package listas;

public abstract class ListaD extends Lista {
    protected NodoDoble inicio;
    protected NodoDoble ultimo;

    /*
    -Sin parametros
    -Retorna verdadero si el inicio es null, falso de lo contrario
    -Verificar que la ListaDoble no este vacia (inicio no esta setteado)
     */
    @Override
    public boolean vacio() {
        return inicio == null;
    }
    /*
    -Sin parametros
    -Retorna un el atributo inicio de tipo NodoDoble
    -Para obtener el primer NodoDoble de la ListaDoble
     */
    @Override
    public NodoDoble getInicio() {
        return inicio;
    }
    /*
    -Sin parametros
    -Retorna un el atributo ultimo de tipo NodoDoble
    -Para obtener el ultimo NodoDoble de la ListaDoble
     */
    @Override
    public NodoDoble getUltimo() {
        return ultimo;
    }

}

