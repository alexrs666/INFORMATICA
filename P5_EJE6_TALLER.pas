{6) Una empresa de logística necesita implementar un programa para procesar los envíos
	realizados durante 2026. De cada envío se conoce el código del cliente, día, mes, código
	postal de destino y peso del paquete. En el programa se debe:
	a) Implementar un módulo que lea los envíos, genere y retorne un árbol binario de
		búsqueda ordenado por código postal, donde para cada código postal se almacenen la
		cantidad de paquetes enviados por mes. La lectura finaliza con código de cliente 0.
	b) Implementar un módulo que reciba la estructura generada en el inciso a), un código
		postal y un valor entero. El módulo debe retornar la cantidad de meses cuya cantidad
		supere al valor entero recibido para el código postal recibido.
	c) Implementar un módulo que reciba la estructura generada en el inciso a), dos códigos
		postales y retorne los códigos postales dentro de los dos códigos recibidos (incluirlos),
		que tuvieron al menos un mes sin envíos.}
program  P5_EJE6_TALLER;
type
	envios=record
		cod_cli:integer;
		dia,mes:integer;
		cod_pos:integer;
		peso_paq:integer;
	end;
	vector=array[1..12]of integer;
	infoArbol=record
		cod_pos:integer;
		cantMes:vector;
	end;
	arbol=^nodo;
	nodo=record
		elem:infoArbol;
		HI:arbol;
		HD:arbol;
	end;
procedure CargarArbol(var a:arbol);
			procedure leerEnvios(var e:envio);
			begin
				e.cod_cli:=random(1000);
				if(e.cod_cli<>0)then begin
					e.dia:=random(31)+1;
					e.mes:=random(12)+1;
					e.cod_pos:=random(100);
					e.peso_paq:=random(1000);
				end;
			end;
			procedure inicializarVector(var v:vector);
			var 
				i:integer;
			begin
				for i:=1 to 12 do
					v[i]:=0;
			end;
			procedure insertarEnvio(var a:arbol;e:envios);
			begin
				if(a=nil)then begin
					new(a);
					a^.HI:=nil;
					a^.HD:=nil;
					incializarVector(a^.elem.cantMes);
					a^.elem.cantMes[e.mes]:=a^.elem.cantMes[e.mes] +1;
				end
				else if(a^.elem.cod_pos<e.cod_pos)then
					insertarEnvio(a^.HI,e)
				else
					insertarEnvio(a^.HD,e);
			end;
var
	e:envios;
begin
	leerEnvios(e);
	while(e.cod_cli<>0)do begin
		insertarEnvio(a,e);
		leerEnvios(e);
	end;
end;
function DevolverMayores(a:arbol;codP,cantPrueba:integer):integer;
		function ContarMeseMayores(v:vector;cantP:integer):integer;
		var 
			i:integer;
			cantM:integer;
		begin
			cantM:=0;
			for i:=1 to 12 do begin
				if(v[i]>cantP)then
					cantM:=cantM + 1;
			end;
			ContarMeseMayores:=cantM;
		end;
		function EncontrarCodigoPostal(a:arbol;c,cant:integer):integer;
		begin
			if(a=nil
				EncontrarCodigoPostal:=0
			else if(a^.elem.cod_pos<c)then
				EncontrarCodigoPostal:=EncontrarCodigoPostal(a^.HD,c,cant)
			else if(a^.elem.cod_pos>c)then
				EncontrarCodigoPostal:=EncontrarCodigoPostal(a^.HD,c,cant)
			else
				EncontrarCodigoPostal:=ContarMesesMayores(a^.elem.cantMes,cant);
		end;
begin
	DevolverMayores:=EncontrarCodigoPostal(a,codP,cantPrueba);
end;
function RetonarRangoCod(a:arbol;lm,ls:integer):integer;
		function cantRangosCod(a:arbol;li,ls:integer):integer;
		begin
			if(a=nil)then
				cantRangosCod:=0
			else if(a^.elem.cod_pos>li)then
				cantRangosCod:=cantRangosCod(a^.HD,li,ls)
			else if(a^.elem.cod_poas<ls)then
				cantRangosCod:=cantRangosCod(a^.HI,li,ls)
			else
				cantRangosCod:=1+cantRangosCod(a^.HI,li,ls)+cantRangosCod(a^.HD,li,ls);
		end;
begin
	RetonarRangoCod:=cantRangosCod(a,li,ls);
end;
var
	a:arbol;
	codigoPos,CantidadMese:integer;
	cantPrueba:ineteger;
	limI,limS:integer;
	cantRan:integer;
begin
	randomize;
	a:=nil;
	//inciso A
	CargarArbol(a);
	//inciso B
	readln(codigoPos);
	readln(CantidadMese);
	CantidadMese:=DevolverMayores(a,codigoPos,CantPrueba);
	//inciso c
	readln(limI);
	readln(limS);
	cantRan:=RetonarRangoCod(a,limI,limS);
end.
