package pilas;

public class ArrayPila implements Stack {
    protected Object[] pila;
    protected int contador = 0;

    public ArrayPila() {
        pila = new Object[1000];
    }

    @Override
    public void push(Object x) {
        if (contador == 1000) {
            System.out.println("La pila está llena.");
        }
        else {
            pila[contador++] = x;
        }
    }

    @Override
    public Object pop() {
        if (contador == 0) {
            System.out.println("La pila está vacía.");
            return null;
        }
        else {
            return pila[contador--] = null;
        }
    }

    @Override
    public Object top() {
        if (contador == 0) {
            System.out.println("La pila está vacía.");
            return null;
        }
        else {
            return pila[contador--] = null;
        }
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public boolean isEmpty() {
        if (contador == 0) {
            return true;
        }
        return false;
    }
}
