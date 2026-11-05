{4- Realice un programa en el que 4 robots mueven de a una todas las flores de la esquina
(10,10) a la esquina (11,11). Para ello, cada robot que toma una flor de la esquina (10,10) la
deposita en la esquina (11,11) y luego retorna a su esquina inicial. Cada robot que finaliza
(o, sea, que detecta que la esquina (10,10) se ha vaciado) deberá avisar al robot
coordinador que ha finalizado. Cuando todos los robots finalizaron, el robot coordinador
deberá informar qué robot finalizó último y a continuación deberá recolectar todas las flores
de la esquina (11,11).
El robot coordinador inicia en la esquina (1,1).
Los robots inician en las esquinas (9,9) (9,10) (9,11) y (9,12).
b- Implemente una variante en la cual los robots luego de tomar cada flor de la esquina
(10,10) vuelvan a su esquina inicial, pasen a la esquina (11,11) a depositarla y finalmente
vuelvan a la esquina inicial.
c- Analice:
- ¿Cuál de las 2 soluciones maximiza la concurrencia?
- ¿Se podría resolver este problema sin que los robots deban regresar a su esquina
inicial?
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
areas
  areaPC: AreaPC(10,10,11,11)
  area1: AreaP(9,9,9,9)
  area2: AreaP(9,10,9,10)
  area3: AreaP(9,11,9,11)
  area4: AreaP(9,12,9,12)
  areaJefe: AreaP(1,1,1,1)
robots
  robot recolector
  variables
    id, avIni, caIni: numero
    termino: boolean
  comenzar
    RecibirMensaje(id,jefe)
    avIni := PosAv
    caIni := PosCa
    termino := F
    mientras(~termino)
      BloquearEsquina(10,10)
      Pos(10,10)
      si(HayFlorEnLaEsquina)
        tomarFlor
        Pos(avIni,caIni) 
        LiberarEsquina(10,10)
        BloquearEsquina(11,11)
        Pos(11,11)
        depositarFlor
        Pos(avIni,caIni)
        LiberarEsquina(11,11)
      sino
        termino:=V
        Pos(avIni,caIni)
        LiberarEsquina(10,10)
    EnviarMensaje(id, jefe)
  fin
  robot Jefe
  variables
    idUltimo: numero
    id: numero
    cantF: numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    EnviarMensaje(4,r4)
    repetir 4
      RecibirMensaje(id,*)
      idUltimo:=id
    Informar(idUltimo)  
    cantF := 0
    BloquearEsquina(11,11)
    Pos(11,11)
    juntarFlores(cantF)
    Pos(1,1)
    LiberarEsquina(11,11)
    Informar(cantF)
  fin
variables
  r1,r2,r3,r4: recolector
  jefe: Jefe
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
  Iniciar(r1,9,9)
  Iniciar(r2,9,10)
  Iniciar(r3,9,11)
  Iniciar(r4,9,12)
  Iniciar(jefe,1,1)
fin