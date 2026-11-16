//Author: Matheus garrido
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Metodos {
    public Acidente[] RegistraAcidente(Acidente[] acidente){
        int i;
        for(i=0;i<10;i++){ 
            acidente[i] = new Acidente(); 
        }
        for(i=0;i<10;i++){
            acidente[i].cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da cidade: "));
            acidente[i].name = JOptionPane.showInputDialog("Digite o nome da cidade: ");
            acidente[i].qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes da cidade: "));
        }
        return acidente;
    }
    public void ConsultaQuantidade(Acidente [] acidente){
        int i;
        for (i=0;i<10;i++){
            if (acidente[i].qtd>100 && acidente[i].qtd<500){
                System.out.println("Codigo: "+acidente[i].cod
                        +"\n Nome: "+acidente[i].name
                        +" \n Quantidade: "+acidente[i].qtd
                        +"\n ****************************");
            }
        }
    }
    public void ConsultaMaiorMenor(Acidente [] acidente){
        int i;
        int codmenor = 0; int codmaior = 0; int maior = 0; int menor = 0;
        for(i=0;i<10;i++){
            if (i==0){
                maior = acidente[i].qtd;
                menor = acidente[i].qtd;
                codmaior = acidente[i].cod;
                codmenor = acidente[i].cod;
            }
            else{
                if (acidente[i].qtd>maior){
                    maior = acidente[i].qtd;
                    codmaior = acidente[i].cod;
                }
                else {
                    if (acidente[i].qtd<menor){
                        menor = acidente[i].qtd;
                        codmenor = acidente[i].cod;
                    }
                }
            }
        }
        System.out.println("A cidade com mais acidentes tem codigo "+codmaior+" com "+maior+" acidentes e "
                + "a cidade de menor quantidade tem como codigo "+codmenor+" com "+menor+" acidentes"
                        + "\n*************************************************************************"); 
        
    }
    public void AcimaMedia(Acidente [] acidente){
        int media = 0; int total = 0;
        int i; int cont = 0;
        for(i=0;i<10;i++){
            total += acidente[i].qtd;
        }
        media = total/10;
        for(i=0;i<10;i++){
            if(acidente[i].qtd>media){
                System.out.println("A cidade de codigo "+acidente[i].cod+" esta acima da media de acidentes");
                cont += 1;
            }
        }
        System.out.println("********************************************************************************* \n"
                + "Numero de cidades acima da media: "+cont);
    }
//    public void procedures{
//        public Acidente[] GravaAcidente(Acidente[]acidente)throws IOException{
//            int i; String fileName= "ArquivoAcidente.txt";
//            BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
//            for(i=0;i<10;i++){
//                acidente[i] = new Acidente();
//            }
//            for(i=0;i<10;i++){
//                acidente[i].cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da cidade: "));
//                gravar.write(Integer.toString(acidente[i].cod));gravar.newLine();
//                acidente[i].name = JOptionPane.showInputDialog("Digite o nome da cidade: ");
//                gravar.write(acidente[i].name);gravar.newLine();
//                acidente[i].qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes da cidade: "));
//                
//            }
//        }
//    }
//    public void 
}