{3. Implementar un programa modularizado para una librería. Implementar módulos para:
a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.
b. Imprimir el contenido del árbol ordenado por código de producto.
c. Retornar el código de producto con mayor cantidad de unidades vendidas.
d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.
e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros.}
program P4_EJE3_TALLER;
type
 producto=record
  codP:integer;
  cantTot:integer;
  montoTot:real;
 end;
 ventas=record
  codV:integer;
  codPV:integer;
  cantUni:integer;
  precio:real;
 end;
 arbol=^nodo;
 nodo=record
  elem:producto;
  HI:arbol;
  HD:arbol;
 end;
procedure CargarArbol(var a:arbol);
   procedure leerVentas(var v:ventas);
   begin
     v.codv:=random(21)-1;
     if(v.codv<>-1)then begin
       v.codPV:=random(100)+1;
       v.cantUni:=random(15)+1;
       v.precio:=random(1000) + 150.50;
     end;
   end;
   procedure Actualizar(var p:producto;v:ventas);
   begin
    p.codP:=v.codPv;
    p.cantTot:=v.cantUni;
    p.montoTot:=v.cantUni * v.precio;
   end;
   procedure insertarProductos(var a:arbol;v:ventas);
   var
    p:producto;
   begin
    if(a=nil)then begin
     new(a);
     Actualizar(p,v);
     a^.elem:=p;
     a^.HI:=Nil;
     A^.HD:=Nil;
    end
    else If(v.codPV=a^.elem.codP)then begin
       a^.elem.montoTot:=a^.elem.montoTot + (v.cantUni*v.precio);
       a^.elem.cantTot:=a^.elem.cantTot + v.cantUni;
    end
    else if(v.codPV<a^.elem.codP)then
        insertarProductos(a^.HI,v)
    else
        insertarProductos(a^.HD,v);
   end;
var
 v:ventas;
begin
 leerVentas(v);
 while(v.codV<>-1)do begin
   insertarProductos(a,v);
   leerVentas(v);
 end;
end;
procedure ImprimirOrdenado(a:arbol);
begin
  if(a<>nil)then begin
    ImprimirOrdenado(a^.HI);
    writeln('este es el codigo:',a^.elem.codP,' este es la cant total:',a^.elem.cantTot,' este es el monto total:',a^.elem.montoTot:0:2);
    ImprimirOrdenado(a^.HD);
  end;
end;
procedure MayorCantVendidas(a:arbol;var MaxCOD:integer);
 procedure MayorCantidad(a:arbol;var m,maximo:integer);
 begin
    if(a<>nil)then begin
     if(a^.elem.cantTot>m)then begin
        m:=a^.elem.cantTot;
        maximo:=a^.elem.codP;
     end;
     MayorCantidad(a^.HI,m,maximo);
     MayorCantidad(a^.HD,m,maximo);
    end;
  end;
var
 max:integer;
begin
 max:=-1;
 MayorCantidad(a,max,MaxCOD);
 if(max=-1)then
  writeln('no hubo un maximo')
 else
  writeln('este es el codigo con mayor cantidad de ventas:',MaxCOD,' con:',max,' ventas');
end;
procedure MenorCodRecibido(a:arbol;var cant:integer);
   function cantidadValores(a:arbol;v:integer):integer;
   begin
     if(a=nil)then
      cantidadValores:=0
     else if(a^.elem.codP>=v)then
       cantidadValores:=cantidadValores(a^.HI,V)
     else
       cantidadValores:=1 + cantidadValores(a^.HI,v)+cantidadValores(a^.HD,v);
   end;
var
 valor:integer;
begin
 write('ingrese un valor:');
 readln(valor);
 cant:=cantidadValores(a,valor);
 if(cant=0)then
  writeln('no hay cantidad de valores menores al ingresado')
 else
  writeln('esta es la cantidad de valores menores:',cant);
end;
procedure RangoValores(a:arbol;var montoFinal:real);
  function SumatoriaRango(a:arbol;m1,m2:integer):real;
  begin
    if(a=nil)then
     SumatoriaRango:=0
    else if(a^.elem.codP<=m1)then
      SumatoriaRango:=SumatoriaRango(a^.HD,m1,m2)
    else if(a^.elem.codP>=m2)then
      SumatoriaRango:=SumatoriaRango(a^.HI,m1,m2)
    else
      SumatoriaRango:=a^.elem.montoTot + SumatoriaRango(a^.HI,m1,m2) + SumatoriaRango(a^.HD,m1,m2);
  end;
var
 v1,v2:integer;
begin
 write('ingrese un valor minimo:');
 readln(v1);
 write('ingrese un valor maximo:');
 readln(v2);
 montoFinal:=SumatoriaRango(a,v1,v2);
 if(montoFinal=0)then
  writeln('no hubo un rango entre esos valores')
 else
  writeln('este es la suma entre esos rangos:',montoFinal:0:2);
end;
var
 a:arbol;
 m:integer;
 c:integer;
 montoRango:real;
begin
randomize;
 a:=nil;
 cargarArbol(a);
 ImprimirOrdenado(a);
 MayorCantVendidas(a,m);
 MenorCodRecibido(a,c);
 RangoValores(a,montoRango);
end.