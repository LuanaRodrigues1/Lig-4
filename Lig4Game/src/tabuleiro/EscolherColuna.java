package tabuleiro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class EscolherColuna extends JPanel implements KeyListener {

        private static final int NUM_QUADRADOS = 7;
        private static final int TAM_QUADRADO = 50;
        private static final int TAM_BOLINHA = 30;
        private static final int TAM_JANELA = NUM_QUADRADOS * TAM_QUADRADO;

        private int posicaoBolinha = 1;
        private Color corBolinha = Color.YELLOW;

        public EscolherColuna() {
            setPreferredSize(new Dimension(TAM_JANELA, TAM_QUADRADO));
            setFocusable(true);
            addKeyListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < NUM_QUADRADOS; i++) {
                int x = i * TAM_QUADRADO;
                int y = 0;
                g.setColor(Color.BLACK);
                Border borda = BorderFactory.createLineBorder(Color.BLACK);
                setBorder(borda);
                g.drawRect(x, y, TAM_QUADRADO, TAM_QUADRADO);
                if (i == posicaoBolinha - 1) {
                    g.setColor(corBolinha);
                    g.fillOval(x + (TAM_QUADRADO / 2) - (TAM_BOLINHA / 2),
                            y + (TAM_QUADRADO / 2) - (TAM_BOLINHA / 2), TAM_BOLINHA, TAM_BOLINHA);
                }
            }
        }

        private void moverBolinha(int novaPosicao) {
            if (novaPosicao >= 1 && novaPosicao <= NUM_QUADRADOS) {
                posicaoBolinha = novaPosicao;
                repaint();
            }
        }

        public void setCorBolinha(Color cor) {
            corBolinha = cor;
            repaint();
        }
        
        public int getPosicaoBolinha() {
            return posicaoBolinha;
        }

        // Setter para o atributo posicaoBolinha
        public void setPosicaoBolinha(int posicaoBolinha) {
            this.posicaoBolinha = posicaoBolinha;
            repaint(); // Redesenha a bolinha ao atualizar a posição
        }
        

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_D) {
                moverBolinha(posicaoBolinha + 1);
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                moverBolinha(posicaoBolinha - 1);
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JOptionPane.showMessageDialog(this, "A bolinha está no quadrado " + posicaoBolinha);
            } else if (e.getKeyCode() == KeyEvent.VK_C) {
                Color corEscolhida = JColorChooser.showDialog(this, "Escolher Cor", corBolinha);
                if (corEscolhida != null) {
                    setCorBolinha(corEscolhida);
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }