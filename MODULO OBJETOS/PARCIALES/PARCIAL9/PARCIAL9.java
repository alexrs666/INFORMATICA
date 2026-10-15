package PARCIAL9;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    Representar una empresa de alquiler de bauleras. La empresa tiene nombre, dirección, costo por mes y
mantiene una estructura que representa el espacio de almacenamiento con los sectores con bauleras
(1..S sectores y 1..B bauleras por sector) que almacenará los clientes que reservan cada una. De cada
cliente se conoce dni, nombre, teléfono, localidad y si contrata seguro adicional.
1) Genere las clases necesarias. Provea constructores para iniciar:
• - los clientes a partir de la información necesaria;
• - la empresa a partir de una dirección, costo por mes y las dimensiones del espacio de
almacenamiento (S y B) y sin clientes cargados.
2) Implemente los métodos necesarios, en las clases que corresponda, para:
• a) Ingresar un cliente al almacén, teniendo en cuenta que los clientes primero completan el primer
sector en lugares sucesivos, luego el segundo y así siguiendo.
• b) Listar los clientes de la localidad de Los Hornos que alquilan bauleras del sector X. Se debe
devolver un String con las representaciones de los mismos con el siguiente formato:
"dni, nombre, teléfono, localidad, asegurado"
• c) Obtener el número del sector con más clientes que hayan contratado seguro.
• d) Obtener un String que represente la empresa siguiendo el ejemplo:
"Empresa: Nombre - Dirección; Costo por mes.
Sector 1:
Baulera 1; dni, nombre, teléfono, localidad, asegurado
Baulera 2; dni, nombre, teléfono, localidad, sin seguro
...
Sector 2:
..."
3) Realice un programa que cree la empresa "Storage" con 5 sectores de 3 bauleras cada uno. Simule el
alquiler de varios clientes y compruebe el correcto funcionamiento de los métodos implementados.
*/
public class PARCIAL9 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Empresa e= new Empresa("Storage","av francia",123,5,3);
        Cliente c1= new Cliente(123,"alex",4564,"ezpe",false);
        Cliente c2= new Cliente(123,"alex",4564,"los Hornos",false);
        Cliente c3= new Cliente(123,"alex",4564,"ezpe",true);
        Cliente c4= new Cliente(123,"alex",4564,"ezpe",false);
        
        e.ingresarCliente(c1);
        e.ingresarCliente(c2);
        e.ingresarCliente(c3);
        e.ingresarCliente(c4);
        
        System.out.println(e.listarClientes("los Hornos", 1));
        System.out.println("este sector tiene mas clientes con seguros:"+e.nroSectorConMasClientes());
        System.out.println(e.toString());
    }
}
