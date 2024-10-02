import javax.swing.*;
import java.awt.*;

public class PainelArvore extends JPanel {
    private ArvoreBinariaMorse arvore;

    public PainelArvore(ArvoreBinariaMorse arvore) {
        this.arvore = arvore;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharNo(g, arvore.raiz, getWidth() / 2, 30, getWidth() / 4);
    }

    private void desenharNo(Graphics g, No no, int x, int y, int espacamento) {
        if (no != null) {
            g.setColor(Color.DARK_GRAY);
            String texto = no.caractere != null ? no.caractere.toString() : "*";
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(texto, x - 5, y + 5);

            if (no.esquerdo != null) {
                // desenha linha para o filho esquerdo
                int xEsq = x - espacamento;
                int yEsq = y + 50;
                g.drawLine(x, y + 15, xEsq, yEsq - 15);
                // Chama recursivamente para o filho esquerdo
                desenharNo(g, no.esquerdo, xEsq, yEsq, espacamento / 2);
            }

            if (no.direito != null) {
                // desenha linha para o filho direito
                int xDir = x + espacamento;
                int yDir = y + 50;
                g.drawLine(x, y + 15, xDir, yDir - 15);
                desenharNo(g, no.direito, xDir, yDir, espacamento / 2);
            }
        }
    }
}
