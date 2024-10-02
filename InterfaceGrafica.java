import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class InterfaceGrafica extends JFrame{
    private ArvoreBinariaMorse arvore;

    public InterfaceGrafica() {
        arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        criarJanela();
    }

    private void criarJanela() {
        JFrame frame = new JFrame("Árvore Morse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);


        setSize(570, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        painelPrincipal.add(inputField, BorderLayout.NORTH);
        ImageIcon morseImage = new ImageIcon("morse.png");
        JLabel morseLabel = new JLabel(morseImage);
        painelPrincipal.add(morseLabel, BorderLayout.CENTER);
        add(painelPrincipal);
        setVisible(true);


        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1));
        JButton botaoInserir = new JButton("Inserir Caractere");
        JButton botaoBuscar = new JButton("Buscar Caractere");
        JButton botaoDecodificar = new JButton("Decodificar Mensagem");
        JButton botaoExibir = new JButton("Exibir Árvore");
        JButton botaoSair = new JButton("Sair");
        painel.add(botaoInserir);
        painel.add(botaoBuscar);
        painel.add(botaoDecodificar);
        painel.add(botaoExibir);
        painel.add(botaoSair);




        botaoInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inserirCaractere();
            }
        });

        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCaractere();
            }
        });

        botaoDecodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decodificarMensagem();
            }
        });

        botaoExibir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirArvore();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.getContentPane().add(painel);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }

    private void inserirCaractere() {
        String caractereStr = JOptionPane.showInputDialog("Digite o caractere a ser inserido:");
        if (caractereStr == null || caractereStr.trim().isEmpty()) {
            return;
        }
        char caractere = caractereStr.trim().toUpperCase().charAt(0);

        String codigoMorse = JOptionPane.showInputDialog("Digite o código Morse correspondente:");
        if (codigoMorse == null || codigoMorse.trim().isEmpty()) {
            return;
        }

        // Remove espaços e valida o código Morse
        codigoMorse = codigoMorse.replace(" ", "").trim();
        if (!codigoMorse.matches("[.-]+")) {
            JOptionPane.showMessageDialog(null, "Código Morse inválido. Use apenas '.' e '-'.");
            return;
        }

        arvore.inserir(codigoMorse, caractere);
        JOptionPane.showMessageDialog(null, "Caractere inserido com sucesso!");
    }

    private void buscarCaractere() {
        String codigoMorse = JOptionPane.showInputDialog("Digite o código Morse para buscar:");
        if (codigoMorse == null || codigoMorse.trim().isEmpty()) {
            return;
        }

        // Remove espaços e valida o código Morse
        codigoMorse = codigoMorse.replace(" ", "").trim();
        if (!codigoMorse.matches("[.-]+")) {
            JOptionPane.showMessageDialog(null, "Código Morse inválido. Use apenas '.' e '-'.");
            return;
        }




        Character resultado = arvore.buscar(codigoMorse);
        if (resultado != null) {
            JOptionPane.showMessageDialog(null, "Código " + codigoMorse + " corresponde ao caractere: " + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Código não encontrado.");
        }
    }




    private void decodificarMensagem() {


        String mensagemMorse = JOptionPane.showInputDialog("Digite a mensagem em código Morse, separando letras por espaços:");
        if (mensagemMorse == null || mensagemMorse.trim().isEmpty()) {
            return;
        }

        String traducao = arvore.decodificarMensagem(mensagemMorse);
        JOptionPane.showMessageDialog(null, "Mensagem decodificada: " + traducao);
    }




    private void exibirArvore() {
        JFrame frameArvore = new JFrame("Visualização da Árvore");
        frameArvore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameArvore.setSize(1300, 600);

        PainelArvore painelArvore = new PainelArvore(arvore);
        frameArvore.getContentPane().add(painelArvore);

        frameArvore.setLocationRelativeTo(null);
        frameArvore.setVisible(true);
    }


}
