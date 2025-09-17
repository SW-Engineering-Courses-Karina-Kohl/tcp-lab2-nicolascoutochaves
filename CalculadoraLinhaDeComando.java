import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraLinhaDeComando {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraSegura calculadora = new CalculadoraSegura();
        double resultado = 0;
        boolean calculoConcluido = false;


        // Loop principal até o cálculo ser concluído com sucesso
        while (!calculoConcluido) {
            try {
                System.out.print("Digite o numerador (dividendo): ");
                int numerador = scanner.nextInt();

                System.out.print("Digite o denominador (divisor): ");
                int denominador = scanner.nextInt();

                // Tentativa de cálculo - PONTO CRÍTICO QUE PODE LANÇAR UMA EXCEÇÃO
                resultado = calculadora.dividir(numerador, denominador);
                calculoConcluido = true; // Se chegou aqui, deu tudo certo. Sai do loop.

            } catch (ArithmeticException e) {
                // Bloco catch 1: Captura a exceção específica de divisão por zero
                System.err.println("\nErro: " + e.getMessage());
                System.err.println("Você tentou dividir por zero. Isso é matematicamente indefinido.");
                System.err.println("Por favor, insira um divisor diferente de zero.\n");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito

            } catch (InputMismatchException e) {
                // Bloco catch 2: Captura a exceção de se digitar algo que não é número
                System.err.println("\nErro: Entrada inválida.");
                System.err.println("Por favor, insira apenas números inteiros.\n");
                scanner.nextLine(); // Limpa o buffer do scanner É FUNDAMENTAL aqui!

            } catch (Exception e) {
                // Bloco catch 3: Captura qualquer outra exceção inesperada
                System.err.println("\nOcorreu um erro inesperado: " + e.getMessage());
                scanner.nextLine();
            }
        }

        // Se saiu do loop, é porque o cálculo deu certo!
        System.out.println("O resultado da divisão é: " + resultado);
        scanner.close();
    }

    
}
