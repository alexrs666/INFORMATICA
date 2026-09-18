{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}
Program P1_EJE2_TALLER;
Const
 DF=300;
Type
 SubOficina=1..DF;
 oficina=record
  codI:integer;
  DNI:integer;
  valorEx:real;
 end;
 vecOfi=array[SubOficina]of oficina;
procedure leerOficina(var o:oficina);
begin
 write('ingrese un codigo identificador:');
 readln(o.codI);
 If(o.codI<>-1)Then begin
  write('ingrese el dni de la persona:');
  readln(o.DNI);
  write('ingrese el monto en expensas:');
  readln(o.valorEx);
 end;
end;
procedure CargarVector(var v:vecOfi;var dl:integer);
var 
 o:oficina;
begin
 dl:=0;
 leerOficina(o);
 While(o.codI<>-1)and(dl<DF)do begin
  dl:=dl + 1;
  v[dl]:=o;
  If(dl<DF)Then
    leerOficina(o);
 end;
end;
procedure Insercion(var v:vecOfi;dl:integer);
Var
 i,j:integer;
 actual:oficina;
begin
 For i:=2 to dl do begin
   actual:=v[i];
   j:=i-1;
   While(j>0)and(v[j].codI>actual.codI)do begin
     v[j+1]:=v[j];
     j:= j -1;
   end;
   v[j+1]:=actual;
 end;
end;
procedure seleccion(var v:vecOfi;dl:integer);
var 
 i,j,pos:integer;
 item:oficina;
begin
 For i:=1 to (dl-1)do begin
   pos:=i;
   For j:=i+1 to dl do begin
     If(v[j].codI<v[pos].codI)Then
       pos:=j;
   end;
   item:=v[pos];
   v[pos]:=v[i];
   v[i]:=item;
 end;
end;
var
 V,V2:vecOfi;
 DL:integer;
begin
 CargarVector(V,DL);
 V2:=V;
 Insercion(V,DL);
 seleccion(V2,DL);
end.