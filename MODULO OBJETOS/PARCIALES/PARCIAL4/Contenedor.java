/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL4;

/**
 *
 * @author Usuario
 */
public class Contenedor {
    private int codigo;
    private String empresa;
    private int peso;
    private int cantDias;

    public Contenedor(int codigo, String empresa, int peso, int cantDias) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.peso = peso;
        this.cantDias = cantDias;
    }

    public int getCantDias() {
        return cantDias;
    }

    public String toString() {
        return " Contenedor{" + "codigo=" + codigo + ", empresa=" + empresa + ", peso=" + peso + ", cantDias=" + cantDias + '}';
    }

    
}
