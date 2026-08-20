{4.- Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 6) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio -1.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 20 elementos) con los productos del rubro 3.
Considerar que
puede haber más o menos de 20 productos del rubro 3. Si la cantidad de
productos del rubro 3
es mayor a 20, almacenar los primeros 30 que están en la lista e ignore el
resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno
de los dos
métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d).}
Program P1_EJE4_TALLER;
Const 
 DFR = 30;
 DF = 6;
Type 
 subCodR = 1..DF;
 subRubro = 1..DFR;
 producto = Record
  cod:integer;
  codR:subCodR;
  precio:real;
 End;
 lista = ^nodo;
 nodo = Record
  elem:producto;
  sig:lista;
 End;
 vecListas = array[subCodR] Of lista;
 vecRubro = array[subRubro] of producto;
Procedure leerProducto(Var p:producto);
Begin
 write('ingrese el precio del producto:');
 readln(p.precio);
 If (p.precio<>-1)Then
  Begin
   write('ingrese un codigo de producto:');
   readln(p.cod);
   write('ingrese un codigo de rubro del producto:');
   readln(p.codR);
  End;
End;
Procedure InsertarOrdenado(var l:lista;p:producto);
Var ant,act,nue:lista;
Begin
 new(nue);
 nue^.elem := p;
 nue^.sig := Nil;
 ant:=l;
 act := l;
 While (act<>Nil)And(act^.elem.cod>nue^.elem.cod) Do
  Begin
   ant := act;
   act := act^.sig;
  End;
 If (l=act)Then
  Begin
   nue^.sig := l;
   l := nue;
  End
 Else
  ant^.sig := nue;
 nue^.sig := act;
End;
Procedure inicializarVecListas(Var v:vecListas);
Var i:subCodR;
Begin
 For i:=1 To DF Do
  v[i] := Nil;
End;
Procedure CargarVecListas(Var l:vecListas);
Var 
 p:producto;
Begin
 inicializarVecListas(l);
 leerProducto(p);
 While (p.precio<>-1) Do
  Begin
   InsertarOrdenado(l[p.codR],p);
   leerProducto(p);
  End;
End;
Procedure imprimirListas(l:lista);
Begin
 While (l<>Nil) Do
  Begin
   writeln('estos son los prodcutos:');
   writeln('codigo de producto:',l^.elem.cod);
   writeln('este es el vendria siendo el codigo de rubro:',l^.elem.codR);
   writeln('este es el precio del producto:',l^.elem.precio);
   l := l^.sig;
  End;
End;
Procedure imprimirVecListas(l:vecListas);
Var i:subCodR;
Begin
 For i:=1 To DF Do
  imprimirListas(l[i]);
End;
procedure GenerarVecNuevo(l:lista;var v2:vecRubro;var dl:integer);
begin
 dl:=0;
 While(l<>Nil)and(dl<DFR)do begin
   dl:=dl + 1;
   v2[dl]:=l^.elem;
   l:=l^.sig;
 end;
end;
procedure insercion(var v:vecRubro;dl:integer);
var 
 i,j:Integer;
 item:producto;
begin
 For i:=2 to dl do begin
   item:=v[i];
   j:=i-1;
   While(j>0)and(v[j].precio>item.precio)do begin
     v[j+1]:=v[j];
     j:=j-1
   end;
   v[j+1]:=item;
 end;
end;
procedure ImprimirNuevoVec(v2:vecRubro;dl:integer);
var i:subRubro;
begin
 For i:=1 to dl do begin
  writeln('esta es la posicion:',i,' --del producto ordenado de mayor a menor--');
  writeln('este producto del rubro 3 tiene este precio:',v2[i].precio);
  writeln('este es el codigo de producto:',v2[i].cod);
 end;
end;
function promedio(v2:vecRubro;dl:integer):real;
var 
 sumaTotal:real;
 i:subRubro;
begin
 sumaTotal:=0;
 For i:=1 to dl do
  sumaTotal:=sumaTotal + v2[i].precio;
 
 promedio:=(sumaTotal/dl);
end;
Var 
 v:vecListas;
 v2:vecRubro;
 dl:integer;
Begin
 CargarVecListas(v);
 imprimirVecListas(v);
 GenerarVecNuevo(v[3],v2,DL);
 insercion(v2,DL);
 ImprimirNuevoVec(v2,DL);
 writeln('este es el promdio de precio de los productos:',promedio(v2,DL):0:2);
End.
