package PARCIAL2;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
public class PARCIAL2 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Medicion m1 = new Medicion(1, 47332, 10, false);
        Medicion m2 = new Medicion(2, 47332, 20, false);
        Medicion m3 = new Medicion(3, 47332, 30, true);
        Medicion m4 = new Medicion(4, 47332, 40, true);
        Medicion m5 = new Medicion(5, 47332, 50, true);

        Zona z1 = new Zona("Varela corre", 5);
        Zona z2 = new Zona("Quilmes a los tiros", 5);

        z1.agregarMedicion(m1);
        z1.agregarMedicion(m2);
        z1.agregarMedicion(m3);

        z2.agregarMedicion(m4);
        z2.agregarMedicion(m5);

        Empresa e1 = new Empresa("Logic Pro");

        e1.agregarZona(z1);
        e1.agregarZona(z2);

        System.out.print(e1.toString());
        System.out.print(e1.zonaMayorCantMediciones());
    }
}
