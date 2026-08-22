{2. Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información de
los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2015..2024), marca,
color y modelo, finalizando con marca ‘MMM’) y los almacene en dos estructuras de
datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar juntas las patentes y colores de los autos pertenecientes a ella.
b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.
c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.
e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.
f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
color del auto con dicha patente.}
program P5_EJE2_TALLER;
const
    INF=2015;
    SUP=2024;
type
    SubAnios=INF..SUP;
    autos=record
        patente:string;
        anioFac:SubAnios;
        marca:string;
        color:string;
        modelo:string;  
    end;
    arbol=^nodo;
    nodo=record
        elem:autos;
        HI:arbol;
        HD:arbol;
    end;
    NuevaEstruc=record
        patente:string;
        color:string;
    end;
    lista=^nodo2;
    nodo2=record
        elem:NuevaEstruc;
        sig:lista;
    end;
    listaMarcas=record
        marca2:string;
        listaMar:lista;
    end;
    arbol2=^nodo3;
    nodo3=record
        elem:listaMarcas;
        HI:arbol2;
        HD:arbol2;
    end;
    listaAutos=^nodo4;
    nodo4=record
        elem:autos;
        sig:listaAutos;
    end;
    vector=array[SubAnios]of listaAutos;
procedure cargarArbol(var a:arbol;var a2:arbol2);
        procedure leerAutos(var s:autos);
        begin
            write('ingrese una marca de auto:');
            readln(s.marca);
            if(s.marca<>'MMM')then begin
                write('ingrese una patente:');
                readln(s.patente);
                write('ingrese el año de fabricacion del auto:');
                readln(s.anioFac);
                write('ingrese el color del auto:');
                readln(s.color);
                write('ingrese el modelo del auto:');
                readln(s.modelo);
            end; 
        end;
        procedure insertarAutos(var a:arbol;o:autos);
        begin
            if(a=nil)then begin
                new(a);
                a^.elem:=o;
                a^.HI:=nil;
                a^.HD:=nil;
            end
            else if(o.patente<a^.elem.patente)then
                insertarAutos(a^.HI,o)
            else
                insertarAutos(a^.HD,o);
        end;
        procedure insertarAdelante(var l:lista;n:NuevaEstruc);
        var
            nue:lista;
        begin
            new(nue);
            nue^.elem:=n;
            nue^.sig:=l;
            l:=nue;
        end;
        procedure insertarMarcas(var a2:arbol2;o:autos);
        var
            n:NuevaEstruc;
        begin
            n.patente:=o.patente;
            n.color:=o.color;
            if(a2=nil)then begin
                new(a2);
                a2^.elem.marca2:=o.marca;
                a2^.elem.listaMar:=nil;
                insertarAdelante(a2^.elem.listaMar,n);
                a2^.HI:=nil;
                a2^.HD:=nil;
            end
            else if(o.marca=a2^.elem.marca2)then
                insertarAdelante(a2^.elem.listaMar,n)
            else if(o.marca<a2^.elem.marca2)then
                insertarMarcas(a2^.HI,o)
            else
                insertarMarcas(a2^.HD,o);
        end;
var
 o:autos;
begin
    leerAutos(o);
    While(o.marca<>'MMM')do begin
        insertarAutos(a,o);
        insertarMarcas(a2,o);
        leerAutos(o);
    end;
end;
procedure CantidadMarcasdeAutos(a:arbol;var cant:integer);
        function cantMarcas(a:arbol;m:string):integer;
        begin
            if(a=nil)then
                cantMarcas:=0
            else if(a^.elem.marca=m)then
                cantMarcas:=1 + cantMarcas(a^.HI,m)+cantMarcas(a^.HD,m)
            else
                cantMarcas:=cantMarcas(a^.HI,m)+cantMarcas(a^.HD,m);
        end;
var
    mar:string;
begin
    write('ingrese una marca para autos:');
    readln(mar);
    cant:=cantMarcas(a,mar);
    if(cant=0)then
        writeln('no hubo marcas del mismo nombre')
    else
        writeln('esta es la cantidad de marcas del mismo nombre:',cant);
end;
procedure CantMarcasAutos2(a2:arbol2;var c:integer);
        function contadorLista(l:lista):integer;
        begin
          if(l=nil)then
            contadorLista:=0
          else
            contadorLista:=1+contadorLista(l^.sig);
        end;
        function cantM(a2:arbol2;m:string):integer;
        begin
            if(a2=nil)then
                cantM:=0
            else if(a2^.elem.marca2<m)then
                cantM:=cantM(a2^.HD,m)
            else if(a2^.elem.marca2>m)then
                cantM:=cantM(a2^.HI,m)
            else
                cantM:=ContadorLista(a2^.elem.listaMar);
        end;
var
    mar:string;
begin
    write('ingrese marca:');
    readln(mar);
    c:=cantM(a2,mar);
    if(c=0)then
        writeln('no hubo nada de autos de la marca')
    else
        writeln('esta es la cantidad total de autos por marca:',c);
end;
procedure CargarVectorAutos(a:arbol;var v:vector);
        procedure inicializarVector(var v:vector;I:integer);
        begin
            if(I<=SUP)then begin
                v[I]:=nil;
                inicializarVector(v,I+1);
            end;
        end;
        procedure insertarAdelante(var l:listaAutos;a:autos);
        var
            nue:listaAutos;
        begin
            new(nue);
            nue^.elem:=a;
            nue^.sig:=l;
            l:=nue;
        end;
        procedure cargarVec(var v:vector;a:arbol);
        begin
            if(a<>nil)then begin
                insertarAdelante(v[a^.elem.anioFac],a^.elem);
                cargarVec(v,a^.HI);
                cargarVec(v,a^.HD);
            end;
        end;
var
    INDICE:integer;
begin
    INDICE:=INF;
    inicializarVector(v,INDICE);
    cargarVec(v,a);
end;
procedure devolverModeloAuto(a:arbol;var mode:string);
    procedure ModeloAuto(a:arbol;p:string;var mode:string);
    begin
        if(a=nil)then
            mode:='patente no encontrada'
        else if(a^.elem.patende=p)then
            mode:=a^.elem.modelo
        else if(a^.elem.patente>p)then
            ModeloAuto(a^.HI,p,mode)
        else
            ModeloAuto(a^.HD,p,mode);
    end;
var 
    p:string;
begin        
    write('ingrese una patende para buscar:');
    readln(p);
    ModeloAuto(a,p,mode);
    writeln('este es el modelo del auto con la patente ingresada:',mode);                   
end;
procedure devolverColorAuto(a2:arbol2;var colo:string);
        procedure BuscarLista(l:lista;p:string;var c:string);
        begin
            if(l<>nil)then begin
                if(l^.elem.patente=p)then
                    c:=l^.elem.color
                else
                    BuscarLista(l^.sig,p,c);
            end;
        end;
        procedure recorreArbol2(a2:arbol2;p:string;var color:string);
        begin
            if(a2<>nil)then begin
                BuscarLista(a2^.elem.listaMar,p,color);
                recorreArbol2(a2^.HI,p,color);
                recorreArbol2(a2^.HD,p,color);
            end;
        end;
var
    p:string;    
begin
    write('ingrese una patente para probar:');
    readln(p);
    colo:='NO SE ENCONTRO LA PATENTE';
    recorreArbol2(a2,p,colo);
    writeln('este es el color de la patente:',colo);
end;
var
    a:arbol;
    a2:arbol2;
    cant,cont:integer;
    v:vector;
    m,color:string;
begin
    a:=nil;
    a2:=nil;
    //inciso A
    cargarArbol(a,a2);
    //inciso B
    CantidadMarcasdeAutos(a,cant);
    //inciso C
    CantMarcasAutos2(a2,cont);
    //inciso D
    CargarVectorAutos(a,v);
    //inciso E
    devolverModeloAuto(a,m);
    //inciso F
    devolverColorAuto(a2,color);
end.