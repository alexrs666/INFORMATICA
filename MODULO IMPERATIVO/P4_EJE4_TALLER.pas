{4. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN 0. Las estructuras deben
ser eficientes para buscar por ISBN.
    i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos
       insertarlos a la derecha.
    ii.En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
       (prestar atención sobre los datos que se almacenan).
b. Un módulo recursivo que reciba la estructura generada en i. y retorne el
ISBN más
grande.
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el
ISBN más
pequeño.
d. Un módulo recursivo que reciba la estructura generada en i. y un número de
socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
e. Un módulo recursivo que reciba la estructura generada en ii. y un número de
socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
f. Un módulo que reciba la estructura generada en i. y retorne una nueva
estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de
veces
que se prestó.
g. Un módulo que reciba la estructura generada en ii. y retorne una nueva
estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de
veces
que se prestó.
h. Un módulo recursivo que reciba la estructura generada en g. y muestre su
contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de
ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores
de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
}
program P4_EJE4_TALLER;
Type
 fecha=record
   dia:integer;
   mes:integer;
 end;
 prestamo=record
  ISBN:integer;
  numSoc:integer;
  fec:fecha;
  cantPres:integer;
 end;
 arbol=^nodo;
 nodo=record
  elem:prestamo;
  HI:arbol;
  HD:arbol;
 end;
 estruc2=record
  numSoc:integer;
  fec:fecha;
  cantPres:integer;
 end;
 lista=^nodo2;
 nodo2=record
  elem:estruc2;
  sig:lista;
 end;
 NuevaEstruc=record
  ISBN2:integer;
  ListaNueva:lista;
 end;
 arbol2=^nodo3;
 nodo3=record
  elem:NuevaEstruc;
  HI:arbol2;
  HD:arbol2;
 end;
 ISBNprestamo=record
  ISBN3:integer;
  cantPres:integer;
 end;
 arbol3=^nodo4;
 nodo4=record
  elem:ISBNprestamo;
  HI:arbol3;
  HD:arbol3;
 end;
 arbol4=^nodo5;
 nodo5=record
  elem:ISBNprestamo;
  HI:arbol4;
  HD:arbol4;
 end;
procedure cargarArbol(var a:arbol;var a2:arbol2);
  procedure LeerPrestamo(var p:prestamo);
     procedure LeerFecha(var f:fecha);
     begin
       f.dia:=random(30)+1;
       f.mes:=random(12)+1;
     end; 
  begin
    p.ISBN:=random(50);
    if(p.ISBN<>0)Then begin
      p.numSoc:=random(100);
      LeerFecha(p.fec);
      p.cantPres:=random(15)+1;
    end;
  end;
  procedure insertarPrestamo(var a:arbol;p:prestamo);
  begin
    if(a=nil)Then begin
       new(a);
       a^.elem:=p;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    Else if(p.ISBN>=a^.elem.ISBN)Then
        insertarPrestamo(a^.HD,p)
    Else if(p.ISBN<a^.elem.ISBN)Then
        insertarPrestamo(a^.HI,p);
  end;
  procedure insertarInciso2(var a2:arbol2;p:prestamo);
     procedure insertarAdelante(var l:lista;p2:estruc2);
     Var 
      nue:lista;
     begin
      new(nue);
      nue^.elem:=p2;
      nue^.sig:=l;
      l:=nue;
     end;
  var 
   e:estruc2;
  begin
    e.numSoc:=p.numSoc;
    e.fec:=p.fec;
    e.cantPres:=p.cantPres;
   if(a2=nil)Then begin
    new(a2);
    
    a2^.elem.ISBN2:=p.ISBN;
    a2^.elem.ListaNueva:=nil;
    insertarAdelante(a2^.elem.ListaNueva,e);
    a2^.HI:=nil;
    a2^.HD:=nil;
   end
   
   Else if(p.ISBN=a2^.elem.ISBN2)Then begin
    insertarAdelante(a2^.elem.ListaNueva,e);
   end
   else if(p.ISBN<a2^.elem.ISBN2)then
     insertarInciso2(a2^.HI,p)
   else
     insertarInciso2(a2^.HD,p);
  end;
var
 p:prestamo;
begin
 LeerPrestamo(p);
 While(p.ISBN<>0)do begin
  insertarPrestamo(a,p);
  insertarInciso2(a2,p);
  LeerPrestamo(p);
 end;
end;
function ISBNmasgrande(a:arbol):integer;
begin
 If(a=nil)Then
    ISBNmasgrande:=-1
 Else if(a^.HD=nil)Then
    ISBNmasgrande:=a^.elem.ISBN
 Else
    ISBNmasgrande:=ISBNmasgrande(a^.HD);
end;
function MenorISBN(a2:arbol2):integer;
begin
  if(a2=nil)then
    MenorISBN:=-1
  else if(a2^.HI=nil)then
    MenorISBN:=a2^.elem.ISBN2
  else
    MenorISBN:=MenorISBN(a2^.HI);
end;
procedure CantSocios(a:arbol;var cantS:integer);
 procedure cantNumSocios(a:arbol;s:integer;var c:integer);
 begin
   IF(a<>nil)then begin
    if(a^.elem.numSoc=s)then
      c:=c + 1;
    cantNumSocios(a^.HI,s,c);
    cantNumSocios(a^.HD,s,c);
   end;
 end;
var 
 numS:integer;
begin
 write('ingrese un numero de socio:');
 readln(numS);
 cantS:=0;
 cantNumSocios(a,numS,cantS);
 if(cantS=0)then
  writeln('no hubo socios con el mismo numero')
 else
  writeln('esta es la cantidad de socios con el mismo num:',cantS);
end;
procedure CantSocSegundaEstructura(a2:arbol2;var cont:integer);
  function contadorSocios(l:lista;s:integer):integer;
  begin
     if(l=nil)then
      contadorSocios:=0
     else if(l^.elem.numSoc=s)then
         contadorSocios:=1+ contadorSocios(l^.sig,s)
     else
       contadorSocios:=contadorSocios(l^.sig,s);
  end;
  procedure recorrerArbol(a2:arbol2;s:integer;var c:integer);
  begin
     if(a2<>nil)then begin
       c:=c + contadorSocios(a2^.elem.ListaNueva,s);
       recorrerArbol(a2^.HI,s,c);
       recorrerArbol(a2^.HD,s,c);
     end;
  end;
var
 Soc:integer;
begin
 write('ingrese un numero de socio:');
 readln(Soc);
 cont:=0;
 recorrerArbol(a2,Soc,cont);
 if(cont=0)then
  writeln('no hubo socios con el valor ingresado')
 else
  writeln('esta es la cantidad de socios con el mismo num:',cont);
end;
procedure CrearNuevaEstructura(a:arbol;var a3:arbol3);
       procedure InsertarEstructuraNueva(var a3:arbol3;p:prestamo);
       begin 
         if(a3=nil)then begin
            new(a3);
            a3^.elem.ISBN3:=p.ISBN;
            a3^.elem.cantPres:=1;
            a3^.HI:=nil;
            a3^.HD:=nil;
         end
         else if(p.ISBN=a3^.elem.ISBN3)then begin
            a3^.elem.ISBN3:=p.ISBN;
            a3^.elem.cantPres:=a3^.elem.cantPres + 1;
         end
         else if(p.ISBN<a3^.elem.ISBN3)then
            InsertarEstructuraNueva(a3^.HI,p)
          else 
            InsertarEstructuraNueva(a3^.HD,p);
      end;
      procedure RecorridoArbol1(a:arbol;var a3:arbol3);
      begin
         if(a<>nil)then begin
             InsertarEstructuraNueva(a3,a^.elem);
             RecorridoArbol1(a^.HI,a3);
             RecorridoArbol1(a^.HD,a3);
         end;
      end;
begin
 RecorridoArbol1(a,a3);
end;
procedure CrearSegundaEstructura(a2:arbol2;var a4:arbol4);
       function ContadorLista(l:lista):integer;
       var 
        cant:integer;
       begin
            cant:=0;
            While(l<>nil)do begin
             cant:=cant + 1;
             l:=l^.sig;
            end;
            ContadorLista:=cant;
       end;
       procedure InsertarEstructuraNueva(var a4:arbol4;p:NuevaEstruc);
       begin 
         if(a4=nil)then begin
            new(a4);
            a4^.elem.ISBN3:=p.ISBN2;
            a4^.elem.cantPres:=ContadorLista(p.ListaNueva);
            a4^.HI:=nil;
            a4^.HD:=nil;
         end
         else if(p.ISBN2<a4^.elem.ISBN3)then
            InsertarEstructuraNueva(a4^.HI,p)
          else 
            InsertarEstructuraNueva(a4^.HD,p);
       end; 
       procedure RecorridoArbol2(a2:arbol2;var a4:arbol4);
       begin
          if(a2<>nil)then begin
             InsertarEstructuraNueva(a4,a2^.elem);
             RecorridoArbol2(a2^.HI,a4);
             RecorridoArbol2(a2^.HD,a4);
          end;
       end;
begin
  RecorridoArbol2(a2,a4);
end;
procedure imprimirArbol4(a4:arbol4);
begin
  if(a4<>nil)then begin
    imprimirArbol4(a4^.HI);
    writeln('este es el ISBN:',a4^.elem.ISBN3,' la cantidad de veces q se presto:',a4^.elem.cantPres);
    imprimirArbol4(a4^.HD);
  end;
end;
procedure RangosISBN(a:arbol;var cant:integer);
   function cantidadRangos(a:arbol;min,max:integer):integer;
   begin
    if(a=nil)then
     cantidadRangos:=0
    else if(a^.elem.ISBN<min)then
       cantidadRangos:=cantidadRangos(a^.HD,min,max)
    else if(a^.elem.ISBN>max)then
       cantidadRangos:=cantidadRangos(a^.HI,min,max)
    else
       cantidadRangos:= 1 + cantidadRangos(a^.HI,min,max)+cantidadRangos(a^.HD,min,max); 
   end;
var
 v1,v2:integer;
begin
 write('ingrese un ISBN minimo:');
 readln(v1);
 write('ingrese un ISBN maximo:');
 readln(v2);
 cant:=0;
 cant:=cantidadRangos(a,v1,v2);
 if(cant=0)then
   writeln('no hubo cantidad en esos rangos')
 else
   writeln('esta es la cantidad de ISBN en esos rangos:',cant);
end;
procedure RangosISBN2(a2:arbol2;var cont:integer);
   function ContadorLista(l:lista):integer;
   var 
      cant:integer;
   begin
     cant:=0;
     While(l<>nil)do begin
       cant:=cant + 1;
       l:=l^.sig;
     end;
     ContadorLista:=cant;
   end;
   function cantidadRangos(a2:arbol2;min,max:integer):integer;
   begin
    if(a2=nil)then
     cantidadRangos:=0
    else if(a2^.elem.ISBN2<min)then
       cantidadRangos:=cantidadRangos(a2^.HD,min,max)
    else if(a2^.elem.ISBN2>max)then
       cantidadRangos:=cantidadRangos(a2^.HI,min,max)
    else
       cantidadRangos:= ContadorLista(a2^.elem.ListaNueva) + cantidadRangos(a2^.HI,min,max)+cantidadRangos(a2^.HD,min,max); 
   end;
var
 v1,v2:integer;
begin
 write('ingrese un ISBN minimo:');
 readln(v1);
 write('ingrese un ISBN maximo:');
 readln(v2);
 cont:=0;
 cont:=cantidadRangos(a2,v1,v2);
 if(cont=0)then
   writeln('no hubo cantidad en esos rangos')
 else
   writeln('esta es la cantidad de ISBN en esos rangos:',cont);
end;
var
 a:arbol;
 a2:arbol2;
 a3:arbol3;
 a4:arbol4;
 MayorISBN,MenISBN,c,CantS,cantISBN,contISBN:integer;
begin
   randomize;
   a:=nil;
   a2:=nil;
   a3:=nil;
   a4:=nil;
   cargarArbol(a,a2);
   MayorISBN:=ISBNmasgrande(a);
   writeln('este es el ISBN mas grande:',MayorISBN);
   MenISBN:=MenorISBN(a2);
   writeln('este es el menor ISBN de la segunda estructura:',MenISBN);
   CantSocios(a,c);
   CantSocSegundaEstructura(a2,CantS);
   CrearNuevaEstructura(a,a3);
   CrearSegundaEstructura(a2,a4);
   imprimirArbol4(a4);
   RangosISBN(a,cantISBN);
   RangosISBN2(a2,contISBN);
end. 