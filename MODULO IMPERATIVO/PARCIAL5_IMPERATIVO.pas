{Una clinica necesita un sistema para el procesamiento de las atenciones realizadas a los pacientes durante el año 2023.
a) Implementar un módulo que lea información de las atenciones y retorne un vector donde se almacenen las
    atenciones agrupadas por mes. Las atenciones de cada mes deben quedar almacenadas en un árbol binario de
    búsqueda ordenado por DNI del paciente y sólo deben almacenarse dni del paciente y código de diagnóstico.
    De cada atención se lee: matrícula del médico, DNI del paciente, mes y dlagnóstico (valor entre LyP).Lalecta
    finaliza con matrícula 0.
b) Implementar un módulo recurslvo que reciba el vector generado en a) y retorne el mes con mayor cantidad de
    atenciones.
c) Implementar un módulo que reciba el vector generado en a) y un DNI de paciente, y retorne si fue atendido o
    no, el paciente con el DNI Ingresado.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c. En caso de ser necesario, puede utilizar los
    modulos que se encuentran a continuación.}
program PARCIAL5_IMPERATIVO;
const
    SUP=12;
    INF=1;
type
    rangoMes = INF..SUP;
    atencion=record
        mat_medi:integer;
        DNI:integer;
        mes:rangoMes;
        diagnos:char;
    end;
    regArbol=record
        DNI:integer;
        diagnos:char;
    end;
    arbol=^nodo;
    nodo=record
        elem:regArbol;
        HI:arbol;
        HD:arbol;
    end;
    vector=array[rangoMes]of arbol;
procedure CargarVectorDeArbol(var v:vector);
    procedure LeerAtencion(var a:atencion);
    var
        v:array[INF..5]of char=('L','M','N','O','P');
    begin
        a.mat_medi := random(1000);
        if (a.mat_medi <> 0) then begin
            a.DNI:= random(10000) + 1;
            a.mes:=random(12)+1;
            a.diagnos:=v[random(5)+1];
        end;
    end;
    procedure iniciaizarVecArbol(var v:vector);
    var
        i:rangoMes;
    begin
        for i:=INF to SUP do
            v[i]:=nil;
    end;
    procedure ActualizarRegis(var r:regArbol;a:atencion);
    begin
        r.DNI:=a.DNI;
        r.diagnos:=a.diagnos;
    end;
    procedure InsertarAtencion(var a: arbol; r: regArbol);
    begin

        if (a = nil) then begin
            new(a);
            a^.HI := nil;
            a^.HD := nil;
            a^.elem:=r;
        end
        else if (r.DNI<a^.elem.DNI) then
            InsertarAtencion(a^.HI, r)
        else
            InsertarAtencion(a^.HD, r);
    end;
var
    a: atencion;
    r: regArbol;
begin
    LeerAtencion(a);
    iniciaizarVecArbol(v);
    while (a.mat_medi <> 0) do begin
        ActualizarRegis(r,a);
        InsertarAtencion(v[a.mes],r);
        LeerAtencion(a);
    end;
end;
function retornarMaxMes(v:vector):integer;
            function contarNodos(a:arbol):integer;
            begin
                if(a=nil)then
                    contarNodos:=0
                else
                    contarNodos:=1+contarNodos(a^.HI)+contarNodos(a^.HD);
            end;
            procedure calcularMaximoMes(cant,pos:integer;var m,p:integer);
            begin
                if(cant>m)then begin
                    m:=cant;
                    p:=pos;
                end;
            end;
            procedure MaxVector(v:vector;pos:integer;var MaxM,max:integer);
            var
                cantAct:integer;
            begin
                if(pos<=SUP)then begin
                    cantAct:=contarNodos(v[pos]);
                    calcularMaximoMes(cantAct,pos,max,MaxM);
                    MaxVector(v,pos+1,MaxM,max);
                end;
            end;
var
    max:integer;
    MesMx:integer;
begin
    max:=-1;
    MesMx:=1;
    MaxVector(v,INF,MesMx,max);
    retornarMaxMes:=MesMx;
end;
function retornarSIfueAtendido(v:vector):boolean;
            function controlarArboles(a:arbol;dni:integer):boolean;
            begin
                if(a=nil)then
                    controlarArboles:=false
                else if(a^.elem.DNI<dni)then
                    controlarArboles:=controlarArboles(a^.HD,dni)
                else if(a^.elem.DNI>dni)then
                    controlarArboles:=controlarArboles(a^.HI,dni)
                else
                    controlarArboles:=true;
            end;
            function controlarAtencion(v:vector;dni:integer):boolean;
            var
                i:integer;
                esta:boolean;
            begin
                i:=1;
                esta:=false;
                while(i<=SUP)and(esta=false)do begin
                    esta:=controlarArboles(v[i],dni);
                    i:=i+1;
                end;  
                controlarAtencion:=esta;
            end;
var
    DniA:integer;
    aten:boolean;
begin
    write('ingrese un dni:');
    readln(DniA);
    retornarSIfueAtendido:=controlarAtencion(v,DniA);
end;
var
    V:vector;
    MaxMes:integer;
    dniAtencion:boolean;
begin
    randomize;
    //inciso A
    CargarVectorDeArbol(V);
    //inciso B
    MaxMes:=retornarMaxMes(V);
    //inciso C
    dniAtencion:=retornarSIfueAtendido(V);
end.