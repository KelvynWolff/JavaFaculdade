
package javaapplication3;

import java.util.Scanner;

public class VerificarIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        
        if (idade < 18) {
            System.out.println("Você é menor de idade.");
        } else if (idade >= 18 && idade < 60) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é idoso.");
        }
        
        scanner.close();
    }
}
