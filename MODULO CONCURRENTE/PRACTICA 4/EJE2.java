{2. Productores y consumidores
Existen dos robots productores que recorren las avenidas 5 y 10 respectivamente, juntando
todos los papeles de su avenida. A lo largo del recorrido, cada vez que juntan 5 papeles, los
depositan en la esquina (50,50).
Además existen dos robots consumidores que intentan tomar una cantidad aleatoria de
papeles (entre 2 y 5) de la esquina (50,50) para depositarla en su esquina de origen. Si la
esquina (50,50) no posee la cantidad de papeles requerida, vuelven a su esquina de origen
sin tomar ningún papel. Si luego de 8 intentos seguidos un consumidor detecta que la
esquina (50,50) no tiene papeles suficientes para juntar, entonces asumirá que los
productores ya han completado su trabajo y por lo tanto terminará su tarea también.
Los consumidores inician en las esquinas (11,1) y (12,1) respectivamente.}
programa ejemplo
procesos
  proceso depositarPapeles(E cantP:numero)
  comenzar
    repetir cantP
      si (HayPapelEnLaBolsa)
        depositarPapel
  fin
  proceso procesarEsquina(ES cantP:numero; E avActual:numero; E caActual:numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      cantP := cantP + 1
      si (cantP = 5)
        BloquearEsquina(50,50)
        Pos(50,50)
        depositarPapeles(cantP)
        cantP := 0
        Pos(avActual, caActual)
        LiberarEsquina(50,50)
  fin
  proceso intentarRecoger(E valorAle:numero; ES tomados:numero; ES pudo:boolean)
  comenzar
    tomados := 0
    mientras (HayPapelEnLaEsquina) & (tomados < valorAle)
      tomarPapel
      tomados := tomados + 1
    si (tomados = valorAle)
      pudo := V
    sino
      pudo := F
      depositarPapeles(tomados)
  fin
  proceso intentosTomar(ES intentos:numero; E avIni:numero; E caIni:numero)
  variables
    valorAle: numero
    pudo: boolean
    tomados: numero
  comenzar
    Random(valorAle, 2, 5)
    BloquearEsquina(50,50)
    Pos(50,50)
    intentarRecoger(valorAle, tomados, pudo)
    Pos(avIni, caIni)
    LiberarEsquina(50,50)
    si (pudo)
      intentos := 0
      depositarPapeles(valorAle)
    sino
      intentos := intentos + 1
  fin
areas
  areaPC1: AreaPC(50,50,50,50)
  area1: AreaP(5,1,5,100)
  area2: AreaP(10,1,10,100)
  area3: AreaP(11,1,11,1)
  area4: AreaP(12,1,12,1)
robots
  robot productor
  variables
    cantP, avActual, caActual: numero
  comenzar
    cantP := 0
    avActual := PosAv
    mientras (PosCa < 100)
      caActual := PosCa
      procesarEsquina(cantP,avActual,caActual)
      mover
    caActual := PosCa
    procesarEsquina(cantP,avActual,caActual)
  fin
  robot consumidor
  variables
    caIni,avIni,intentos:numero
  comenzar
    caIni := PosCa
    avIni := PosAv
    intentos := 0
    mientras (intentos<8)
      intentosTomar(intentos,avIni,caIni)
  fin
variables
  r1, r2: productor
  r3, r4: consumidor
comenzar
  AsignarArea(r1, area1)
  AsignarArea(r1, areaPC1)
  AsignarArea(r2, area2)
  AsignarArea(r2, areaPC1)  
  AsignarArea(r3, area3)
  AsignarArea(r3, areaPC1)
  AsignarArea(r4, area4)
  AsignarArea(r4, areaPC1)
  Iniciar(r1, 5, 1)
  Iniciar(r2, 10, 1)
  Iniciar(r3, 11, 1)
  Iniciar(r4, 12, 1)
fin