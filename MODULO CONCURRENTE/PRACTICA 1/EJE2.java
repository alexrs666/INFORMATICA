{2) Realice un programa en el que 4 robots limpien de papeles el perímetro de un cuadrado de lado 20
en sentido horario, como se muestra en la figura:

El vértice inferior izquierdo del cuadrado se ubica en la esquina (10,10).
Al finalizar, cada robot debe informar la cantidad de papeles juntados en su lado.
Al realizar este programa, analizar:
a) ¿Cómo deben declararse la o las áreas?
b) ¿Existe riesgo de colisión?}

programa ejemplo
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  proceso juntarPapeles(ES cantPapeles:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantPapeles:=cantPapeles + 1
  fin  
  proceso recorrer(ES cantP: numero)
  comenzar
    repetir 19
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP)
  fin
areas
  ciudad: AreaP(10,10,10,29)
  ciudad2: AreaP(10,30,29,30)
  ciudad3: AreaP(30,11,30,30)
  ciudad4: AreaP(11,10,30,10)
robots
  robot robot1 
  variables
    cantP:numero
  comenzar
    cantP:=0
    recorrer(cantP)
    Informar(cantP)
  fin  
  robot robot2
  variables
    cantP:numero
  comenzar
    cantP:=0
    derecha
    recorrer(cantP)
    Informar(cantP)
  fin
  robot robot3
  variables
    cantP:numero
  comenzar
    cantP:=0
    repetir 2
      derecha
    recorrer(cantP)
    Informar(cantP)
  fin
  robot robot4
  variables
    cantP:numero
  comenzar
    cantP:=0
    izquierda
    recorrer(cantP)
    Informar(cantP)
  fin
variables
  R1: robot1
  R2: robot2
  R3: robot3
  R4: robot4
comenzar
  AsignarArea(R1, ciudad)
  AsignarArea(R2, ciudad2)
  AsignarArea(R3, ciudad3)
  AsignarArea(R4, ciudad4)
  Iniciar(R1, 10,10)
  Iniciar(R2, 10,30)
  Iniciar(R3, 30,30)
  Iniciar(R4, 30,10)

fin