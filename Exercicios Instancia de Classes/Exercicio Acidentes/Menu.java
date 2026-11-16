//Author: Matheus garrido
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Menu {
    public static void main(String[]args){
        Acidente[] acidente = new Acidente[10];
        Metodos m = new Metodos();
        int opc=0;
        while(opc!=9){
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                  "1 - Registrar acidente "            
                + "\n 2 - Consulta por quantidade de acidentes"
                + "\n 3 - Consulta por estatísticas de acidentes"
                + "\n 4 - Acidentes acima da média das 10 cidades"
                + "\n 9 - finalizar programa"));
            switch(opc){
                case 1: acidente = m.RegistraAcidente(acidente);
                    break;
                case 2: m.ConsultaQuantidade(acidente);
                    break;
                case 3: m.ConsultaMaiorMenor(acidente);
                    break;
                case 4: m.AcimaMedia(acidente);
                    break;
                case 9: JOptionPane.showMessageDialog(null,"Fim");
                    break;
                default: JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }
}
