package br.unigran.aula02;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Aula02 extends JFrame implements ActionListener{
    JButton btnOK = new JButton("Click");
    JButton btnNOK = new JButton("Não Click");
    JButton help = new JButton("Help");
    public Aula02() {
        setLayout(null);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aula2");
        //posicionamento manual
        btnOK.setBounds(0, 0, 100, 50);
        btnNOK.setBounds(100, 0, 100, 50);
        btnNOK.setBackground(Color.red);
        help.setBounds(200, 0, 100, 50);
        help.setBackground(Color.yellow);
        
        //add em tela
        add(btnOK);
        btnOK.addActionListener(this);
        add(btnNOK);
        btnNOK.addActionListener(this);
        add(help);
        help.addActionListener(this);
    }
    public static void main(String[] args){
        Aula02 teste = new Aula02();
        teste.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnOK) ){
        JOptionPane.showMessageDialog(this, "Mensagem");
        } else if(e.getSource().equals(btnNOK)) {
            new Tela2().setVisible(true);
    } else { 
    System.exit(0);
    }
}
    
}
