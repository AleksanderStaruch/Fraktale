import javax.swing.*;
import java.awt.*;

public abstract class Obrazek extends JPanel {

    protected Color background;
    protected Color obraz;
    protected int grubosc;
    protected int iteracje;

    public Obrazek() {
        obraz=new Color(
                (int)(Math.random()*256),
                (int)(Math.random()*256),
                (int)(Math.random()*256)
        );
        background=new Color(
                (int)(Math.random()*256),
                (int)(Math.random()*256),
                (int)(Math.random()*256)
        );
        this.setPreferredSize(new Dimension(700,700));
    }

    public void setBack(Color background) {
        this.background = background;
    }
    public void setObraz(Color obraz) {
        this.obraz = obraz;
    }
    public void setGrubosc(int grubosc) {
        this.grubosc = grubosc;
    }
    public void setIteracje(int iteracje) {
        this.iteracje = iteracje;
    }

    public Color getBackground() {
        return background;
    }
    public abstract String getName();
    //public int getIteracje() {return iteracje;}
    //public int getGrubosc() {return grubosc;}
}