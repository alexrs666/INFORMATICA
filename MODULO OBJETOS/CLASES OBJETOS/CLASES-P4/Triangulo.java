/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_4;

/**
 *
 * @author AlexRs
 */
public class Triangulo extends Figura{
    private double ladoA;
    private double ladoB;
    private double ladoC;
    public Triangulo(double unladoA,double unladoB,double unladoC,String unColorRelleno,String unColorLinea){
        super(unColorRelleno,unColorLinea);
        setLadoA(unladoA);
        setLadoB(unladoB);
        setLadoC(unladoC);
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
    public void setLadoA(double unLadoA){
        ladoA=unLadoA;
    }
    public void setLadoB(double unLadoB){
        ladoB=unLadoB;
    }
    public void setLadoC(double unLadoC){
        ladoC=unLadoC;
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

    public String toString() {
        return "Triangulo{" + "ladoA=" + ladoA + ", ladoB=" + ladoB + ", ladoC=" + ladoC + " info colores y calculos:"+super.toString();
    }
}
