{2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.
e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.}
Program P2_EJE2_TALLER;
Const 
 DF = 200;
 DL = 100;
Type 
 lista = ^nodo;
 nodo = Record
  elem:integer;
  sig:lista;
 End;
Function NumerosRandom:integer;

Var valores:integer;
Begin
 valores := DF-DL + 1;
 NumerosRandom := DL + random(valores);
End;



{Procedure InsertarAtras(Var l, ult: lista; n: integer);
Var nue: lista;
Begin
 new(nue);
 nue^.elem := n;
 nue^.sig := Nil;
 If (l = Nil) Then
   l := nue 
 Else
   ult^.sig := nue;
 ult := nue;
End;
Procedure cargarLista(Var l, ult: lista);
Var n: integer;
Begin
 n := NumerosRandom;
 If (n <> 100) Then
  Begin
   InsertarAtras(l, ult, n);
   cargarLista(l, ult);
  End;
End;
}
Procedure cargarLista(Var l:lista);
Var n:integer;
Begin
 n := NumerosRandom;
 If (n<>DL)Then
  Begin
   new(l);
   l^.elem := n;
   cargarLista(l^.sig);
  End
 Else
  Begin
   l := Nil;
  End;
End;
Procedure imprimir(l:lista);
Begin
 If (l<>Nil)Then
  Begin
   writeln('numero aleatorios:',l^.elem);
   imprimir(l^.sig);
  End;
End;
Procedure imprimirInverso(l:lista);
Begin
 If (l<>Nil)Then
  Begin
   imprimirInverso(l^.sig);
   writeln('imprime de atras para adelante:',l^.elem);
  End;
End;
function valorMin(l:lista):integer;
var m:integer;
begin
  If(l=Nil)Then
   valorMin:=9999
  Else begin
   m:=valorMin(l^.sig);
   If(l^.elem<m)Then
     valorMin:=l^.elem
   Else
     valorMin:=m;
  end;  
end;
function analizar(l:lista;v:integer):boolean;
begin
  If(l=Nil)Then
    analizar:=false
  Else 
   If(l^.elem=v)Then
     analizar:=true
   Else
     analizar:=analizar(l^.sig,v);  
end;
Var 
 l:lista;
 v:integer;
Begin
 randomize;
 l := Nil;
 cargarLista(l);
 imprimir(l);
 imprimirInverso(l);
 writeln('este es el valor minimo:',valorMin(l));
 writeln('--ingrese un valor para saber si esta en la lista dentro del rango--');
 readln(v);
 writeln('devuele true si estuvo el valor sino ,false:',analizar(l,v));
End.