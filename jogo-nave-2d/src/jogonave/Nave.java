package jogonave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import jogonave.strategy.ContextTiro;
import jogonave.strategy.tiposdetiro.TiroModificado;
import jogonave.strategy.tiposdetiro.TiroSimples;

/**
 *
 * @author Tayná Alexandra
 */
public class Nave {

    private int x, y;
    private int MoverNave;
    private List<ContextTiro> tiros;

    private boolean tiroSimples = false;

    public Nave() {
        this.x = 20;
        this.y = 435;

        tiros = new ArrayList<ContextTiro>();
    }

    /**
     * Desenha/Carrega nave na tela.
     *
     * @param g
     */
    public void carregarNave(Graphics g) {

        g.setColor(Color.ORANGE);
        g.fillRect(x - 2, y + 1, 4, 15);
        g.fillRect(x + 10, y + 1, 4, 4);
        g.fillRect(x + 6, y + 4, 4, 4);
        g.fillRect(x + 2, y + 7, 4, 4);

        g.fillRect(x + 27, y + 1, 4, 15);
        g.fillRect(x + 15, y + 1, 4, 4);
        g.fillRect(x + 19, y + 4, 4, 4);
        g.fillRect(x + 23, y + 7, 4, 4);

        g.fillRect(x + 13, y - 7, 3, 20);

        g.fillRect(x + 3, y - 17, 22, 10);
    }

    /**
     * Atualiza a posição da nave, sem deixar ela encostar nas estremidades
     * esquerda e direita.
     */
    public void atualizarNave() {
        int estremidadeEsquerda = 15;
        int estremidadeDireita = 440;
        if (x + MoverNave > estremidadeEsquerda && x + MoverNave < estremidadeDireita) {
            x += MoverNave;
        }
    }

    /**
     * Trata as teclas pressionadas no teclado.
     *
     * @param tecla
     */
    public void keyPressed(KeyEvent tecla) {

        int codigoTeclado = tecla.getKeyCode();

        if (codigoTeclado == KeyEvent.VK_LEFT) {
            MoverNave = -3;
        }

        if (codigoTeclado == KeyEvent.VK_RIGHT) {
            MoverNave = 3;
        }

        //Trata o F3 para alternar o tipo de tiro com Strategy.
        if (codigoTeclado == KeyEvent.VK_F3) {
            tiroSimples = !tiroSimples;
        }

        //Instancia o tipo de tiro pelo ContextTiro, que possui um atrituto da interface do Strategy.
        if (codigoTeclado == KeyEvent.VK_SPACE) {
            if (tiroSimples) {
                this.tiros.add(new ContextTiro(this, this.x + 14, this.y - 35, new TiroSimples()));
            } else {
                this.tiros.add(new ContextTiro(this, this.x + 14, this.y - 35, new TiroModificado()));
            }

        }
    }

    public void keyRelease(KeyEvent event) {

        int codigoTeclado = event.getKeyCode();

        if (codigoTeclado == KeyEvent.VK_LEFT) {
            MoverNave = 0;
        }

        if (codigoTeclado == KeyEvent.VK_RIGHT) {
            MoverNave = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<ContextTiro> getTiros() {
        return tiros;
    }

}
