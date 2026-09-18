
{3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)
c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.
Desafío...
}

Program P2_EJE3_TALLER;

Const 
 LI = 300;
 DF = 20;
 LS = 1550;

Type 
 subVec = 1..DF;
 vector = array[subVec] Of integer;
Function NumerosRandom:integer;

Var valores:integer;
Begin
 valores := LS-LI + 1;
 NumerosRandom := LI + random(valores);
End;
Procedure cargarVector(Var v:vector;dl:integer);
Begin
 If (dl<=DF)Then
  Begin
   dl:=dl + 1;
   v[dl] := NumerosRandom;
   cargarVector(v,dl);
  End;
End;
Procedure imprimir(v:vector;dl:integer);
Begin
 If (dl<=DF)Then
  Begin
   writeln('valores vector:',v[dl]);
   imprimir(v,dl + 1);
  End;
End;
Procedure Insercion(Var v:vector;dl:integer);
Var 
 i,j,item:integer;
Begin
 For i:=2 To dl Do
  Begin
   j := i-1;
   item := v[i];
   While (j>0)And(v[j]>item) Do
    Begin
     v[j+1] := v[j];
     j := j - 1;
    End;
   v[j+1] := item;
  End;
End;
Procedure busquedaDicotomica (v: vector; ini,fin: integer; dato:integer; Var pos: integer);
Var aux: integer;
Begin
 If (ini <= fin) Then
  Begin
   aux := (fin + ini) Div 2;
   If (v[aux] = dato) Then
    pos := aux
   Else
    Begin
     If (dato < v[aux]) Then
      busquedaDicotomica(v, ini, aux-1, dato, pos)
     Else
      busquedaDicotomica(v, aux+1, fin, dato, pos);
    End;
  End
  Else
   pos:=-1;
End;

Var 
 v:vector;
 dl:integer;
 ini,fin:subVec;
 elem:integer;
 pos:integer;
Begin
 randomize;
 dl:= 0;
 cargarVector(v,dl);
 imprimir(v,dl);
 Insercion(v,dl);
 writeln('--aca se muestra el vector ordenado--');
 imprimir(v,dl);
 writeln('--ingrese un elemento para sabes si esta o no en el vector--');
 readln(elem);
 ini := 1;
 fin := DF;
 busquedaDicotomica(v, ini, fin, elem, pos);
 If(pos=-1)Then
  writeln('el elemento no estaba en el vector')
 Else
  writeln('el elemento:',elem,'se encontro correctamente ,en la posicion:',pos);
End.
