{2. Escribir un programa que:
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendidas.
iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la lista de
las ventas realizadas del producto.
Nota: El módulo debe retornar TRES árboles.

b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad
total de productos vendidos en la fecha recibida.
c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.
c. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto
con mayor cantidad de ventas.}
program P3_EJE2_TALLER;
const
 DC= 1000;
 DF=26;
 CV=99;
type
 ventas=record
  cod:integer;
  fec:integer;
  cant:integer;
 end;
 arbol=^nodo;
 nodo=record
  elem:ventas;
  HI:arbol;
  HD:arbol;
 end;
 ventas2=record
  cantTotal:integer;
  cod2:integer;
 end;
 arbol2=^nodo2;
 nodo2=record
  elem:ventas2;
  HI:arbol2;
  HD:arbol2;
 end;
 ListasV=^nodo4;
 nodo4=record
  elem:ventas;
  sig:ListasV;
 end;
 ventas3=record
  cod3:integer;
  lista:ListasV;
 end;
 arbol3=^nodo3;
 nodo3=record
  elem:ventas3;
  HI:arbol3;
  HD:arbol3;
 end;
 
procedure cargarArboles(var a1:arbol;var a2:arbol2;var a3:arbol3);
 Procedure aleatoriamente(Var v:ventas);
 Begin
  v.cod := random(DC);
  If (v.cod<>0)Then Begin
   v.fec := 2000 + random(DF)+1;
   v.cant := 1 + random(CV);
  End;
 End;
 procedure insertarDatos(var a:arbol;v:ventas);
 begin
  If(a=nil)Then begin
   new(a);
   a^.elem:=v;
   a^.HI:=nil;
   a^.HD:=Nil;
  end
  Else If(v.cod<a^.elem.cod)then
     insertarDatos(a^.HI,v)
  Else
     insertarDatos(a^.HD,v);
 end;
 procedure insertarDatos2(var a2:arbol2;v:ventas);
 begin
  If(a2=nil)then begin
    new(a2);
    a2^.elem.cod2:=v.cod;
    a2^.elem.cantTotal:=v.cant;
    a2^.HI:=nil;
    a2^.HD:=nil;
  end
  else if(v.cod=a2^.elem.cod2)then
     a2^.elem.cantTotal:=a2^.elem.cantTotal + v.cant
     else if(v.cod<a2^.elem.cod2)then
      insertarDatos2(a2^.HI,v)
     else
      insertarDatos2(a2^.HD,v);
 end;  
 procedure InsertarAdelante(var l:ListasV;v:ventas);
 var
  nue:ListasV;
 begin
  new(nue);
  nue^.elem:=v;
  nue^.sig:=l;
  l:=nue;
 end;
 procedure insertarDatos3(var a3:arbol3;v:ventas);
 begin
  if(a3=nil)then begin
   new(a3);
   a3^.elem.cod3:=v.cod;
   a3^.elem.lista:=nil;
   InsertarAdelante(a3^.elem.lista,v);
   a3^.HI:=nil;
   a3^.HD:=nil;
  end
  else if(v.cod=a3^.elem.cod3)then begin
    InsertarAdelante(a3^.elem.lista,v);
  end 
  else if(v.cod<a3^.elem.cod3)then begin
    insertarDatos3(a3^.HI,v);
  end
  else begin
    insertarDatos3(a3^.HD,v);
  end;
 end;
var
 v:ventas;
begin
 aleatoriamente(v);
 While(v.cod<>0)do begin
  insertarDatos(a1,v);
  insertarDatos2(a2,v);
  insertarDatos3(a3,v);
  aleatoriamente(v);
 end;
end;
procedure CantTotalFechas(a:arbol);
 function fecBuscada(a:arbol;fecha:integer):integer;
 begin
  if(a=nil)then
   fecBuscada:=0
  else if(a^.elem.fec=fecha)then
     fecBuscada:=a^.elem.cant + fecBuscada(a^.HI,fecha) + fecBuscada(a^.HD,fecha)
  else
     fecBuscada:=fecBuscada(a^.HI,fecha) + fecBuscada(a^.HD,fecha);
 end;
var
 fechaBus,total:integer;
begin
 write('ingrese una fecha que desea Buscar:');
 readln(fechaBus);
 total:=fecBuscada(a,fechaBus);
 if(total=0)then
   writeln('no se encontro la fecha')
 else
   writeln('la fecha tiene:',total,' de ventas');
end;
procedure imprimirArbol(a:arbol);
begin
 if(a<>nil)then begin
   imprimirArbol(a^.HI);
   writeln('CODIGO VENTA:',a^.elem.cod,' fecha de venta:',a^.elem.fec,' la cantidad de venta:',a^.elem.cant);
   imprimirArbol(a^.HD);
 end;
end;
procedure MayorCodProducto(a2:arbol2);
  procedure MayorCant(codi:integer;vent:integer;var m,MaxCod:integer);
  begin
   if(vent>m)then begin
    m:=vent;
    MaxCod:=codi;
   end;
  end;
  procedure CalcularMaximoCod(a2:arbol2;var m,MaxCod:integer);
  begin
   if(a2<>nil)then begin
     MayorCant(a2^.elem.cod2,a2^.elem.cantTotal,m,MaxCod);
     CalcularMaximoCod(a2^.HI,m,MaxCod);
     CalcularMaximoCod(a2^.HD,m,MaxCod);
   end;
  end;
var
 m,MaxC:integer;
begin
 m:=-1;
 CalcularMaximoCod(a2,m,MaxC);
 if(m=-1)Then
  writeln('no hubo datos')
 else
  writeln('este es el codigo con mas ventas:',MaxC);
end;
procedure imprimirArbol2(a2:arbol2);
begin
 if(a2<>nil)then begin
  imprimirArbol2(a2^.HI);
  writeln('codigo de venta:',a2^.elem.cod2,' cantidad de ventas totales:',a2^.elem.cantTotal);
  imprimirArbol2(a2^.HD);
 end;
end;
procedure imprimirArbol3(a3:arbol3);
var aux:ListasV;
begin
  if(a3<>nil)then begin
   aux:=a3^.elem.lista;
   While(aux<>nil)do begin
     writeln('este es el codigo:',aux^.elem.cod,' este es la cantidad:',aux^.elem.cant,' esta es la fecha:',aux^.elem.fec);
     aux:=aux^.sig;
   end;
   imprimirArbol3(a3^.HI);
   imprimirArbol3(a3^.HD);
  end;
end;
procedure MaxCodProduct(a3:arbol3);
 Function contarVentas(l:ListasV):integer;
 var cont:integer;
 begin
   cont:=0;
   While(l<>nil)do begin
    cont:=cont + 1;
    l:=l^.sig;
   end;
   contarVentas:=cont;
 end;
 procedure VentasProducto(a3:arbol3;var m,MaxCodigo:integer);
 var cantProdu:integer;
 begin
   if(a3<>nil)then begin
     cantProdu:=contarVentas(a3^.elem.lista);
     if(cantProdu>m)then begin
      m:=cantProdu;
      MaxCodigo:=a3^.elem.cod3;
     end;
     VentasProducto(a3^.HI,m,MaxCodigo);
     VentasProducto(a3^.HD,M,MaxCodigo);   
   end;
 end;
var
 m,maxCodigoProdu:integer;
begin
 m:=-1;
 VentasProducto(a3,m,maxCodigoProdu);
 if(m=-1)then
  writeln('no hubo datos')
 else
  writeln('este es el codigo con mas cantidad de ventas:',maxCodigoProdu);
end;
var
 a1:arbol;
 a2:arbol2;
 a3:arbol3;
Begin
 randomize;
 a1:=nil;
 a2:=nil;
 a3:=nil;
 cargarArboles(a1,a2,a3);
 imprimirArbol(a1);
 CantTotalFechas(a1);
 imprimirArbol2(a2);
 MayorCodProducto(a2);
 imprimirArbol3(a3);
 MaxCodProduct(a3);
End.