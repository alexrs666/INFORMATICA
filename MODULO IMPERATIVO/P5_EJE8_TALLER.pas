{8) Un supermercado necesita implementar un programa para procesar la información de sus
ventas. De cada venta se conoce: DNI de cliente, código de sucursal (1..10), número de
factura y monto total de la venta. En el programa se debe:
a) Implementar un módulo que lea información de las ventas. La lectura finaliza al
ingresar DNI de cliente igual a 0 y se debe retornar dos estructuras de datos:
i) Una estructura de datos eficiente para la búsqueda por DNI de cliente. Para cada
DNI debe almacenarse una lista de todas sus compras (número de factura y monto
total).
ii) Una estructura de datos que almacene la cantidad de ventas para cada sucursal.
b) Implementar un módulo que reciba la estructura generada en el inciso a) i), un monto y
un DNI. El módulo debe retornar la cantidad de facturas cuyo monto es superior al
monto recibido para el DNI recibido.
c) Implementar un módulo recursivo que reciba la estructura generada en inciso a) ii) y
retorne el código de sucursal con mayor cantidad de ventas.}
program P5_EJE8_TALLER;
const
    DF=10;
    DL=1;
type
    subSucursal=DL..DF;
    ventas=record
        cod_Sucur:integer;
        dni:integer;
        monto:real;
        num_fac:integer;
    end;
    infoLista=record
        monto:real;
        num_fac:integer;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        dni:integer;
        lisV:lista;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    vector=array[subSucursal]of integer;
procedure cargarArbolyVec(var a:arbol;var v:vector);
            procedure LeerVenta(var s:ventas);
            begin
                s.dni:=random(100);
                if(s.dni<>0)then begin
                    s.num_fac:=random(1000);
                    s.monto:=random(10000)/(random(15)+1);
                    s.cod_Sucur:=random(1000)+1;
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
            procedure insertarVenta(var a:arbol;s:ventas);
            var
                i:infoLista;
            begin
                i.num_fac:=s.num_fac;
                i.monto:=s.monto;
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.dni:=s.dni;
                    a^.elem.lisV:=nil;
                    insertarAdelante(a^.elem.lisV,i);
                end
                else if(s.dni=a^.elem.dni)then begin
                    insertarAdelante(a^.elem.lisV,i);
                end
                else if(s.dni<a^.elem.dni)then
                    insertarVenta(a^.HI,s)
                else
                    insertarVenta(a^.HD,s);
            end;
            procedure inicializarVec(var v:vector);
            var
                i:subSucursal;
            begin
                for i:=DL to DF do
                    v[i]:=0;
            end;
var
    s:ventas;
begin
    LeerVenta(s);
    inicializarVec(v);
    while(s.dni<>0)do begin
        insertarVenta(a,s);
        v[s.cod_Sucur]:=v[s.cod_Sucur]+1;
        LeerVenta(s);
    end;
end;
function contarSupMonto(l:lista;monP:real):integer;
var
    cant:integer;
begin
    cant:=0;
    while(l<>nil)do begin
        if(l^.elem.monto>monP)then
            cant:=cant + 1;
        l:=l^.sig;
    end;
    contarSupMonto:=cant;
end;
function BuscarNodo(a:arbol;dniP:integer;monP:real):integer;
begin
    if(a=nil)then
        BuscarNodo:=0
    else if(a^.elem.dni<dniP)then
        BuscarNodo:=BuscarNodo(a^.HD,dniP,monP)
    else if(a^.elem.dni>dniP)then
        BuscarNodo:=BuscarNodo(a^.HI,dniP,monP)
    else
        BuscarNodo:=contarSupMonto(a^.elem.lisV,monP);
end;
function retornarMayorSucur(v:vector):integer;
            procedure retornarElMax(monto:real;posI:integer;var max:real;var pos:integer);
            begin
                if(monto>max)then begin
                    max:=monto;
                    pos:=posI;
                end;
            end;
            procedure BuscarMax(v:vector;dimF:integer;var max:real;var pos:integer);
            begin
                if(dimF>0)then begin
                    retornarElMax(v[dimF],dimF,max,pos);
                    BuscarMax(v,dimF-1,max,pos);
                end;
            end;
var
    max:real;
    pos:integer;
begin
    max:=-1;
    pos:=0;
    BuscarMax(v,DF,max,pos);
    retornarMayorSucur:=pos;
end;
var
    a:arbol;
    v:vector;
    montoPrueba:real;
    dniPrueba:integer;
    cantSup:integer;
    MayorSucursal:integer;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbolyVec(a,v);
    //inciso B
    readln(montoPrueba);
    readln(dniPrueba);
    cantSup:=BuscarNodo(a,dniPrueba,montoPrueba);
    //inciso C
    MayorSucursal:=retornarMayorSucur(v);
end.