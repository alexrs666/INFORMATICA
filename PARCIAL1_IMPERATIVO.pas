{TURNO:E    PARCIAL IMPERATIVO FECHA:16/09/25
Supermercado GranVariedad necesita un siitema para procesar la información de sus ventas. De cada venta se
conoce: DNI de cliente, código de sucursal (1 a 10), número de factura y monto.
a) implementar un moduio que lea información de las ventas (la lectura finaliza al ingresar DNI de cliente 0) y
retorne:
    I.Una estructura de datos eficiente para la búsqueda por DNI de cliente, Para cada DNI debe almacenarse una
        Ilsta de todas sus compras (número de factura y monto)
    II.Una estructura de datos que almacene la cantidad de ventas de cada sucursal
b)Realzar un módulo que recita la estructura generada en el incho a) I. un monto y un DNI. El módulo debe
    retornar la cantidad de facturas cuyo monto es superior al monto ingresado para el DNI lngresado.
c)Realizar un módulo recursivo que reciba la estructura generada en incio a)II. y retorne el código de sucursal
    con mayor cantidad de ventas.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c. En caso de ser necesario, puede utilizar los
módulos que se encuentran a continación.}
program PARCIAL1_IMPERATIVO;
const DF=10;
type
    subSucursal=1..DF;
    venta=record
       dniC:integer;
       cod_sucursal:integer;
       num_Fac:integer;
       monto:real;
    end;
    registroFac=record
       num_Fac:integer;
       monto:real;
    end;
    lista=^nodo;
    nodo=record
       elem:registroFac;
       sig:lista;
    end;
    listaDni=record
       dniC:integer;
       listaD:lista;
    end;
    arbol=^nodo2;
    nodo2=record
       elem:listaDni;
       HI:arbol;
       HD:arbol;
    end;
    vector=array[subSucursal]of integer;
procedure cargarArbolyContador(var a:arbol;var v:Vector);
		procedure leerVenta(var e:venta);
		begin
			e.dniC:=random(2000);
			if(e.dniC<>0)then begin
				e.cod_sucursal:=random(10)+1;
				e.num_Fac:=random(10000)+1;
				e.monto:=random(10000)/random(10)*1;
			end;
		end;
		procedure insertarAdelante(var l:lista;e:registroFac);
		var
			nue:lista;
		begin
			new(nue);
			nue^.elem:=e;
			nue^.sig:=l;
			l:=nue;
		end;
		procedure insertarArbol(var a:arbol;e:venta);
		var
			l:registroFac;
		begin
			l.num_Fac:=e.num_Fac;
			l.monto:=e.monto;
			if(a=nil)then begin
				new(a);
				a^.elem.dniC:=e.dniC;
				a^.elem.listaD:=nil;
				insertarAdelante(a^.elem.listaD,l);
				a^.HI:=nil;
				a^.HD:=nil;
			end
			else if(e.dniC=a^.elem.dniC)then
				insertarAdelante(a^.elem.listaD,l)
			else if(e.dniC<a^.elem.dniC)then
				insertarArbol(a^.HI,e)
			else
				insertarArbol(a^.HD,e);
		end;
		procedure inicializarVec(var v:vector);
		var
			i:subSucursal;
		begin
			for i:=1 to DF do 
				v[i]:=0;
		end;
var
	e:venta;
begin
	inicializarVec(v);
	leerVenta(e);
	while(e.dniC<>0)do begin
		insertarArbol(a,e);
		v[e.cod_sucursal]:=v[e.cod_sucursal] +1;
		leerVenta(e);
	end;
end;
procedure MayorMonto(a:arbol;var cantF:integer);
		function contador(l:lista;mon:real):integer;
		var	c:integer;
		begin
			c:=0;
			while(l<>nil)do begin
				if(l^.elem.monto>mon)then
					c:=c +1;
				l:=l^.sig;
			end;
			contador:=c;
		end;
		function cantidadFac(a:arbol;d:integer;m:real):integer;
		begin
			if(a=nil)then
				cantidadFac:=0
			else if(a^.elem.dniC<d)then
				cantidadFac:=cantidadFac(a^.HD,d,m)
			else if(a^.elem.dniC>d)then
				cantidadFac:=cantidadFac(a^.HI,d,m)
			else
				cantidadFac:=contador(a^.elem.listaD,m);
		end;
var
	dni:integer;
	monT:real;
begin
	write('ingrese un dni:');
	readln(dni);
	write('ingrese un monto:');
	readln(monT);
	cantF:=0;
	cantF:=cantidadFac(a,dni,monT);
	if(cantF=0)then
		write('no se encontro factura superiores al monto ingresado')
	else
		write('esta es la cantida de facturas mayores al monto:',cantF);
end;
procedure MayorCantVentas(v:Vector;var maxSucur:integer);
		procedure mayorCanVen(v:Vector;var m:integer;punt:integer);
		begin
			if(punt<=DF)then
				if(v[punt]>m)then
					m:=v[punt];
				mayorCanVen(v,m,punt +1);
		end;
var
	m:integer;
begin
	m:=-1;
	mayorCanVen(v,m,1);
	maxSucur:=m;
end;
var
	a:arbol;
	v:vector;
	cant:integer;
	MaxS:integer;
begin
	randomize;
	a:=nil;
	//INCISO A
	cargarArbolyContador(a,v);
	//INCISO B
	MayorMonto(a,cant);
	//INCISO C
	MayorCantVentas(v,maxS);
end.
