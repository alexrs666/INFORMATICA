/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas_java.Practica_5.P5_EJE1_JAVA;

/**
 *
 * @author AlexRs
 */
public class Subsidio {
    private double monto;
    private String motivo;
    private boolean otorgado;

    public Subsidio(double monto, String motivo) {
        setMonto(monto);
        setMotivo(motivo);
        setOtorgado(false);
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
}
