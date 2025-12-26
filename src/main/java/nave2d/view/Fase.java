package nave2d.view;

import javax.swing.*;
import java.awt.*;

public class Fase extends JPanel {
    private Image fundo;

    public Fase(){
        ImageIcon referencia = new ImageIcon("");
        fundo = referencia.getImage();

    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        g.dispose();

    }
}
