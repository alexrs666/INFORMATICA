/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialito;

/**
 *
 * @author Estudiante
 */
public class Feria {
    private String nombre;
    private String fechaInicio;
    private Organizador organizador;
    private Empresa [][] agenda;
    private final int DS=15;
    private int DP;
    private int[] DL;

    public Feria(String nombre, String fechaInicio, Organizador organizador, int DP) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.organizador = organizador;
        this.DP = DP;
        this.agenda = new Empresa[this.DP][this.DS];
        this.DL = new int [this.DP];
        for(int i=0;i<this.DP;i++){
            this.DL[i]=0;
        }
    }
    public void agregarEmpresa(int nroPasillo,Empresa empresa){
        this.agenda[nroPasillo-1][this.DL[nroPasillo-1]]=empresa;
    }
    public String listarEmpresa(int nroPasillo){
        String aux="";
        for(int i=0;i<this.DL[nroPasillo-1];i++){
            aux+=this.agenda[nroPasillo-1][i].toString()+"\n";
        }
        return aux;
    }
    public int contarRubro(String rubro){
        int contador=0;
        for(int i=0;i<this.DP;i++){
            for(int j=0;j<this.DL[i];j++){
                if(this.agenda[i][j].getRubro().equals(rubro))
                    contador++;
            }
        }
        return contador;
    }
    public String totString(){
        String aux="Feria:"+nombre+" ,"+fechaInicio+" ,"+organizador.toString()+"\n";
        for(int i=0;i<this.DP;i++){
            aux+="pasillo:"+(i+1)+"\n";
            for(int j=0;j<this.DL[i];j++){
                aux+="Stand:"+(j+1)+this.agenda[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    
    
}
