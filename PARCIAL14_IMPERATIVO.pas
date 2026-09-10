{TURNO:D   PARCIAL IMPERATIVO FECHA:09/09/2026
Una empresa de transporte necesita procesar los boletos vendidos en julio de 2026. De cada boleto se conoce el código
único de boleto, día, horario, dni del cliente, ciudad destino y monto del pasaje.
a) Implementar un módulo que lea boletos, genere y retorne un árbol binario de búsqueda por ciudad destino y.que
almacene una estructura de datos con los boletos correspondientes. La lectura finaliza con dni del cliente 0. Se sugiere
utilizar el módulo leerBoleto().
b) Implementar un módulo que reciba la estructura generada en a), dos ciudades destinos y un DNI. El módulo debe
retornar la cantidad de viajes que realizó dicho DNI entre ambos destinos (incluidos).
c) Realizar un módulo que reciba la estructura generada en a). El módulo debe retornar el monto total acumulado en
cada día del mes.}
program PARCIAL14_IMPERATIVO;
type
    dias = 1 .. 31;
    boleto = record
        cod_boleto:integer;
        dia: dias;
        horario:integer;
        dni_cliente: integer;
        destino:string;
        monto: real;
    end;
    infoLista=record
        cod_boleto:integer;
        dia:integer;
        horario:integer;
        dni_cliente:integer;
        monto:real;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
    infoArbol=record
        destino:string;
        lisB:lista;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    conj = set of 100 .. 200;
    vector=array[1..31]of real;
procedure cargarArbol(var a:arbol);
            procedure leerBoleto(var b: boleto;var c: conj);
            begin
                b.dni_cliente := Random(10000);
                if (b.dni_cliente > 0) then begin
                    b.cod_boleto := Random(101) + 100;
                    while (b.cod_boleto IN c) do
                        b.cod_boleto := Random(101)+ 100;
                    c := c + [b.cod_boleto];
                    b.dia := Random(31) + 1;
                    b.horario := Random(24);
                    b.monto := Random(9999) / (Random(10) + 1);
                    read(b.destino);
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
                procedure insertarBoleto(var a:arbol;destBus:string;i:infoLista);
                begin
                    if(a=nil)then begin
                        new(a);
                        a^.HI:=nil;
                        a^.HD:=nil;
                        a^.elem.destino:=destBus;
                        a^.elem.lisB:=nil;
                        insertarAdelante(a^.elem.lisB,i);
                    end
                    else if(destBus=a^.elem.destino)then
                        insertarAdelante(a^.elem.lisB,i)
                    else if(destBus<a^.elem.destino)then
                        insertarBoleto(a^.HI,destBus,i)
                    else
                        insertarBoleto(a^.HD,destBus,i);
                end;
                procedure ActualizarInfo(b:boleto;var i:infoLista);
                begin
                    i.cod_boleto:=b.cod_boleto;
                    i.dia:=b.dia;
                    i.horario:=b.horario;
                    i.dni_cliente:=b.dni_cliente;
                    i.monto:=b.monto;
                end;
var
    b:boleto;
    c:conj;
    i:infoLista;
begin
    a:=nil;
    c:=[];
    leerBoleto(b,c);
    while(b.dni_cliente<>0)do begin
        ActualizarInfo(b,i);
        insertarBoleto(a,b.destino,i);
        leerBoleto(b,c);
    end;
end;
function retornarCantViajes(a:arbol;des1,des2:string;dniBus:integer):integer;
                function contarViajes(l:lista;dniBus:integer):integer;
                var
                    cant:integer;
                begin
                    cant:=0;
                    while(l<>nil)do begin
                        if(l^.elem.dni_cliente=dniBus)then
                            cant:=cant + 1;
                        l:=l^.sig;
                    end;
                    contarViajes:=cant;
                end;
                function BuscarDestinos(a:arbol;des1,des2:string;dniBus:integer):integer;
                begin
                    if(a=nil)then
                        BuscarDestinos:=0
                    else if(a^.elem.destino<des1)then
                        BuscarDestinos:=BuscarDestinos(a^.HD,des1,des2,dniBus)
                    else if(a^.elem.destino>des2)then
                        BuscarDestinos:=BuscarDestinos(a^.HI,des1,des2,dniBus)
                    else
                        BuscarDestinos:=contarViajes(a^.elem.lisB,dniBus) + BuscarDestinos(a^.HI,des1,des2,dniBus) + BuscarDestinos(a^.HD,des1,des2,dniBus);
                end;
begin
    retornarCantViajes:=BuscarDestinos(a,des1,des2,dniBus);
end;
procedure inicializarVec(var v:vector);
var
    i:integer;
begin
    for i:=1 to 31 do
        v[i]:=0;
end;
procedure retornarMontoTotalDias(a:arbol;var v:vector);
                procedure generarVector(l:lista;var v:vector);
                begin
                    while(l<>nil)do begin
                        v[l^.elem.dia]:=v[l^.elem.dia] + l^.elem.monto;
                        l:=l^.sig;
                    end;
                end;
                procedure recorrerArbol(a:arbol;var v:vector);
                begin
                    if(a<>nil)then begin
                        generarVector(a^.elem.lisB,v);
                        recorrerArbol(a^.HI,v);
                        recorrerArbol(a^.HD,v);
                    end;
                end;
begin
    recorrerArbol(a,v);
end;
var
    a:arbol;
    v:vector; 
    
    destino1,destino2:string;
    dniBuscado:integer;
    cantViajesDni:integer;
begin
    randomize;
    //inciso A
    cargarArbol(a);
    //inciso B
    readln(destino1);
    readln(destino2);
    readln(dniBuscado);
    cantViajesDni:=retornarCantViajes(a,destino1,destino2,dniBuscado);
    //inciso C
    inicializarVec(v);
    retornarMontoTotalDias(a,v);
end.