{TURNO:I   PARCIAL IMPERATIVO FECHA:17/09/2025
Una casa de repuestos de automotores necesita un sistema para manejar el stock de repuestos.
a) Implementar un módulo que lea información de los repuestos y retorne un árbol binario de búsqueda
    ordenado por código de marca, donde por cada código de marca agrupe los repuestos por código de
    modelo de automóvil (cada código de marca podrá tener a lo sumo 15 códigos de modelos de
    automóviles. )

    De cada repuesto se lee: código de marca de automóvil, código de modelo (1 .. 15), stock, año
    fabricación. La lectura finaliza al ingresar el código de marca 0.

b) Realice un módulo que reciba la estructura generada en a), un código de marca M y retorne una lista
    ordenada por código de modelo con aquellos repuestos perteneciente al código de marca M cuyo
    stock es menor a 3.
c) Realice un módulo recursivo que reciba la estructura generada en b) y retorne la cantidad de repuestos
    cuyo stock es igual a 1.}
program PARCIAL4_IMPERATIVO;
const
    INF=1;
    SUP=15;
type
    subCod=INF..SUP;
    repuesto=record
        cod_mar:integer;
        cod_mode:subCod;
        stock:integer;
        anioFac:integer;
    end;
    repuestoNue=record
        stock:integer;
        anioFac:integer; 
    end;
    //
    respuestoEstrucNue=record
        cod_mode:subCod;
        stock:integer;
    end;
    lisOrdenada=^nodo3;
    nodo3=record
        elem:respuestoEstrucNue;
        sig:lisOrdenada;
    end;
    //
    lista=^nodo;
    nodo=record
        elem:repuestoNue;
        sig:lista;
    end;
    vector=array[subCod]of lista;
    regisNueRepuesto=record
        cod_mar:integer;
        vecLis:vector;
    end;
    arbol=^nodo2;
    nodo2=record
        elem:regisNueRepuesto;
        HI:arbol;
        HD:arbol;
    end;
procedure cargarArbol(var a:arbol);
            procedure LeerRepuesto(var r:repuesto);
            begin
                r.cod_mar:=random(100);
                if(r.cod_mar<>0)then begin
                    r.cod_mode:=random(15)+1;
                    r.stock:=random(1000)+1;
                    r.anioFac:=2000 + random(27);
                end;
            end;
            procedure insertarAdelante(var l:lista;r:repuestoNue);
            var
                nue:lista;
            begin
                new(nue);
                nue^.elem:=r;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure inicializarVecLis(var v:vector);
            var
                i:subCod;
            begin
                for i:=INF to SUP do 
                    v[i]:=nil;
            end;
            procedure insertarCodMarca(var a:arbol;r:repuesto);
            var
                rn:repuestoNue;
            begin
                rn.stock:=r.stock;
                rn.anioFac:=r.anioFac;
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.cod_mar:=r.cod_mar;
                    inicializarVecLis(a^.elem.vecLis);
                    insertarAdelante(a^.elem.vecLis[r.cod_mode],rn);
                end
                else if(r.cod_mar=a^.elem.cod_mar)then
                    insertarAdelante(a^.elem.vecLis[r.cod_mode],rn)
                else if(r.cod_mar<a^.elem.cod_mar)then
                    insertarCodMarca(a^.HI,r)
                else
                    insertarCodMarca(a^.HD,r);
            end;
var
    r:repuesto;
begin
    LeerRepuesto(r);
    while(r.cod_mar<>0)do begin
        insertarCodMarca(a,r);
        LeerRepuesto(r);
    end;
end;
procedure retornarLisOrdenada(a:arbol;var l:lisOrdenada);
            procedure insertarAdelante(var l:lisOrdenada;r:respuestoEstrucNue);
            var
                nue:lisOrdenada;
            begin
                new(nue);
                nue^.elem:=r;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure buscarStock(l:lista;var ls:lisOrdenada;pos:integer);
            var
                r:respuestoEstrucNue;
            begin
                while(l<>nil)do begin
                    if(l^.elem.stock<3)then begin
                        r.cod_mode:=pos;
                        r.stock:=l^.elem.stock;
                        insertarAdelante(ls,r);
                    end;
                    l:=l^.sig;
                end;
            end;
            procedure armarLista(v:vector;var l:lisOrdenada);
            var i:subCod;
            begin
                for i:=SUP downto INF do
                    buscarStock(v[i],l,i);
            end;
            procedure armarListaNue(a:arbol;codM:integer;var l:lisOrdenada);
            begin
                if(a<>nil)then begin
                    if(a^.elem.cod_mar<codM)then
                        armarListaNue(a^.HD,codM,l)
                    else if (a^.elem.cod_mar>codM)then
                        armarListaNue(a^.HI,codM,l)
                    else
                        armarLista(a^.elem.vecLis,l);
                end;
            end;
var
    codM:integer;
begin
    write('ingrese un codigo de marca:');
    readln(codM);
    armarListaNue(a,codM,l);
end;
procedure retornarCantRepuestos(l:lisOrdenada;var cant:integer);
        function cantRepuestos(l:lisOrdenada):integer;
        begin
            if(l=nil)then
                cantRepuestos:=0
            else if(l^.elem.stock=1)then
                cantRepuestos:=1 + cantRepuestos(l^.sig)
            else
                cantRepuestos:=cantRepuestos(l^.sig);
        end;
begin
    cant:=0;
    cant:=cantRepuestos(l);
    if(cant=0)then
        writeln('no hubo repuestos con en stock en 1')
    else
        writeln('esta es la cantidad de respuesto con 1 stock:',cant);
end;
var
    a:arbol;
    l:lisOrdenada;
    cantR:integer;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    retornarLisOrdenada(a,l);
    //inciso C
    retornarCantRepuestos(l,cantR);
end.