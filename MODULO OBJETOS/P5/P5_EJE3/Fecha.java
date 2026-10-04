/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE3_JAVA;

/**
 *
 * @author AlexRs
 */
public class Fecha {
    private String ciudad;
    private String dia;

    public Fecha(String ciudad, String dia) {
        setCiudad(ciudad);
        setDia(dia);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
