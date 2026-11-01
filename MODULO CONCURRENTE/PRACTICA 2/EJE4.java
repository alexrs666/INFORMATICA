{4. Realice un programa en el que un robot fiscalizador controla el acceso de 4 robots
recolectores al cuadrante encerrado entre las esquinas (25,25) y (75,75) . Para ello, el
robot fiscalizador avisa a un robot recolector aleatorio que puede ingresar al área. El
robot que recibe la autorización de acceso calcula una esquina aleatoria dentro del
área, limpia dicha esquina de flores y papeles, regresa a su esquina y avisa al robot
fiscalizador que ya finalizó.
Se realizarán en total 10 accesos al cuadrante entre los 4 robots recolectores. Al
finalizar, el robot fiscalizador deberá indicar al robot ganador (el que juntó más objetos
en total) que se posicione en la esquina (50,50).
El robot fiscalizador inicia en la esquina (1,1) y los robots recolectores inician en las
esquinas (25,1) (30,1) (35,1) y (40,1) respectivamente.}
programa ejercicio
procesos
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      cantF := cantF + 1
  fin
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      cantP := cantP + 1
  fin
  proceso limpiarEsquina(ES cantFyP:numero)
  comenzar
    juntarPapeles(cantFyP)
    juntarFlores(cantFyP)
  fin
  proceso acceso(E robotAle:numero)
  variables
    listo: boolean
  comenzar
    si (robotAle = 1)
      EnviarMensaje(V, r1)
      RecibirMensaje(listo, r1)
    sino
      si (robotAle = 2)
        EnviarMensaje(V, r2)
        RecibirMensaje(listo, r2)
      sino
        si (robotAle = 3)
          EnviarMensaje(V, r3)
          RecibirMensaje(listo, r3)
        sino
          si (robotAle = 4)
            EnviarMensaje(V, r4)
            RecibirMensaje(listo, r4)
  fin
  proceso avisarFin
  comenzar
    EnviarMensaje(F, r1)
    EnviarMensaje(F, r2)
    EnviarMensaje(F, r3)
    EnviarMensaje(F, r4)
  fin
  proceso actualizar(E cant:numero; E id:numero; ES max:numero; ES idG:numero)
  comenzar
    si (cant > max)
      max := cant
      idG := id
  fin
  proceso maximo(ES max:numero; ES idGano:numero)
  variables
    id: numero
    cant: numero
  comenzar
    RecibirMensaje(id, *)
    si (id = 1)
      RecibirMensaje(cant, r1)
    sino
      si (id = 2)
        RecibirMensaje(cant, r2)
      sino
        si (id = 3)
          RecibirMensaje(cant, r3)
        sino
          si (id = 4)
            RecibirMensaje(cant, r4)
    actualizar(cant, id, max, idGano)
  fin
  proceso notificarGanador(E idG:numero)
  comenzar
    si (idG=1)
      EnviarMensaje(V,r1)
    sino
      EnviarMensaje(F,r1)    
    si (idG=2)
      EnviarMensaje(V,r2)
    sino
      EnviarMensaje(F,r2)   
    si (idG=3)
      EnviarMensaje(V,r3)
    sino
      EnviarMensaje(F,r3)    
    si (idG=4)
      EnviarMensaje(V,r4)
    sino
      EnviarMensaje(F,r4)
  fin
areas
  area1: AreaPC(25, 25, 75, 75)
  area3: AreaP(1, 1, 1, 1)
  area4: AreaP(25, 1, 25, 1)
  area5: AreaP(30, 1, 30, 1)
  area6: AreaP(35, 1, 35, 1)
  area7: AreaP(40, 1, 40, 1)
robots
  robot recolector
  variables
    cantObj: numero
    id: numero
    ok, gano: boolean
    avRandom, calleRandom: numero
    avIni, calleIni: numero
  comenzar
    RecibirMensaje(id, fisco)
    avIni := PosAv
    calleIni := PosCa
    cantObj := 0
    RecibirMensaje(ok, fisco)
    mientras (ok)
      Random(avRandom, 25, 75)
      Random(calleRandom, 25, 75)
      Pos(avRandom, calleRandom)
      limpiarEsquina(cantObj)
      Pos(avIni, calleIni)
      EnviarMensaje(V, fisco)
      RecibirMensaje(ok, fisco)
    EnviarMensaje(id, fisco)
    EnviarMensaje(cantObj, fisco)
    RecibirMensaje(gano, fisco)
    si (gano)
      Pos(50, 50)
  fin
  robot fiscalizador
  variables
    id: numero
    robotAle: numero
    idGanador: numero
    max: numero
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
    repetir 10
      Random(robotAle, 1, 4)
      acceso(robotAle)
    avisarFin
    max := -1
    repetir 4
      maximo(max, idGanador)
    notificarGanador(idGanador)
    Informar(idGanador)
  fin
variables
  r1, r2, r3, r4: recolector
  fisco: fiscalizador
comenzar
  AsignarArea(r1, area4)
  AsignarArea(r1, area1)
  AsignarArea(r2, area5)
  AsignarArea(r2, area1)
  AsignarArea(r3, area6)
  AsignarArea(r3, area1)
  AsignarArea(r4, area7)
  AsignarArea(r4, area1)
  AsignarArea(fisco, area3)
  Iniciar(r1, 25, 1)
  Iniciar(r2, 30, 1)
  Iniciar(r3, 35, 1)
  Iniciar(r4, 40, 1)
  Iniciar(fisco, 1, 1)
fin