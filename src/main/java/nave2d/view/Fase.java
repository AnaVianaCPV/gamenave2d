package nave2d.view;

import javax.swing.*;
import java.awt.*;

public class Fase extends JPanel {
    private Image fundo;

    public Fase() {
        try {
            ImageIcon referencia = new ImageIcon(getClass().getResource("/image/fundopreto.jpg"));
            fundo = referencia.getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (fundo != null) {
            graficos.drawImage(fundo, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
