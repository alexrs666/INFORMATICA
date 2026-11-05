{3- Realice un programa donde 4 robots colaboren para recoger todas las flores de una
esquina indicada por un robot jefe, seleccionada de manera aleatoria dentro del cuadrante
(2,2) y (10,10). Para ello el jefe determina inicialmente una esquina y los robots deben
accederla, tomar de a una las flores y volver a su posición inicial. Cuando los robots
terminan el jefe deberá informar cuál de ellos logró recoger más flores.
Las esquinas de inicio de los robots deberán ser jefe (1,1) y robots (2,1), (3, 1), (4,1) y (5,1).
}
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
  proceso recolectarFlores(ES cantF:numero)
  variables
    avAle,caAle:numero
    ok:boolean
  comenzar
    RecibirMensaje(ok,jefe)
    si(ok)
      RecibirMensaje(avAle,jefe)
      RecibirMensaje(caAle,jefe)
      BloquearEsquina(avAle,caAle)
      Pos(avAle,caAle)
      juntarFlores(cantF)
      Pos(PosAv,PosCa)
      LiberarEsquina(avAle,caAle)
      EnviarMensaje(V,jefe)
  fin
  proceso reconomientoYacceso(E id:numero;E avA:numero;E caA:numero)
  variables
    listo:boolean
  comenzar
    si(id=1)
      EnviarMensaje(V,r1)
      EnviarMensaje(avA,r1)
      EnviarMensaje(caA,r1)
      RecibirMensaje(listo,r1)
    sino
      si(id=2)
        EnviarMensaje(V,r2)
        EnviarMensaje(avA,r2)
        EnviarMensaje(caA,r2)
        RecibirMensaje(listo,r2)
      sino
        si(id=3)
          EnviarMensaje(V,r3)
          EnviarMensaje(avA,r3)
          EnviarMensaje(caA,r3)
          RecibirMensaje(listo,r3)
        sino
          si(id=4)
            EnviarMensaje(V,r4)
            EnviarMensaje(avA,r4)
            EnviarMensaje(caA,r4)
            RecibirMensaje(listo,r4)
  fin
  proceso posicionAleatoria
  variables
    avAle,caAle:numero
    id:numero
  comenzar
    Random(avAle,2,10)
    Random(caAle,2,10)
    reconomientoYacceso(1,avAle,caAle)
    reconomientoYacceso(2,avAle,caAle)
    reconomientoYacceso(3,avAle,caAle)
    reconomientoYacceso(4,avAle,caAle)
  fin
  proceso identificar(ES id:numero;ES cantF:numero)
  comenzar
    si(id=1)
      RecibirMensaje(cantF,r1)
    sino
      si(id=2)
        RecibirMensaje(cantF,r2)
      sino
        si(id=3)
          RecibirMensaje(cantF,r3)
        sino
          si(id=4)
            RecibirMensaje(cantF,r4)
  fin
  proceso calcularMaximo(E id:numero;E cantF:numero;ES m:numero;ES idG:numero)
  comenzar
    si(cantF>m)
      m:=cantF
      idG:=id
  fin
areas
  areaPC: AreaPC(2,2,10,10)
  area1: AreaP(2,1,2,1)
  area2: AreaP(3,1,3,1)
  area3: AreaP(4,1,4,1)
  area4: AreaP(5,1,5,1)
  areaJefe: AreaP(1,1,1,1)
robots
  robot recolectores
  variables
    cantF:numero
    id:numero
    avIni,caIni:numero
  comenzar
    RecibirMensaje(id,jefe)
    avIni:=PosAv
    caIni:=PosCa
    cantF:=0
    recolectarFlores(cantF)
    EnviarMensaje(id,jefe)
    EnviarMensaje(cantF,jefe)
    Pos(avIni,caIni)
  fin
  robot Jefe
  variables
    idGanador:numero
    id:numero
    cantF:numero
    max:numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    EnviarMensaje(4,r4)
    posicionAleatoria
    max:=-1
    repetir 4
      RecibirMensaje(id,*)
      identificar(id,cantF)
      calcularMaximo(id,cantF,max,idGanador)
    Informar(idGanador)
  fin
variables
  r1,r2,r3,r4:recolectores
  jefe:Jefe
comenzar
  AsignarArea(r1,areaPC)
  AsignarArea(r1,area1)
  AsignarArea(r2,areaPC)
  AsignarArea(r2,area2)
  AsignarArea(r3,areaPC)
  AsignarArea(r3,area3)
  AsignarArea(r4,areaPC)
  AsignarArea(r4,area4)
  AsignarArea(jefe,areaPC)
  AsignarArea(jefe,areaJefe)
  Iniciar(r1,2,1)
  Iniciar(r2,3,1)
  Iniciar(r3,4,1)
  Iniciar(r4,5,1)
  Iniciar(jefe,1,1)
fin