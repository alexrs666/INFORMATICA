{3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
septiembre de 2025. De cada película se conoce: código de película, código de género (1:
acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y
puntaje promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).}
Program P1_EJE3_TALLER;
Const 
 DF = 8;
Type 
 subCodG = 1..DF;
 pelis = Record
  codP:integer;
  codGe:subCodG;
  puntaje:real;
 End;
 lista = ^nodo;
 nodo = Record
  elem:pelis;
  sig:lista;
 End;
 vecPelis = array[subCodG] Of pelis;
 vecListas = array[subCodG]of lista;
Procedure inicializarVecListas(var v,u:vecListas);
var i:subCodG;
begin
  For i:=1 to DF do begin
    v[i]:=Nil;
    u[i]:=Nil;
  end;
end;
Procedure leerLista(Var p:pelis);
Begin
 write('ingrese un codigo de pelicula:');
 readln(p.codP);
 If (p.codP<>-1)Then
  Begin
   write('ingrese un codigo de genero de la pelicula:');
   readln(p.codGe);
   write('ingrese el puntaje obtenido de la pelicula:');
   readln(p.puntaje);
  End;
End;
Procedure insertarAtras(Var l,ult:lista;p:pelis);
Var nue:lista;
Begin
 new(nue);
 nue^.elem := p;
 nue^.sig := Nil;
 If (l=Nil)Then
  l := nue
 Else
  ult^.sig := nue;
 ult := nue;
End;
Procedure CargarLista(Var l:vecListas);
Var 
 p:pelis;
 ult:vecListas;
Begin
 inicializarVecListas(l,ult);
 leerLista(p);
 While (p.codP<>-1) Do
  Begin
   insertarAtras(l[p.codGe],ult[p.codGe],p);
   leerLista(p);
  End;
End;
Procedure maximosGeneros(vl:lista;var m:pelis);
Begin
 m.puntaje:=-1;
 While(vl<>Nil)do begin
  If (vl^.elem.puntaje>m.puntaje)Then
      m:=vl^.elem;
  vl:=vl^.sig;
 end;
End;
Procedure RecorrerLista(vl:vecListas;Var v:vecPelis);
Var 
 max:pelis;
 i:subCodG;
Begin
 For i:=1 to DF do begin
   maximosGeneros(vl[i],max);
   v[i]:=max;
 end;
End;
Procedure seleccion(Var v:vecPelis);
Var 
 i,j,pos:integer;
 item:pelis;
Begin
 For i:=1 To (DF-1) Do
  Begin
   pos := i;
   For j:=i+1 To DF Do
    Begin
     If (v[j].puntaje>v[pos].puntaje)Then
      pos := j;
    End;
   item := v[pos];
   v[pos] := v[i];
   v[i] := item;
  End;
End;
Procedure MayorYmenorPuntaje(v:vecPelis);
begin
  writeln('este el el genero que tiene el mayor puntaje:',v[1].codP);
  writeln('este es el ultimo:',v[DF].codP);
end;
Var 
 vl:vecListas;
 v:vecPelis;
Begin
 CargarLista(vl);
 RecorrerLista(vl,v);
 seleccion(v);
 MayorYmenorPuntaje(v);
End.
