{9) Una biblioteca necesita implementar un programa para procesar la información de los
libros que administra. De cada libro se conoce: ISBN, código del autor y código de género
(de 1 a 15). En el programa se debe:
a) Implementar un módulo que lea información de los libros y retorne una estructura de
datos eficiente para la búsqueda por código de autor que contenga código de autor y
una lista de todos sus libros. La lectura finaliza al ingresar un ISBN con el valor 0.
b) Implementar un módulo que reciba la estructura generada en el inciso a), un código de
autor y un código de género. El módulo debe retornar una lista que contenga un código
de autor y la cantidad de libros para el código de género recibido, para cada autor cuyo
código sea superior al código de autor recibido.
c) Realizar un módulo recursivo que reciba la estructura generada en inciso b) y retorne
cantidad y código de autor con mayor cantidad de libros.}
program P5_EJE9_TALLER;
const
    DF=15;
    DL=1;
type
    subGen=DL..DF;
    libros=record
        ISBN:integer;
        cod_autor:integer;
        cod_gen:subGen;
    end;
    infoLista=record
        ISBN:integer;
        cod_gen:subGen;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        cod_autor:integer;
        lisB:lista;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    infoLista2=record
        cod_autor:integer;
        cantLib:integer;
    end;
    lista2=^nodoLista2;
    nodoLista2=record
        elem:infoLista2;
        sig:lista2;
    end;
procedure cargarArbol(var a:arbol);
            procedure leerLibros(var l:libros);
            begin
                l.ISBN:=random(100);
                if(l.ISBN<>0)then begin
                    l.cod_autor:=random(1000);
                    l.cod_gen:=random(15)+1;
                end;
            end;
            procedure insertarAdelante(var l:lista;i:infoLista);
            var
                nue:lista;
            begin
                new(nue);
                nue^.elem:=i;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure insertarLibros(var a:arbol;l:libros;i:infoLista);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.cod_autor:=l.cod_autor;
                    a^.elem.lisB:=nil;
                    insertarAdelante(a^.elem.lisB,i);
                end
                else if(l.cod_autor=a^.elem.cod_autor)then
                    insertarAdelante(a^.elem.lisB,i)
                else if(l.cod_autor<a^.elem.cod_autor)then
                    insertarLibros(a^.HI,l)
                else
                    insertarLibros(a^.HD,l);
            end;
            procedure actualizarDatos(var i:infoLista;l:libros);
            begin
                i.cod_gen:=l.cod_gen;
                i.ISBN:=l.ISBN;
            end;
var
    l:libros;
    i:infoLista;
begin
    leerLibros(l);
    while(l.ISBN<>0)do begin
        actualizarDatos(i,l);
        insertarLibros(a,l,i);
        leerLibros(l);
    end;
end;
procedure RetornarNuevaLista(a:arbol;var l2:lista2;codP:integer;codG:subGen);
            function contarGeneros(l:lista;codG:subGen):integer;
            var
                cant:integer;
            begin
                cant:=0;
                while(l<>nil)do begin
                    if(l^.elem.cod_gen=codG)then
                        cant:=cant + 1;
                    l:=l^.sig;
                end;
                contarGeneros:=cant;
            end;
            procedure insertarAdelante(var l2:lista2;i:infoLista2);
            var 
                nue:lista2;
            begin
                new(nue);
                nue^.elem:=i;
                nue^.sig:=l2;
                l2:=nue;
            end;
            procedure BuscarAutorMayor(a:arbol;var l2:lista2;codP:integer;codG:subGen);
            var
                i:infoLista2;
            begin
                if(a<>nil)then begin
                    if(a^.elem.cod_autor>codP)then begin
                        i.cantLib:=contarGeneros(a^.elem.lisB,codG);
                        i.cod_autor:=a^.elem.cod_autor;

                        insertarAdelante(l2,i);
                        
                        BuscarAutorMayor(a^.HI,l2,codP,codG);
                        BuscarAutorMayor(a^.HD,l2,codP,codG);
                    end
                    else begin
                        BuscarAutorMayor(a^.HD,l2,codP,codG);
                    end;
                end;
            end;
begin
    l2:=nil;
    BuscarAutorMayor(a,l2,codP,codG);
end;
procedure retornarCantYCod(l2:lista2;var i:infoLista2);
            procedure BuscarMaximo(l2:lista2;var i:infoLista2);
            begin
                if(l2<>nil)then begin
                    if(l2^.elem.cantLib>i.cantLib)then begin
                        i.cantLib:=l2^.elem.cantLib;
                        i.cod_autor:=l2^.elem.cod_autor;
                    end;
                    BuscarMaximo(l2^.sig,i);
                end;
            end;
begin   
    i.cantLib:=-1;
    BuscarMaximo(l2,i);
end;
var
    a:arbol;
    l2:lista2;
    codAutorPrueba:integer;
    codGenPrueba:subGen;
    i:infoLista2;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    readln(codAutorPrueba);
    readln(codGenPrueba);
    RetornarNuevaLista(a,l2,codAutorPrueba,codGenPrueba);
    //inciso C
    retornarCantYCod(l2,i);
end.