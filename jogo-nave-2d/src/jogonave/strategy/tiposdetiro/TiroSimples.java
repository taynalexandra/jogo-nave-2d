package jogonave.strategy.tiposdetiro;

import java.awt.Color;
import java.awt.Graphics;

import jogonave.strategy.ContextTiro;
import jogonave.strategy.StrategyTiro;

/**
 * Classe que implementa o Tiro Simples, que segue a posição da nave.
 * 
 * @author Tayná Alexandra
 */
public class TiroSimples implements StrategyTiro {

    @Override
    public void carregar(ContextTiro tiro, Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(tiro.getX() - 2, tiro.getY() + 1, 4, 15);

    }

    @Override
    public void atualizar(ContextTiro tiro) {

        int tiroY = tiro.getY();
        tiroY -= tiro.getVELOCIDADE();
        tiro.setY(tiroY);

        //Passa a coordenada X da nave para o tiro seguir a mesma posição.
        int naveX = tiro.getNave().getX();
        naveX += 12;
        tiro.setX(naveX);

    }

}
