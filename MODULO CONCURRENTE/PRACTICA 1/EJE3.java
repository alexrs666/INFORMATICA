{3) Realice un programa en el que 3 robots realicen escaleras de 4 escalones. El tamaño de cada
escalón se incrementa en un 1 respecto al escalón anterior. El primer escalón será de 1x1, el
segundo de 2x2, y así sucesivamente, como se muestra a continuación:
Al finalizar el recorrido, cada robot debe informar la cantidad de escalones en los que la
cantidad de papeles superó en 1 a la cantidad de flores. Las esquinas deben quedar sin
modificar.}
programa ejer3
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  proceso contarFlor(ES f:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso contarPapel(ES p:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:=p + 1
  fin
  proceso restablecerFlores(E f:numero)
  comenzar
    repetir f
      depositarFlor
  fin
  proceso restablecerPapeles(E p:numero)
  comenzar
    repetir p
      depositarPapel
  fin
  proceso contarYrestablecer(ES cantFlo:numero;ES cantPap:numero)
  variables
    f,p:numero
  comenzar
    f:=0
    p:=0
    contarFlor(f)
    contarPapel(p)
    restablecerFlores(f)
    restablecerPapeles(p)
    cantFlo:=cantFlo + f
    cantPap:=cantPap + p
  fin
  proceso escalon(E tam:numero;ES cumple:numero)
  variables
    cantF,cantP:numero
  comenzar
    cantF:=0
    cantP:=0
    repetir tam
      contarYrestablecer(cantF,cantP)
      mover
    derecha
    repetir tam
      contarYrestablecer(cantF,cantP)
      mover
    izquierda
    si(cantP=(cantF + 1))
      cumple:=cumple + 1
  fin
  proceso escalones(ES cumple:numero)
  variables
    tam:numero
  comenzar
    tam:=1
    repetir 4
      escalon(tam,cumple)
      tam:=tam + 1
  fin
areas
  c1: AreaP(2,14,10,25)
  cPC1: AreaPC(11,14,12,25)
  c2: AreaP(13,14,20,25)
  cPC2: AreaPC(21,14,21,25)
  c3: AreaP(22,14,31,25)
robots
  robot robot1
  variables
    cumple:numero
  comenzar
    cumple:=0
    escalones(cumple)
    Informar(cumple)
  fin
variables
  r1,r2,r3:robot1
comenzar
  AsignarArea(r1, c1)
  AsignarArea(r1, cPC1)
  AsignarArea(r2, cPC1)
  AsignarArea(r2, c2)
  AsignarArea(r2, cPC2)
  AsignarArea(r3, cPC2)
  AsignarArea(r3, c3)
  Iniciar(r1,2,14)
  Iniciar(r2,11,14)
  Iniciar(r3,21,14)
fin