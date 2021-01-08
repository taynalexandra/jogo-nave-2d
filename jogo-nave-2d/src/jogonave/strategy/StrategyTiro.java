package jogonave.strategy;

import java.awt.Graphics;

/**
 * Interface StrategyTiro que é implementada pelas duas classes de tipos de tiro
 * da nave.
 *
 * @author Tayná Alexandra
 */
public interface StrategyTiro {

    /**
     * Desenha/Carrega o tiro na tela.
     *
     * @param tiro
     * @param g
     */
    public void carregar(ContextTiro tiro, Graphics g);

    /**
     * Atualiza o tiro.
     *
     * @param tiro
     */
    public void atualizar(ContextTiro tiro);
}
