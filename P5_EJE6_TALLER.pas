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
const
    DF=12;
type
	envios=record
		cod_cli:integer;
		dia,mes:integer;
		cod_pos:integer;
		peso_paq:integer;
	end;
	vector=array[1..DF]of integer;
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
    lista=^nodo2;
    nodo2=record    
        elem:integer;
        sig:lista;
    end;
procedure CargarArbol(var a:arbol);
			procedure leerEnvios(var e:envios);
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
				for i:=1 to DF do
					v[i]:=0;
			end;
			procedure insertarEnvio(var a:arbol;e:envios);
			begin
				if(a=nil)then begin
					new(a);
					a^.HI:=nil;
					a^.HD:=nil;
					inicializarVector(a^.elem.cantMes);
                    a^.elem.cod_pos:=e.cod_pos;
					a^.elem.cantMes[e.mes]:=1;
				end
                else if(e.cod_pos=a^.elem.cod_pos)then
                    a^.elem.cantMes[e.mes]:=a^.elem.cantMes[e.mes]+1
				else if(e.cod_pos<a^.elem.cod_pos)then
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
		function ContarMesesMayores(v:vector;cantP:integer):integer;
		var 
			i:integer;
			cantM:integer;
		begin
			cantM:=0;
			for i:=1 to DF do begin
				if(v[i]>cantP)then
					cantM:=cantM + 1;
			end;
			ContarMesesMayores:=cantM;
		end;
		function EncontrarCodigoPostal(a:arbol;c,cant:integer):integer;
		begin
			if(a=nil)then
				EncontrarCodigoPostal:=0
			else if(a^.elem.cod_pos<c)then
				EncontrarCodigoPostal:=EncontrarCodigoPostal(a^.HD,c,cant)
			else if(a^.elem.cod_pos>c)then
				EncontrarCodigoPostal:=EncontrarCodigoPostal(a^.HI,c,cant)
			else
				EncontrarCodigoPostal:=ContarMesesMayores(a^.elem.cantMes,cant);
		end;
begin
	DevolverMayores:=EncontrarCodigoPostal(a,codP,cantPrueba);
end;
procedure RetonarRangoCod(a:arbol;lm,ls:integer;var l:lista);
        procedure insertarAdelante(var l:lista;codigo_Pos:integer);
        var
            nue:lista;
        begin
            new(nue);
            nue^.elem:=codigo_Pos;
            nue^.sig:=l;
            l:=nue;
        end;
        function analizarMeses(v:vector):boolean;
        var 
            i:integer;
            esta:boolean;
        begin
            esta:=false;
            i:=1;
            while(i<=DF)and(esta=false)do begin
                if(v[i]=0)then
                    esta:=true
                else
                    i:=i +1;
            end;
            analizarMeses:=esta;
        end;
		procedure cantRangosCod(a:arbol;li,ls:integer;var l:lista);
		var
            esta:boolean;
        begin
			esta:=false;
            if(a<>nil)then begin
                if(a^.elem.cod_pos>li)then
                    cantRangosCod(a^.HI,li,ls,l);

                if(a^.elem.cod_pos>=li)and(a^.elem.cod_pos<=ls)then begin
                    esta:=analizarMeses(a^.elem.cantMes);
                    if(esta=true)then
                        insertarAdelante(l,a^.elem.cod_pos);
                end;

                if(a^.elem.cod_pos<ls)then
                    cantRangosCod(a^.HD,li,ls,l);
            end;
        end;
begin
    l:=nil;
	cantRangosCod(a,lm,ls,l);
end;
var
	a:arbol;
	codigoPos,CantidadMese:integer;
	cantPrueba:integer;
	limI,limS:integer;
    l:lista;
begin
	randomize;
	a:=nil;
	//inciso A
	CargarArbol(a);
	//inciso B
	readln(codigoPos);
	readln(cantPrueba);
	CantidadMese:=DevolverMayores(a,codigoPos,cantPrueba);
	//inciso c
	readln(limI);
	readln(limS);
    RetonarRangoCod(a,limI,limS,l);
end.