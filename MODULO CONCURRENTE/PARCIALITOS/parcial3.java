{Tres robots deben realizar 3 cuadrados cada uno, como se ejemplifica en la figura, juntando
todas las flores que encuentran a su paso. El tamaño de cada cuadrado será determinado
aleatoriamente entre 1 y 4 por cada robot. Al finalizar cada cuadrado, deberán depositar de
a una todas las flores encontradas en la esquina (50,50). Cuando los robots terminan los 3
cuadrados, un robot coordinador deberá informar qué robot recorrió más esquinas.

Los robots inician en las esquinas (1,1), (7,1) y (14,1) y el robot coordinador en la esquina
(51,51)}
programa parcialTurnoE
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso escalon(E lado:numero;ES cantF:numero;ES cantE:numero)
  comenzar
    repetir lado
      juntarFlores(cantF)
      mover
      cantE:=cantE + 1
    juntarFlores(cantF)
    cantE:=cantE + 1
    derecha
    repetir lado
      juntarFlores(cantF)
      mover
      cantE:=cantE + 1
    juntarFlores(cantF)
    cantE:=cantE + 1
  fin
  proceso cuadrado(E lados:numero;ES cantF:numero;ES cantE:numero)
  comenzar
    repetir 2
      escalon(lados,cantF,cantE)
      derecha
  fin
  proceso depositarEsq(E cantF:numero)
  variables
    avAct,caAct:numero
  comenzar
    caAct:=PosCa
    avAct:=PosAv
    repetir cantF
      BloquearEsquina(50,50)
      Pos(50,50)
      depositarFlor
      Pos(avAct,caAct)
      LiberarEsquina(50,50)
  fin
  proceso cuadrados(ES cantF:numero;ES cantEsq:numero)
  variables
    valorAle:numero
    caAct:numero
    avAct:numero
  comenzar
    repetir 3
      Random(valorAle,1,4)
      cuadrado(valorAle,cantF,cantEsq)
      depositarEsq(cantF)
      cantF:=0
      avAct:=PosAv
      caAct:=PosCa
      Pos(avAct,caAct+valorAle+1)
  fin
  proceso identificar(E id:numero;ES cantE:numero)
  comenzar
    si(id=1)
      RecibirMensaje(cantE,r1)
    sino
      si(id=2)
        RecibirMensaje(cantE,r2)
      sino
        si(id=3)
          RecibirMensaje(cantE,r3)
  fin
  proceso maximo(E id:numero; E can:numero ;ES idMax:numero;ES max:numero)
  comenzar
    si(can>max)
      max:=can
      idMax:=id
  fin
areas
  areaR1: AreaP(1, 1, 5, 16)
  areaR2: AreaP(7, 1, 11, 16)
  areaR3: AreaP(14,1,18,16)
  areaCoordi: AreaP(51,51,51,51)
  areaDep: AreaPC(50, 50, 50, 50)
robots
  robot recolector
  variables
    id, cantF:numero
    cantidadEsqui:numero
  comenzar
    cantF:=0
    cantidadEsqui:=0
    RecibirMensaje(id,coordi)
    cuadrados(cantF,cantidadEsqui)
    EnviarMensaje(id,coordi)
    EnviarMensaje(cantidadEsqui,coordi)
  fin
  robot coordinador
  variables
    id,cantE,maxRobot,max:numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    max:=-1
    repetir 3
      RecibirMensaje(id,*)
      identificar(id,cantE)
      maximo(id,cantE,maxRobot,max)
    Informar('EsteEsElGanador',maxRobot)
  fin
variables
  r1,r2,r3:recolector
  coordi:coordinador
comenzar
  AsignarArea(r1, areaR1)
  AsignarArea(r1, areaDep)
  AsignarArea(r2, areaR2)
  AsignarArea(r2, areaDep)
  AsignarArea(r3, areaR3)
  AsignarArea(r3, areaDep)
  AsignarArea(coordi, areaCoordi)
  Iniciar(r1, 1, 1)
  Iniciar(r2, 7, 1)
  Iniciar(r3, 14, 1)
  Iniciar(coordi,51,51)
fin