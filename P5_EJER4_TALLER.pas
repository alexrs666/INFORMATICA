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
program ejer4;
type
	type subGenero = 1..7;
	libro = record
		isbn : integer;
		codAutor : integer;
		genero : subGenero;
		
	end;
	arbol=^nodo;
	nodo=record
		elem:libro;
		HI:arbol;
		HD:arbol;
	end;
	lista=^nodo2;
	nodo2=record
		elem:=libro;
		sig:lista;
	end;
	vector=array[subGenero] of libro;
procedure CargarArbol(var a:arbol;var v:vector);
	procedure leerLibro (var l : libro);
	var v: array [1..7] of string = (‘literario’, ‘filosofía’, ‘arte‘, ‘biología’, ‘computación’, ‘medicina’,‘ingeniería’);
	begin
		l.isbn := Random(1000);
		if (l.isbn <> 0) then begin
			l.codAutor := Random(300) + 100;
			l.genero := Random(7) + 1;
		end;
	end;
	procedure insertarLibro(var a:arbol;l:libro);
	begin
		if(a=nil) then begin
			new(a);
			a^.elem.:=l;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else if(l.isbn<a^.elem.isbn)then
			insertarLibro(a^.HI,l)
		else 
			insertarLibro(a^.HD,l);
	end;
var
	l:libro;
begin
	leerLibro(l);
	while(l.isbn<>0)do begin
		
		insertarLibro(a,l);
		leerLibro(l);
	end;
end;
var 
	a:arbol
begin
	randomize;
	a:=nil;
	CargaArbol(a,v);
end.