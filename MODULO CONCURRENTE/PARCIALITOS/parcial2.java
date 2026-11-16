programa parcialTurnoP
procesos
  proceso juntarPapeles(ES cantP: numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      cantP := cantP + 1
  fin
  proceso recorrerTramo(E cantEsq: numero; ES cantP: numero)
  comenzar
    repetir cantEsq-1
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP) 
  fin
  proceso depositarPapeles(E cantP: numero)
  variables
    avAnt, caAnt: numero
  comenzar
    avAnt := PosAv
    caAnt := PosCa
    repetir cantP
      BloquearEsquina(3,20)
      Pos(3,20)
      depositarPapel
      Pos(avAnt, caAnt)
      LiberarEsquina(3,20)
  fin
  proceso limpiarDeposito(E avIni: numero; E caIni: numero)
  comenzar
    Pos(3, 20)
    mientras (HayPapelEnLaEsquina)
      tomarPapel
    Pos(avIni,caIni)
  fin
  proceso minimo(E id:numero; E cantP:numero; ES idMin:numero; ES min:numero)
  comenzar
    si (cantP < min)
      min := cantP
      idMin := id
  fin
  proceso identificadores(E id:numero;ES cantP:numero)
  comenzar
    si(id=1)
      RecibirMensaje(cantP,r1)
    sino
      si(id=2)
        RecibirMensaje(cantP,r2)
      sino
        RecibirMensaje(cantP,r3)
  fin
areas
  areaR1: AreaP(1, 2, 20, 2)
  areaR2: AreaP(21, 2, 41, 2)
  areaR3: AreaP(42, 2, 63, 2)
  areaJefe: AreaP(2, 1, 2, 1)
  areaDep: AreaPC(3, 20, 3, 20)
robots
  robot recolector
  variables
    id, cantP: numero
    puede: boolean
    avIni, caIni: numero
  comenzar
    avIni := PosAv
    caIni := PosCa
    cantP := 0
    derecha
    RecibirMensaje(id, jefe)  
    si (id=1)
      recorrerTramo(20, cantP)
      EnviarMensaje(V, r2)
    sino
      si (id=2)
        RecibirMensaje(puede, r1)
        recorrerTramo(21, cantP)
        EnviarMensaje(V, r3)
      sino
        si (id=3)
          RecibirMensaje(puede, r2)
          recorrerTramo(22, cantP)
    EnviarMensaje(id, jefe)
    EnviarMensaje(cantP, jefe)
    depositarPapeles(cantP)
    RecibirMensaje(puede, jefe)
    si (puede)
      limpiarDeposito(avIni, caIni)
  fin
  robot Jefe
  variables
    id, cantP, idMin, min: numero
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    min := 9999
    repetir 3
      RecibirMensaje(id, *)
      identificadores(id,cantP)
      minimo(id, cantP, idMin, min)
    EnviarMensaje(idMin=1,r1)
    EnviarMensaje(idMin=2,r2)
    EnviarMensaje(idMin=3,r3)
  fin
variables
  r1,r2,r3:recolector
  jefe:Jefe
comenzar
  AsignarArea(r1, areaR1)
  AsignarArea(r1, areaDep)
  AsignarArea(r2, areaR2)
  AsignarArea(r2, areaDep)
  AsignarArea(r3, areaR3)
  AsignarArea(r3, areaDep)
  AsignarArea(jefe, areaJefe)
  Iniciar(r1, 1, 2)
  Iniciar(r2, 21, 2)
  Iniciar(r3, 42, 2)
  Iniciar(jefe, 2, 1)
fin