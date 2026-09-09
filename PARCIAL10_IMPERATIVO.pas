{La fiesta nacional de la empanada artesanal necesica un slere pare ts
presentadas.
a) Implementar un módulo que lea información de las empanadas. De cada empanada se conoce: categoria de
    empanada (1 .. 10), DNI del chef, materia prima principal y forma de cocción. La lectura finaliza con DNI del chel
    0. Se sugiere utilizor el módulo leerEmponado(). El módulo deber retornar dos estructuras:
    i. Un árbol binario de búsqueda ordenado por el DNI del chef. Para cada DNI debe almacenarse la cantidad de
        empanadas correspondientes a dicho chef.
    ii. Una lista que almacene en cada nodo el nombre de la materia prima principal y la cantidad total de
        empanadas con esa materia prima. Esta estructura debe quedar ordenada por el nombre de materia prima.
b) Implementar un módulo que reciba el árbol generado en a)i., y un DNI. El módulo debe retornar la cantidad de
    chefs menor al DNI ingresado.
c) Implementar un módulo recursivo que reciba la lista generada en alii, y retorne el nombre de la materia prima
    con mayor cantidad de empanadas.}
program PARCIAL10_IMPERATIVO;
const 
    DF=10;
type
    cadena=string[30];
    subCat=1..DF;
    empanadas=record
        categ:subCat;
        dniChef:integer;
        m_prima:string;
        formaCoccion:cadena;
    end;
    infoArbol=record
        dniChef:integer;
        canTotal:integer;
    end;
    arbol=^nodoArbol;
    nodoArbol=record
        elem:infoArbol;
        HI:arbol;
        HD:arbol;
    end;
    infoLista=record
        m_prima:string;
        canMat:integer;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:infoLista;
        sig:lista;
    end;
procedure CargarArbolyLista(var a:arbol;var l:lista);
            procedure leerEmpanada(var e:empanadas);
            begin
                e.dniChef:=random(200);
                if(e.dniChef<>0)then begin
                    e.categ:=random(DF)+1;
                    readln(e.m_prima);
                    readln(e.formaCoccion);
                end;
            end;
            procedure insertarEmpanada(var a:arbol;DniBus:integer);
            begin
                if(a=nil)then begin
                    new(a);
                    a^.HI:=nil;
                    a^.HD:=nil;
                    a^.elem.dniChef:=DniBus;
                    a^.elem.canTotal:=1;
                end
                else if(DniBus=a^.elem.dniChef)then
                    a^.elem.canTotal:=a^.elem.canTotal + 1
                else if(DniBus<a^.elem.dniChef)then
                    insertarEmpanada(a^.HI,DniBus)
                else
                    insertarEmpanada(a^.HD,DniBus);
            end;
            procedure insertarOrdenado(var l:lista;materia:string);
            var
                ant,act,nue:lista;
            begin
                new(nue);
                nue^.elem.m_prima:=materia;
                nue^.elem.canMat:=1;

                ant:=l;
                act:=l;
                while(act<>nil)and(act^.elem.m_prima<materia)do begin
                    ant:=act;
                    act:=act^.sig;
                end;
                if(act = l)then
                    l:=nue
                else
                    ant^.sig:=nue;
                nue^.sig:=act;
            end;
            procedure ActualizarLista(var l:lista;materia:string);
            var
               aux:lista; 
            begin
                aux:=l;
                while(aux<>nil)and(aux^.elem.m_prima<>materia)do begin
                    aux:=aux^.sig;
                end;
                if(aux<>nil)then
                    aux^.elem.canMat:=aux^.elem.canMat +1
                else
                    insertarOrdenado(l,materia);
            end;
var
    e:empanadas;
begin
    a:=nil;
    l:=nil;
    leerEmpanada(e);
    while(e.dniChef<>0)do begin
        insertarEmpanada(a,e.dniChef);
        ActualizarLista(l,e.m_prima);
        leerEmpanada(e);
    end;
end;
function retornarCantChefMenor(a:arbol;dniC:integer):integer;
            function BuscarDnis(a:arbol;dniC:integer):integer;
            begin
                if(a=nil)then
                    BuscarDnis:=0
                else if(a^.elem.dniChef<dniC)then
                    BuscarDnis:= 1 + BuscarDnis(a^.HI,dniC) + BuscarDnis(a^.HD,dniC)
                else
                    BuscarDnis:=BuscarDnis(a^.HI,dniC);
            end;
begin
    retornarCantChefMenor:=BuscarDnis(a,dniC);
end;
procedure retornarMaxMateria(l:lista;var maxM:string);
            procedure maximo(cant:integer;nomMate:string;var max:integer;var maxM:string);
            begin
                if(cant>max)then begin
                    max:=cant;
                    maxM:=nomMate;
                end;
            end;
            procedure BuscarMaximo(l:lista;var max:integer;var maxM:string);
            begin
                if(l<>nil)then begin
                    maximo(l^.elem.canMat,l^.elem.m_prima,max,maxM);
                    BuscarMaximo(l^.sig,max,maxM);
                end;
            end;
var 
    max:integer;
begin
    max:=-1;
    BuscarMaximo(l,max,maxM);
end;
var
    a:arbol;
    l:lista;
    dniChefPrueba:integer;
    cantDnis:integer;
    maxMateria:string;
begin
    randomize;
    //inciso A
    CargarArbolyLista(a,l);
    //inciso B
    readln(dniChefPrueba);
    cantDnis:=retornarCantChefMenor(a,dniChefPrueba);
    //inciso C
    retornarMaxMateria(l,maxMateria);
end.
