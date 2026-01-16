package nave2d.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Player {

    private int x, y;
    private int dx;
    private final int velocidade = 6;

    private Image imagem;
    private int largura, altura;

    public Player() {
        load();
    }

    private void load() {
        ImageIcon referencia = new ImageIcon(
                Objects.requireNonNull(
                        getClass().getResource("/player/navgray.png")
                )
        );

        Image original = referencia.getImage();

        largura = 64;
        altura = 64;

        imagem = original.getScaledInstance(
                largura,
                altura,
                Image.SCALE_SMOOTH
        );
    }

    public void update() {
        x += dx;
    }

    public void limitarTela(int larguraTela) {
        if (x < 0) x = 0;
        if (x > larguraTela - largura) {
            x = larguraTela - largura;
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        switch (codigo) {
            case KeyEvent.VK_LEFT -> dx = -velocidade;
            case KeyEvent.VK_RIGHT -> dx = velocidade;
        }
    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
