{1) Realice un programa para que un robot junte todas las flores de la avenida 1 y las deposite al final
de dicha avenida. Al finalizar, debe informar la cantidad de flores depositadas y la cantidad de
esquinas sin flores que encontró durante el recorrido.
a) Modifique el programa anterior para que el mismo robot realice lo mismo en las avenidas 1, 3
y 5.
b) Modifique el programa anterior para que el trabajo sea realizado por 3 robots: uno realiza la
avenida 1, otro realiza la avenida 3 y otro la avenida 5. Cada robot debe iniciar en las esquina
(1,1), (3,1) y (5,1) respectivamente.}

programa ejemplo
procesos
  proceso depositarF(E cantF:numero)
  comenzar
    repetir cantF
      depositarFlor
  fin
  proceso juntarFlores(ES cantFlores:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:=cantFlores + 1
  fin
  proceso contar(ES cantF:numero;ES cantSinFlor:numero)
  comenzar
    si~(HayFlorEnLaEsquina)
      cantSinFlor:=cantSinFlor + 1
    sino
      juntarFlores(cantF)
  fin
  proceso recorrerAvenida(ES cantF: numero;ES cantSinF:numero)
  comenzar
    repetir 99
      contar(cantF,cantSinF)
      mover
    contar(cantF,cantSinF)
  fin
areas
  ciudad: AreaP(1,1,1,100)
  ciudad2: AreaP(3,1,3,100)
  ciudad3: AreaP(5,1,5,100)
robots
  robot robot1 
  variables
    cantF,cantSnF:numero
  comenzar
    cantF:=0
    cantSnF:=0
    recorrerAvenida(cantF,cantSnF)
    depositarF(cantF)
    Informar(cantF)
    Informar(cantSnF)
  fin
variables
  R1,R2,R3: robot1
comenzar
  AsignarArea(R1, ciudad)
  AsignarArea(R2, ciudad2)
  AsignarArea(R3, ciudad3)
  Iniciar(R1, 1,1)
  Iniciar(R2, 3,1)
  Iniciar(R3, 5,1)
fin