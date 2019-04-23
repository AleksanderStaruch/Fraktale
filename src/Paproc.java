import java.awt.*;

class Paproc extends Obrazek{

    static double x=1;
    static double y=1;
    static int r;

    public Paproc() {
        super();
        grubosc=1;
        iteracje=10000;
    }

    public String getName() {
        return "Paproc";
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(background);
        int w= getWidth();
        int h= getHeight();
        for(int i=1;i<iteracje;i++){
            System.out.println(i+" "+x+" "+y);
            r=(int)(Math.random()*100);
            if(r<=1){
                x=0;
                y=0.16*y;
            }else{
                if(r<=8){
                    x=0.20*x-0.26*y;
                    y=0.23*x+0.22*y+0.106;
                }else{
                    if(r<=15){
                        x=-0.15*x+0.28*y;
                        y=0.26*x+0.24*y+0.44;
                    }else{
                        x=0.85*x+0.04*y;
                        y=-0.04*x+0.85*y+1.06;
                    }
                }
            }
            g.setColor(obraz);
            g.fillRect(h/2-(int)((x)*100),w-(int)((y)*100),grubosc,grubosc);
        }
    }
}