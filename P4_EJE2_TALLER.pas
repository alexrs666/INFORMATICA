{2. Descargar el programa ImperativoEjercicioClase3.pas de la clase anterior e incorporar lo
necesario para:
i. Informar el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.
ii. Informar los datos del socio con el número de socio más chico. Debe invocar a un
módulo recursivo que retorne dicho socio.
iii. Leer un valor entero e informar si existe o no existe un socio con ese valor. Debe
invocar a un módulo recursivo que reciba el valor leído y retornar verdadero o falso.
iv. Leer dos valores e informar la cantidad de socios cuyos códigos se encuentran
comprendidos entre los valores leídos. Debe invocar a un módulo recursivo que reciba
los valores leídos y retorne la cantidad solicitada.}
program P4_EJE2_TALLER;
type
 rangoEdad = 12..100;
 cadena15 = string [15];
 socios = record
  numSoc:integer;
  nombre:cadena15;
  edad:rangoEdad;
 end;
 arbol=^nodo;
 nodo=record
   elem:socios;
   HI:arbol;
   HD:arbol;
 end;
procedure cargarArbol(var a:arbol);
  Procedure CargarSocio (var s: socios);
  var vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola');
  begin
   s.numSoc:= random (51) * 100;
   If (s.numSoc <> 0)then begin
    s.nombre:= vNombres[random(10)];
    s.edad:= 12 + random (89);
   end;
  end;  
  Procedure InsertarElemento (Var a: arbol;s: socios);
  Begin
    If (a = Nil)Then Begin
      new(a);
      a^.elem := s;
      a^.HI := Nil;
      a^.HD := Nil;
    End
    Else If (s.numSoc < a^.elem.numSoc)Then
      InsertarElemento(a^.HI,s)
    Else
      InsertarElemento(a^.HD,s);
  End;
Var s: socios;
Begin
 writeln ('----- Ingreso de socios y armado del arbol ----->');
 a := Nil;
 CargarSocio (s);
 While (s.numSoc <> 0) Do Begin
   InsertarElemento (a, s);
   CargarSocio (s);
 End;
End;
function SocioMasGrande(a:arbol):integer;
begin
  if(a=nil)then
    SocioMasGrande:=0
  else if(a^.HD=Nil)Then
    SocioMasGrande:=a^.elem.numSoc
  else
    SocioMasGrande:=SocioMasGrande(a^.HD);
end;
function SocioMasChico(a:arbol):arbol;
begin
  if(a=nil)then
    SocioMasChico:=nil
  else if(a^.HI=nil)then
    SocioMasChico:=a
  else
    SocioMasChico:=SocioMasChico(a^.HI);
end;
procedure ExisteNumSocio(a:arbol;var e:boolean);
  function ExisteSocio(a:arbol;valor:integer):boolean;
  begin
     if(a=nil)then
      ExisteSocio:=false
     else if(a^.elem.numSoc=valor)then
        ExisteSocio:=true
     else if(valor<a^.elem.numSoc)then
        ExisteSocio:=ExisteSocio(a^.HI,valor)
     else 
        ExisteSocio:=ExisteSocio(a^.HD,valor);
  end;
var
 va:integer;
begin
 write('ingrese un numero de socio:');
 readln(va);
 e:=ExisteSocio(a,va);
 if(e=false)then
   writeln('no estaba el numero ingresado')
 else
   writeln('el numero de socio existe');
end;
procedure RangoValores(a:arbol;var c:integer);
    function ValoresR(a:arbol;min,max:integer):integer;
    begin
     if(a=nil)then
      ValoresR:=0
     else if(a^.elem.numSoc<min)then
        ValoresR:=ValoresR(a^.HD,min,max)
     else if(a^.elem.numSoc>max)then
        ValoresR:=ValoresR(a^.HI,min,max)
     else
       ValoresR:=1 + ValoresR(a^.HI,min,max) + ValoresR(a^.HD,min,max);
    end;
var
 v1,v2:integer;
begin
 write('ingrese un valor minimo:');
 readln(v1);
 write('ingrese un valor maximo:');
 readln(v2);
 c:=ValoresR(a,v1,v2);
 if(c=0)then
  writeln('no hubo valores entre esos rangos')
 else
  writeln('esta es la cantidad de valores entre esos rangos:',c);
end;
var
 a:arbol;
 s:integer;
 m:arbol;
 existe:boolean;
 cont:integer;
begin
randomize;
 a:=nil;
 cargarArbol(a);
 s:=SocioMasGrande(a);
 m:=SocioMasChico(a);
 writeln('este es el socio mas grande:',s);
 if(m<>nil)then
  writeln('este es el socio mas chico:',m^.elem.numSoc,'nombre:',m^.elem.nombre,' edad:',m^.elem.edad)
 else
  writeln('no hubo socio mas chico');
 ExisteNumSocio(a,existe);
 RangoValores(a,cont);
end.