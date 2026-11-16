//Author: Matheus garrido
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Acidente {
    int cod;
    String name;
    int qtd;
    
    Acidente(){
        this(0,"",0);
    }
    
    Acidente(int codigo,String nome, int quantidade){
        cod = codigo;
        name = nome;
        qtd = quantidade;
    }
}