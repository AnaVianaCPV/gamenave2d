package nave2d.view;

import javax.swing.*;

public class Tela extends JFrame {
    public Tela(){
        add(new Fase());
        setTitle("Nave 2D");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }

}
