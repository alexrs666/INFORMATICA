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
public class Libro {
    private String titulo;
    private Autor primerAutor;
    private String editorial;
    private int anioEdicion;
    private String ISBN;
    private double precio;
    public Libro(String unTitulo,String unaEditorial,int unAnioEdicion,Autor unPrimerAutor,String unISBN,double unPrecio){
        titulo=unTitulo;
        primerAutor=unPrimerAutor;
        editorial=unaEditorial;
        anioEdicion=unAnioEdicion;
        ISBN=unISBN;
        precio=unPrecio;
    }
    public Libro(String titulo,String editorial,Autor primerAutor,String ISBN){
        this.titulo=titulo;
        this.editorial=editorial;
        this.anioEdicion=2015;
        this.primerAutor=primerAutor;
        this.ISBN=ISBN;
        this.precio=100;
    }
    public Libro(){
        
    }
    public String getTitulo(){
        return titulo;
    }
    public Autor getPrimerAutor(){
        return primerAutor;
    }
    public String getEditorial(){
        return editorial;
    }
    public int getAnioEdicion(){
        return anioEdicion;
    }
    public String getISBN(){
        return ISBN;
    }
    public double getPrecio(){
        return precio;
    }
    public void setTitulo(String unTitulo){
        titulo=unTitulo;
    }
    public void setPrimerAutor(Autor unPrimerAutor){
        primerAutor=unPrimerAutor;
    }
    public void setEditorial(String unaEditorial){
        editorial=unaEditorial;
    }
    public void setAnioEdicion(int unAnioEdicion){
        anioEdicion=unAnioEdicion;
    }
    
    public void setISBN(String unISBN){
        ISBN=unISBN;
    }
    public void setPrecio(double unPrecio){
        precio=unPrecio;
    }
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", primerAutor=" + primerAutor + ", editorial=" + editorial + ", anioEdicion=" + anioEdicion + ", ISBN=" + ISBN + ", precio=" + precio + '}';
    }
}
