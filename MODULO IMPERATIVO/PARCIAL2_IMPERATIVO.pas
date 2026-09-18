{TURNO:H    PARCIAL IMPERATIVO FECHA:16/09/2025
Se lee información de las compras realizadas por los clientes a un supermercado en el año 2024. De cada compra se lee
el código de cliente, dia, número de mes y monto gastado. La lectura finaliza cuando se lee el cliente con código 0.
a) Realizar un módulo que lea la información de las compras y retorne un árbol binario de búsqueda ordenado por
    código de cliente. Para cada código de cliente, se debe almacenar un vector con el monto total gastado por
    dicho cliente en cada mes del año 2024.
b) Realizar un módulo que reciba la estructura generada en a) y un código de cliente, y retorne el mes con mayor
    gasto de dicho cliente.
c) Realizar un módulo que reciba la estructura generada en a) y un número de mes, y retorne la cantidad de
    clientes que no gastaron nada en dicho mes.
NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.

En caso de ser necesario, adjuntamos algunas porciones de código que puede utilizar en su programa.}
program PARCIAL2_IMPERATIVO;
const
    INF=1;
    SUP=12;
type
    subMes=INF..SUP;
    compras=record
        cod_Cli:integer;
        dia:integer;
        mes:integer;
        monto:real;
    end;
    vecMes=array[subMes]of real;
    compraCli=record
         cod_Cli:integer;
         vec:vecMes;
    end;
    arbol=^nodo;
    nodo=record
        elem:compraCli;
        HI:arbol;
        HD:arbol;
    end;
procedure cargarArbol(var a:arbol);
            procedure LeerCompra(var c:compras);
            begin
                c.cod_Cli:=random(100);
                if(c.cod_Cli<>0)then begin
                    c.dia:=random(31)+1;
                    c.mes:=random(12)+1;
                    c.monto:=random(20000)/(random(10)+1);
                end;
            end;
            procedure inicializarVec(var v:vecMes);
            var
                i:subMes;
            begin
                for i:=INF to SUP do 
                    v[i]:=0;
            end;
            procedure insertarCompra(var a:arbol;c:compras);
            begin
                
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    inicializarVec(a^.elem.vec);
                    a^.elem.cod_Cli:=c.cod_Cli;                    
                    a^.elem.vec[c.mes]:=c.monto;
                end
                else if(c.cod_Cli=a^.elem.cod_Cli)then
                    a^.elem.vec[c.mes]:=a^.elem.vec[c.mes] + c.monto
                else if(c.cod_Cli<a^.elem.cod_Cli)then
                    insertarCompra(a^.HI,c)
                else
                    insertarCompra(a^.HD,c);
            end;
var
    c:compras;
begin
    LeerCompra(c);
    while(c.cod_Cli<>0)do begin
        insertarCompra(a,c);
        LeerCompra(c);
    end;
end;
procedure MayorMesGastado(a:arbol;var MaxMes:integer);
            function calculandoMayorMes(v:vecMes):integer;
            var
                max:real;
                i:subMes;
                mesMax:integer;
            begin
                max:=-1;
                for i:=INF to SUP do begin
                    if(v[i]>max)then begin
                        max:=v[i];
                        mesMax:=i;
                    end;
                end;
                calculandoMayorMes:=mesMax;
            end;
            function MayorMes(a:arbol;c:integer):integer;
            begin
                if(a=nil)then
                    MayorMes:=0
                else if(a^.elem.cod_Cli<c)then
                    MayorMes:=MayorMes(a^.HD,c)
                else if(a^.elem.cod_Cli>c)then
                    MayorMes:=MayorMes(a^.HI,c)
                else
                    MayorMes:=calculandoMayorMes(a^.elem.vec);
            end;
var
    cli:integer;
begin
    write('ingrese un codigo de cliente:');
    readln(cli);
    MaxMes:=0;
    MaxMes:=MayorMes(a,cli);
    if(MaxMes=0)then
        writeln('no se encontro el cliente')
    else
        writeln('este es el mes en el q el cliente gasto mas:',MaxMes);
end;
procedure CantClientesSinGastos(a:arbol;var cant:integer);
            procedure calcularMes(v:vecMes;m:integer;var c:integer);
            begin
                if(v[m]=0)then
                    c:=c+1;
            end;
            procedure CalcularClientes(a:arbol;mes:integer;var c:integer);
            begin
                if(a<>nil)then begin
                    calcularMes(a^.elem.vec,mes,c);
                    CalcularClientes(a^.HI,mes,c);
                    CalcularClientes(a^.HD,mes,c);
                end;
            end;
var
    m:integer;
begin
    write('ingrese un mes de 1 a 12');
    readln(m);
    cant:=0;
    CalcularClientes(a,m,cant);
    if(cant=0)then
        writeln('no hubo clientes que gastaron 0')
    else
        writeln('esta es la cantidad de clientes que no gastaron:',cant);
end;
var
    a:arbol;
    MaxM:integer;
    cant:integer;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    MayorMesGastado(a,MaxM);
    //inciso C
    CantClientesSinGastos(a,cant);
end.