{1- Se organizó una competencia entre el equipo rojo y el equipo azul. Cada equipo consta
de dos robots, y debe realizar una tarea:
- Los robots R1 y R2 del equipo rojo debe juntar todas las flores de las avenidas 2 y 3
respectivamente
- Los robots A1 y A2 del equipo azul debe juntar todos los papeles de las calles 98 y
99 respectivamente
Al finalizar la competencia, un robot fiscalizador deberá informar el equipo que juntó más
objetos.}
programa ejemplo
procesos
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      cantP := cantP + 1
  fin
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      cantF := cantF + 1
  fin
  proceso recorrerAvenida(ES cantF:numero)
  variables
    avAct, caSig: numero
  comenzar
    repetir 96
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    avAct := PosAv
    caSig := PosCa + 1
    repetir 2
      BloquearEsquina(avAct, caSig)
      mover
      juntarFlores(cantF)
      LiberarEsquina(avAct, caSig)
      caSig := caSig + 1
    mover
    juntarFlores(cantF)
  fin
  proceso recorrerCalles(ES cantP:numero)
  variables
    caAct, avSig: numero
  comenzar
    derecha
    juntarPapeles(cantP)
    caAct := PosCa
    avSig := PosAv + 1
    repetir 2
      BloquearEsquina(avSig, caAct)
      mover
      juntarPapeles(cantP)
      LiberarEsquina(avSig, caAct)
      avSig := avSig + 1
    repetir 96
      mover
      juntarPapeles(cantP)
  fin
  proceso identificador(E id:numero; ES cantF:numero; ES cantP:numero)
  variables
    can: numero
  comenzar
    si (id=1)
      RecibirMensaje(can, r1)
      cantF := cantF + can
    sino
      si (id=2)
        RecibirMensaje(can, r2)
        cantF := cantF + can
      sino
        si (id=3)
          RecibirMensaje(can, a1)
          cantP := cantP + can
        sino
          si (id=4)
            RecibirMensaje(can, a2)
            cantP := cantP + can
  fin
  proceso maximo(E cantF:numero; E cantP:numero)
  comenzar
    si (cantF > cantP)
      Informar('ganadorEquipoRojo',1)
    sino
      Informar('ganadorEquipoAzul',2)
  fin
areas
  cruce: AreaPC(2,98,3,99)
  rPriv1A: AreaP(2,1,2,97)
  rPriv1B: AreaP(2,100,2,100)
  rPriv2A: AreaP(3,1,3,97)
  rPriv2B: AreaP(3,100,3,100)
  aPriv1A: AreaP(1,98,1,98)
  aPriv1B: AreaP(4,98,100,98)
  aPriv2A: AreaP(1,99,1,99)
  aPriv2B: AreaP(4,99,100,99)
  areaFisco: AreaP(1,1,1,1)
robots
  robot equipoRojo
  variables
    cantF, id: numero
  comenzar
    RecibirMensaje(id, jefe)
    cantF := 0
    recorrerAvenida(cantF)
    EnviarMensaje(id, jefe)
    EnviarMensaje(cantF, jefe)
  fin
  robot equipoAzul
  variables
    cantP,id:numero
  comenzar
    RecibirMensaje(id,jefe)
    cantP:=0
    recorrerCalles(cantP)
    EnviarMensaje(id,jefe)
    EnviarMensaje(cantP,jefe)
  fin
  robot fiscalizador
  variables
    id,cantF,cantP:numero
  comenzar
    cantF:=0
    cantP:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, a1)
    EnviarMensaje(4, a2)
    repetir 4
      RecibirMensaje(id, *)
      identificador(id, cantF, cantP)
    maximo(cantF, cantP)
  fin
variables
  r1, r2: equipoRojo
  a1, a2: equipoAzul
  jefe: fiscalizador
comenzar
  AsignarArea(r1, rPriv1A)
  AsignarArea(r1, cruce)
  AsignarArea(r1, rPriv1B)
  AsignarArea(r2, rPriv2A)
  AsignarArea(r2, cruce)
  AsignarArea(r2, rPriv2B)
  AsignarArea(a1, aPriv1A)
  AsignarArea(a1, cruce)
  AsignarArea(a1, aPriv1B)
  AsignarArea(a2, aPriv2A)
  AsignarArea(a2, cruce)
  AsignarArea(a2, aPriv2B)
  AsignarArea(jefe, areaFisco)
  Iniciar(jefe, 1, 1)
  Iniciar(r1, 2, 1)
  Iniciar(r2, 3, 1)
  Iniciar(a1, 1, 98)
  Iniciar(a2, 1, 99)
fin