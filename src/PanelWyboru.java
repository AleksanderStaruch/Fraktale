import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelWyboru extends JPanel{

    private static String inp;

    public PanelWyboru(JFrame jf) {
        inp = (String)JOptionPane.showInputDialog(null, "Wybierz",
                "Wybierz", JOptionPane.QUESTION_MESSAGE,null,new String[] {"Trojkat" ,"Paproc"},"Trojkat");

        JPanel settings = new JPanel();
        BoxLayout bl = new BoxLayout(settings,BoxLayout.Y_AXIS);
        settings.setLayout(bl);

        JPanel jp1 = new JPanel();
        MySliders ms1 = new MySliders("Background");
        jp1.add(ms1.getSliderPanel());
        settings.add(jp1);

        JPanel jp2 = new JPanel();
        MySliders ms2 = new MySliders("Picture");
        jp2.add(ms2.getSliderPanel());
        settings.add(jp2);

        FraktalTrojkat trojkat = new FraktalTrojkat();
        Paproc paproc = new Paproc();

        ArrayList<Obrazek> al = new ArrayList<>();
        al.add(trojkat);
        al.add(paproc);
        JComboBox<Obrazek> jcb = new JComboBox<>(
                al.stream().toArray(Obrazek[]::new)
        );
        jcb.setRenderer(new MyObrazekListRenderer());
        settings.add(jcb);

        JButton refresh = new JButton("REFRESH");
        refresh.isDefaultButton();
        settings.add(refresh);

        JButton drawnew = new JButton("DRAW NEW");
        drawnew.isDefaultButton();
        settings.add(drawnew);

        this.add(settings,BorderLayout.LINE_START);

        /*
        FraktalTrojkat fraktalTrojkat = new FraktalTrojkat();
        Paproc fraktalaPaproc = new Paproc();

        switch (inp){
            case "Trojkat":
                System.out.println("1");
                new ChangeBack(ms1,jp1,fraktalTrojkat);
                new ChangeObject(ms2,jp2,fraktalTrojkat);
                refresh.addActionListener(
                        e1->{
                            String tmp1 = (String)JOptionPane.showInputDialog(null, "Grubosc",
                                    "Trojkat", JOptionPane.QUESTION_MESSAGE,null,null,fraktalTrojkat.grubosc+"");

                            String tmp2 = (String)JOptionPane.showInputDialog(null, "Iteracja",
                                    "Trojkat", JOptionPane.QUESTION_MESSAGE,null,null,fraktalTrojkat.iteracje+"");

                            fraktalTrojkat.repaint();
                            fraktalTrojkat.setGrubosc(Integer.parseInt(tmp1));
                            fraktalTrojkat.setIteracje(Integer.parseInt(tmp2));
                            //this.setBackground(fraktalTrojkat.getBackground());
                            Painter painter = new Painter(new FraktalTrojkat(),jf,1);
                            painter.start();
                        }
                );
                //this.setBackground(fraktalTrojkat.getBackground());
                this.add(fraktalTrojkat,BorderLayout.CENTER);
                break;
            case "Paproc":
                System.out.println("2");
                new ChangeBack(ms1,jp1,fraktalaPaproc);
                new ChangeObject(ms2,jp2,fraktalaPaproc);
                refresh.addActionListener(
                        e2->{
                            String tmp1 = (String)JOptionPane.showInputDialog(null, "Grubosc",
                                    "Paproc", JOptionPane.QUESTION_MESSAGE,null,null,fraktalaPaproc.grubosc+"");

                            String tmp2 = (String)JOptionPane.showInputDialog(null, "Iteracja",
                                    "Paproc", JOptionPane.QUESTION_MESSAGE,null,null,fraktalaPaproc.iteracje+"");

                            fraktalaPaproc.repaint();
                            fraktalaPaproc.setGrubosc(Integer.parseInt(tmp1));
                            fraktalaPaproc.setIteracje(Integer.parseInt(tmp2));
                            //this.setBackground(fraktalaPaproc.getBackground());
                        }
                );
                //this.setBackground(fraktalaPaproc.getBackground());
                this.add(fraktalaPaproc,BorderLayout.CENTER);
                break;
            default:
                break;
        }*/

        jcb.addActionListener(
                e -> {
                    inp=al.get(jcb.getSelectedIndex()).getName();
                    System.out.println(inp);
                    switch (inp){
                        case "Trojkat":
                            //this.remove(fraktalaPaproc);
                            break;
                        case "Paproc":
                            //this.remove(fraktalTrojkat);
                            break;
                        default:
                            break;
                    }
                    new ChangeBack(ms1,jp1,al.get(jcb.getSelectedIndex()));
                    new ChangeObject(ms2,jp2,al.get(jcb.getSelectedIndex()));
                    drawnew.addActionListener(
                            e1->{
                                String tmp1 = (String)JOptionPane.showInputDialog(null, "Grubosc",
                                        al.get(jcb.getSelectedIndex()).getName(), JOptionPane.QUESTION_MESSAGE,null,null,al.get(jcb.getSelectedIndex()).grubosc+"");

                                String tmp2 = (String)JOptionPane.showInputDialog(null, "Iteracja",
                                        al.get(jcb.getSelectedIndex()).getName(), JOptionPane.QUESTION_MESSAGE,null,null,al.get(jcb.getSelectedIndex()).iteracje+"");

                                al.get(jcb.getSelectedIndex()).repaint();
                                al.get(jcb.getSelectedIndex()).setGrubosc(Integer.parseInt(tmp1));
                                al.get(jcb.getSelectedIndex()).setIteracje(Integer.parseInt(tmp2));
                            }
                            //this.setBackground(al.get(jcb.getSelectedIndex()).getBackground());
                    );
                    this.add(al.get(jcb.getSelectedIndex()),BorderLayout.CENTER);
                }
        );

    }
}