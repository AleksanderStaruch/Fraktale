import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChangeObject {

    public ChangeObject(MySliders a, JPanel p1, Obrazek p2) {
        ChangeListener cl = new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                Color kolor = new Color(
                        a.getMjsp1().getValue(),
                        a.getMjsp2().getValue(),
                        a.getMjsp3().getValue()
                );
                p1.setBackground(kolor);
                p2.setObraz(kolor);
            }
        };
        a.getMjsp1().addChangeListener(cl);
        a.getMjsp2().addChangeListener(cl);
        a.getMjsp3().addChangeListener(cl);
    }
}