import javax.swing.*;
import java.awt.*;

public class MyObrazekListRenderer extends JPanel implements ListCellRenderer{

    protected JLabel jl;

    public MyObrazekListRenderer() {
        jl = new JLabel();
        jl.setFont(
                new Font(Font.MONOSPACED, Font.BOLD, 20)
        );
        add(jl);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Obrazek ob = (Obrazek) value;
        this.setBackground(Color.WHITE);
        jl.setText(ob.getName());
        return this;
    }
}
