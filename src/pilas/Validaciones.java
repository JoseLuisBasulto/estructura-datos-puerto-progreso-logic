package pilas;

public class Validaciones {
    protected ArrayPila pila;

    public Validaciones() {
        pila = new ArrayPila();
    }

    public boolean parentesis(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                pila.push('(');
            } else {
                if (cadena.charAt(i) == ')' && !pila.isEmpty()) {
                    pila.pop();
                } else {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    public boolean palindromo (String cadena) {
        int inicio;

        for (int i = 0; i < cadena.length()/2 ; i++)
            pila.push(cadena.charAt(i));
            if (cadena.length() % 2 != 0) {
                inicio = cadena.length() / 2 + 1;
            } else {
                inicio = cadena.length() / 2;
            }
            for (int i = inicio; i < cadena.length(); i++) {
                char elemento = (char) pila.pop();
                if (elemento != cadena.charAt(i)) {
                    return false;
                }
            }
            return pila.isEmpty();
        }

    public static void main(String[] args) {
        Validaciones valida = new Validaciones();
        if (valida.parentesis("()()")) {
            System.out.println("La cadena es valida.");
        }
        else {
            System.out.println("La cadena no es valida.");
        }
    }
}
