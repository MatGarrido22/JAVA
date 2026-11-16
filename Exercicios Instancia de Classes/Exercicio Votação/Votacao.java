//Author: Matheus Garrido
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Votacao {
    int numsec;
    int numcand;
    public Votacao(){
        this(0,0);
    }
    
    public Votacao (int numerosecao, int numerocandidato){
        numsec = numerosecao;
        numcand = numerocandidato;
    }
}
