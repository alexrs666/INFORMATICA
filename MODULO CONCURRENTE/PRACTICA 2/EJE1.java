{Objetivo:
Realizar programas en R-info con distintos tipos de robots. Utilizar el pasaje de mensajes para
la comunicación entre robots. Usar la función random para generar valores aleatorios.
1. Dos robots compiten para ver cuál junta más flores. El primer robot recoge todas las
flores de la avenida 1 entre las calles 1 y 10. El segundo robot recoge todas las flores
de la avenida 2, entre las calles 11 y 20.
Al finalizar el recorrido, el robot que recogió mayor cantidad de flores debe informar la
diferencia de flores que obtuvo respecto al robot perdedor (el que obtuvo menos flores).
Los robots inician en las esquinas (1, 1) y (2, 11) respectivamente.
b. Modifique el ejercicio anterior, considerando que ahora habrá un robot fiscalizador,
que será responsable de informar la diferencia de flores que obtuvo el ganador con
respecto al perdedor. El robot fiscalizador se ubica en la esquina (2,1)
c. Modifique el ejercicio anterior para que ahora participen 6 robots
○ Robot 1: Avenida 1, entre las calles 1 y 10
○ Robot 2: Avenida 2, entre las calles 11 y 20
○ Robot 3: Avenida 3, entre las calles 21 y 30
○ Robot 4: Avenida 4, entre las calles 31 y 40
○ Robot 5: Avenida 5, entre las calles 41 y 50
○ Robot 6: Avenida 6, entre las calles 51 y 60
○ Fiscalizador: Avenida 2, calle 1
El fiscalizador deberá informar la cantidad de flores que juntó el robot que juntó la
mayor cantidad de flores.
d. Modifique el inciso anterior para que ahora el fiscalizador informe también, cuál fue el
robot que juntó la mayor cantidad de flores.
e. Analizar (no es necesario implementar): ¿cómo se puede implementar el inciso 1.c.
sin robot fiscalizador?
→ ¿qué cantidad de robots participarán del juego?
→ ¿qué cantidad de mensajes deben enviarse?
}
programa ejercicio
procesos
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso recorrer(ES cantF:numero)
  comenzar
    repetir 9
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
  fin
  proceso actualizarMax(E cantF:numero; E id:numero; ES Max:numero; ES maxRobot:numero)
  comenzar
    Max:=cantF
    maxRobot:=id
  fin
areas
  area1: AreaP (1, 1, 1, 10)
  area2: AreaP (2, 11, 2, 20)
  area3: AreaP (3, 21, 3, 30)
  area4: AreaP (4, 31, 4, 40)
  area5: AreaP (5, 41, 5, 50)
  area6: AreaP (6, 51, 6, 60)
  area7: AreaP (2, 1, 2, 1)
robots
  robot tipo1
  variables
    cantF: numero
    nroIde: numero
  comenzar
    RecibirMensaje(nroIde, r7)
    cantF:=0
    recorrer(cantF)
    EnviarMensaje(nroIde, r7)
    EnviarMensaje(cantF, r7)
  fin
  robot tipo2
  variables
    Max: numero
    maxRobot: numero
    cantF: numero
    nroIde: numero
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
    EnviarMensaje(5, r5)
    EnviarMensaje(6, r6)
    Max := -1
    repetir 6
      RecibirMensaje(nroIde, *)
      si (nroIde = 1)
        RecibirMensaje(cantF, r1)
      sino
        si(nroIde = 2)
          RecibirMensaje(cantF, r2)
        sino 
          si(nroIde = 3)
            RecibirMensaje(cantF, r3)
          sino
            si(nroIde = 4)
              RecibirMensaje(cantF, r4)
            sino
              si(nroIde = 5)
                RecibirMensaje(cantF, r5)
              sino
                si(nroIde = 6)
                  RecibirMensaje(cantF, r6) 
      si(cantF>Max)
        actualizarMax(cantF,nroIde,Max,maxRobot)
    Informar(maxRobot)
    Informar(Max)
  fin
variables
  r1,r2,r3,r4,r5,r6: tipo1
  r7: tipo2
comenzar
  AsignarArea(r1, area1)
  AsignarArea(r2, area2)
  AsignarArea(r3, area3)
  AsignarArea(r4, area4)
  AsignarArea(r5, area5)
  AsignarArea(r6, area6)
  AsignarArea(r7, area7)
  Iniciar(r1, 1, 1)
  Iniciar(r2, 2, 11)
  Iniciar(r3, 3, 21)
  Iniciar(r4, 4, 31)
  Iniciar(r5, 5, 41)
  Iniciar(r6, 6, 51)
  Iniciar(r7, 2, 1)
fin