{2- Realice un programa en el cual 2 robots corren una carrera. El recorrido realizado por
cada uno es el que se muestra en la siguiente figura. Durante el recorrido el robot 1 debe
juntar todas las flores que encuentre en los vértices de cada escalón, y el robot 2 debe
juntar todos los papeles que encuentre en los vértices de cada escalón. Al finalizar deben
informar la cantidad de elementos recogidos.
El robot 1 debe iniciar su recorrido en la esquina (1,1) y el robot 2 en la esquina (31,1).
Al finalizar la carrera, un robot jefe (inicializado en la esquina (16,1) ) debe informar qué
robot llegó primero a la esquina central de su recorrido.}
programa ejemplo
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  proceso tomarYsumarFlor(ES cantF:numero)
  comenzar
    tomarFlor
    cantF:=cantF + 1
  fin
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarYsumarFlor(cantF)
  fin
  proceso tomarYsumarPapel(ES cantP:numero)
  comenzar
    tomarPapel
    cantP:=cantP + 1
  fin
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarYsumarPapel(cantP)
  fin
  proceso escalon(E altura:numero;E ancho:numero;ES cantF:numero)
  comenzar
    repetir altura
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    derecha
    repetir ancho
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    izquierda
  fin
  proceso escalonIn(E altura:numero;E ancho:numero;ES cantP:numero)
  comenzar
    repetir altura
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP)
    izquierda
    repetir ancho
      juntarPapeles(cantP)
      mover
    juntarPapeles(cantP)
    derecha
  fin
  proceso escalones(ES cantF:numero)
  variables
    tam:numero
  comenzar
    tam:=5
    repetir 4
      escalon(tam,tam,cantF)
      tam:=tam - 1 
  fin
  proceso ultimoEscalonF(ES cantF:numero;E id:numero)
  comenzar
    juntarFlores(cantF)
    mover
    juntarFlores(cantF)
    derecha
    BloquearEsquina(16,16)
    mover
    juntarFlores(cantF)
    EnviarMensaje(id,r3)
    repetir 2
      derecha
    mover
    LiberarEsquina(16,16)
  fin
  proceso escalonesF(ES cantF:numero)
  variables
    tam:numero
  comenzar
    tam:=2
    repetir 4
      escalon(tam,tam,cantF)
      tam:=tam + 1
  fin
  proceso escalonesInvertidos(ES cantP:numero)
  variables
    tam:numero
  comenzar
    tam:=5
    repetir 4
      escalonIn(tam,tam,cantP)
      tam:=tam - 1
  fin
  proceso ultimoEscalonP(ES cantP:numero;E id:numero)
  comenzar
    juntarPapeles(cantP)
    mover
    juntarPapeles(cantP)
    izquierda
    BloquearEsquina(16,16)
    mover
    juntarPapeles(cantP)
    EnviarMensaje(id,r3)
    repetir 2
      derecha
    mover
    LiberarEsquina(16,16)
  fin
  proceso escalonesP(ES cantP:numero)
  variables
    tam:numero
  comenzar
    tam:=2
    repetir 4
      escalonIn(tam,tam,cantP)
      tam:=tam + 1
  fin
areas
  areaC: AreaC(1,1,100,100)
robots
  robot robot1
  variables
    cantF:numero
    id:numero
  comenzar
    RecibirMensaje(id,r3)
    cantF:=0
    escalones(cantF)
    ultimoEscalonF(cantF,id)
    escalonesF(cantF)
    Informar(cantF)
  fin
  robot robot2
  variables
    cantP:numero
    id:numero
  comenzar
    RecibirMensaje(id,r3)
    cantP:=0
    escalonesInvertidos(cantP)
    ultimoEscalonP(cantP,id)
    escalonesP(cantP)
    Informar(cantP)
  fin
  robot jefe
  variables
    id:numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    RecibirMensaje(id,*)
    Informar(id)
  fin
variables
  r1:robot1
  r2:robot2
  r3:jefe
comenzar
  AsignarArea(r1,areaC)
  AsignarArea(r2,areaC)
  AsignarArea(r3,areaC)
  Iniciar(r1,1,1)
  Iniciar(r2,31,1)
  Iniciar(r3,16,1)
fin