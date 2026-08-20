{1.Escribir un programa que:
a. Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente.
b. Una vez generado el arbol, realice modulos independientes que reciban el arbol como parametro para: 
i. Informar los datos de los socios en orden creciente.
ii. Informar los datos de los socios en orden decreciente.
iii. Informar el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
iv. Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.
vi. Leer un nombre e informar si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
vii. Informar la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
viii. Informar el promedio de edad de los socios. Debe invocar a un módulo recursivo que retorne el promedio de las edades de los socios.}
program P3_EJE1_TALLER;
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
procedure imprimir(a:arbol);
begin
  If(a<>Nil)then begin
    imprimir(a^.HI);
    writeln('NUM SOCIO:',a^.elem.numSoc,' NOMBRE DEL SOCIO:',a^.elem.nombre,' EDAD DEL SOCIO:',a^.elem.edad);
    imprimir(a^.HD);
  End;
end;
Procedure imprimirDescendente(a:arbol);
begin
 If(a<>Nil)then begin
  imprimirDescendente(a^.HD);
  writeln('NUM SOCIO:',a^.elem.numSoc,' NOMBRE DEL SOCIO:',a^.elem.nombre,' EDAD DEL SOCIO:',a^.elem.edad);
  imprimirDescendente(a^.HI);
 end;
end;
procedure MaxEdadSocio(a:arbol);
 procedure Calcular(e:integer;numS:integer;var m,num:integer);
 begin
  If(e>m)then begin
   m:=e;
   num:=numS;
  end;
 end;
 procedure Buscar(a:arbol;var m,MaxNum:integer);
 begin
  If (a<>Nil)Then Begin
   Calcular(a^.elem.edad,a^.elem.numSoc,m,MaxNum);
   Buscar(a^.HI,m,MaxNum);
   Buscar(a^.HD,m,MaxNum);
  End;
 end;
var
 m,MaxNum:integer;
begin
 m:=-1;
 MaxNum:=0;
 Buscar(a,m,MaxNum);
 If(m=-1)then
   writeln('no se encontro datos')
 Else
   writeln('este es el socio con MayorEdad:',MaxNum,' esta es su edad:',m);
end;
procedure Actualizar(a:arbol);
  procedure impar(a:arbol;var cant:integer);
  begin
   If(a<>Nil)then begin
    If(a^.elem.edad mod 2<>0)then begin
     a^.elem.edad:=a^.elem.edad + 1;
     cant:=cant + 1;
    end;
    impar(a^.HI,cant);
    impar(a^.HD,cant);
   end;
  end;
var 
 c:integer;
begin
 c:=0;
 impar(a,c);
 If(c=0)then
  writeln('no hubo socio con edad impar')
 Else
  writeln('est es la cantidad de socio a los q se le aumentaron:',c);
end;
procedure BuscarNombre(a:arbol);
  function busquedaNom(a:arbol;valorNombre:string):boolean;
  begin
   If(a=nil)then
    busquedaNom:=false
   Else If(a^.elem.nombre=valorNombre)then
    busquedaNom:=true
   Else
    busquedaNom:=busquedaNom(a^.HI,valorNombre) or busquedaNom(a^.HD,valorNombre);
  end;
var
 ValorNom:string;
begin
 write('ingrese un nombre que quiera buscar:');
 readln(ValorNom);
 If(busquedaNom(a,valorNom)=false)then
  writeln('no se encontro el nombre')
 Else
  writeln('el nombre se encontro');
end;
procedure TotalSocios(a:arbol);
 function contar(a:arbol):integer;
 begin
   If(a=nil)then
    contar:=0
   Else 
    contar:= 1 + contar(a^.HI) + contar(a^.HD);
 end;
begin
 If(contar(a)=0)then
  writeln('no hubo socios')
 Else
  writeln('esta es la cantidad total de socios:',contar(a));
end;
procedure Promedios(a:arbol);
 procedure sumarCant(a:arbol;var contador,sumaEdad:integer);
 begin
   If(a<>nil)then begin
    contador:=contador + 1;
    sumaEdad:=sumaEdad + a^.elem.edad;
    sumarCant(a^.HI,contador,sumaEdad);
    sumarCant(a^.HD,contador,sumaEdad);
   end;
 end;
var 
 prom:real;
 cont,sum:integer;
begin
 cont:=0;
 sum:=0;
 sumarCant(a,cont,sum);
 If(cont=0)and(sum=0)then
   writeln('no hubo socios')
 Else begin
   prom:=(sum/cont);
   writeln('esta es la edad promedio de los socios:',prom:0:0);
 end;
end;
var
 a:arbol;
 m:integer;
begin
randomize;
  a:=Nil;
  cargarArbol(a);
  imprimir(a);
  writeln('--de forma descendente--');
  imprimirDescendente(a);
  MaxEdadSocio(a);
  Actualizar(a);
  BuscarNombre(a);
  TotalSocios(a);
  Promedios(a);  
end.