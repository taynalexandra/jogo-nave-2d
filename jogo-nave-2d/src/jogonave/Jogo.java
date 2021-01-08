package jogonave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import jogonave.strategy.ContextTiro;

/**
 *
 * @author Tayná Alexandra
 */
public class Jogo extends JPanel implements ActionListener {

    private Nave nave;
    private Timer temporizador;
    private ContextTiro tiro;

    public Jogo() {
        setFocusable(true);
        setDoubleBuffered(true);

        nave = new Nave();

        addKeyListener(new TecladoAdapter());

        temporizador = new Timer(3, this);
        temporizador.start();
    }

    public void paint(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        nave.carregarNave(g);

        List<ContextTiro> tiros = nave.getTiros();
        
        for (ContextTiro listaDeTiros : tiros) {
            tiro = listaDeTiros;
            tiro.carregarTiro(tiro, g);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        nave.atualizarNave();

        List<ContextTiro> tiros = nave.getTiros();
        
        for (ContextTiro listaDeTiros : tiros) {
            tiro = listaDeTiros;
            if (tiro.isVisible()) {
                tiro.atualizarTiro(tiro);
            } else {
                tiros.remove(listaDeTiros);
            }
        }
        
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            nave.keyPressed((e));
        }

        @Override
        public void keyReleased(KeyEvent e) {

            nave.keyRelease(e);
        }
    }

}
