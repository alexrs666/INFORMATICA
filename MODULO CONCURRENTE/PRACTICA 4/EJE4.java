{4. Jefe y trabajadores - Master/Slave
Un robot jefe asigna tareas a los trabajadores. Las tareas consisten en 1. recoger flores, 2.
recoger papeles, 3. vaciar bolsa, 4. finalizar .
Existen 2 robots trabajadores que reciben solicitudes de tareas del robot jefe. Para cada
solicitud, reciben la tarea y la esquina donde deben realizarla (salvo cuando la tarea es 4
que no deben acceder a una esquina). Luego de recibir la tarea, los robots van a la esquina
indicada, realizan la tarea y quedan a la espera de una nueva tarea.
El robot jefe inicia en la esquina (1,1) y los robots trabajadores inician en las esquinas (2,1)
y (3,1). Las tareas se asignan aleatoriamente a cualquier esquina dentro del cuadrante
comprendido entre las esquinas (2,2) y (100,100). El robot jefe envía 10 tareas aleatorias
(entre las tareas 1 y 3) a trabajadores aleatorios y termina. Al finalizar el jefe envía la tarea
4.
Analice: existe el riesgo de que el programa quede bloqueado, y que ningún robot
trabajador pueda realizar su tarea. ¿en qué caso puede suceder esto? ¿qué resulta
necesario considerar para evitar esta situación?}
programa ejemplo
procesos
  proceso juntarPapeles(ES cantP:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:=cantP + 1
  fin
  proceso juntarFlores(ES cantF:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:=cantF + 1
  fin
  proceso depositarPapeles(E cantP:numero)
  comenzar
    repetir cantP
      si(HayPapelEnLaBolsa)
        depositarPapel
  fin
  proceso depositarFlores(E cantF:numero)
  comenzar
    repetir cantF
      si(HayFlorEnLaBolsa)
        depositarFlor
  fin
  proceso vaciarBolsa(E cantP:numero; E cantF:numero)
  comenzar
    depositarPapeles(cantP)
    depositarFlores(cantF)
  fin
  proceso tareas(E nroTarea:numero; ES cantP:numero; ES cantF:numero)
  comenzar
    si(nroTarea = 1)
      juntarFlores(cantF)
    sino
      si(nroTarea = 2)
        juntarPapeles(cantP)
      sino
        si(nroTarea = 3)
          vaciarBolsa(cantP,cantF)
  fin
  proceso valoresAleatorios(E id:numero)
  variables
    ca,av,tarea:numero
    ok:boolean
  comenzar
    Random(ca,2,100)
    Random(av,2,100)
    Random(tarea,1,3)
    si(id=1)
      EnviarMensaje(tarea,r1)
      EnviarMensaje(av,r1)
      EnviarMensaje(ca,r1)
      RecibirMensaje(ok,r1)
    sino
      si(id=2)
        EnviarMensaje(tarea,r2)
        EnviarMensaje(av,r2)
        EnviarMensaje(ca,r2)
        RecibirMensaje(ok,r2)
  fin
areas
  areaC: AreaPC(2,2,100,100)
  area1: AreaP(1,1,1,1)
  area2: AreaP(2,1,2,1)
  area3: AreaP(3,1,3,1)
robots
  robot trabajadores
  variables
    id:numero
    cantF,cantP:numero
    nroTarea:numero
    avA,caA:numero
    avIni,caIni:numero
  comenzar
    RecibirMensaje(id,jefe)
    cantP:=0
    cantF:=0
    avIni := PosAv
    caIni := PosCa
    EnviarMensaje(id,jefe)
    RecibirMensaje(nroTarea,jefe)
    mientras(nroTarea<>4)
      RecibirMensaje(avA,jefe)
      RecibirMensaje(caA,jefe)
      BloquearEsquina(avA,caA)
      Pos(avA,caA)
      tareas(nroTarea,cantP,cantF)
      Pos(avIni,caIni)
      LiberarEsquina(avA,caA)
      EnviarMensaje(V,jefe)
      EnviarMensaje(id,jefe)
      RecibirMensaje(nroTarea,jefe)
  fin
  robot Jefe
  variables
    id:numero
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    repetir 10
      RecibirMensaje(id,*)
      valoresAleatorios(id)
    repetir 2
      RecibirMensaje(id,*)
      si(id=1)
        EnviarMensaje(4,r1)
      sino
        EnviarMensaje(4,r2)
  fin 
variables
  r1,r2:trabajadores
  jefe:Jefe
comenzar
  AsignarArea(r1,area2)
  AsignarArea(r1,areaC)
  AsignarArea(r2,area3)
  AsignarArea(r2,areaC)
  AsignarArea(jefe,area1)
  Iniciar(jefe,1,1)
  Iniciar(r1,2,1)
  Iniciar(r2,3,1)
fin