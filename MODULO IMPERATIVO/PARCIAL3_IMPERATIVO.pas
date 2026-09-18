{TURNO:G   PARCIAL IMPERATIVO FECHA:16/09/2025
Una biblioteca necesita un sistema para procesar la información de los libros. De cada libro se conoce: ISBN, código del
autor y código de género (1 a 15).
a) Implementar un módulo que lea información de los libros y retorne una estructura de datos eficiente para la
    búsqueda por código de autor que contenga código de autor y una lista de todos sus libros. La lectura finaliza al
    ingresar el valor 0 para un ISBN.
b) Realizar un módulo que reciba la estructura generada en el inciso a), un código de autor y un código de género.
    El módulo debe retornar una lista con código de autor y cantidad de libros del código de género recibido, para
    cada autor cuyo código sea superior al código de autor ingresado.
c) Realizar un módulo recursivó que reciba la estructura generada en inciso b) y retorne cantidad y código de autor
    con mayor cantidad de libros.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c. En caso de ser necesario, puede utilizar los
módulos que se encuentran a continuación.}
program PARCIAL3_IMPERATIVO;
type
    subGen=1..15;
    libro=record
        ISBN:integer;
        cod_autor:integer;
        codGen:subGen;
    end;
    libAuto=record
        ISBN:integer;
        codGen:subGen;
    end;
    lista=^nodo;
    nodo=record
        elem:libAuto;
        sig:lista;
    end;
    librosAutor=record
        cod_autor:integer;
        lis:lista;
    end;
    arbol=^nodo2;
    nodo2=record
        elem:librosAutor;
        HI:arbol;
        HD:arbol;
    end;
    autorCant=record
        cod_autor:integer;
        cantGen:integer;
    end;
    listasNue=^nodo3;
    nodo3=record
        elem:autorCant;
        sig:listasNue;
    end;
procedure CargarArbol(var a:arbol);
            procedure LeerLibro(var l:libro);
            begin
                readln(l.ISBN);
                if(l.ISBN<>0)then begin
                    l.cod_autor:=random(2000)+1;
                    l.codGen:=random(15)+1;
                end;
            end;
            procedure insertarAdelante(var l:lista;t:libAuto);
            var
                nue:lista;
            begin
                new(nue);
                nue^.elem:=t;
                nue^.sig:=l;
                l:=nue;
            end;
            procedure InsertarAutor(var a:arbol;l:libro);
            var
                t:libAuto;
            begin
                t.ISBN:=l.ISBN;
                t.codGen:=l.codGen;
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.cod_autor:=l.cod_autor;
                    a^.elem.lis:=nil;
                    insertarAdelante(a^.elem.lis,t);
                end
                else if(l.cod_autor=a^.elem.cod_autor)then
                    insertarAdelante(a^.elem.lis,t)
                else if(l.cod_autor<a^.elem.cod_autor)then
                    InsertarAutor(a^.HI,l)
                else
                    InsertarAutor(a^.HD,l);
            end;
var
    l:libro;
begin
    LeerLibro(l);
    while(l.ISBN<>0)do begin
        InsertarAutor(a,l);
        LeerLibro(l);
    end;
end;
procedure RetornarListasNuevas(a:arbol;var l:listasNue);
            procedure insertarAdelante(var l:listasNue;a:autorCant);
            var
                nue:listasNue;
            begin
                new(nue);
                nue^.elem:=a;
                nue^.sig:=l;
                l:=nue;
            end;
            function cantidadGeneros(l:lista;g:subGen):integer;
            var
                c:integer;
            begin
                c:=0;
                while(l<>nil)do begin
                    if(l^.elem.codGen=g)then
                        c:=c+1;
                    l:=l^.sig;
                end;
                cantidadGeneros:=c;
            end;
            procedure armarListaNue(a:arbol;codBus:integer;codg:subGen;var l:listasNue);
            var
                regNue:autorCant;
            begin
                if(a<>nil)then begin
                    if(a^.elem.cod_autor>codBus)then begin
                        regNue.cod_autor:=a^.elem.cod_autor;
                        regNue.cantGen:=cantidadGeneros(a^.elem.lis,codg);
                        insertarAdelante(l,regNue);

                        armarListaNue(a^.HI,codBus,codg,l);
                        armarListaNue(a^.HD,codBus,codg,l);
                    end
                    else begin
                        armarListaNue(a^.HD,codBus,codg,l);
                    end;
                end;
            end;
var
    cod:integer;
    codG:subGen;
begin
    write('Ingrese el codigo de autor a superar: ');
    readln(cod);
    write('Ingrese el genero a buscar (1..15): ');
    readln(codG);
    l:=nil;
    armarListaNue(a,cod,codG,l);
end;
procedure retornarMaxAutor(l:listasNue;var r:autorCant);
            procedure MaxAutor(l:listasNue;var max,autor:integer);
            begin
                if(l<>nil)then begin
                    if(l^.elem.cantGen>max)then begin
                        max:=l^.elem.cantGen;
                        autor:=l^.elem.cod_autor;
                    end;
                    MaxAutor(l^.sig,max,autor);
                end;
            end;
begin
    r.cantGen:=-1;
    maxAutor(l,r.cantGen,r.cod_autor);
end;
var
    a:arbol;
    l:listasNue;
    r:autorCant;
begin
    randomize;
    a:=nil;
    //inciso A
    cargarArbol(a);
    //inciso B
    RetornarListasNuevas(a,l);
    //inciso C
    retornarMaxAutor(l,r);
    if (r.cantGen <> -1) then
        writeln('El autor con mas libros es el codigo: ', r.cod_autor, ' con ', r.cantGen, ' libros.')
    else
        writeln('La lista estaba vacia.');
end.