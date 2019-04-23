import javax.swing.*;
import java.awt.*;

public class MySliders extends JPanel {

    private MyJSliderPanel mjsp1;
    private MyJSliderPanel mjsp2;
    private MyJSliderPanel mjsp3;
    private JPanel sliderPanel;


    public MySliders(String str)  {
        JLabel text = new JLabel(str);
        sliderPanel = new JPanel();
        BoxLayout bl = new BoxLayout(sliderPanel, BoxLayout.Y_AXIS);
        sliderPanel.setLayout(bl);
        sliderPanel.add(text);
        mjsp1 = new MyJSliderPanel(new Color(255, 0, 0));
        sliderPanel.add(mjsp1);
        mjsp2 = new MyJSliderPanel(new Color(0,255,0));
        sliderPanel.add(mjsp2);
        mjsp3 = new MyJSliderPanel(new Color(0,0,255));
        sliderPanel.add(mjsp3);
    }

    public MyJSliderPanel getMjsp1() {
        return mjsp1;
    }

    public MyJSliderPanel getMjsp2() {
        return mjsp2;
    }

    public MyJSliderPanel getMjsp3() {
        return mjsp3;
    }

    public JPanel getSliderPanel() {
        return sliderPanel;
    }
}