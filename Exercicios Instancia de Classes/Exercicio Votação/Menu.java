//Author: Matheus Garrido
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Menu {
    public static void main(String args[])throws IOException{
        Votacao [] votacao = new Votacao[200];
        Metodos m = new Metodos();
        int opc = 0;
        while(opc!=9){
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - cadastra voto \n"
                    + "2 - classifica seção \n"
                    + "3 - gravar registros \n"
                    + "4 - mostrar indicadores \n"
                    + "9 - finalizar sistema"));
                switch(opc){
                    case 1: votacao = m.fcadastravotacao(votacao);
                        break;
                    case 2: votacao = m.fclassificasecao(votacao);
                        break;
                    case 3: votacao = m.gravavotacao(votacao);
                        break;
                    case 4: m.pmostraindicadores(votacao);
                        break;
                    case 9: JOptionPane.showMessageDialog(null,"Fim");
                        System.exit(0);
                        break;
                    default: JOptionPane.showMessageDialog(null,"Opção inválida");    
                }
        }
    }
}
