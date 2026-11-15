{Bienvenidos al entorno CMRE.
Lo siguiente es un código de ejemplo que implementa un
proceso que recibe un número de avenida como parámetro,
se posiciona en esa avenida y la recorre.}

programa parcialSembradores
procesos
  proceso buscarFlores(E av: numero; E ca: numero)
  comenzar
    BloquearEsquina(16, 16)
    Pos(16, 16)
    repetir 11
      tomarFlor
    Pos(av, ca)
    LiberarEsquina(16, 16)
  fin  
  proceso recorrerAv(E Av: numero; ES cant: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni := PosAv
    caIni := PosCa
    buscarFlores(avIni, caIni)
    Pos(Av, 5)
    cant := 0
    repetir 11
      si (~HayFlorEnLaEsquina)
        depositarFlor
        cant := cant + 1
      si (PosCa < 15)
        mover
    Pos(avIni, caIni)
  fin
  proceso Identificar(E id:numero;ES av:numero)
  comenzar
    si(id=1)
      EnviarMensaje(av, r1)
      av:=av + 1
    sino
      si(id=2)
        EnviarMensaje(av, r2)
        av:=av + 1
      sino 
        EnviarMensaje(av, r3) 
        av:=av + 1
  fin
areas
  areaC: AreaPC(5,5,15,15)
  areaFuente: AreaPC(16,16,16,16)
  area1: AreaP(1,12,1,12)
  area2: AreaP(2,12,2,12)
  area3: AreaP(3,12,3,12)
  area4: AreaP(4,12,4,12)
robots
  robot sembradores
  variables
    Av, cant, id: numero
  comenzar
    cant := 0
    RecibirMensaje(id, jefe) 
    EnviarMensaje(id, jefe)
    RecibirMensaje(Av, jefe)
    mientras (Av <> 0)
      recorrerAv(Av, cant)
      EnviarMensaje(id, jefe)
      RecibirMensaje(Av, jefe)
    EnviarMensaje(cant, jefe)
  fin
  robot Jefe
  variables
    cant, num, Av, id: numero
  comenzar
    EnviarMensaje(1, r1) 
    EnviarMensaje(2, r2) 
    EnviarMensaje(3, r3) 
    cant:=0
    Av:=5
    mientras (Av <= 15)  
      RecibirMensaje(id, *)
      Identificar(id,Av)  
    EnviarMensaje(0, r1) 
    EnviarMensaje(0, r2) 
    EnviarMensaje(0, r3) 
    repetir 3 
      RecibirMensaje(id, *)
      RecibirMensaje(num, *)
      cant :=cant + num
    Informar(cant)
  fin
variables
  r1,r2,r3:sembradores
  jefe:Jefe
comenzar
  AsignarArea(r1,areaC)
  AsignarArea(r1,areaFuente)
  AsignarArea(r1,area2)
  AsignarArea(r2,areaC)
  AsignarArea(r2,areaFuente)
  AsignarArea(r2,area3)
  AsignarArea(r3,areaC)
  AsignarArea(r3,areaFuente)
  AsignarArea(r3,area4)
  AsignarArea(jefe,area1)
  Iniciar(r1,2,12)
  Iniciar(r2,3,12)
  Iniciar(r3,4,12)
  Iniciar(jefe,1,12)
fin