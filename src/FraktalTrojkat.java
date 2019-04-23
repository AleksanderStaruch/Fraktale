import java.awt.*;

public class FraktalTrojkat extends Obrazek {

    public int[][] tab;

    public FraktalTrojkat() {
        super();
        grubosc=1;
        iteracje=513;
    }

    public String getName() {
        return "Trojkat";
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(background);

        tab= new int[iteracje][];
        for(int i=1;i<iteracje;i++) {
            tab[i] = new int[i];
        }

        if(iteracje>3) {
            tab[1][0] = 1;
            tab[2][0] = 1;
            tab[2][1] = 1;
        }

        for(int i=3;i<tab.length;i++) {
            tab[i][0]=1;
            tab[i][tab[i].length-1]=1;
            for(int j=1;j<tab[i].length-1;j++) {
                tab[i][j]=(tab[i-1][j-1]+tab[i-1][j])%2;
            }
        }

        for(int i=1;i<tab.length;i++) {
            for(int j=0;j<tab[i].length;j++) {
                if(tab[i][j]%2==1) {
                    g.setColor(obraz);
                }else {
                    g.setColor(background);
                }
                g.fillRect(j*grubosc+50,(i-1)*grubosc+50,grubosc,grubosc);
            }
        }
    }
}