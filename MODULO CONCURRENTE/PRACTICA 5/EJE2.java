{2- Tres robots recolectores deben avanzar por su calle vaciando las esquinas. El avance
debe realizarse en conjunto en etapas, siguiendo el modelo de sincronización barrera, en el
cual los robots deben esperar que todos terminen su tarea antes de avanzar a la siguiente
etapa. Cada etapa consiste en recorrer 10 esquinas y luego depositar todas las flores
recolectadas en la esquina (50,50). Una vez que los robots recolectores completaron toda
su calle, un robot fiscalizador deberá juntar todas las flores de la esquina (50,50) e informar
la cantidad total de flores juntadas. Los robots recolectores inician en las esquinas (1,1),
(1,2) y (1,3) respectivamente. El robot fiscalizador inicia en la esquina (1,4).
}
programa ejemplo
procesos
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso depositarFlores(E cantF:numero)
  comenzar
    repetir cantF
      si(HayFlorEnLaBolsa)
        depositarFlor
  fin
areas
  area1: AreaP(1,1,100,1)
  area2: AreaP(1,2,100,2)
  area3: AreaP(1,3,100,3)
  area4: AreaP(1,4,1,4)
  areaC: AreaPC(50,50,50,50)
robots
  robot recolectores
  variables
    cantF:numero
    id:numero
    cantPasos:numero
    avAct,caAct:numero
    listo:boolean
  comenzar
    RecibirMensaje(id,fisco)
    cantF:=0
    derecha
    mientras(PosAv<100)
      RecibirMensaje(listo,fisco)
      cantPasos:=0
      avAct:=PosAv
      caAct:=PosCa
      mientras(cantPasos<10)&(PosAv<100)
        juntarFlores(cantF)
        mover
        cantPasos:=cantPasos + 1
      juntarFlores(cantF)
      avAct:=PosAv
      caAct:=PosCa
      BloquearEsquina(50,50)
      Pos(50,50)
      depositarFlores(cantF)
      cantF:=0
      Pos(avAct,caAct)
      LiberarEsquina(50,50)
      EnviarMensaje(V,fisco)
  fin
  robot fiscalizador
  variables
    id:numero
    avAct,caAct:numero
    cantF:numero
    listo:boolean
  comenzar
    cantF:=0
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    avAct:=PosAv
    caAct:=PosCa
    repetir 10
      EnviarMensaje(V,r1)
      EnviarMensaje(V,r2)
      EnviarMensaje(V,r3)
      RecibirMensaje(listo,r1)
      RecibirMensaje(listo,r2)
      RecibirMensaje(listo,r3)
    BloquearEsquina(50,50)
    Pos(50,50)
    juntarFlores(cantF)
    Pos(avAct,caAct)
    LiberarEsquina(50,50)
    Informar(cantF)
  fin
variables
  r1,r2,r3:recolectores
  fisco:fiscalizador
comenzar
  AsignarArea(r1,area1)
  AsignarArea(r1,areaC)
  AsignarArea(r2,area2)
  AsignarArea(r2,areaC)
  AsignarArea(r3,area3)
  AsignarArea(r3,areaC)
  AsignarArea(fisco,area4)
  AsignarArea(fisco,areaC)
  Iniciar(r1,1,1)
  Iniciar(r2,1,2)
  Iniciar(r3,1,3)
  Iniciar(fisco,1,4)
fin