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
        }
        JOptionPane.showMessageDialog(null,"Registrados com sucesso");
        return votacao;
    }
    
    public Votacao[] fclassificasecao(Votacao[] votacao) {
        int mat[][] = new int[200][2];
        int i,j;
        for (i = 0; i < 200; i++) {
            mat[i][0] = votacao[i].numsec;
            mat[i][1] = votacao[i].numcand;
        }
         for (i = 0; i < 199; i++) {
                for (j = 0; j < 199 - i; j++) {
                    if (mat[j][0] > mat[j+1][0] ||
                       (mat[j][0] == mat[j+1][0] &&
                        mat[j][1] > mat[j+1][1])) {

                        int reserva = mat[j][0];
                        mat[j][0] = mat[j+1][0];
                        mat[j+1][0] = reserva;

                        reserva = mat[j][1];
                        mat[j][1] = mat[j+1][1];
                        mat[j+1][1] = reserva;
                    }
                }
            }
            // Mostra os votos classificados
            for (i = 0; i < 200; i++) {
                System.out.println("Voto " + (i+1));
                System.out.println("Secao = " + mat[i][0]
                        + " Candidato = " + mat[i][1]);
            }
            System.out.println("*************************************************");
            JOptionPane.showMessageDialog(null,"Classificados com sucesso");
            for (i = 0; i < 200; i++) {
               votacao[i].numsec  = mat[i][0];
               votacao[i].numcand = mat[i][1];
            }
            return votacao;
        }
    
    // INDICADORES
    public void pmostraindicadores(Votacao[] votacao){
        int opc = 0;
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                  "1 - Quantidade eleitores por seção \n"
                + "2 - Numero da seção com mais e menos eleitores \n"
                + "3 - Quantidade de votos por candidato \n"
                + "4 - Exibir 10 candidatos mais votados e suas quantidades \n"
                + "9 - Sair dos indicadores"));
        switch(opc){
            case 1:
                pqtdsecao(votacao);
                break;
            case 2:
                pmaiormenor(votacao);
                break;
            case 3:
                pqtdcandidato(votacao);
                break;
            case 4:
                pdezmaisvotados(votacao);
                break;
            case 9:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opção inválida");
        }
    }
    
    public void pqtdsecao(Votacao[] votacao){
        int i,j;
        int vet[] = new int[10];
        for (i=0;i<200;i++){
            for(j=1;j<11;j++){
                if(votacao[i].numsec == j){
                    vet[j-1] += 1;
                }
            }
        }
        for(i=0;i<10;i++){
            System.out.println("Quantidade de eleitores na secao " + (i+1)+ ": " + vet[i]);
        }     
        System.out.println("*********************************************");
    }
    
    public void pmaiormenor(Votacao[] votacao){
        int i,j;
        int pos[] = new int[2];
        int maior = 0; int menor = 0;  
        int vet[] = new int[10];
        for (i=0;i<200;i++){
            for(j=1;j<11;j++){
                if(votacao[i].numsec == j){
                    vet[j-1] += 1;
                }
            }
        }
        for(i=0;i<10;i++){
            if(i==0){
                maior = vet[i];
                menor = vet[i];
            }
            else{
                if (vet[i]>maior){
                    maior = vet[i];
                    pos[0] = (i+1);
                }
                if(vet[i]<menor){
                    menor = vet[i];
                    pos[1] = (i+1);
                }
            }
        }
        System.out.println("Secao com mais eleitores: " + pos[0] + "\n"
                + "Secao com menos eleitores: " + pos[1] + "\n"
                + "**********************************************************");
    }
    
    public void pqtdcandidato(Votacao [] votacao){
        int i;
        int vet1[] = new int[301];
        // Indice do vetor 1 são os numeros dos candidatos
        // Valor do vetor 1 é a quantidade de votos de cada candidato
        for(i=0;i<200;i++){
            vet1[votacao[i].numcand] += 1;
        }
        for(i=1;i<301;i++){
            System.out.println("Candidato "+i+" teve "+vet1[i]+" voto(s)");
        }
        System.out.println("************************************************");
    }
    
    public void pdezmaisvotados(Votacao [] votacao){
        int i,j;
        int qtd[] = new int[301];
        int num[] = new int[301];
        for(i=0;i<200;i++){
            qtd[votacao[i].numcand] += 1;
        }
        for (i = 0; i < 301; i++) {
            num[i] = i;
        }
        for (i = 0; i < 300; i++) {
            for (j = 0; j < 300 - i; j++) {
                if(qtd[j]< qtd[j+1]){
                    // troca quantidade 
                    int reserva = qtd[j];
                    qtd[j] = qtd[j+1];
                    qtd[j+1] = reserva;
                    // troca numero do candidato
                    reserva = num[j];
                    num[j] = num[j+1];
                    num[j+1] = reserva;
                }
            }   
        }
        System.out.println("TOP 10:");
        for(i=0;i<10;i++){
            System.out.println("Posicao "+(i+1)+" = candidato "+num[i]+" com "+qtd[i]+" votos");
        }
        System.out.println("*******************************************");
    }
    public Votacao[] gravavotacao(Votacao[] votacao)throws IOException{
            int i; String fileName= "Votação2021.txt";
            BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
            for(i=0;i<200;i++){
                gravar.write("Seção: "+Integer.toString(votacao[i].numsec));gravar.newLine();
                gravar.write("Candidato: "+Integer.toString(votacao[i].numcand));gravar.newLine();
            }
            gravar.close();
            JOptionPane.showMessageDialog(null,"Arquivo gerado");
            return votacao;
    }
}
