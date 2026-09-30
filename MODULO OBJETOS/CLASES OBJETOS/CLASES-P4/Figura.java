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
public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;

    public Figura(String unCR,String unCL){
        setColorLinea(unCL);
        setColorRelleno(unCR);
    }
    public String getColorRelleno() {
        return colorRelleno;
    }
    public void despintar(){
        setColorRelleno("blanco");
        setColorLinea("negro");
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    public String toString() {
        return "Figura{" + "colorRelleno=" + getColorRelleno() + ", colorLinea=" + getColorLinea()+" calcular area=" +this.calcularArea()+
               " calcular el Perimetro="+this.calcularPerimetro();
    }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
