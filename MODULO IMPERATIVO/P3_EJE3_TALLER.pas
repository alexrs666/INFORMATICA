{3. Implementar un programa que contenga:
a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo,
código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura
generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben
guardarse los finales que rindió en una lista.
b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.
c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
su cantidad de finales aprobados (nota mayor o igual a 4).
c. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}
program P3_EJE3_TALLER;
type
 final=record
  legajo:integer;
  codigo:integer;
  fecha:string;
  nota:integer;
 end;
 listaFinales=^nodo;
 nodo=record
  elem:final;
  sig:listaFinales;
 end;
 alumno=record
  legajo:integer;
  Finales:listaFinales;
 end;
 arbol=^nodo2;
 nodo2=record
  elem:alumno;
  HI:arbol;
  HD:arbol;
 end;
procedure CargarArbol(var a:arbol);
 procedure LeerFinales(var f:final);
 begin
  write('ingrese un legajo:');
  readln(f.legajo);
  if(f.legajo<>0)then begin
   write('ingrese un codigo de la materia:');
   readln(f.codigo);
   write('ingrese fecha del final:');
   readln(f.fecha);
   write('ingrese la nota que obtuvo en el final:');
   readln(f.nota);
  end;
 end;
 procedure insertarAdelante(var l:listaFinales;f:final);
 var nue:listaFinales;
 begin
  new(nue);
  nue^.elem:=f;
  nue^.sig:=l;
  l:=nue;
 end;
 procedure InsertarFinal(var a:arbol;f:final);
 begin
    if(a=nil)then begin
     new(a);
     a^.elem.legajo:=f.legajo;
     a^.elem.finales:=nil;
     insertarAdelante(a^.elem.finales,f);    
     a^.HI:=nil;
     a^.HD:=nil;
    end
    else if(f.legajo=a^.elem.legajo)then begin
       insertarAdelante(a^.elem.finales,f);
    end
    else if(f.legajo<a^.elem.legajo)then begin
       InsertarFinal(a^.HI,f)
    end
    else begin
       InsertarFinal(a^.HD,f);
    end;
 end;
var
 f:final;
begin
 LeerFinales(f);
 While(f.legajo<>0)do begin
   InsertarFinal(a,f);
   LeerFinales(f);
 end;
end;
procedure legajoImpar(a:arbol);
  function recorrerArbol(a:arbol):integer;
  begin
    if(a=nil)then
        recorrerArbol:=0
    else if(a^.elem.legajo mod 2<>0)then
        recorrerArbol:=1 + recorrerArbol(a^.HI)+recorrerArbol(a^.HD)
    else
       recorrerArbol:=recorrerArbol(a^.HI) + recorrerArbol(a^.HD);
  end;
var
 cantidad:integer;
begin
 cantidad:=recorrerArbol(a);
 if(cantidad=0)then
   writeln('no hubo alumnos con legajo impar')
 else
  writeln('esta es la cantidad de alumnos con legajo impar:',cantidad);
end;
procedure AlumnosAprobados(a:arbol);
  procedure recorreLista(l:listaFinales;var cont:integer);
  begin
    While(l<>nil)do begin
      if(l^.elem.nota>=4)then
        cont:=cont + 1;
      l:=l^.sig;
    end;
  end;
  procedure recorrerArbol(a:arbol);
  var contador:integer;
  begin
   contador:=0;
   if(a<>nil)then begin
     recorreLista(a^.elem.Finales,contador);
     writeln('esta es la cantidad de finales que aprobo',contador,' el alumno:',a^.elem.legajo);
     recorrerArbol(a^.HI);
     recorrerArbol(a^.HD);
   end;
  end;
begin
 recorrerArbol(a);
end;
procedure RetornarPromedios(a:arbol);
 procedure recorrerLista(l:listaFinales;var sum,c:integer);
 begin
   While(l<>nil)do begin
    sum:=sum + l^.elem.nota;
    c:=c + 1;
    l:=l^.sig;
   end;
 end;
 procedure recorrerArbol(a:arbol;prom:real);
 var 
  s,c:integer;
  promeAlum:real;
 begin
   s:=0;
   c:=0;
   if(a<>nil)then begin
    recorrerLista(a^.elem.Finales,s,c);
    promeAlum:=(s/c);
    if(promeAlum>prom)then
     writeln('este alumno:',a^.elem.legajo,' supera el promedio ingresado ,tiene:',promeAlum:0:2);
    recorrerArbol(a^.HI,prom);
    recorrerArbol(a^.HD,prom);
   end;
 end;
var
 p:real;
begin
 write('ingrese un promedio que quiera ver si los alumnos cumplen:');
 readln(p);
 recorrerArbol(a,p);
end;
var 
 a:arbol;
begin
 a:=nil;
 cargarArbol(a);
 legajoImpar(a);
 AlumnosAprobados(a);
 RetornarPromedios(a);
end. 