{Una empresa de delivery requiere el procesamiento de sus entregas durante el mes de julio de 2026.
a) Implementar un módulo que lea las entregas. De cada entrega se lee código de entrega, DNI de cliente, día y
categoría de la entrega (de 1 a 10). La lectura finaliza con el DNI de cliente 0. Se sugiere utilizar el módulo leerEntrega(). Se
deben retornar 2 estructuras de datos:
i. Un árbol binario de búsqueda ordenado por DNI del cliente. Para cada cliente deben almacenarse las
entregas que le fueron realizadas.
ii. Un vector que almacena la cantidad de entregas por categoría.

b) Implementar un módulo que reciba el árbol generado en a)i y dos DNI. El módulo debe retornar la cantidad total de
entregas que fueron realizadas a los clientes que se encuentren entre ambos DNI (inclusive).
c) Implementar un módulo recursivo que reciba el vector generado en a)ii, un valor entero y retorne si existe (o no)
una categoría con cantidad de entregas igual al valor recibido.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.}
program PARCIAL11_IMPERATIVO;
const
    DF=10;
type
    subCat=1..DF;
    entregas = record
        dia:integer;
        dnicli:integer;
        categ:subCat;   
        codEntrega:integer;
    end;
    infoLista = record
        dia:integer;
        categ:subCat;
        codEntrega:integer;
    end;
    lista = ^nodoLista;
    nodoLista = record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol = record
        dnicli:integer;
        lisE:lista;
    end;
    arbol = ^nodoArbol;
    nodoArbol = record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    vector=array[subCat]of integer;
procedure cargarArbolyVec(var a:arbol;var v:vector);
            procedure leerEntrega(var e:entregas);
            begin
                e.dnicli:=random(200);
                if(e.dnicli<>0)then begin
                    e.categ:=random(DF)+1;
                    e.codEntrega:=random(1000)+1;
                    e.dia:=random(31)+1;
                end;
            end;
            procedure inicializarVec(var v:vector);
            var
                i:subCat;
            begin
                for i:=1 to DF do
                    v[i]:=0;
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
            procedure insertarEntregas(var a:arbol;dniBus:integer;i:infoLista);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.dnicli:=dniBus;
                    a^.elem.lisE:=nil;
                    insertarAdelante(a^.elem.lisE,i);
                end
                else if(dniBus=a^.elem.dnicli)then
                    insertarAdelante(a^.elem.lisE,i)
                else if(dniBus<a^.elem.dnicli)then
                    insertarEntregas(a^.HI,dniBus,i)
                else
                    insertarEntregas(a^.HD,dniBus,i);
            end;
            procedure actualiazarInfo(e:entregas;var i:infoLista);
            begin
                i.dia:=e.dia;
                i.codEntrega:=e.codEntrega;
                i.categ:=e.categ;
            end;
var
    e:entregas;
    i:infoLista;
begin
    a:=nil;
    leerEntrega(e);
    inicializarVec(v);
    while(e.dnicli<>0)do begin
        actualiazarInfo(e,i);
        insertarEntregas(a,e.dnicli,i);
        v[e.categ]:=v[e.categ] +1;
        leerEntrega(e);
    end;
end;
function RangoDnisCantEn(a:arbol;li,ls:integer):integer;
            function cantEntregas(l:lista):integer;
            var 
                cant:integer;
            begin
                cant:=0;
                while(l<>nil)do begin
                    cant:=cant + 1;
                    l:=l^.sig;
                end;
                cantEntregas:=cant;
            end;
begin
    if(a=nil)then
        RangoDnisCantEn:=0
    else if(a^.elem.dnicli<li)then
        RangoDnisCantEn:=RangoDnisCantEn(a^.HD,li,ls)
    else if(a^.elem.dnicli>ls)then
        RangoDnisCantEn:=RangoDnisCantEn(a^.HI,li,ls)
    else
        RangoDnisCantEn:= cantEntregas(a^.elem.lisE) + RangoDnisCantEn(a^.HI,li,ls) + RangoDnisCantEn(a^.HD,li,ls);
end;
function retornarExiste(v:vector;valorPrueba:integer):boolean;
            function buscarValor(v:vector;valorPrueba,pos:integer):boolean;
            begin
                if(pos>DF)then
                    buscarValor:=false
                else if( v[pos]=valorPrueba)then
                    buscarValor:=true
                else
                    buscarValor:=buscarValor(v,valorPrueba,pos + 1);
            end;
begin   
    retornarExiste:=buscarValor(v,valorPrueba,1);
end;
var
    a:arbol;
    v:vector;
    limI,limS:integer;
    CantEnRangos:integer;

    valorPrue:integer;
    ExisteOno:boolean;
begin
    randomize;
    //inciso A
    cargarArbolyVec(a,v);
    //inciso B
    readln(limI);
    readln(limS);
    CantEnRangos:=RangoDnisCantEn(a,limI,limS);
    //inciso C
    readln(valorPrue);
    ExisteOno:=retornarExiste(v,valorPrue);
end.