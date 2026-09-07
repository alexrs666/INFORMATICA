{10) Un supermercado necesita implementar un programa para administrar las compras
realizadas por sus clientes durante el año 2025. De cada compra se lee el código de
cliente, día del mes (1..31), mes (1..12) y monto total gastado. La lectura finaliza cuando se
lee el cliente con código 0. En el programa se debe:
a) Implementar un módulo que lea la información de las compras y retorne un árbol
binario de búsqueda ordenado por código de cliente. Para cada código de cliente, se
debe almacenar un vector con el monto total gastado por dicho cliente en cada mes del
año 2025.
b) Realizar un módulo que reciba la estructura generada en el inciso a) y un código de
cliente, y retorne el mes con mayor gasto de dicho cliente.
c) Realizar un módulo que reciba la estructura generada en el inciso a) y un número de
mes, y retorne la cantidad de clientes que no gastaron nada en dicho mes.}
program P5_EJE10_TALLER;
const
    DD=31;
    DM=12;
type    
    subDia=1..DD;
    subMes=1..DM;
    compras=record
        monto:real;
        dia:subDia;
        mes:subMes;
        codCli:integer;
    end;
    vector=array[subMes]of real;
    infoArbol=record
        codCli:integer;
        vecMon:vector;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
procedure cargarArbol(var a:arbol);
            procedure LeerCompra(var c:compras);
            begin
                c.codCli:=random(100);
                if(c.codCli<>0)then begin
                    c.monto:=random(10000)/(random(15)+1);
                    c.dia:=random(DD)+1;
                    c.mes:=random(DM)+1;
                end;
            end;
            procedure iniciaizarVec(var v:vector);
            var
                i:subMes;
            begin
                for i:=1 to DM do
                    v[i]:=0;
            end;
            procedure insertarCompra(var a:arbol;c:compras);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.codCli:=c.codCli;
                    iniciaizarVec(a^.elem.vecMon);
                    a^.elem.vecMon[c.mes]:=c.monto;
                end
                else if(c.codCli=a^.elem.codCli)then 
                    a^.elem.vecMon[c.mes]:=a^.elem.vecMon[c.mes] + c.monto
                else if(c.codCli<a^.elem.codCli)then
                    insertarCompra(a^.HI,c)
                else
                    insertarCompra(a^.HD,c);
            end;
var
    c:compras;
begin
    LeerCompra(c);
    while(c.codCli<>0)do begin
        insertarCompra(a,c);
        LeerCompra(c);
    end;
end;
function MayorGastoCliente(a:arbol;codC:integer):integer;
    function MaxMesGastos(v:vector):integer;
    var 
        max:real;
        i:subMes;
        maxM:integer;
    begin
        max:=-1;
        for i:=1 to DM do begin
            if(v[i]>max)then begin
                max:=v[i];
                maxM:=i;
            end;
        end;
        MaxMesGastos:=maxM;
    end;
begin
    if(a=nil)then
        MayorGastoCliente:=0
    else if(a^.elem.codCli<codC)then
        MayorGastoCliente:=MayorGastoCliente(a^.HD,codC)
    else if(a^.elem.codCli>codC)then
        MayorGastoCliente:=MayorGastoCliente(a^.HI,codC)
    else
        MayorGastoCliente:=MaxMesGastos(a^.elem.vecMon);
end;
function BuscarMeses(a:arbol;mes:subMes):integer;
begin
    if(a=nil)then
        BuscarMeses:=0
    else if(a^.elem.vecMon[mes]=0)then
        BuscarMeses:=1+ BuscarMeses(a^.HI,mes) + BuscarMeses(a^.HD,mes)
    else
        BuscarMeses:=BuscarMeses(a^.HI,mes)+BuscarMeses(a^.HD,mes);
end;
var
    a:arbol;
    codCliente:integer;
    mesPrueba:subMes;
    MaxMes:integer;
    cantClientes:integer;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    readln(codCliente);
    MaxMes:=MayorGastoCliente(a,codCliente);
    //inciso C
    readln(mesPrueba);
    cantClientes:=BuscarMeses(a,mesPrueba);
end.