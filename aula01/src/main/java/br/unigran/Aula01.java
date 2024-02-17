package br.unigran;

import br.unigran.entidade.Pessoa;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kelvy
 */
public class Aula01 {

    public static void main(String[] args) {
        List pessoas = new LinkedList();
        do{
            Pessoa pessoa = new Pessoa();
        pessoa.setNome(JOptionPane.showInputDialog("Digite seu Nome:"));
        pessoa.setCPF(JOptionPane.showInputDialog("Informe o seu CPF: "));
        pessoas.add(pessoa);
        }while(JOptionPane.showConfirmDialog(null, "Sim!") == 0);

        JOptionPane.showMessageDialog(null, "Seu nome eh: " + pessoas, "Titulo",
                JOptionPane.QUESTION_MESSAGE);
    }
}
