{TURNO I
Módulo Programación Concurrente
Un robot Jefe debe coordinar a tres robots trabajadores (R1, R2 y R3) 
para juntar todas las flores de las avenidas 10 a 19, desde la calle 1 hasta la calle 15.
El Jefe asigna las avenidas de a una, en orden, a medida que los trabajadores estén disponibles.
Cada vez que un trabajador esté disponible solicita al Jefe una nueva avenida para limpiar.
Al terminar de recorrer una avenida, los trabajadores deben depositar las flores juntadas en la esquina (30,30).
Cuando ya no quedan avenidas pendientes, el Jefe debe informar la cantidad total de flores recolectadas.
Los robots trabajadores inician en las esquinas (2,1), (3,1) y (4,1). El robot Jefe inicia en la esquina [1,1]}
programa ejemplo
procesos
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso depositarEsquina(E cantF:numero)
  variables
    avActual,caActual:numero
  comenzar
    avActual:=PosAv
    caActual:=PosCa
    repetir cantF
      BloquearEsquina(30,30)
      Pos(30,30)
      depositarFlor
      Pos(avActual,caActual)
      LiberarEsquina(30,30)
  fin
  proceso recorrerAv(ES numAv: numero;ES totalF:numero)
  variables
    cantF:numero
  comenzar
    Pos(numAv,1)
    cantF:=0
    repetir 14
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    totalF:=totalF + cantF
    depositarEsquina(cantF)
  fin
  proceso identificar(E id:numero;E av:numero)
  comenzar
    si(id=1)
      EnviarMensaje(av,t1)
    sino
      si(id=2)
        EnviarMensaje(av,t2)
      sino
        si(id=3)
          EnviarMensaje(av,t3)
  fin
areas
  areaCosecha: AreaPC (10,1,19,15)
  areaDep: AreaPC(30,30,30,30)
  area1:AreaP(2,1,2,1)
  area2:AreaP(3,1,3,1)
  area3:AreaP(4,1,4,1)
  area4:AreaP(1,1,1,1)
robots
  robot trabajadores
  variables
    id:numero
    totalFlores:numero
    avActual:numero
  comenzar
    totalFlores:=0
    RecibirMensaje(id,jefe)
    EnviarMensaje(id,jefe)
    RecibirMensaje(avActual,jefe)
    mientras(avActual<>0)
      recorrerAv(avActual,totalFlores)
      EnviarMensaje(id,jefe)
      RecibirMensaje(avActual,jefe)
    EnviarMensaje(totalFlores,jefe)
  fin
  robot Jefe
  variables
    id:numero
    total:numero
    cant:numero
    avSig:numero
  comenzar
    total:=0
    EnviarMensaje(1,t1)
    EnviarMensaje(2,t2)
    EnviarMensaje(3,t3)
    avSig:=10
    repetir 10
      RecibirMensaje(id,*)
      identificar(id,avSig)
      avSig:=avSig + 1
    repetir 3
      RecibirMensaje(id,*)
    EnviarMensaje(0,t1)
    EnviarMensaje(0,t2)
    EnviarMensaje(0,t3)
    repetir 3
      RecibirMensaje(cant,*)
      total:=total + cant
    Informar(total)
  fin
variables
  t1,t2,t3:trabajadores
  jefe:Jefe
comenzar
  AsignarArea(t1,areaCosecha)
  AsignarArea(t1,areaDep)
  AsignarArea(t1,area1)
  AsignarArea(t2,areaCosecha)
  AsignarArea(t2,areaDep)
  AsignarArea(t2,area2)
  AsignarArea(t3,areaCosecha)
  AsignarArea(t3,areaDep)
  AsignarArea(t3,area3)
  AsignarArea(jefe,area4)
  Iniciar(t1,2,1)
  Iniciar(t2,3,1)
  Iniciar(t3,4,1)
  Iniciar(jefe,1,1)
fin