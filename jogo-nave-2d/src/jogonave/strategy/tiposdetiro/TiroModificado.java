package jogonave.strategy.tiposdetiro;

import java.awt.Color;
import java.awt.Graphics;

import jogonave.strategy.ContextTiro;
import jogonave.strategy.StrategyTiro;

/**
 * Classe que implementa o Tiro Modificado, que não segue a posição da nave.
 *
 * @author Tayná Alexandra
 */
public class TiroModificado implements StrategyTiro {

    @Override
    public void carregar(ContextTiro tiro, Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(tiro.getX(), tiro.getY() + 1, 4, 15);

    }

    @Override
    public void atualizar(ContextTiro tiro) {
        if (tiro.getY() > tiro.getAltura()) {
            tiro.setVisible(false);
        }
        int tiroY = tiro.getY();
        tiroY -= tiro.getVELOCIDADE();
        tiro.setY(tiroY);

        if (tiro.getY() > tiro.getAltura()) {
            tiro.setVisible(false);
        }

    }

}
