{2. Realice un programa en el que 3 robots realizan una escalera de 4 escalones cada uno.
Todos los escalones tienen un ancho fijo de 1, y un alto aleatorio entre 1 y 5. Al finalizar
el recorrido, cada robot deberá enviar al robot jefe la cantidad de escalones que tenían
más flores que papeles. Una vez que los tres robots finalizaron, el robot jefe deberá
informar la suma de las cantidades enviadas por los 3 robots.
○ El robot jefe inicia en la esquina (1,1)
○ El robot 1 inicia en la esquina (2,1)
○ El robot 2 inicia en la esquina (20,1)
○ El robot 3 inicia en la esquina (40,1
}
programa ejercicio
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:=cantP + 1
  fin
  proceso recolectar(ES cantF:numero;ES cantP:numero)
  comenzar
    juntarFlores(cantF)
    juntarPapeles(cantP)
  fin
  proceso cantidadCumple(ES cantF:numero;ES cantP:numero;ES cumple:numero)
  comenzar
    si(cantF>cantP)
      cumple:=cumple + 1
  fin
  proceso escalon(E altura:numero;ES cumple:numero)
  variables
    cantF,cantP:numero
  comenzar
    cantF:=0
    cantP:=0
    repetir altura
      recolectar(cantF,cantP)
      mover
    recolectar(cantF,cantP)
    derecha
    mover
    recolectar(cantF,cantP)
    izquierda
    cantidadCumple(cantF,cantP,cumple)
  fin
  proceso recorrerEscalones(ES cumple:numero)
  variables
    altura:numero
  comenzar
    repetir 4
      Random(altura,1,5)
      escalon(altura,cumple)
  fin
areas
  area1: AreaP(2,1,19,21)
  area2: AreaP(20,1,39,21)
  area3: AreaP(40,1,60,21)
  area4: AreaP(1,1,1,1)
robots
  robot tipo1
  variables
    cumple:numero
  comenzar
    cumple:=0
    recorrerEscalones(cumple)
    EnviarMensaje(cumple,r4)
  fin
  robot jefe
  variables
    cantC:numero
    suma:numero
  comenzar
    suma:=0
    repetir 3
      RecibirMensaje(cantC,*)
      suma:=suma + cantC
    Informar('cantidad de escalones que cumplen',suma)
  fin
variables
  r1,r2,r3: tipo1
  r4: jefe
comenzar
  AsignarArea(r1, area1)
  AsignarArea(r2, area2)
  AsignarArea(r3, area3)
  AsignarArea(r4, area4)
  Iniciar(r1, 2, 1)
  Iniciar(r2, 20, 1)
  Iniciar(r3, 40, 1)
  Iniciar(r4, 1, 1)
fin