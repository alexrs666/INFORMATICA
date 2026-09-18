{Una empresa de gastronomía procesar las entregas de comida realizadas a sus clientes durante el año 2022.
a) Implementar un módulo que lea entregas de comidas. De cada compra se lee código de comida, código de cliente
ccmpas
y categoría de la entrega ('Full','Super','Media','Normal, 'Basica'). La lectura finaliza con el código de cliente 0. Se sugiere
utilizar el módulo leerEntrega(). Se deben retornar 2 estructuras de datos;

I. Un árbol binario de búsqueda ordenado por código de comida. Para cada código de comida debe almacenarse la
cantidad de entregas realizadas a ese código entre todos los clientes.
ii. Un vector que almacene en cada posición el nombre de la categoria y la cantidad de entregas realizadas para esa
categoría.

b) Implementar un módulo que reciba el árbol generado en a) y un código de comida. El módulo debe retornar la
cantidad de entregas realizadas al código de comida ingresado.
c) Implementar un módulo que reciba el vector generado en a), lo ordene por cantidad de entregas de menor a
mayor y retorne la categoría con mayor cantidad de entregas.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.
En caso de ser necesario, adjuntamos algunas porciones de código que puede utilizar en su programa.}
program PARCIAL8_IMPERATIVO;
const DF=5;
type 
	subCat=1..DF;
	compra=record
		categoria:string;
		dniCli:integer;
		codComida:integer;
	end;
	infoArbol=record
		cantTotal:integer;
		codComida:integer;
	end;
	arbol=^nodoArbol;
	nodoArbol=record
		elem:infoArbol;
		HI:arbol;
		HD:arbol;
	end;
	infoVector=record
		categoria:string;
		cantCate:integer;
	end;
	vector=array[subCat]of infoVector;
procedure cargarArbolyVec(var a:arbol;var v:vector);
			procedure inicializarVector(var v:vector);
			begin
				v[1].categoria:='full';v[1].cantCate:=0;
				v[2].categoria:='super';v[2].cantCate:=0;
				v[3].categoria:='media';v[3].cantCate:=0;
				v[4].categoria:='normal';v[4].cantCate:=0;
				v[DF].categoria:='basica';v[DF].cantCate:=0;
			end;
			procedure leerCompra(var c:compra);
			var
				v:array[1..DF]of string=('full','super','media','normal','basica');
			begin
				c.dniCli:=random(100);
				if(c.dniCli<>0)then begin
					c.codComida:=random(1000);
					c.categoria:=v[random(5)+1];
				end;
			end;
			procedure insertarCompra(var a:arbol;c:compra);
			begin
				if(a=nil)then begin
					new(a);
					a^.elem.codComida:=c.codComida;
					a^.elem.cantTotal:=1;
					a^.HI:=nil;
					a^.HD:=nil;
				end
				else if(c.codComida=a^.elem.codComida)then
					a^.elem.cantTotal:=a^.elem.cantTotal +1 
				else if(c.codComida<a^.elem.codComida)then
					insertarCompra(a^.HI,c)
				else 
					insertarCompra(a^.HD,c);
			end;
			procedure ActualizarVector(var v:vector;categoria:string);
			var
				i:integer;
			begin
				i:=1;
				while(i<=DF)and(v[i].categoria<>categoria)do begin
					i:=i+1;
				end;
				if(i<=DF)then
					v[i].cantCate:=v[i].cantCate + 1;
			end;
var
	c:compra;
begin
	a:=nil;
	inicializarVector(v);
	leerCompra(c);
	while(c.dniCli<>0)do begin
		insertarCompra(a,c);
		ActualizarVector(v,c.categoria);
		leerCompra(c);
	end;
end;
function BuscarCod(a:arbol;codC:integer):integer;
begin
    if(a=nil)then
        BuscarCod:=0
    else if(a^.elem.codComida<codC)then
        BuscarCod:=BuscarCod(a^.HD,codC)
    else if(a^.elem.codComida>codC)then
        BuscarCod:=BuscarCod(a^.HI,codC)
    else
        BuscarCod:=a^.elem.cantTotal;
end;
procedure retornarMaximoVector(var v:vector;var maxCate:string);
			procedure seleccion(var v:vector);
			var
				i,j,pos:integer;
				item:infoVector;
			begin
				for i:=1 to DF-1 do begin
					pos:=i;
					for j:=i+1 to DF do begin
                        if(v[j].cantCate < v[pos].cantCate)then
                            pos:=j;
                    end;

                    item:=v[pos];
                    v[pos]:=v[i];
                    v[i]:=item;
				end;
			end;
begin
	seleccion(v);
    maxCate:=v[DF].categoria;
end;
var
    a:arbol;
    v:vector;
    codComidaPrueba:integer;
    cantCom:integer;
    maxC:string;
begin
    randomize;
    //inciso A
    cargarArbolyVec(a,v);
	//inciso B
    readln(codComidaPrueba);
    cantCom:=BuscarCod(a,codComidaPrueba);
    //inciso C
    retornarMaximoVector(v,maxC);
end.