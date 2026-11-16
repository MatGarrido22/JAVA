import javax.swing.*;
public class Ex05 {
    public static void main(String args[]){
        int a = 0; int b = 0; int c = 0; double delta = 0.0; double raiz1 = 0; double raiz2 = 0;
        a = Integer.parseInt(JOptionPane.showInputDialog("Digite quem acompanha o X²: "));
        b = Integer.parseInt(JOptionPane.showInputDialog("Digite quem acompanha o X: "));
        c = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero sozinho: "));
        delta = (b*b) - (4*a*c);
        raiz1 = ((-b) + Math.pow(delta,0.5))/(2*a);
        raiz2 = ((-b) - Math.pow(delta,0.5))/(2*a);
        System.out.println("Raiz 1: "+raiz1);
        System.out.println("Raiz 2: "+raiz2);
    }
}
