package jogonave.strategy;

import java.awt.Graphics;

import jogonave.Nave;

/**
 * Classe ContextTiro possui atributo da interface StrategyTiro, assim consegue
 * acessar as classes que a implementam: TiroModificado e TiroSimples.
 *
 * @author Tayná Alexandra
 */
public class ContextTiro {

    private int x, y;
    private boolean isVisible;

    private static final int ALTURA = 450;
    private static int VELOCIDADE = 2;

    //Atributo da interface.
    private StrategyTiro strategy;
    private Nave nave;

    //O construtor recebe uma das implementações da interface.
    public ContextTiro(Nave nave, int x, int y, StrategyTiro strategy) {
        this.nave = nave;

        this.x = x;
        this.y = y;

        isVisible = true;

        this.strategy = strategy;

    }

    /**
     * Método que carrega o tiro, acessando uma das classes que implementa a
     * interface.
     *
     * @param tiro
     * @param g
     */
    public void carregarTiro(ContextTiro tiro, Graphics g) {
        strategy.carregar(tiro, g);
    }

    /**
     * Método que atualiza a posição do tiro, acessando uma das classes que
     * implementa a interface.
     *
     * @param tiro
     */
    public void atualizarTiro(ContextTiro tiro) {
        strategy.atualizar(tiro);
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public static int getAltura() {
        return ALTURA;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

}
