{TURNO:I   PARCIAL IMPERATIVO FECHA:10/09/2026}
program Alquileres;
const 
    DF=12;
type
    subDia=1..31;
    subMes=1..DF;
    alquiler=record
        dia:subDia;
        mes:subMes;
        monto:real;
        dniCli:integer;
    end;
    vector=array[subMes]of integer;
    infoArbol=record
        dniCli:integer;
        montoTotal:real;
        vmes:vector;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
procedure cargarArbol(var a:arbol);
            procedure leerAlquiler(var alq:alquiler);
            begin
                alq.dniCli:=random(10);
                if(alq.dniCli<>0)then begin
                    alq.dia:=random(31)+1;
                    alq.mes:=random(DF)+1;
                    alq.monto:=random(10000)/(random(15)+1);
                end;
            end;
            procedure inicializarVec(var v:vector);
            var
                i:subMes;
            begin
                for i:=1 to DF do
                    v[i]:=0;
            end;
            procedure insertarAlquiler(var a:arbol;alq:alquiler);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.dniCli:=alq.dniCli;
                    inicializarVec(a^.elem.vmes);
                    a^.elem.montoTotal:=alq.monto;
                    a^.elem.vmes[alq.mes]:=1;
                end
                else if(alq.dniCli=a^.elem.dniCli)then begin
                    a^.elem.montoTotal:=a^.elem.montoTotal + alq.monto;
                    a^.elem.vmes[alq.mes]:=a^.elem.vmes[alq.mes] + 1;
                end
                else if(alq.dniCli<a^.elem.dniCli)then
                    insertarAlquiler(a^.HI,alq)
                else
                    insertarAlquiler(a^.HD,alq);
            end;
var
    alq:alquiler;
begin
    a:=nil;
    leerAlquiler(alq);
    while(alq.dniCli<>0)do begin
        insertarAlquiler(a,alq);
        leerAlquiler(alq);
    end;
end;
function retornarMontoDniMax(a:arbol):real;
begin
    if(a=nil)then
        retornarMontoDniMax:=0
    else if(a^.HD=nil)then
        retornarMontoDniMax:=a^.elem.montoTotal
    else
        retornarMontoDniMax:=retornarMontoDniMax(a^.HD);
end;
function retornarCanTotalViajes(a:arbol;dni1,dni2:integer):integer;
                function contarViajes(v:vector):integer;
                var 
                    i:subMes;
                    cant:integer;
                begin
                    cant:=0;
                    for i:=1 to DF do
                        cant:=cant + v[i];
                    
                    contarViajes:=cant;
                end;
                function BuscarDnis(a:arbol;dni1,dni2:integer):integer;
                begin
                    if(a=nil)then
                        BuscarDnis:=0
                    else if(a^.elem.dniCli<dni1)then
                        BuscarDnis:=BuscarDnis(a^.HD,dni1,dni2)
                    else if(a^.elem.dniCli>dni2)then
                        BuscarDnis:=BuscarDnis(a^.HI,dni1,dni2)
                    else
                        BuscarDnis:=contarViajes(a^.elem.vmes) + BuscarDnis(a^.HI,dni1,dni2) + BuscarDnis(a^.HD,dni1,dni2);
                end;
begin
    retornarCanTotalViajes:=BuscarDnis(a,dni1,dni2);
end;
procedure imprimirArbol(a:arbol);
        procedure imprimirVector(v:vector);
        var i:subMes;
        begin
            for i:=1 to DF do
                writeln('EN ESTE MES:',i,' hubo:',v[i],' cantidad de alquileres');
        end;
begin
    if(a<>nil)then begin
        imprimirArbol(a^.HI);
        writeln('este dni:',a^.elem.dniCli ,' su monto es de :',a^.elem.montoTotal:0:2);
        writeln('///////////////////////////////');
        imprimirVector(a^.elem.vmes);
        imprimirArbol(a^.HD);
    end;
end;
var
    a:arbol;

    MontoDniMax:real;

    dniCLi1,dniCli2:integer;
    canTotalV:integer;
begin
    randomize;
    //inciso A
    cargarArbol(a);
    //inciso B
    imprimirArbol(a);
    MontoDniMax:=retornarMontoDniMax(a);
    writeln('este es el monto del dni mas grande:',MontoDniMax:0:2);
    //inciso C
    write('ingrese un dni de cliente:');
    readln(dniCLi1);
    write('ingrese otro dni de cliente:');
    readln(dniCli2);
    canTotalV:=retornarCanTotalViajes(a,dniCLi1,dniCli2);
    writeln('esta es la cantidad Total de viajes entre los dni recibidos:',canTotalV);
end.