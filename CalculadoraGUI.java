import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame {

    private JTextField campoNumerador;
    private JTextField campoDenominador;
    private JLabel labelResultado;
    private Calculadora calculadora = new Calculadora();

    public CalculadoraGUI() {
        // Configuração básica da janela
        setTitle("Calculadora com Tratamento de Exceções");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 5, 5)); // Linhas, colunas, espaçamento

        // Criando os componentes
        JLabel labelNumerador = new JLabel("Numerador:");
        campoNumerador = new JTextField();

        JLabel labelDenominador = new JLabel("Denominador:");
        campoDenominador = new JTextField();

        JButton botaoDividir = new JButton("Dividir");
        labelResultado = new JLabel("Resultado: ");

        // Adicionando os componentes à janela
        add(labelNumerador);
        add(campoNumerador);
        add(labelDenominador);
        add(campoDenominador);
        add(new JLabel()); // Espaço vazio
        add(botaoDividir);
        add(new JLabel()); // Espaço vazio
        add(labelResultado);

        // Configurando o ouvinte (listener) do botão
        botaoDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. Tentar converter o texto dos campos para números
                    int numerador = Integer.parseInt(campoNumerador.getText());
                    int denominador = Integer.parseInt(campoDenominador.getText());

                    // 2. Tentar realizar a divisão (pode lançar ArithmeticException)
                    
                    double resultado = calculadora.dividir(numerador, denominador);

                    // 3. Se chegou aqui, deu tudo certo! Atualiza a interface.
                    labelResultado.setText("Resultado: " + resultado);
                    labelResultado.setForeground(Color.BLACK); // Cor normal

                } catch (NumberFormatException ex) {
                    // Captura se o usuário digitou algo que não é número
                    JOptionPane.showMessageDialog(CalculadoraGUI.this,
                            "Erro: Por favor, digite apenas números inteiros válidos nos dois campos.",
                            "Entrada Inválida",
                            JOptionPane.ERROR_MESSAGE);
                    limparCampos();

                } catch (ArithmeticException ex) {
                    // Captura a divisão por zero
                    JOptionPane.showMessageDialog(CalculadoraGUI.this,
                            "Erro: " + ex.getMessage() + "\nO denominador não pode ser zero.\nPor favor, digite outro valor.",
                            "Divisão por Zero",
                            JOptionPane.WARNING_MESSAGE);
                    campoDenominador.setText(""); // Limpa apenas o campo do denominador
                    campoDenominador.requestFocus(); // Coloca o foco de volta no campo

                } catch (Exception ex) {
                    // Captura qualquer outro erro inesperado
                    JOptionPane.showMessageDialog(CalculadoraGUI.this,
                            "Ocorreu um erro inesperado: " + ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true); // Torna a janela visível
    }



    private void limparCampos() {
        campoNumerador.setText("");
        campoDenominador.setText("");
        campoNumerador.requestFocus(); // Coloca o foco no primeiro campo
    }

    public static void main(String[] args) {
        // Executa a GUI na Event Dispatch Thread (EDT) do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraGUI();
            }
        });
    }
}
