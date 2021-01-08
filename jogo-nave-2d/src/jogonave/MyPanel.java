package jogonave;

import javax.swing.JFrame;

/**
 *
 * @author Tayná Alexandra
 */
public class MyPanel extends JFrame {

    public MyPanel() {
        add(new Jogo());
        setTitle("**** Jogo Nave - Tayná Alexandra ****");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyPanel();
    }
}
