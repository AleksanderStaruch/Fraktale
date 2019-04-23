import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public 
	class MyJSliderPanel
	extends JPanel {

    private JSlider js;
	
	public MyJSliderPanel(Color color){
		this(color, null);
	}
	
	public MyJSliderPanel(Color color, ChangeListener cl){
        JPanel jp = new JPanel();
        js = new JSlider(0, 255);
        JLabel jl = new JLabel();

        jl.setText(""+js.getValue());
        jp.setBackground(color);
        js.addChangeListener(
				e -> jl.setText(""+js.getValue())
		);
		js.addChangeListener(cl);

		add(jp);
		add(js);
		add(jl);
	}
	
	public void addChangeListener(ChangeListener cl){
		js.addChangeListener(cl);
	}
	
	public int getValue(){
		return js.getValue();
	}
}