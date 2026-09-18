{4. La Feria del Libro necesita un sistema para obtener estadísticas sobre los libros
presentados.
a) Implementar un módulo que lea información de los libros. De cada libro se conoce:
ISBN, código del autor y código del género (1: literario, 2: filosofía, 3: biología, 4: arte,
5: computación, 6: medicina, 7: ingeniería) . La lectura finaliza con el valor 0 para el
ISBN. Se sugiere utilizar el módulo leerLibro(). El módulo deber retornar dos
estructuras:
i. Un árbol binario de búsqueda ordenado por código de autor. Para cada código de autor
debe almacenarse la cantidad de libros correspondientes al código.
ii. Un vector que almacene para cada género, el código del género y la cantidad de libros del
género.
b) Implementar un módulo que reciba el vector generado en a), lo ordene por cantidad
de libros de mayor a menor y retorne el nombre de género con mayor cantidad
cantidad de libros.
c) Implementar un módulo que reciba el árbol generado en a) y dos códigos. El módulo
debe retornar la cantidad total de libros correspondientes a los códigos de autores
entre los dos códigos ingresados (incluidos ambos).
NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.
* }
program P5_EJE4_TALLER;
Const
    DF=7;
    NombresGeneros: array [1..DF] of string = ('literario', 'filosofía', 'arte', 'biología', 'computación', 'medicina', 'ingeniería');
type
    subGenero = 1..DF;
	libro = record
		isbn : integer;
		codAutor : integer;
		genero : integer;
		
	end;
    cantAutor=record
        codAutor:integer;
        cantLib:integer;
    end;
	arbol=^nodo;
	nodo=record
		elem:cantAutor;
		HI:arbol;
		HD:arbol;
	end;
    CantLibros=record
        cod_genero:integer;
        cantLib:integer;
    end;
	vector=array[subGenero] of CantLibros;
procedure CargarArbol(var a:arbol;var v:vector);
	procedure leerLibro (var l : libro);
	begin
		l.isbn := Random(1000);
		if (l.isbn <> 0) then begin
			l.codAutor := Random(300) + 100;
			l.genero := Random(7) + 1;
		end;
	end;
	procedure insertarLibro(var a:arbol;codAutor:integer);
	begin
		if(a=nil) then begin
			new(a);
			a^.elem.codAutor:=codAutor;
            a^.elem.cantLib:= 1;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else if(codAutor=a^.elem.codAutor)then
            a^.elem.cantLib:=a^.elem.cantLib + 1
        else if(codAutor<a^.elem.codAutor)then
			insertarLibro(a^.HI,codAutor)
        else
            insertarLibro(a^.HD,codAutor);
    end;
    procedure iniciaizarVec(var v:vector);
    var 
        i:integer;
    begin
        for i:=1 to DF do begin
            v[i].cod_genero:=i;
            v[i].cantLib:=0;
        end;
    end;
var
	l:libro;
begin
    iniciaizarVec(v);
	leerLibro(l);
	while(l.isbn<>0)do begin
        v[l.genero].cantLib:=v[l.genero].cantLib + 1;
		insertarLibro(a,l.codAutor);
		leerLibro(l);
	end;
end;
procedure OrdenarYretornarMayor(var v:vector;var mayor:string);
     procedure Insercion(var v:vector);
     var
        i,j:integer;
        item:CantLibros;
    begin
        for i:=2 to DF do begin
            item:=v[i];
            j:=i-1;
            while(j>0)and(v[j].cantLib<item.cantLib)do begin
                v[j+1]:=v[j];
                j:=j-1;
            end;
            v[j+1]:=item;
        end;
    end;
begin
    insercion(v);
    mayor:=NombresGeneros[v[1].cod_genero];
end;
procedure cantidadRangosAutor(a:arbol;var cant:integer);
        function rangosAutor(a:arbol;cod1,cod2:integer):integer;
        begin
            if(a=nil)then
                rangosAutor:=0
            else if(a^.elem.codAutor<cod1)then
                rangosAutor:=rangosAutor(a^.HD,cod1,cod2)
            else if(a^.elem.codAutor>cod2)then
                rangosAutor:=rangosAutor(a^.HI,cod1,cod2)
            else
                rangosAutor:=a^.elem.cantLib + rangosAutor(a^.HI,cod1,cod2)+rangosAutor(a^.HD,cod1,cod2);
        end;
var
    c1,c2:integer;
begin
    write('ingrese un codigo de autor:');
    readln(c1);
    write('ingrese otro autor:');
    readln(c2);
    cant:=0;
    cant:=rangosAutor(a,c1,c2);
    if(cant=0)then
        write('no hubo ningun autor entre esos rangos')
    else
        write('esta es la cantidad de libros entre esos rangos:',cant);
end;
var 
	a:arbol;
    v:vector;
    MaxGenNombre:string;
    cantL:integer;
begin
	randomize;
	a:=nil;
	//INCISO A
    CargarArbol(a,v);
    //INCISO B
    OrdenarYretornarMayor(v,MaxGenNombre);
    writeln('este es el genero que tiene mas libros:',MaxGenNombre);
    //INCISO C
    cantidadRangosAutor(a,cantL);
end.