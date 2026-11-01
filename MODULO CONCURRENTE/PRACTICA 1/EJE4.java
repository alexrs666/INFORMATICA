{4) Realice un programa en el que dos robots se encargan de limpiar la ciudad. La ciudad se dividió
en 4 áreas: las impares (1 y 3) deben limpiarse de flores; y las pares (2 y 4) deben limpiarse de
papeles. Un robot debe encargarse de las áreas impares y otro robot de las pares. Modularice el
recorrido de cada área
- Área 1: desde la avenida 1 hasta la avenida 25
- Área 2: desde la avenida 26 hasta la avenida 50
- Área 3: desde la avenida 51 hasta la avenida 75
- Área 4: desde la avenida 76 hasta la avenida 100

a) Analizar (no es necesario implementar) qué se debería modificar si ahora se pide que la
ciudad se divida en 20 áreas:
● Área 1: Avenidas 1 a 5
● Área 2: Avenidas 6 a 10
● …
● Área 19: Avenidas 91 a 95
● Área 20: Avenidas 96 a 100}

programa ejemplo
procesos
  proceso juntarFlores
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso juntarPapeles
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso limpiarAvenidaFlores
  comenzar
    repetir 99
      juntarFlores
      mover
    juntarFlores
  fin
  proceso limpiarAvenidaPapeles
  comenzar
    repetir 99
      juntarPapeles
      mover
    juntarPapeles
  fin
  proceso recorrerAvenidaFlores(ES actual:numero)
  comenzar
    Pos(actual,1)
    limpiarAvenidaFlores
    actual:=actual + 1
  fin
  proceso recorrerAvenidaPapel(ES actual:numero)
  comenzar
    Pos(actual,1)
    limpiarAvenidaPapeles
    actual:=actual + 1
  fin
  proceso recorrerAreasF(E avIni:numero;E avFin:numero)
  variables
    cantAve,actual:numero
  comenzar
    actual:=avIni
    cantAve:=(avFin - avIni)+1
    repetir cantAve
      recorrerAvenidaFlores(actual) 
  fin
  proceso recorrerAreasP(E avIni:numero;E avFin:numero)
  variables
    cantAve,actual:numero
  comenzar
    actual:=avIni
    cantAve:=(avFin - avIni)+1
    repetir cantAve
      recorrerAvenidaPapel(actual)
  fin
areas
  area1: AreaP (1, 1, 25, 100)
  area2: AreaP (26, 1, 50, 100)
  area3: AreaP (51, 1, 75, 100)
  area4: AreaP (76, 1, 100, 100)
robots
  robot robotFlores
  comenzar
    recorrerAreasF(1,25)
    recorrerAreasF(51,75)
  fin
  robot robotPapeles
  comenzar
    recorrerAreasP(26,50)
    recorrerAreasP(76,100)
  fin 
variables
  robotF: robotFlores
  robotP: robotPapeles
comenzar
  AsignarArea(robotF, area1)
  AsignarArea(robotP, area2)
  AsignarArea(robotF, area3)
  AsignarArea(robotP, area4)
  Iniciar(robotF,1,1)
  Iniciar(robotP,26,1)
fin