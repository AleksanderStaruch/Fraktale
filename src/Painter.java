import javax.swing.*;

public class Painter extends Thread {

    int tempo;
    int przeskok;
    JFrame frame;
    Obrazek obrazek;

    public Painter(Obrazek obrazek, JFrame frame,int tempo)  {
        this.tempo = tempo;
        this.przeskok = obrazek.iteracje;
        this.frame = frame;
        this.obrazek = obrazek;
    }

    public void paint(){
        while(true){
            for(int i=1;i<przeskok;i++) {

                obrazek.setIteracje(i+1);
                obrazek.repaint();

                frame.setContentPane(obrazek);

                obrazek.setVisible(true);
                try {
                    sleep(tempo);
                }catch(InterruptedException ie){
                    System.out.println("ie exception");
                }
                SwingUtilities.updateComponentTreeUI(frame);
            }
        }

    }

    public void run() {
        paint();
    }
}
