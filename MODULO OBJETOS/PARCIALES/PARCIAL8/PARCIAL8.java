package PARCIAL8;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class PARCIAL8 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        OrdenPractica op= new OrdenPractica("mejoralito",10000000,12343,34324,"4324","hasdh643",1,"14/07/2020");
        OrdenMedicamento om= new OrdenMedicamento("1235",123,"12343","34324",2,"13/06/2022");
        
        Medicamento m1= new Medicamento("Tuculforten",1243);
        Medicamento m2= new Medicamento("Tuculforten",1243);
        Medicamento m3= new Medicamento("Tuculforten",1243);
        Medicamento m4= new Medicamento("Tuculforten",1243);
        Medicamento m5= new Medicamento("Tuculforten",1243);
        
        om.agregarMedicamento(m1);
        om.agregarMedicamento(m2);
        om.agregarMedicamento(m3);
        om.agregarMedicamento(m4);
        om.agregarMedicamento(m5);
        
        System.out.println(om.toString());
        System.out.println(op.toString());
        System.out.println("¿necesita seguimiento?"+op.seguimiento());
        System.out.println("¿necesita seguimiento?"+om.seguimiento());
        
    }
}
