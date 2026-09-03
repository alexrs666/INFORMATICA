
{Módulo imperativo - Tema 1 PARCIAL IMPERATIVO REDICTADO 07/04/2025
Se desea analizar los exámenes finales de una cátedra. De cada final se conoce: legajo del
alumno, nota y fecha del examen. Un mismo alumno haber rendido más de un final. Los
exámenes a analizar son todos los que se tomaron entre 2011 y 2024, ambos inclusive. Realice
un programa que contenga:
a) Un módulo que lea finales (sin ningún orden preestablecido), hasta leer un examen con
    legajo -1, y las almacene en una estructura agrupadas por año. En cada año los exámenes
    deben quedar ordenados por nota de manera descendente.
b) Un módulo que reciba la estructura generada en a) y devuelva otra estructura con los
    exámenes cuya nota sea mayor a un valor recibido por parámetro. Esta estructura debe
    ser eficiente para la búsqueda por legajo.
c) Un módulo que reciba la estructura generada en b) y devuelva la cantidad de exámenes
    que rindió un alumno cuyo legajo se recibe por parámetro.}
program PARCIAL6_IMPERATIVO;
const
    DF=2024;
    DL=2011;
type
    rangoanios = DL .. DF;
    Fecha = record
        dia, mes, anio: integer;
    end;
    Examen = record
        legajo: integer;
        nota: integer;
        fecha: Fecha;
    end;
    infoLista=record
        legajo:integer;
        nota:integer;
        mes,dia:integer;
    end;
    lista=^nodo1;
    nodo1=record
        elem:infoLista;
        sig:lista;
    end;
    vector=array[rangoanios]of lista;
    infoFinal=record
        nota:integer;
        dia,mes,anio:integer;
    end;
    listaFinales=^nodo2;
    nodo2=record
        elem:infoFinal;
        sig:listaFinales;
    end;
    infoArbol=record
        legajo:integer;
        final:listafinales;
    end;
    arbol=^nodo;
    nodo=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
procedure CargarVecListas(var v:vector);
            procedure LeerExamen (var e: Examen) ;
            begin
                e.legajo := random(10000) - 1;
                if (e.legajo<>-1) then begin
                    e.nota := random(12) - 1;
                    e.fecha.dia := random(28) + 1;
                    e.fecha.mes := random(11) + 2;
                    e.fecha.anio := random(14) + 2011;
                end;
            end;
            procedure inicializarVecLis(var v:vector);
            var
                i:rangoanios;
            begin
                for i:=DL to DF do
                    v[i]:=nil; 
            end;
            procedure InsertarOrdenado(var l:lista;f:infoLista);
            var
                ant,act,nue:lista;
            begin
                new(nue);
                nue^.elem:=f;
                nue^.sig:=nil;
                ant:=l;
                act:=l;
                while(act<>nil)and(act^.elem.nota>nue^.elem.nota)do begin
                    ant:=act;
                    act:=act^.sig;
                end;
                if(l=act)then 
                    l:=nue
                else
                    ant^.sig:=nue;
                nue^.sig:=act;
            end;
            procedure ActualizarInfo(var f:infoLista;e:examen);
            begin
                f.legajo:=e.legajo;
                f.nota:=e.nota;
                f.mes:=e.fecha.mes;
                f.dia:=e.fecha.dia;
            end;
var
    e:examen;
    f:infoLista;
begin
    LeerExamen(e);
    inicializarVecLis(v);
    while(e.legajo<>-1)do begin
           ActualizarInfo(f,e);
           InsertarOrdenado(v[e.fecha.anio],f);
           LeerExamen(e);
    end;
end;
procedure generarNuevaEstruc(v:Vector;var a:arbol);
            procedure insertarAdelante(var l:listaFinales;i:infoFinal);
            var
                nue:listaFinales;
            begin
                new(nue);
                nue^.elem:=i;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure ActualizarInfo(var f:infoFinal;i:infoLista;anio:integer);
            begin
                f.nota:=i.nota;
                f.dia:=i.dia;
                f.mes:=i.mes;
                f.anio:=anio;
            end;
            procedure insertarExamen(var a:arbol;legajoBus:integer;f:infoFinal);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.legajo:=legajoBus;
                    a^.elem.final:=nil;
                    insertarAdelante(a^.elem.final,f);
                end
                else if(legajoBus=a^.elem.legajo)then
                    insertarAdelante(a^.elem.final,f)
                else if(legajoBus<a^.elem.legajo)then
                    insertarExamen(a^.HI,legajoBus,f)
                else
                    insertarExamen(a^.HD,legajoBus,f);
            end;
            procedure cargarArbol(l:lista;nota,pos:integer;var a:arbol);
            var
                f:infoFinal;
            begin
                while(l<>nil)and(l^.elem.nota>nota)do begin
                    ActualizarInfo(f,l^.elem,pos);
                    insertarExamen(a,l^.elem.legajo,f);
                    l:=l^.sig;
                end;
            end;
            procedure generarArbol(v:vector;nota:integer;var a:arbol);
            var
                i:rangoanios;
            begin
                for i:=DL to DF do
                    cargarArbol(v[i],nota,i,a);
            end;
var
    notaPrueba:integer;
begin
    write('ingrese una nota:');
    readln(notaPrueba);
    a:=nil;
    generarArbol(v,notaPrueba,a);
end;
function cantExamenesRendidos(a:arbol):integer;
            function contadorExamenes(l:listaFinales):integer;
            var
                cant:integer;
            begin
                cant:=0;
                while(l<>nil)do begin
                    cant:=cant + 1;
                    l:=l^.sig;
                end;
                contadorExamenes:=cant;
            end;
            function BuscarLegajo(a:arbol;legBus:integer):integer;
            begin
                if(a=nil)then
                    BuscarLegajo:=0
                else if(a^.elem.legajo<legBus)then
                    BuscarLegajo:=BuscarLegajo(a^.HD,legBus)
                else if(a^.elem.legajo>legBus)then
                    BuscarLegajo:=BuscarLegajo(a^.HI,legBus)
                else
                    BuscarLegajo:=contadorExamenes(a^.elem.final);
            end;
var
    legajo:integer;
begin
    write('ingrese un legajo:');
    readln(legajo);
    cantExamenesRendidos:=BuscarLegajo(a,legajo);
end;
var
    v:vector;
    a:arbol;
    cantExamen:integer;
begin
    randomize;
    //inciso A
    CargarVecListas(v);
    //inciso B
    generarNuevaEstruc(v,a);
    //inciso C
    cantExamen:=cantExamenesRendidos(a);
end.