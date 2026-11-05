{1.Existe un robot que sirve de flores a tres robots clientes. Cada cliente solicita al servidor que
le deposite en su esquina siguiente una cantidad de flores aleatoria (entre 1 y 4). Por
ejemplo, si el cliente se encuentra en la esquina (2,1) le solicitará que coloque x cantidad de
flores en la esquina (2,2).
Cuando el robot servidor deposita las flores en la esquina solicitada, el cliente las junta y las
deposita una a una a lo largo de la avenida en la que se encuentra.
El programa finaliza cuando todos los robos clientes completan su avenida. Asuma que el
robot servidor tiene flores suficientes en su bolsa.
El robot servidor se inicia en la esquina (100,100)
Los robots clientes inician en las esquinas (1,1) , (2,1) y (3,1) respectivamente}
programa ejemplo
procesos
  proceso recibirDatos(E id:numero; ES cantF:numero; ES avCli:numero; ES caCli:numero)
  comenzar
    si (id=1)
      RecibirMensaje(cantF, r1)
      si(cantF<>0)
        RecibirMensaje(avCli, r1)
        RecibirMensaje(caCli, r1)
    sino
      si (id=2)
        RecibirMensaje(cantF, r2)
        si(cantF<>0)
          RecibirMensaje(avCli, r2)
          RecibirMensaje(caCli, r2)
      sino
        si (id=3)
          RecibirMensaje(cantF, r3)
          si(cantF<>0)
            RecibirMensaje(avCli, r3)
            RecibirMensaje(caCli, r3)
  fin
  proceso enviarACK(E id:numero)
  comenzar
    si (id=1)
      EnviarMensaje(1,r1)
    sino
      si (id=2)
        EnviarMensaje(2,r2)
      sino
        si (id=3)
          EnviarMensaje(3,r3)
  fin
  proceso juntarTodas(ES cantF:numero)
  comenzar
    cantF:=0
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      cantF := cantF + 1
  fin
  proceso avanzarYDejar(ES cantF:numero)
  comenzar
    mientras(cantF > 0)&(PosCa < 100)
      si (HayFlorEnLaBolsa)  
        depositarFlor
        mover
      cantF := cantF - 1
       
  fin
areas
  areaPC1:AreaPC(1,2,1,100)
  areaPC2:AreaPC(2,2,2,100)
  areaPC3:AreaPC(3,2,3,100)
  area1:AreaP(1,1,1,1)
  area2:AreaP(2,1,2,1)
  area3:AreaP(3,1,3,1)
  area4:AreaP(100,100,100,100)
robots
  robot cliente
  variables
    id,cantF,avActual,caSig,ack: numero
    caIni:numero
  comenzar
    RecibirMensaje(id, servi)
    avActual := PosAv
    mientras (PosCa < 100)
      caIni:=PosCa
      caSig := PosCa + 1
      Random(cantF, 1, 4)
      EnviarMensaje(id, servi)
      EnviarMensaje(cantF, servi)
      EnviarMensaje(avActual, servi)
      EnviarMensaje(caSig, servi)
      RecibirMensaje(ack, servi) 
      Pos(avActual,caSig)
      juntarTodas(cantF)
      Pos(avActual,caIni)
      avanzarYDejar(cantF)
    EnviarMensaje(id,servi)
    EnviarMensaje(0,servi)
  fin
  robot servidor
  variables
    id, cantF, avCli, caCli, terminados: numero
  comenzar  
    terminados := 0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    mientras (terminados < 3)
      RecibirMensaje(id, *)
      recibirDatos(id, cantF, avCli, caCli)
      si (cantF <> 0)
        Pos(avCli, caCli)
        repetir cantF
          depositarFlor
        Pos(100, 100)
        enviarACK(id)
      sino
        terminados:=terminados + 1
  fin
variables
  r1,r2,r3: cliente
  servi: servidor
comenzar
  AsignarArea(r1, area1)
  AsignarArea(r1, areaPC1)
  AsignarArea(r2, area2)
  AsignarArea(r2, areaPC2)  
  AsignarArea(r3, area3)
  AsignarArea(r3, areaPC3)
  AsignarArea(servi, area4)
  AsignarArea(servi, areaPC1)
  AsignarArea(servi, areaPC2)
  AsignarArea(servi, areaPC3)
  Iniciar(r1,1,1)
  Iniciar(r2,2,1)
  Iniciar(r3,3,1)
  Iniciar(servi,100,100)
fin