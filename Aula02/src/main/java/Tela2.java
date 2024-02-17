
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

    public class Tela2 extends JFrame{
        
            JButton b1 = new JButton("B1");
            JButton b2 = new JButton("B2");
            JButton b3 = new JButton("B3");
            JButton b4 = new JButton("B4");
            
        public Tela2(){
            setLayout(new BorderLayout());
            setSize(800, 600);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            add(b1, BorderLayout.PAGE_START);
            add(b2, BorderLayout.LINE_END);
            add(b3, BorderLayout.CENTER);
            add(b4, BorderLayout.PAGE_END);
    
}
        
        public static void main (String[] args){
            Tela2 teste = new Tela2();
            teste.setVisible(true);
        }
    }