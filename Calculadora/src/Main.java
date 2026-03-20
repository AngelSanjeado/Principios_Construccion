import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la operacion: ");
        String operacion = sc.nextLine();

        char[] cifras = operacion.toCharArray();
        List<Double> numeros = new ArrayList<>();
        char operador = '0';

        String numero = "";
        for (int i = 0; i < cifras.length; i++) {

            if (Character.isWhitespace(cifras[i])) continue;

            if (Character.isDigit(cifras[i]) || cifras[i] == '.'){
                numero += cifras[i];
                continue;
            }

            if (cifras[i] == '-' && (i == 0 || esOperador(cifras, i))) {
                numero += cifras[i];
                continue;
            }

            numeros.add(Double.parseDouble(numero));
            operador = cifras[i];
            numero = "";
        }

        if (!numero.isEmpty()){
            numeros.add(Double.parseDouble(numero));
        }

        System.out.printf("%.2f %c %.2f = %.2f", numeros.get(0), operador, numeros.get(1), calcular(numeros, operador));
    }

    public static boolean esOperador(char[] caracter, int indice){
        indice -= 1;

        while (indice >= 0 && Character.isWhitespace(caracter[indice])){

            if (indice == 0) return true;

            indice -= 1;
        }

        return switch (caracter[indice]) {
            case '+', '/', '*', '-' -> true;
            default -> false;
        };
    }

    public static double calcular(List<Double> operandos, char operador){
        return switch (operador){
            case '+' -> operandos.get(0) + operandos.get(1);
            case '-' -> operandos.get(0) - operandos.get(1);
            case '/' -> operandos.get(0) / operandos.get(1);
            case '*' -> operandos.get(0) * operandos.get(1);
            default -> 0.0;
        };
    }
}