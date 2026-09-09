{TURNO:F   PARCIAL IMPERATIVO FEHCA:08/09/2026
Una agencia de alquiler de vehículos necesita un sistema para procesar la información de sus alquileres. De cada alquiler
se conoce: patente, fecha, DNI del cliente y cantidad de días alquilados.
a) Implementar un módulo que lea información de los alquileres y retorne una estructura de datos eficiente para la
búsqueda por DNI y que para cada DNI contenga sus alquileres. La lectura finaliza al ingresar el valor 0 para un DNI.
b) Realizar un módulo que reciba la estructura generada en el inciso a) y retorne otra estructura que almacene para
patente, la cantidad total de días que se alquiló.
c) Realizar un módulo recursivo que reciba la estructura generada en inciso b) y retorne patente del vehículo con
mayor cantidad de días alquilados.}
program PARCIAL9_IMPERATIVO;
type
	alquiler=record
        patente:string;
        fecha:string;
        dni:integer;
        cantDias:integer;
    end;
    infoLista=record
        fecha:string;
        patente:string;
        cantDias:integer;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        dni:integer;
        lisA:lista;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    infoLista2=record
        patente:string;
        canTotDias:integer;
    end;
    lista2=^nodoLista2;
    nodoLista2=record
        elem:infoLista2;
        sig:lista2;
    end;
procedure cargarArbol(var a:arbol);
            procedure leerAlquiler(var alqui:alquiler);
            begin
                alqui.dni:=random(10000);
                if(alqui.dni<>0)then begin
                    readln(alqui.patente);
                    readln(alqui.fecha);
                    alqui.cantDias:=random(31)+1;
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
            procedure insertarAlquiler(var a:arbol;DniBus:integer;i:infoLista);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.dni:=DniBus;
                    a^.elem.lisA:=nil;
                    insertarAdelante(a^.elem.lisA,i);
                end
                else if(DniBus=a^.elem.dni)then
                    insertarAdelante(a^.elem.lisA,i)
                else if(DniBus<a^.elem.dni)then
                    insertarAlquiler(a^.HI,DniBus,i)
                else
                    insertarAlquiler(a^.HD,DniBus,i);
            end;
            procedure ActualizarInfo(var i:infoLista;alqui:alquiler);
            begin
                i.patente:=alqui.patente;
                i.fecha:=alqui.fecha;
                i.cantDias:=alqui.cantDias;
            end;
var
    alqui:alquiler;
    i:infoLista;
begin
    a:=nil;
    leerAlquiler(alqui);
    while(alqui.dni<>0)do begin
        ActualizarInfo(i,alqui);
        insertarAlquiler(a,alqui.dni,i);
        leerAlquiler(alqui);
    end;
end;
procedure retornarEstrutura(a:arbol;var l2:lista2);
            procedure insertarAdelante(var l2:lista2;i:infoLista2);
            var 
                nue:lista2;
            begin
                new(nue);
                nue^.elem.patente:=i.patente;
                nue^.elem.canTotDias:=i.canTotDias;
                nue^.sig:=l2;
                l2:=nue;
            end;
            procedure armarLista(var l2:lista2;i:infoLista2);
            var
                aux:lista2;
            begin
                aux:=l2;
                while(aux<>nil)and(aux^.elem.patente<>i.patente)do begin
                    aux:=aux^.sig;
                end;
                if(aux<>nil)then
                    aux^.elem.canTotDias:=aux^.elem.canTotDias + i.canTotDias
                else
                    insertarAdelante(l2,i);
            end;
            procedure recorrerLista(l:lista;var l2:lista2);
            var
                i:infoLista2;
            begin
                while(l<>nil)do begin
                    i.patente:=l^.elem.patente;
                    i.canTotDias:=l^.elem.cantDias;
                    armarLista(l2,i);
                    l:=l^.sig;
                end;
            end;
            procedure recorrerArbol(a:arbol;var l2:lista2);
            begin
                if(a<>nil)then begin
                    recorrerLista(a^.elem.lisA,l2);
                    recorrerArbol(a^.HI,l2);
                    recorrerArbol(a^.HD,l2);
                end;
            end;

begin
    l2:=nil;
    recorrerArbol(a,l2);
end;
procedure retornarMaxPatente(l2:lista2;var MaxP:string);
        procedure Maximo(cant:integer;pat:string;var max:integer;var MaxP:string);
        begin
            if(cant>max)then begin
                max:=cant;
                MaxP:=pat;
            end;
        end;
        procedure BuscarMaximo(l2:lista2;var MaxP:string;var max:integer);
        begin
            if(l2<>nil)then begin
                Maximo(l2^.elem.canTotDias,l2^.elem.patente,max,MaxP);
                BuscarMaximo(l2^.sig,MaxP,max);
            end;
        end;
var
    max:integer;    
begin
    max:=-1;
    BuscarMaximo(l2,MaxP,max);
end;
var
    a:arbol;
    l2:lista2;
    MaxPatente:string;
begin
    randomize;
    //inciso A
    cargarArbol(a);
    //inciso B
    retornarEstrutura(a,l2);
    //inciso C
    retornarMaxPatente(l2,MaxPatente);
end.
	