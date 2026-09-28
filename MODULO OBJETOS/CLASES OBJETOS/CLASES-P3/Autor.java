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
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    public Autor(String unNombre,String unaBiografia,String unOrigen){
        nombre=unNombre;
        biografia=unaBiografia;
        origen=unOrigen;
    }
    public Autor(){
        nombre="-";
        biografia="-";
        origen="-";
    }
    public String getNombre(){
        return nombre;
    }
    public String getBiografia(){
        return biografia;
    }
    public String getOrigen(){
        return origen;
    }
    public void setNombre(String unNombre){
        nombre=unNombre;
    }
    public void setBiografia(String unaBiografia){
        biografia=unaBiografia;
    }
    public void setOrigen(String unOrigen){
        origen=unOrigen;
    }
    public String toString(){
        return "nombre Autor:"+nombre+" biografia:"+biografia+" este es el origen:"+origen;
    }
}
