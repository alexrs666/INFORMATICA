{1. El administrador de un edificio de oficinas tiene la información del pago de las expensas
de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se deben cargar, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación 0.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En caso de encontrarlo, debe
retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0.
Luego el programa debe informar el DNI del propietario o un cartel indicando que no
se encontró la oficina.
d) Un módulo recursivo que retorne el monto total acumulado de las expensas.}
program oficinas;
const
    DF=300;
type
    oficina=record
      codI:integer;
      DNIpro:integer;
      valorEx:real;
    end;
    vector=array[1..DF]of oficina;
    procedure CargarVector(var v:vector;var diml:integer);
        procedure leerOficina(var o:oficina);
        begin
          o.codI:=random(51)*100;
          if(o.codI<>0)then begin
            o.DNIpro:=random(1000);
            o.valorEx:=random(50)+25.5;
          end;
        end;
    var
        o:oficina;
    begin
        diml:=0;
        leerOficina(o);
        While(o.codI<>0)and(diml<DF)do begin
            diml:=diml + 1;
            v[diml]:=o;
            if(diml<DF)then
              leerOficina(o);
        end;
    end;
    procedure seleccion(var v:vector;dimL:integer);
    var 
        i,j,p:integer;
        item:oficina;
    begin
        for i:=1 to (dimL-1)do begin
            p:=i;
            for j:=i+1 to dimL do begin
                if(v[j].codI<v[p].codI)then
                    p:=j;
            end;
            item:=v[p];
            v[p]:=v[i];
            v[i]:=item;
        end;
    end;
procedure busquedaDeDato(v:vector;diml:integer);
    Procedure busquedaDicotomica (v: vector; ini,fin: integer; dato:integer; Var pos: integer);
    Var aux: integer;
    Begin
        If (ini <= fin) Then Begin
            aux := (fin + ini) Div 2;
          If (v[aux].codI = dato) Then
            pos := aux
          Else Begin
            If (dato < v[aux].codI) Then
                 busquedaDicotomica(v, ini, aux-1, dato, pos)
            Else
                 busquedaDicotomica(v, aux+1, fin, dato, pos);
          End;
        End
    End;
var
  dato:integer;
  pos:integer;
  ini,fin:integer;
begin
    write('Ingrese el codigo de oficina a buscar: ');
    readln(dato);
    pos:=0;
    ini:=1;
    fin:=diml;
    busquedaDicotomica(v,ini,fin,dato,pos);
    if (pos = 0) then
      writeln('No se encontro la oficina.')
    else
      writeln('Oficina encontrada. DNI del propietario: ', v[pos].DNIpro);
end;
procedure MontoTOTALEXP(v:vector;diml:integer;var acumulado:real);
    procedure recorridoVector(v:vector;diml:integer;var tot:real);
    begin
        if(diml>0)then begin
            tot:=tot + v[diml].valorEx;
            recorridoVector(v,diml-1,tot);
        end;
    end;
begin
    acumulado:=0;
    recorridoVector(v,diml,acumulado);
end;
var
    v:Vector;
    dimL:integer;
    total:real;
begin
    randomize;
    CargarVector(v,dimL);
    seleccion(v,dimL);
    busquedaDeDato(v,diml);
    MontoTOTALEXP(v,diml,total);
    WriteLn('este es el monto total acumulado de las expensas:',total:0:2);
end.