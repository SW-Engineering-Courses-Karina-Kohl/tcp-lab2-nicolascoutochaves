import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraSegura {

    // Método que realiza a operação e potencialmente LANÇA a exceção para ser tratada no `main`
    public static double dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            // Lança (throw) uma exceção do tipo ArithmeticException
            throw new ArithmeticException("Divisão por zero.");
        }
        return (double) a / b;
    }
}
