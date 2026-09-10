{TURNO:B   PARCIAL IMPERATIVO FECHA:09/09/2026
El campeonato nacional del Alfajor necesita un sistema para obtener estadisticas sobre los alfajores presentados
    a) Implementar un módulo que lea información de los alfajores. De cada alfajor conoce: código de identificación
        unico (100 al 200), cuit del fabricante y nombre del ingrediente base. La lectura finaliza con el valor 0 para el
        cut. Se sugiere utficor el módulo leerAlfajor(). El módulo deber retornar dos estructuras
        i. Un arbol binario de busqueda ordenado por cuit del fabricante. Para cada cuit debe almacenarse la
             cantidad de alfajores correspondientes a dicho fabricante.
        ii.Una lista que almacene en cada nodo el nombre del ingrediente base y la cantidad total de alfajores de ese
             Ingrediente. Esta estructura debe quedar ordenada por el nombre del ingrediente.
    b) Implementar un módulo que reciba el árbol generado en a)i., y un cuit. El módulo debe retornar la cantidad de
        fabricantes con cuit menor al cuit ingresado.
    c) Implementar un módulo recursivo que reciba la lista generada en a)ii, y retorne el nombre del ingrediente base
con mayor cantidad de alfajores.}
program PARCIAL13_IMPERATIVO;
type
    alfajores=record
        codAlf:integer;
        cuit:integer;
        nomIn:string;
    end;
    infoArbol=record
        cuit:integer;
        cantAlf:integer;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    infoLista=record
        nomIn:string;
        cantIn:integer;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    conj= set of 100..200;
procedure CargarArbolyLista(var a:arbol;var l:lista);
            procedure leerAlfajor(var a:alfajores;var c:conj);
            begin
                a.cuit:=random(100);
                if(a.cuit<>0)then begin
                    a.codAlf:=random(101)+100;
                    while(a.codAlf in C)do 
                        a.codAlf:=random(101)+100;
                    c:=c + [a.codAlf];
                    readln(a.nomIn);
                end;
            end;
            procedure insertarAlfajores(var a:arbol;cuitBus:integer);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.cuit:=cuitBus;
                    a^.elem.cantAlf:=1;
                end
                else if(cuitBus=a^.elem.cuit)then
                    a^.elem.cantAlf:=a^.elem.cantAlf + 1
                else if(cuitBus<a^.elem.cuit)then
                    insertarAlfajores(a^.HI,cuitBus)
                else
                    insertarAlfajores(a^.HD,cuitBus);
            end;
            procedure actualizarListaOrdenada(var l:lista;ingrediente:string);
            var
                ant,act,nue:lista;
            begin
                act:=l;
                while(act<>nil)and(act^.elem.nomIn<ingrediente)do begin
                    ant:=act;
                    act:=act^.sig;
                end;

                if(act<>nil)and(act^.elem.nomIn=ingrediente)then
                    act^.elem.cantIn:=act^.elem.cantIn + 1
                else begin
                    new(nue);
                    nue^.elem.nomIn:=ingrediente;
                    nue^.elem.cantIn:=1;
                    nue^.sig:=act;
                    if(act=l)then
                        l:=nue
                    else
                        ant^.sig:=nue;
                end;
            end;
var
    alf:alfajores;
    c:conj;
begin
    a:=nil;
    l:=nil;
    c:=[];
    leerAlfajor(alf,c);
    while(alf.cuit<>0)do begin
        insertarAlfajores(a,alf.cuit);
        actualizarListaOrdenada(l,alf.nomIn);
        leerAlfajor(alf,c);
    end;
end;
function CantCuitMenores(a:arbol;cuit:integer):integer;
begin
    if(a=nil)then
        CantCuitMenores:=0
    else if(a^.elem.cuit<cuit)then
        CantCuitMenores:= 1 + CantCuitMenores(a^.HI,cuit) + CantCuitMenores(a^.HD,cuit)
    else
        cantCuitMenores:=cantCuitMenores(a^.HI,cuit);
end;
procedure CantMaxNombre(l:lista;var nomMax:string);
                procedure maximo(cant:integer;nombre:string;var max:integer;var nomM:string);
                begin
                    if(cant>max)then begin
                        max:=cant;
                        nomM:=nombre;
                    end;
                end;
                procedure BuscarMaximo(l:lista;var max:integer;var nomM:string);
                begin
                    if(l<>nil)then begin
                        maximo(l^.elem.cantIn,l^.elem.nomIn,max,nomM);
                        BuscarMaximo(l^.sig,max,nomM);
                    end;
                end;
var
    max:integer;
begin
    max:=-1;
    BuscarMaximo(l,max,nomMax);
end;
var
    a:arbol;
    l:lista;

    cuitPrueba:integer;
    cuitMenores:integer;

    maxNombreIn:string;
begin
    randomize;
    //inciso A
    CargarArbolyLista(a,l);
    //inciso B
    readln(cuitPrueba);
    cuitMenores:=CantCuitMenores(a,cuitPrueba);
    //inciso C
    CantMaxNombre(l,maxNombreIn);
end.