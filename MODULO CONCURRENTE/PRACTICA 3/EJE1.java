{1- Realice un programa con 2 robots recolectores de flores (floreros) y 2 robots recolectores
de papeles (papeleros).
Los floreros comparten área y tienen 5 intentos cada uno para juntar las flores de una
esquina, dentro de dicha área, elegida al azar en cada intento. Del mismo modo, los
papeleros comparten área y tienen 3 intentos cada uno para juntar los papeles. En cada
intento cada robot va a la esquina al azar, junta todos los elementos (flores o papeles según
le corresponda) y vuelve a su esquina original. Al finalizar sus intentos cada robot debe
acceder a la esquina (10, 10) y depositar los elementos recogidos de a uno.
- Área de floreros: (1,1) a (5, 10)
- Área de papeleros: (6, 1) a (10, 9)
- Esquinas de inicio de floreros: (6,10) y (7,10)
- Esquinas de inicio de papeleros: (8,10) y (9,10)}
programa ejemplo
procesos
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
  proceso depositarFlores(E cantF:numero; E avIni:numero; E caIni:numero)
  comenzar
    repetir cantF
      BloquearEsquina(10, 10)
      Pos(10, 10)
      depositarFlor
      Pos(avIni, caIni)
      LiberarEsquina(10, 10)
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
  proceso depositarPapeles(E cantP:numero; E avIni:numero; E caIni:numero)
  comenzar
    repetir cantP
      BloquearEsquina(10, 10)
      Pos(10, 10)
      depositarPapel
      Pos(avIni, caIni)
      LiberarEsquina(10, 10)
  fin
  proceso intentosFlores(ES cantF:numero)
  variables
    avAle,calleAle: numero
    avIni,caIni: numero
  comenzar
    avIni:=PosAv
    caIni:=PosCa
    repetir 5
      Random(avAle,1,5)
      Random(calleAle,1,10)
      BloquearEsquina(avAle,calleAle)
      Pos(avAle,calleAle)
      juntarFlores(cantF)
      Pos(avIni,caIni)
      LiberarEsquina(avAle,calleAle)
  fin
  proceso intentosPapeles(ES cantP:numero)
  variables
    avAle,calleAle:numero
    avIni,caIni:numero
  comenzar
    avIni:=PosAv
    caIni:=PosCa
    repetir 3
      Random(avAle,6,10)
      Random(calleAle,1,9)
      BloquearEsquina(avAle,calleAle)
      Pos(avAle,calleAle)
      juntarPapeles(cantP)
      Pos(avIni,caIni)
      LiberarEsquina(avAle,calleAle)
  fin
areas
  areaF: AreaPC(1,1,5,10)
  areaP: AreaPC(6,1,10,9)
  areaDep: AreaC(10,10,10,10)
  areaF1: AreaP(6,10,6,10)
  areaF2: AreaP(7,10,7,10)
  areaP1: AreaP(8,10,8,10)
  areaP2: AreaP(9,10,9,10)
robots
  robot Floreros
  variables
    cantF, avIni, caIni: numero
  comenzar
    avIni:=PosAv
    caIni:=PosCa
    cantF:=0
    intentosFlores(cantF)
    depositarFlores(cantF,avIni,caIni)
  fin
  robot Papeleros
  variables
    cantP,avIni,caIni: numero
  comenzar
    avIni:=PosAv
    caIni:=PosCa
    cantP:=0
    intentosPapeles(cantP)
    depositarPapeles(cantP,avIni,caIni)
  fin
variables
  r1,r2: Floreros
  r3,r4: Papeleros
comenzar
  AsignarArea(r1, areaF1)
  AsignarArea(r1, areaF)
  AsignarArea(r1, areaDep)
  AsignarArea(r2, areaF2)
  AsignarArea(r2, areaF)
  AsignarArea(r2, areaDep)
  AsignarArea(r3, areaP1)
  AsignarArea(r3, areaP)
  AsignarArea(r3, areaDep)
  AsignarArea(r4, areaP2)
  AsignarArea(r4, areaP)
  AsignarArea(r4, areaDep)
  Iniciar(r1,6,10)
  Iniciar(r2,7,10)
  Iniciar(r3,8,10)
  Iniciar(r4,9,10)
fin