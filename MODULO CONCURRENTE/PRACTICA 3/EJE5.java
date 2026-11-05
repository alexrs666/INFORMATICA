{5- Realice un programa en el que 4 robots juegan una carrera por avenidas diferentes: 4, 6,
8 y 10 respectivamente. Todos los robots inician en la calle 1.
Para poder avanzar, cada robot debe juntar un papel de una fuente de papeles localizada
en la esquina (11,11), colocarlo en la esquina actual de su avenida y avanzar un paso.
Cuando la esquina fuente ya no tiene más papeles, o cuando se haya completado la
avenida, deberán avisar al robot coordinador y este informará quién es el robot ganador
considerando el que llegó más lejos. Si hay empate, el ganador es el del aviso que haya
llegado antes.}
programa ejemplo
procesos
  proceso identificar(ES id:numero;ES cantP:numero)
  comenzar
    si(id=1)
      RecibirMensaje(cantP,r1)
    sino
      si(id=2)
        RecibirMensaje(cantP,r2)
      sino
        si(id=3)
          RecibirMensaje(cantP,r3)
        sino
          si(id=4)
            RecibirMensaje(cantP,r4)
  fin
  proceso calcularMaximo(E id:numero;E cantP:numero;ES m:numero;ES idG:numero)
  comenzar
    si(cantP > m)
      m:=cantP
      idG:=id
  fin
  proceso darPaso(ES hayPapel:boolean;ES caActual:numero;ES cantPasos:numero;E avActual:numero)
  comenzar
    BloquearEsquina(11,11)
    Pos(11,11)
    si(HayPapelEnLaEsquina)
      tomarPapel
      Pos(avActual, caActual)
      LiberarEsquina(11,11)   
      depositarPapel
      mover
      caActual:=PosCa
      cantPasos:=cantPasos + 1
    sino
      hayPapel := F
      Pos(avActual, caActual)
      LiberarEsquina(11,11)
  fin
areas
  areaPC: AreaPC(11,11,11,11)
  area1: AreaP(4,1,4,100)
  area2: AreaP(6,1,6,100)
  area3: AreaP(8,1,8,100)
  area4: AreaP(10,1,10,100)
  areaJefe: AreaP(1,1,1,1)
robots
  robot recolector
  variables
    id, avActual, caActual: numero
    cantPasos: numero
    hayPapel: boolean
  comenzar
    RecibirMensaje(id, jefe)
    avActual:=PosAv
    caActual:=PosCa
    cantPasos:=0
    hayPapel:=V 
    mientras ((hayPapel)&(caActual<100))
      darPaso(hayPapel,caActual,cantPasos,avActual)     
    EnviarMensaje(id,jefe)
    EnviarMensaje(cantPasos,jefe)
  fin
  robot coordinador
  variables
    idGanador:numero
    id:numero
    cantP:numero
    max:numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    EnviarMensaje(4,r4)
    max:=-1  
    repetir 4
      RecibirMensaje(id, *)
      identificar(id, cantP)
      calcularMaximo(id, cantP, max, idGanador)  
    Informar(idGanador)
  fin
variables
  r1,r2,r3,r4:recolector
  jefe:coordinador
comenzar
  AsignarArea(r1,areaPC)
  AsignarArea(r1,area1)
  AsignarArea(r2,areaPC)
  AsignarArea(r2,area2)
  AsignarArea(r3,areaPC)
  AsignarArea(r3,area3)
  AsignarArea(r4,areaPC)
  AsignarArea(r4,area4)
  AsignarArea(jefe,areaPC)
  AsignarArea(jefe,areaJefe)
  Iniciar(r1,4,1)
  Iniciar(r2,6,1)
  Iniciar(r3,8,1)
  Iniciar(r4,10,1)
  Iniciar(jefe,1,1)
fin