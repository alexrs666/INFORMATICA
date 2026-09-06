{7) Una empresa aérea necesita un programa para procesar los pasajes vendidos en el mes de
enero de 2026. De cada pasaje se conoce el código de vuelo, día del mes (1..31), DNI del
pasajero, código ciudad destino y monto del pasaje. En el programa se debe
a) Implementar un módulo que lea pasajes, genere y retorne un árbol binario de
búsqueda por código de ciudad destino y que almacene una lista con los pasajes
(código de vuelo, día del mes, DNI del pasajero y monto del pasaje) correspondientes.
La lectura finaliza con dni 0.
b) Implementar un módulo que reciba la estructura generada en el inciso a), dos códigos
de destino y un DNI. El módulo debe retornar la cantidad de vuelos que realizó el
pasajero con el DNI recibido cuyo código de destino está entre los dos códigos de
destino recibidos (no incluirlos).
c) Implementar un módulo que reciba la estructura generada en el inciso a) y retornar el
monto total acumulado en cada día del mes.}
program P5_EJE7_TALLER;
const
    DF=31;
    DL=1;
type
    subDias=DL..DF;
    pasajes=record
        dni_Pas:integer;
        cod_des:integer;
        dia:subDias;
        monto:real;
        cod_vuelo:integer;
    end;
    infoLista=record
        dni_Pas:integer;
        dia:subDias;
        monto:real;
        cod_vuelo:integer;
    end;
    lista=^nodo;
    nodo=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        cod_des:integer;
        lisP:lista;
    end;
    arbol=^nodo2;
    nodo2=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    vector=array[subDias]of real;
procedure cargarArbol(var a:arbol);
            procedure LeerPasajes(var p:pasajes);
            begin
                p.dni_Pas:=random(1000);
                if(p.dni_Pas<>0)then begin
                    p.cod_des:=random(150)+1;
                    p.cod_vuelo:=random(1000);
                    p.monto:=random(10000)/(random(100)+1);
                    p.dia:=random(31)+1;
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
            procedure ActualizarInfo(var i:infoLista;p:pasajes);
            begin
                i.dni_Pas:=p.dni_Pas;
                i.monto:=p.monto;
                i.cod_vuelo:=p.cod_vuelo;
                i.dia:=p.dia;
            end;
            procedure insertarPasajes(var a:arbol;p:pasajes);
            var
                i:infoLista;
            begin
                ActualizarInfo(i,p);
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.cod_des:=p.cod_des;
                    a^.elem.lisP:=nil;
                    insertarAdelante(a^.elem.lisP,i);
                end
                else if(p.cod_des=a^.elem.cod_des)then
                    insertarAdelante(a^.elem.lisP,i)
                else if(p.cod_des<a^.elem.cod_des)then
                    insertarPasajes(a^.HI,p)
                else
                    insertarPasajes(a^.HD,p);
            end;
var
    p:pasajes;
begin
    LeerPasajes(p);
    while(p.dni_Pas<>0)do begin
        insertarPasajes(a,p);
        LeerPasajes(p);
    end;
end;
function RetornarCantRangos(a:arbol;li,ls,dni:integer):integer;
            function contadorDnis(l:lista;dni:integer):integer;
            var
                cant:integer;
            begin
                cant:=0;
                while(l<>nil)do begin
                    if(l^.elem.dni_Pas=dni)then
                        cant:=cant + 1;
                    l:=l^.sig;
                end;
                contadorDnis:=cant;
            end;
            function RangosCodVuelos(a:arbol;li,ls,dni:integer):integer;
            begin
                if(a=nil)then
                    RangosCodVuelos:=0
                else if(a^.elem.cod_des<=li)then
                    RangosCodVuelos:=RangosCodVuelos(a^.HD,li,ls,dni)
                else if(a^.elem.cod_des>=ls)then
                    RangosCodVuelos:=RangosCodVuelos(a^.HI,li,ls,dni)
                else
                    RangosCodVuelos:=contadorDnis(a^.elem.lisP,dni) + RangosCodVuelos(a^.HI,li,ls,dni)+RangosCodVuelos(a^.HD,li,ls,dni);
            end;
begin
    RetornarCantRangos:=RangosCodVuelos(a,li,ls,dni);
end;
procedure iniciaizarVec(var v:vector);
var
    i:subDias;
begin
    for i:=DL to DF do 
        v[i]:=0;
end;
procedure TotalAcumuladoMes(a:arbol;Var v:vector);
        procedure generarVector(l:lista;var v:vector);
        begin
            while(l<>nil)do begin
                v[l^.elem.dia]:=v[l^.elem.dia] + l^.elem.monto;
                l:=l^.sig;
            end;
        end;
begin
    if(a<>nil)then begin
        generarVector(a^.elem.lisP,v);
        TotalAcumuladoMes(a^.HI,v);
        TotalAcumuladoMes(a^.HD,v);
    end;
end;
var
    a:arbol;
    limI,limS:integer;
    DniP:integer;
    cantRangos:integer;
    v:vector;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    readln(limI);
    readln(limS);
    readln(DniP);
    cantRangos:=RetornarCantRangos(a,limI,limS,DniP);
    //inciso C
    iniciaizarVec(v);
    TotalAcumuladoMes(a,v);
end.