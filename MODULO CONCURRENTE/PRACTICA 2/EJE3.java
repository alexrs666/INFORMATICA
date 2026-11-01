{3. Realice un programa con 2 equipos.
- El equipo A, compuesto por los robots A1 y A2, debe juntar papeles de las
primeras 20 esquinas de la calle 5
- El equipo B, compuesto por los robots B1 y B2, debe juntar papeles de las
primeras 20 esquinas de la calle 7
Además existe un robot Fiscalizador que envía las identificaciones necesarias.
Los robots A1 y B1 deberán realizar las 10 primeras esquinas de su recorrido, y al
finalizar avisarán a los robots A2 y B2 respectivamente para que continúen con las
siguientes 10 esquinas. Al finalizar el Fiscalizador debe informar qué equipo fue el
ganador.
Inicialice los robots en las esquinas que considere más apropiadas según el trayecto
que le corresponde realizar a cada uno. El Fiscalizador inicia en la esquina (1,1).
b. Modifique el programa anterior para que cada equipo repita el recorrido con las
siguientes 20 esquinas de sus correspondientes calles.
c. Analice (no es necesario implementar) cómo implementaría el inciso b si ahora cada
equipo debe realizar 8 segmentos de 20 esquinas
}
programa ejercicio
procesos
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:=cantP + 1
  fin
  proceso recorrer(ES cantP:numero)
  comenzar
    derecha
    repetir 9
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP)
  fin 
  proceso ganador(E sumaEquipoA:numero;E sumaEquipoB:numero;ES gana:numero)
  comenzar
    si(sumaEquipoA>sumaEquipoB)
      gana:=1
    sino
      gana:=2
  fin
areas
  area1: AreaP(1,5,10,5)
  area2: AreaP(11,5,20,5)
  area3: AreaP(1,7,10,7)
  area4: AreaP(11,7,20,7)
  area5: AreaP(1,1,1,1)
robots
  robot equipoA1
  variables
    cantP:numero
    id:numero
  comenzar
    RecibirMensaje(id,fisco)
    cantP:=0
    recorrer(cantP)
    EnviarMensaje(cantP,A2)
  fin
  robot equipoA2
  variables
    cantP:numero
    cantA1:numero
    sumaEA:numero
    id:numero
  comenzar
    RecibirMensaje(id,fisco)
    RecibirMensaje(cantA1,A1)
    cantP:=0
    sumaEA:=0
    recorrer(cantP)
    sumaEA:=cantA1 + cantP
    EnviarMensaje(sumaEA,fisco)
  fin
  robot equipoB1
  variables
    cantP:numero
    id:numero
  comenzar
    RecibirMensaje(id,fisco)
    cantP:=0
    recorrer(cantP)
    EnviarMensaje(cantP,B2)
  fin
  robot equipoB2
  variables
    cantP:numero
    cantB1:numero
    sumaEB:numero
    id:numero
  comenzar
    RecibirMensaje(id,fisco)
    RecibirMensaje(cantB1,B1)
    cantP:=0
    sumaEB:=0
    recorrer(cantP)
    sumaEB:=cantB1 + cantP
    EnviarMensaje(sumaEB,fisco)
  fin
  robot fiscalizador
  variables
    sumaEquipoA,sumaEquipoB:numero
    gana:numero
  comenzar
    EnviarMensaje(1,A1)
    EnviarMensaje(2,A2)
    EnviarMensaje(3,B1)
    EnviarMensaje(4,B2)
    RecibirMensaje(sumaEquipoA,A2)
    RecibirMensaje(sumaEquipoB,B2)
    ganador(sumaEquipoA,sumaEquipoB,gana)
    Informar(gana)
  fin
variables
  A1:equipoA1
  A2:equipoA2
  B1:equipoB1
  B2:equipoB2
  fisco:fiscalizador
comenzar
  AsignarArea(A1, area1)
  AsignarArea(A2, area2)
  AsignarArea(B1, area3)
  AsignarArea(B2, area4)
  AsignarArea(fisco,area5)
  Iniciar(A1, 1, 5)
  Iniciar(A2, 11, 5)
  Iniciar(B1, 1, 7)
  Iniciar(B2, 11, 7)
  Iniciar(fisco, 1, 1)
fin