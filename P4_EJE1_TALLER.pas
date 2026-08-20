{a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por código de producto.
 De cada producto deben quedar almacenados su código,la cantidad total de unidades vendidas y el monto total.
 De cada venta se cargan código de venta, código del producto vendido, cantidad de unidades vendidas y precio unitario.
 El ingreso de las ventas finaliza cuando se lee el código de venta 0.
b. Imprimir el contenido del árbol ordenado por código de producto.
c. Retornar el menor código de producto.
d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor que se recibe como parámetro.
e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos valores recibidos (sin incluir) como parámetros.}
program P4_EJE1_TALLER;
type
 producto = record
  codigo:integer;
  cantTot:integer;
  montoTot:real;
 end;
 ventas=record
  codVen:integer;
  codProdu:integer;
  cant:integer;
  precio:real;
 end;
 arbol=^nodo;
 nodo=record
  elem:producto;
  HI:arbol;
  HD:arbol;
 end;
procedure CargarArbol(var a:arbol);
   procedure cargarVenta(var p:ventas);
   begin
     p.codVen:=random(51)*100;
     if(p.codVen<>0)then begin
      p.codProdu:=random(100)+1;
      p.cant:=random(15)+1;
      p.precio:=(random(1000)+ 150.50);
     end;
   end;
   procedure Actualizar(var p:producto;v:ventas);
   begin
      p.cantTot:=v.cant;
      p.montoTot:=v.precio * v.cant;
      p.codigo:=v.codProdu;
   end;
   procedure InsertarVentas(var a:arbol;v:ventas);
   var
    p:producto;
   begin
    if(a=nil)then begin
      new(a);
      Actualizar(p,v);
      a^.elem:=p;
      a^.HI:=nil;
      a^.HD:=nil;
    end
    else if(v.codProdu=a^.elem.codigo)then begin
        a^.elem.cantTot:=a^.elem.cantTot + v.cant;
        a^.elem.montoTot:=a^.elem.montoTot +(v.cant * v.precio);
    end
    else if(v.codProdu<a^.elem.codigo)then
        InsertarVentas(a^.HI,v)
    else
        InsertarVentas(a^.HD,v);
   end;
var 
 v:ventas;
begin
 cargarVenta(v);
 while(v.codVen<>0)do begin
   InsertarVentas(a,v);
   cargarVenta(v);
 end;
end;
procedure ImprimirArbol(a:arbol);
begin
 if(a<>nil)then begin
  ImprimirArbol(a^.HI);
  writeln('codigo producto:',a^.elem.codigo,' cantidad total:',a^.elem.cantTot,' precio total:',a^.elem.montoTot:0:0);
  ImprimirArbol(a^.HD);
 end;
end;
function CodigoMinimo(a:arbol):integer;
begin 
  if(a=nil)then
    CodigoMinimo:=-1
  else if(a^.HI=nil)then
   CodigoMinimo:=a^.elem.codigo
  else
   CodigoMinimo:=CodigoMinimo(a^.HI);
end;
procedure ArbolesMenores(a:arbol;var c:integer);
   function MenorValor(a:arbol;v:integer):integer;
   begin
     if(a=nil)then 
       MenorValor:=0
     else if(a^.elem.codigo>=v)then
       MenorValor:=MenorValor(a^.HI,v)
     else
       MenorValor:=1+ MenorValor(a^.HI,v) + MenorValor(a^.HD,v);
   end;
var
 v:integer;
begin
 write('ingrese un valor de codigo de producto:');
 readln(v);
 c:=MenorValor(a,v);
end;
procedure MontoTotalReci(a:arbol;var tot:real);
   function BuscarRecibidos(a:arbol;min,max:integer):real;
   begin
      if(a=nil)then
       BuscarRecibidos:=0
      else if(a^.elem.codigo<=min)then
        BuscarRecibidos:=BuscarRecibidos(a^.HD,min,max)
      else if(a^.elem.codigo>=max)then
        BuscarRecibidos:=BuscarRecibidos(a^.HI,min,max)
      else
        BuscarRecibidos:=a^.elem.montoTot + BuscarRecibidos(a^.HI,min,max) + BuscarRecibidos(a^.HD,min,max);
   end;
var
 min,max:integer;
begin
 write('ingrese un minimo:');
 readln(min);
 write('ingrese un maximo:');
 readln(max);
 tot:=BuscarRecibidos(a,min,max);
end;
var 
 a:arbol;
 minC:integer;
 c:integer;
 tot:real;
begin
randomize;
 a:=nil;
 CargarArbol(a);
 ImprimirArbol(a);
 minC:=CodigoMinimo(a);
 ArbolesMenores(a,c);
 MontoTotalReci(a,tot);
end.