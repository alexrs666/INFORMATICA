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
public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String colorRelleno;
    private String colorLinea;
    public Triangulo(double unladoA,double unladoB,double unladoC,String unColorRelleno,String unColorLinea){
        setLadoA(unladoA);
        setLadoB(unladoB);
        setLadoC(unladoC);
        setColorRelleno(unColorRelleno);
        setColorLinea(unColorLinea);
    }
    
    public Triangulo(){
    }
    
    public double getLadoA(){
        return ladoA;
    }
    
    public double getLadoB(){
        return ladoB;
    }
    public double getLadoC(){
        return ladoC;
    }
    public String getColorRelleno(){
        return colorRelleno;
    }
    public String getColorLinea(){
        return colorLinea;
    }
    public void setLadoA(double unLadoA){
        ladoA=unLadoA;
    }
    public void setLadoB(double unLadoB){
        ladoB=unLadoB;
    }
    public void setLadoC(double unLadoC){
        ladoC=unLadoC;
    }
    public void setColorRelleno(String unosColoresRelleno){
        colorRelleno=unosColoresRelleno;
    }
    public void setColorLinea(String unosColoresLinea){
        colorLinea=unosColoresLinea;
    }
    public double calcularPerimetro(){
        double perimetro;
        perimetro=ladoA + ladoB + ladoC;
        return perimetro;
    }
    public double calcularArea(){
        double s;
        s = calcularPerimetro()/2.0;
        return Math.sqrt(s*(s-ladoA)*(s-ladoB)*(s-ladoC));
    }
}
