{5) Realice un programa en el que cuatro robots realizan las siguientes actividades:
● El robot 1 debe limpiar de flores las primeras 15 esquinas de las calles 75 y 80. Al finalizar
cada calle, debe depositar todas las flores en la última esquina.
● El robot 2 debe limpiar de papeles las últimas 20 esquinas de las avenidas 75 y 80. Al
finalizar cada avenida debe depositar todos los papeles en la primera esquina.
● El robot 3 debe limpiar de flores las últimas 15 esquinas de las calles 10 y 15. Al finalizar
cada calle, debe depositar todas las flores en la última esquina.
● El robot 4 debe limpiar de papeles las primeras 20 esquinas de las avenidas 10 y 15. Al
finalizar cada avenida debe depositar todos los papeles en la primera esquina.}
programa ejemplo
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:=cantP + 1
  fin
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso depositarPapeles(E cantP:numero)
  comenzar
    repetir cantP
      depositarPapel
  fin
  proceso depositarFlores(E cantF:numero)
  comenzar
    repetir cantF
      depositarFlor
  fin
  proceso limpiarEsquinas(ES cantF:numero)
  comenzar
    derecha
    repetir 14
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
  fin
  proceso limpiarEsquinas2(ES cantP:numero)
  comenzar
    repetir 19
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP)
  fin
  proceso limpiarCalles(E nroCalle:numero;E nroAve:numero)
  variables 
    cantF:numero
  comenzar
    cantF:=0
    Pos(nroAve,nroCalle)
    limpiarEsquinas(cantF)
    depositarFlores(cantF)
    izquierda
  fin
  proceso limpiarAvenida(E nroAve:numero;E nroCalle:numero)
  variables
    cantP:numero
  comenzar
    cantP:=0
    Pos(nroAve,nroCalle)
    limpiarEsquinas2(cantP)
    Pos(nroAve,nroCalle)
    depositarPapeles(cantP)
  fin
areas
  area1: AreaP (1, 75, 15, 80)
  area2: AreaP (75, 81,80, 100)
  area3: AreaP (86,10,100,15)
  area4: AreaP (10,1,15,20)
robots
  robot robot1
  comenzar
    limpiarCalles(75,1)
    limpiarCalles(80,1)
  fin
  robot robot2
  comenzar
    limpiarAvenida(75,81)
    limpiarAvenida(80,81)
  fin
  robot robot3
  comenzar
    limpiarCalles(10,86)
    limpiarCalles(15,86)
  fin
  robot robot4
  comenzar
    limpiarAvenida(10,1)
    limpiarAvenida(15,1)
  fin
variables
  r1: robot1
  r2: robot2
  r3: robot3
  r4: robot4
comenzar
  AsignarArea(r1, area1)
  AsignarArea(r2, area2)
  AsignarArea(r3, area3)
  AsignarArea(r4, area4)
  Iniciar(r1,1,75)
  Iniciar(r2,75,81)
  Iniciar(r3,86,10)
  Iniciar(r4,10,1)
fin