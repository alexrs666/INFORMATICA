/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java;
/**
 *
 * @author AlexRs
 */
public class Estante {
    private int DF=20;
    private int DL;
    private Libro[] vecLibro;
    
    public Estante(){
        this.DL=0;
        this.vecLibro = new Libro[DF];
    }
    //INCISO C
    public Estante(int N){
       this.DL = 0;
       this.DF = N;  
       this.vecLibro = new Libro[N];
    }
    //INCISO I
    public int cantLibros(){
        return DL;
    }
    //INCISO II
    public boolean estanteLleno(){
       return DL==DF;
    }
    //INCISO III
    public void agregarLibro(Libro unLibro){
        if(!estanteLleno())
            vecLibro[DL++]=unLibro;
        else
            System.out.println("el estante esta lleno no se va a poder agregar libro");
    }
    //INCISO IV
    public Libro devolverLibro(String unTitulo){
        int i=0;
        while((i<DL)&&(!vecLibro[i].getTitulo().equals(unTitulo)))
            i++;
        
        if(i<DL)
            return vecLibro[i];
        else
            return null;
    }
}