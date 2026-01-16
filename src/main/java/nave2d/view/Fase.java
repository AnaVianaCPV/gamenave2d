package nave2d.view;

import nave2d.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Player player;
    private Timer timer;

    public Fase() {
        ImageIcon referencia = new ImageIcon(
                getClass().getResource("/image/fundopreto.jpg")
        );
        fundo = referencia.getImage();

        player = new Player();

        setFocusable(true);

        addKeyListener(new TecladoAdapter());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                posicionarPlayer();
            }
        });

        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
        posicionarPlayer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;

        if (fundo != null) {
            graficos.drawImage(fundo, 0, 0, getWidth(), getHeight(), null);
        }

        graficos.drawImage(
                player.getImagem(),
                player.getX(),
                player.getY(),
                this
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        player.limitarTela(getWidth()); // só horizontal
        repaint();
    }

    private void posicionarPlayer() {
        if (getWidth() <= 0 || getHeight() <= 0) return;

        int x = (getWidth() - player.getLargura()) / 2;
        int y = getHeight() - player.getAltura() - 20;

        player.setPosition(x, y);
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
