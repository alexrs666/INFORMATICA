{Se desea procesar la información de las ventas de productos de un comercio (como máximo 50). 
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el día de la venta, código del producto (entre 1 y 15) y cantidad vendida
 (como máximo 99 unidades). El código y el dia deben generarse automáticamente (random) y la cantidad se debe leer. El ingreso de las ventas finaliza con el día de venta 0 
 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g).}
Program P1_EJE1_TALLER;
Const 
 DF = 50;
 DV = 99;
 DC = 15;
Type 
 subVentas = 1..DF;
 subCant = 1..DV;
 subCod = 1..DC;
 ventas = Record
  dia:Integer;
  cod:integer;
  cant:subCant;
 End;
 NuevoV = record
   codVec:integer;
   cantTotal:integer;
 end;
 VecVentas = array[subVentas] Of ventas;
 VecNuevo = array[subVentas]of NuevoV;
procedure inicializarVector(var vn:VecNuevo);
var i:subVentas;
begin
 For i:=1 to DF do begin
   vn[i].cantTotal:=0;
   vn[i].codVec:=0;
 end;
end;
Procedure leerVentas(Var v:ventas);
Begin
 v.cod := random(15)+1;
 Write('ingrese dia:');
 Readln(v.dia);
 If (v.dia<>0) Then
  Begin
   Write('ingrese cantidad:');
   Readln(v.cant);
  End;
End;
Procedure CargarVentas(Var v:VecVentas;Var DL:integer);
Var 
 ve:ventas;
Begin
 DL := 0;
 randomize;
 leerVentas(ve);
 While (ve.dia<>0)And(DL<DF) Do
  Begin
   DL := DL + 1;
   v[DL] := ve;
   If (DL<DF)Then
    leerVentas(ve);
  End;
End;
Procedure informarVectorin(v:ventas);
Begin
 writeln('este es el dia de la venta:',v.dia);
 writeln('este es el codigo de la venta:',v.cod);
 writeln('esta es la cantidad de ventas:',v.cant);
End;
Procedure informar(v:VecVentas;DL:subVentas);
Var i:Integer;
Begin
 For i:=1 To DL Do
  informarVectorin(v[i]);
End;
Procedure Insercion(Var v:VecVentas;DL:subVentas);
Var 
 i,j:integer;
 actual:ventas;
Begin
 For i:=2 To DL Do
  Begin
   actual := v[i];
   j := i-1;
   While (j>0)And(v[j].cod>actual.cod) Do
    Begin
     v[j+1] := v[j];
     j := j - 1;
    End;
   v[j+1] := actual;
  End;
End;
Procedure NuevosValores(Var v1,v2:integer);
Begin
 write('ingrese el valor que quiere eliminar:');
 readln(v1);
 write('ingrese el segundo valor:');
 readln(v2);
End;

{ESTA BUSQUEDA ES MENOS EFICIENTE
Procedure EliminarNums(Var v:VecVentas; Var DL:subVentas; v1,v2:subCod);
Var 
  i, pos: integer;
Begin
  i := 1;
  While (i <= DL) Do 
  Begin
    { Si el código está en el rango, lo eliminamos }
    If (v[i].cod >= v1) And (v[i].cod <= v2) Then 
    Begin
      { Desplazamos todos los elementos un lugar a la izquierda }
      For pos := i To (DL - 1) Do
        v[pos] := v[pos+1];
      
      { Achicamos la dimensión lógica }
      DL := DL - 1;  
      { OJO: No incrementamos 'i' acá, porque el nuevo elemento que 
        cayó en esta posición también debe ser evaluado }
    End
    Else 
    Begin
      i := i + 1; { Solo avanzamos si no eliminamos nada }
    End;
  End;
End;}
Procedure EliminarNums(Var v:VecVentas;Var dl:integer;v1,v2:integer);
Var 
 pri, ult, medio, pos, inicio, fin, i, cantBorrados:integer;
Begin
 pri := 1;
 ult := DL;
 pos := 0;
  { 1. Búsqueda Dicotómica para encontrar UN elemento dentro del rango }
 While (pri <= ult) And (pos = 0) Do
  Begin
   medio := (pri + ult) Div 2;
   If (v[medio].cod >= v1) And (v[medio].cod <= v2) Then
    pos := medio
   Else If (v[medio].cod < v1) Then
         pri := medio + 1
   Else
    ult := medio - 1;
  End;
  { Si pos > 0, significa que encontramos al menos un elemento a borrar }
 If (pos > 0) Then
  Begin
    { 2. Buscar el límite izquierdo (el primer elemento a borrar) }
   inicio := pos;
   While (inicio > 1) And (v[inicio - 1].cod >= v1) Do
    inicio := inicio - 1;
    { 3. Buscar el límite derecho (el último elemento a borrar) }
   fin := pos;
   While (fin < DL) And (v[fin + 1].cod <= v2) Do
    fin := fin + 1;
    { 4. Desplazamiento en bloque (correr los elementos que sobrevivieron) }
   cantBorrados := (fin - inicio) + 1;
   For i := (fin + 1) To DL Do
    Begin
     v[i - cantBorrados] := v[i];
    End;
    { 5. Actualizar la dimensión lógica }
   DL := DL - cantBorrados;
  End;
End;
Procedure GenerarNuevoV(v:VecVentas;dl:integer;var vN:VecNuevo;var dl2:integer);
var 
 i:subVentas;
 canTo:integer;
 actual:subCod;
begin
 i:=1;
 dl2:=0;
 inicializarVector(vN);
 While(i<=dl)do begin
   canTo:=0;
   actual:=v[i].cod;
   While(i<=dl)and(actual=v[i].cod)do begin
     canTo:=canTo + v[i].cant;
     i:=i + 1;
   end;
   If(actual mod 2=0)Then begin
     dl2:=dl2 + 1;
     vN[actual].cantTotal:=canTo;
     vN[actual].codVec:=actual;
   end;
 end;
end;
procedure informarVecNuevo(vn:VecNuevo;dl2:integer);
var i:subVentas;
begin
 For i:=1 to dl2 do begin
   writeln('este es el codigo:',vn[i].codVec);
   writeln('esta es la cantidad que vendio:',vn[i].cantTotal);
 end;
end;
Var 
 v:VecVentas;
 DL,DL2:integer;
 v1,v2:integer;
 vNue:VecNuevo;
Begin
 CargarVentas(v,DL);
 informar(v,DL);
 Insercion(v,DL);
 informar(v,DL);
 NuevosValores(v1,v2);
 EliminarNums(v,DL,v1,v2);
 informar(v,DL);
 GenerarNuevoV(v,DL,vNue,DL2);
 informarVecNuevo(vNue,DL2);
End.