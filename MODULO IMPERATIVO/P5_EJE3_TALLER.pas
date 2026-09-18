{3. PlayStation Store requiere procesar las compras realizadas por sus clientes durante el año
2023.
a) Implementar un módulo que lea compras de videojuegos. De cada compra se lee
código del videojuego, código de cliente y mes. La lectura finaliza con el código de
cliente 0. Se sugiere utilizar el módulo leerCompra(). El módulo debe retornar un árbol
binario de búsqueda ordenado por código de videojuego. En el árbol, para cada código
de videojuego debe almacenarse una lista con código de cliente y mes perteneciente a
cada compra.
b) Implementar un módulo que reciba el árbol generado en a) y un código de videojuego.
El módulo debe retornar la lista de las compras de ese videojuego.
c) Implementar un módulo recursivo que reciba la lista generada en b) y un mes. El
módulo debe retorne la cantidad de clientes que compraron en el mes ingresado.
NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.
}
program P5_EJE3_TALLER;              
type

    compra = record
        cod_videojuego : integer;
        cod_cliente : integer;
        mes : integer;
    end;
    compra2 = record
        cod_cliente:integer;
        mes:integer;
    end;
    lista = ^nodo;
    nodo = record
        elem:compra2;
        sig:lista;
    end;
    listaCliente = record
        cod_videojuego:integer;
        listaCli:lista;
    end;
    arbol=^nodo2;
    nodo2=record
        elem:listaCliente;
        HI:arbol;
        HD:arbol;
    end;
procedure CargarArbol(var a:arbol);
    procedure insertarAdelante(var l:lista;c:compra2);
    var 
        nue:lista;
    begin
        new(nue);
        nue^.elem:=c;
        nue^.sig:=l;
        l:=nue;
    end;
    procedure leerCompra (var c : compra);
    begin
        c.cod_cliente := Random(200);
        if (c.cod_cliente <> 0)then begin
            c.mes := Random(12) + 1;
            c.cod_videojuego := Random(200) + 1000;
        end;
    end;
    procedure insertarCompra(var a:arbol;c:compra);
    var
        c2:compra2;
    begin
        c2.cod_cliente:=c.cod_cliente;
        c2.mes:=c.mes;
        if(a=Nil)then begin
            new(a);
            a^.elem.cod_videojuego:=c.cod_videojuego;
            a^.elem.listaCli:=Nil;
            insertarAdelante(a^.elem.listaCli,c2);
            a^.HI:=nil;
            a^.HD:=nil;
        end
        else if(c.cod_videojuego=a^.elem.cod_videojuego)then
            insertarAdelante(a^.elem.listaCli,c2)
        else if(c.cod_videojuego<a^.elem.cod_videojuego)then
            insertarCompra(a^.HI,c)
        else
            insertarCompra(a^.HD,c);
    end;
var
    c:compra;
begin
    leerCompra(c);
    While(c.cod_cliente<>0)do begin
        insertarCompra(a,c);
        leerCompra(c);
    end;
end;
procedure retornarlistaCompras(a:arbol;var nueL:lista);
        function recorrerArbol(a:arbol;valorCod:integer):lista;
        begin
            if(a=nil)Then
                recorrerArbol:=nil
            else if(a^.elem.cod_videojuego<valorCod)then
                recorrerArbol:=recorrerArbol(a^.HD,valorCod)
            else if(a^.elem.cod_videojuego>valorCod)then
                recorrerArbol:=recorrerArbol(a^.HI,valorCod)
            else
                recorrerArbol:=a^.elem.listaCli;
        end;
var
    valorCodigoV:integer;
begin
    write('ingrese un valor de codigo de videojuego:');
    readln(valorCodigoV);
    nueL:=recorrerArbol(a,valorCodigoV);
    if(nueL=nil)then
        write('no se encontro la lista')
    else 
        write('se encontro la lista exitosamente');
end;
function retornarCantMes(l:lista):integer;
        function cantM(l:lista;valorMes:integer):integer;
        begin
            if(l=nil)then
                cantM:=0
            else if(l^.elem.mes=valorMes)then
                cantM:= 1 + cantM(l^.sig,valorMes)
            else
                cantM:=cantM(l^.sig,valorMes);
        end;
var
    m:integer;
begin
    write('ingrese un mes:');
    readln(m);
    retornarCantMes:=cantM(l,m);
end;
var
    a:arbol;
    lnue:lista;
    cant:integer;
begin
    randomize;
    a:=nil;
    lnue:=nil;
    CargarArbol(a);
    retornarListaCompras(a,lnue);
    retornarCantMes(lnue);
    cant:=retornarCantMes(lnue);
end.