program eje;
const DF=10;
type
	subDiag=1..DF;
	atencion=record
		dni:integer;
		cod_mat:integer;
		cod_diag:subDiag;
		dia:integer;
	end;
	infolista=record
		dni:integer;
		cod_diag:subDiag;
		dia:integer;
	end;
	lista=^nodoLista;
	nodoLista=record
		elem:infoLista;
		sig:lista;
	end;
	infoArbol=record
		cod_mat:integer;
		lisA:lista;
	end;
	arbol=^nodoArbol;
	nodoArbol=record
		elem:infoArbol;
		HI:arbol;
		HD:arbol;
	end;
	vector=array[subDiag]of integer;
procedure cargarArbol(var a:arbol);
		procedure LeerAtenciones(var t:atencion);
		begin
			t.dni:=random(100);
			if(t.dni<>0)then begin
				t.cod_mat:=random(1000);
				t.dia:=random(31)+1;
				t.cod_diag:=random(DF)+1;
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
		procedure insertarAtenciones(var a:arbol;t:atencion;i:infoLista);
		begin
			if(a=nil)then begin
				new(a);
				a^.elem.cod_mat:=t.cod_mat;
				a^.elem.lisA:=nil;
				insertarAdelante(a^.elem.lisA,i);
				a^.HI:=nil;
				a^.HD:=nil;
			end
			else if(t.cod_mat=a^.elem.cod_mat)then
				insertarAdelante(a^.elem.lisA,i)
			else if(t.cod_mat<a^.elem.cod_mat)then
				insertarAtenciones(a^.HI,t,i)
			else
				insertarAtenciones(a^.HD,t,i);
		end;
		procedure actualizarInfo(t:atencion;var i:infoLista);
		begin
			i.dni:=t.dni;
			i.cod_diag:=t.cod_diag;
			i.dia:=t.dia;
		end;
var
	t:atencion;
	i:infoLista;
begin
	a:=nil;
	leerAtenciones(t);
	while(t.dni<>0)do begin
		actualizarInfo(t,i);
		insertarAtenciones(a,t,i);
		leerAtenciones(t);
	end;
end;
function retornarCandDni(a:arbol;li,ls,dni:integer):integer;
			function contarDni(l:lista;dni:integer):integer;
			var
				cant:integer;
			begin
				cant:=0;
				while(l<>nil)do begin
					if(l^.elem.dni=dni)then
						cant:=cant +1;
					l:=l^.sig;
				end;
				contarDni:=cant;
			end;
			function BuscarRangos(a:arbol;li,ls,dni:integer):integer;
			begin
				if(a=nil)then
					BuscarRangos:=0
				else if(a^.elem.cod_mat<=li)then
					BuscarRangos:=BuscarRangos(a^.HD,li,ls,dni)
				else if(a^.elem.cod_mat>=ls)then
					BuscarRangos:=BuscarRangos(a^.HI,li,ls,dni)
				else
					BuscarRangos:=contarDni(a^.elem.lisA,dni) + BuscarRangos(a^.HI,li,ls,dni) + BuscarRangos(a^.HD,li,ls,dni);
			end;
begin
	retornarCandDni:=BuscarRangos(a,li,ls,dni);
end;
procedure retornarCanDiagnostico(a:arbol;var v:vector);
		procedure crearVector(l:lista;var v:vector);
		begin
			while(l<>nil)do begin
				v[l^.elem.cod_diag]:=v[l^.elem.cod_diag] + 1;
				l:=l^.sig;
			end;
		end;
begin
	if(a<>nil)then begin
		crearVector(a^.elem.lisA,v);
		retornarCanDiagnostico(a^.HI,v);
		retornarCanDiagnostico(a^.HD,v);
	end;
end;
procedure inicializarVec(var v:vector);
var
	i:subDiag;
begin
	for i:=1 to DF do 
		v[i]:=0;
end;
var
	a:arbol;
	cantDnis:integer;
	v:vector;
	limI,limS:integer;
	dni:integer;
begin
	randomize;
	//inciso A;
	cargarArbol(a);
	//inciso B
	readln(limI);
	readln(limS);
	readln(dni);
	cantDnis:=retornarCandDni(a,limI,limS,dni);
	//inciso C
	inicializarVec(v);
	retornarCanDiagnostico(a,v);
end.
