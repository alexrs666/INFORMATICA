{5) La Feria del Artesano necesita implementar un programa para obtener estadísticas sobre
las artesanías presentadas. En el programa se pide:
a) Implementar un módulo que lea información de las artesanías. De cada artesanía se
    conoce: código de identificación de la artesanía, DNI del artesano y nombre del
    material base. La lectura finaliza con el valor 0 para el DNI. Este módulo debe retornar
    dos estructuras de datos:
    i) Un árbol binario de búsqueda ordenado por el DNI del artesano. Para cada DNI del
        artesano debe almacenarse la cantidad de artesanías correspondientes.
    ii) Una lista que almacene en cada nodo el nombre del material base y la cantidad
        total de artesanías de ese material.
b) Implementar un módulo que reciba el árbol generado en el inciso a)i), y un DNI. El
    módulo debe retornar la cantidad de artesanos con DNI menor al DNI ingresado.
c) Implementar un módulo recursivo que reciba la lista generada en el inciso a)ii) y
    retorne el nombre de material base con mayor cantidad de artesanías.}
program P5_EJE5_TALLER;
type
    artesanias=record
        cod_ide:integer;
        DNI_art:integer;
        nom_Mate:string;
    end;
    infoArbol=record
        DNI_art:integer;
        cantArt:integer;
    end;
    arbol=^nodo;
    nodo=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    infoLista=record
        nom_Mate:string;
        cantArtMate:integer;
    end;
    lista=^nodo2;
    nodo2=record
        elem:infoLista;
        sig:lista;
    end;
procedure CargarArbolyLista(var a:arbol;var l:lista);
            procedure LeerArtesanias(var a:artesanias);
            begin
                readln(a.DNI_art);
                if(a.DNI_art<>0)then begin
                    readln(a.cod_ide);
                    readln(a.nom_Mate);
                end;
            end;
            procedure insertarArtesania(var a:arbol;r:artesanias);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.DNI_art:=r.DNI_art;
                    a^.elem.cantArt:=1;
                end
                else if(r.DNI_art=a^.elem.DNI_art)then
                    a^.elem.cantArt:=a^.elem.cantArt + 1
                else if(r.DNI_art<a^.elem.DNI_art)then
                    insertarArtesania(a^.HI,r)
                else
                    insertarArtesania(a^.HD,r);
            end;
            procedure insertarAdelante(var l:lista;nomMate:string);
            var
                nue:lista;
            begin
                new(nue);
                nue^.elem.nom_Mate:=nomMate;
                nue^.elem.cantArtMate:=1;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure actualizarMateriales(var l:lista;material:string);
            var
                aux:lista;
            begin
                aux:=l;
                while(aux<>nil)and(aux^.elem.nom_Mate<>material)do begin
                    aux:=aux^.sig;
                end;
                if(aux<>nil)then
                    aux^.elem.cantArtMate:=aux^.elem.cantArtMate + 1
                else
                    insertarAdelante(l,material);
            end;
var
    r:artesanias;
begin
    LeerArtesanias(r);
    while(r.DNI_art<>0)do begin
        insertarArtesania(a,r);
        actualizarMateriales(l,r.nom_Mate);
        LeerArtesanias(r);
    end;
end;
function CantDniMenores(a:arbol):integer;
            function contarNodos(a:arbol;dni:integer):integer;
            begin
                if(a=nil)then
                    contarNodos:=0
                else if(a^.elem.DNI_art>=dni)then
                    contarNodos:=contarNodos(a^.HI,dni)
                else
                    contarNodos:=1+ contarNodos(a^.HI,dni) + contarNodos(a^.HD,dni);
            end;
var
    dni:integer;
begin
    readln(dni);
    CantDniMenores:=contarNodos(a,dni);
end;
procedure MaxMateriales(l:lista;var mxMaterial:string);
        procedure Maximo(mate:string;cant:integer;var max:integer;var maxMate:string);
        begin
            if(cant>max)then begin
                max:=cant;
                maxMate:=mate;
            end;
        end;
        procedure CalcularMaximo(l:lista;var max:integer;var maxM:string);
        begin
            if(l<>nil)then begin
                Maximo(l^.elem.nom_Mate,l^.elem.cantArtMate,max,MaxM);
                CalcularMaximo(l^.sig,max,maxM);
            end;
        end;
var
    max:integer;
    MaxM:string;
begin
    max:=-1;
    CalcularMaximo(l,max,MaxM);
    mxMaterial:=MaxM;
end;
var
    a:arbol;
    l:lista;
    cantDniMen:integer;
    MaxMate:string;
begin
    a:=nil;
    l:=nil;
    //inciso A
    CargarArbolyLista(a,l);
    //inciso B
    cantDniMen:=CantDniMenores(a);
    //inciso C
    MaxMateriales(l,MaxMate);
end.