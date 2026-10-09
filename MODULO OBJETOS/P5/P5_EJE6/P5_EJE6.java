package TestBalanza;
/*
* @Autor AlexRs
*/
/*
6- Queremos representar dos versiones de balanzas comerciales para ser utilizadas en
verdulerías.
La versión básica mantiene el número de compra actual y los productos correspondientes
a la compra actual (como máximo 30). La versión avanzada, es igual a la básica pero
además mantiene dos contadores para la compra actual: uno cuenta la cantidad de
productos de verdulería y otro la cantidad de productos de frutería. De los productos se
conoce: descripción, rubro (indica si es verdura o fruta), peso en kilos y precio por kilo.
Ambas versiones, al finalizar una compra, emiten un Ticket con nro. de compra, resumen
(String) y monto total a pagar.
a) Genere las clases necesarias. Provea constructores para iniciar los objetos de su modelo
a partir de la información necesaria. En particular, las balanzas inician con número de
compra actual 1, sin productos, con capacidad de guardar un máximo de 30 productos;
además, la versión avanzada inicia con sus contadores a 0.
b) Implemente los métodos necesarios, en las clases que corresponda, para:
i- Reiniciar la balanza, preparándola para una nueva compra. Para esto:
incrementa el nro. de compra actual y borra los productos almacenados; además, la
versión avanzada reinicia sus contadores a 0.
ii- Registrar un producto, esto es: agrega el producto en la balanza; además la
versión avanzada debe incrementar el contador adecuado según este producto sea
verdura o fruta.
iii- Obtener el monto total a pagar por la compra, teniendo en cuenta que es la
suma de los precios finales de los productos cargados (el precio final de un
producto es peso_en_kilos*precio_por_kilo).
iv- Finalizar la compra, teniendo en cuenta que: la balanza de versión básica crea y
retorna un Ticket con nro. de compra, resumen (que concatena de cada producto:
descripción y su precio final), y monto total de la compra; además la balanza de
versión avanzada añade al resumen de ese Ticket la cantidad de frutas y cantidad de
verduras de la compra.
c) Realice un programa que instancie dos balanzas (una básica y una avanzada). Registre
algunos productos en cada balanza. Finalice la compra en cada balanza y muestre todos los
datos de los tickets obtenidos. Luego, reinicie cada balanza para una nueva compra.
*/
public class MainBalanza {
    
    public void main(){
        Producto p1 = new Producto("Tomaco", "verduras", 2, 10 );
        Producto p2 = new Producto("Mandarina", "fruta", 2, 30);
        Producto p3 = new Producto("Pera", "fruta", 2, 50);
        Producto p4 = new Producto("Cebolla", "verdura", 2, 25);
        Producto p5 = new Producto("Papa", "verdura", 2, 990);

        BalanzaBasica b1 = new BalanzaBasica();
        BalanzaAvanzada ba1= new BalanzaAvanzada();

        b1.registrarProducto(p1);
        b1.registrarProducto(p2);
        b1.registrarProducto(p3);
        b1.registrarProducto(p4);

        ba1.registrarProducto(p1);
        ba1.registrarProducto(p2);
        ba1.registrarProducto(p4);
        ba1.registrarProducto(p5);

        System.out.println(b1.finalizarCompra());
        System.out.println(ba1.finalizarCompra());

        b1.reiniciarBalanza();



    }
}
