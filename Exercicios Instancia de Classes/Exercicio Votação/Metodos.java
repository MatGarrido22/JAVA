//Author: Matheus Garrido
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Metodos {
    public Votacao[] fcadastravotacao(Votacao [] votacao){
        int i;
        Random gerador = new Random();
        for (i=0;i<200;i++){
            votacao[i] = new Votacao();
            votacao[i].numsec = gerador.nextInt(10)+1;
            votacao[i].numcand = gerador.nextInt(300)+1;
//              CASO PRECISE O USUARIO DIGITAR
//            votacao[i].numsec = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da seção: "));
//            votacao[i].numcand = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do candidato: "));  
        }
        JOptionPane.showMessageDialog(null,"Registrados com sucesso");
        return votacao;
    }
    public Votacao[] fclassificasecao(Votacao [] votacao){
        int i,j;
        int mat[][] = new int[200][2];
        for(i=0;i<200;i++){
            for (j=0;j<2;j++){
                mat[i][j] = votacao[i].numsec;
                if(j==1){
                    mat[i][j] = votacao[i].numcand;
                }
                //mat[votacao[i].numsec][j]= votacao[j].numcand;
            }
        }    
        for (i=0;i<199;i++){
            for(j=0;j<2;j++){
                if(mat[i][j]>mat[i+1][j]){
                    int reserva = 0;
                    reserva = mat[i][j];
                    mat[i+1][j] = mat[i][j];
                    mat[i][j] = reserva;
                }
            }
        }
        for(i=0;i<200;i++){
            System.out.println("Voto "+i+" ");
            for(j=0;j<2;j++){
                if(j==0){
                   System.out.print("Secao = "+mat[i][j]+" "); 
                }
                else{
                    System.out.println("Candidato = "+mat[i][j]);
                }
            }
        }
//                int reserva;
//                reserva = votacao[i].numcand;
//                votacao[i].numcand = votacao[i+1].numcand;
//                votacao[i+1].numcand = reserva
        return votacao;
    }
}

//**************
//    public void pmostraindicadores(){
//        int opc = 0;
//        opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Quantidade eleitores por seção \n"
//                + "2 - Numero da seção com mais e menos eleitores \n"
//                + "3 - Quantidade de votos por candidato \n"
//                + "4 - Exibir 10 candidatos mais votados e suas quantidades \n"
//                + "9 - Sair dos indicadores"));
//        switch(opc){
//            case 1:
//                pqtdsecao();
//                break;
//            case 2:
//                pmaiormenor();
//                break;
//            case 3:
//                pqtdcandidato();
//                break;
//            case 4:
//                pdezmaisvotados();
//                break;
//            case 9:
//                System.exit(0);
//                break;
//            default:
//                JOptionPane.showMessageDialog(null,"Opção inválida");
//        }
//    }
//    public void pqtdsecao(){
//        
//    }
//    public void pmaiormenor(){
//        
//    }
//    public void pqtdcandidato(){
//        
//    }
//    public void pdezmaisvotados(){
//        
//    }
//}