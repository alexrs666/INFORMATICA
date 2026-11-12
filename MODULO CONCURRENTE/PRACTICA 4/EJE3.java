{3. Sincronización barrera
Tres robots papeleros deben vaciar de papeles su avenida, comenzando por la calle 1 y
terminando en la calle 100. El trabajo lo deben realizar todos juntos y en etapas: los robots
inician juntos y cuando todos completan una etapa del trabajo pueden avanzar a la
siguiente, lo que significa que para poder pasar de etapa los robots deben esperar que
todos hayan completado la etapa en curso. Implemente el programa considerando que cada
robot completa una etapa cada 5 esquinas.
a) Resuelva considerando un robot coordinador cuya única tarea es asignar identificadores
a cada robot.
b) Resuelva considerando un robot coordinador cuya tarea es habilitar el inicio de las
etapas.
Los robots inician en las esquinas (1,1), (2,1) y (3,1) respectivamente y el coordinador en la
esquina (4,1).}
programa ejemplo
procesos
  proceso juntarPapeles 
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
areas
  area1: AreaP(1,1,1,100)
  area2: AreaP(2,1,2,100)
  area3: AreaP(3,1,3,100)
  area4: AreaP(4,1,4,1)
robots
  robot papeleros
  variables
    id:numero
    listo:boolean
    cantPasos:numero
  comenzar
    RecibirMensaje(id,r4)
    mientras(PosCa < 100)
      RecibirMensaje(listo,r4)
      cantPasos:=0
      mientras(cantPasos<5)&(PosCa < 100)
        juntarPapeles
        mover
        cantPasos:=cantPasos + 1
      juntarPapeles
      EnviarMensaje(V,r4)
  fin
  robot coordinador
  variables
    id:numero
    listo:boolean
  comenzar
    EnviarMensaje(1,r1)
    EnviarMensaje(2,r2)
    EnviarMensaje(3,r3)
    repetir 20
      EnviarMensaje(V,r1)
      EnviarMensaje(V,r2)
      EnviarMensaje(V,r3)
      RecibirMensaje(listo,r1)
      RecibirMensaje(listo,r2)
      RecibirMensaje(listo,r3)
  fin 
variables
  r1,r2,r3:papeleros
  r4:coordinador
comenzar
  AsignarArea(r1,area1)
  AsignarArea(r2,area2)
  AsignarArea(r3,area3)
  AsignarArea(r4,area4)
  Iniciar(r1,1,1)
  Iniciar(r2,2,1)
  Iniciar(r3,3,1)
  Iniciar(r4,4,1)
fin