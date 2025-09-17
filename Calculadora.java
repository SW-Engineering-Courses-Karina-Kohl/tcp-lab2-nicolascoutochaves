import java.util.Scanner;

public class Calculadora {

    public int somar(int a, int b){
        return a+b;
    }

    public int dividir(int a, int b){
        if(b == 0)
            throw new ArithmeticException("Divisão por zero não é permitida.");
        return a/b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();

        int num2 = sc.nextInt();
        Calculadora calculadora = new Calculadora();

        System.out.println("Soma: " + calculadora.somar(num1, num2));
        System.out.println("Divisão: " + calculadora.dividir(num1, num2));
        
    }
}
