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
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(String unCR,String unCL,double radio){
        super(unCR,unCL);
        setRadio(radio);
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double calcularPerimetro(){
        return 2*Math.PI*this.radio;
    }
    public double calcularArea(){
        return Math.PI *(this.radio * this.radio);
    }
    public String toString() {
        return "Circulo{" + "radio=" + this.radio +" info colores y calculos "+super.toString();
    }
}
