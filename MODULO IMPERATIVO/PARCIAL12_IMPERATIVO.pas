{TURNO:E   PARCIAL IMPERATIVO FECHA:08/09/2026
Un corralon necesita un sistema para procesar la informacion de pedidos a proveedores.De cada pedid se conoce:
Cuit de proveedor,codigo de sucursal(1..20),fecha de pedidoy monto.
    a)implementar un modulo que lea informacion de pedidos la ,La lectura finaliza al ingresar el Cuit 0.Este modulo debe retornar
        i.Una estructura de datos eficientes para busqueda por Cuit.Para cada Cuit debe almacenarse una lista
            con sus pedidos.
        ii.Una estructura de datos que almacene la cantidad de pedidos por sucursal.
    b) Realizar un módulo que reciba la estructura generada en el inciso a) i., un monto y un CUIT. El módulo debe
        retomar la cantidad de pedidos que superen el monto para dicho CUIT.
    c)Realuar un módulo recursivo que reciba la estructura generada en inciso a) ii. y retorne el código de sucursal
        con mayor cantidad de pedidos.}
program PARCIAL12_IMPERATIVO;
const
    DF=20;
type
    subSucur=1..DF;
    pedido=record
        CuitProve:integer;
        codSucur:subSucur;
        fecha:string;
        monto:real;
    end;
    infoLista=record
        codSucur:subSucur;
        fecha:string;
        monto:real;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        CuitProve:integer;
        lisP:lista;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    vector=array[subSucur]of integer;
procedure cargarArbolyVec(var a:arbol;var v:vector);
            procedure leerPedido(var p:pedido);
            begin
                p.CuitProve:=random(1000);
                if(p.CuitProve<>0)then begin
                    p.monto:=random(10000)/(random(15)+1);
                    p.codSucur:=random(DF)+1;
                    readln(p.fecha);
                end;
            end;
            procedure inicializarVec(var v:vector);
            var 
                i:subSucur;
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
            procedure insertarPedidos(var a:arbol;cuitBus:integer;i:infoLista);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.lisP:=nil;
                    a^.elem.CuitProve:=cuitBus;
                    insertarAdelante(a^.elem.lisP,i);
                end
                else if(cuitBus = a^.elem.CuitProve)then
                    insertarAdelante(a^.elem.lisP,i)
                else if(cuitBus<a^.elem.CuitProve)then
                    insertarPedidos(a^.HI,cuitBus,i)
                else
                    insertarPedidos(a^.HD,cuitBus,i);
            end;
            procedure actualizarInfo(p:pedido;var i:infoLista);
            begin
                i.codSucur:=p.codSucur;
                i.monto:=p.monto;
                i.fecha:=p.fecha;
            end;
var
    p:pedido;
    i:infoLista;
begin
    a:=nil;
    inicializarVec(v);
    leerPedido(p);
    while(p.CuitProve<>0)do begin
        actualizarInfo(p,i);
        insertarPedidos(a,p.CuitProve,i);
        v[p.codSucur]:=v[p.codSucur] + 1;
        leerPedido(p);
    end;
end;
function retornarCantMontosMayor(a:arbol;mon:real;cuitPrueba:integer):integer;
            function cantMontosSuperan(l:lista;mon:real):integer;
            var
                cant:integer;
            begin
                cant:=0;
                while(l<>nil)do begin
                    if(l^.elem.monto>mon)then
                        cant:=cant + 1;
                    l:=l^.sig;
                end;
                cantMontosSuperan:=cant;
            end;
            function BuscarCuit(a:arbol;mon:real;cuitPrueba:integer):integer;
            begin
                if(a=nil)then
                    BuscarCuit:=0
                else if(a^.elem.CuitProve<cuitPrueba)then
                    BuscarCuit:=BuscarCuit(a^.HD,mon,cuitPrueba)
                else if(a^.elem.CuitProve>cuitPrueba)then
                    BuscarCuit:=BuscarCuit(a^.HI,mon,cuitPrueba)
                else
                    BuscarCuit:=cantMontosSuperan(a^.elem.lisP,mon);
            end;
begin
    retornarCantMontosMayor:=BuscarCuit(a,mon,cuitPrueba);
end;
function retornarMaxSucur(v:vector):integer;
            procedure Maximo(codS,cantS:integer;var max,maxS:integer);
            begin
                if(cantS>max)then begin
                    max:=cantS;
                    maxS:=codS;
                end;
            end;
            procedure CalcularMaximos(v:vector;pos:integer;var max,maxS:integer);
            begin
                if(pos<=DF)then begin
                    Maximo(pos,v[pos],max,maxS);
                    CalcularMaximos(v,pos+1,max,maxS);
                end;
            end;
var
    max:integer;
    MaxS:integer;
begin
    max:=-1;
    CalcularMaximos(v,1,max,MaxS);
    retornarMaxSucur:=MaxS;
end;
var
    a:arbol;
    v:vector;

    cuitPrue:integer;
    montoPrue:real;
    cantMontos:integer;
    MaxSucur:integer;
begin
    randomize;
    //inciso A
    cargarArbolyVec(a,v);
    //inciso B
    readln(cuitPrue);
    readln(montoPrue);
    cantMontos:=retornarCantMontosMayor(a,montoPrue,cuitPrue);
    //inciso C
    MaxSucur:=retornarMaxSucur(v);
end.