import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        new Main();
    }

    public Main() {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI() {
        JFrame jf = new JFrame();
        jf.setTitle("Fraktale");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(380,0);
        jf.setResizable(false);
        //PanelWyboru panelWyboru = new PanelWyboru(jf);
        //jf.setContentPane(panelWyboru);
        jf.setPreferredSize(new Dimension(980, 730));
        jf.pack( );
        jf.setVisible(true);

        Painter painter = new Painter(new FraktalTrojkat(),jf,10);
        painter.start();

    }
}