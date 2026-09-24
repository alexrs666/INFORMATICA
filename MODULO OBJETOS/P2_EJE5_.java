package practicas_java;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author AlexRs
 */
/*
    5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
       encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
       valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
       nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
       partido sabe responder a los siguientes mensajes:
            getLocal() retorna el nombre (String) del equipo local
            getVisitante() retorna el nombre (String) del equipo visitante
            getGolesLocal() retorna la cantidad de goles (int) del equipo local
            getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
            setLocal(X) modifica el nombre del equipo local al “String” X
            setVisitante(X) modifica el nombre del equipo visitante al “String” X
            setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
            setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
            hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
            getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío).
            hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
       Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
       el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
       nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
       - Para cada partido, armar e informar una representación String del estilo:
            {EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
       - Calcular e informar la cantidad de partidos que ganó River.
       - Calcular e informar el total de goles que realizó Boca jugando de local.=
*/
public class P2_EJE5_JAVA {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        final int DF=20;
        int DL;
        cla.Partido vecPartido[] = new cla.Partido[DF];
        
        String nomVisitante = GeneradorAleatorio.generarString(3).toUpperCase();
        DL=0;
        while(!nomVisitante.equals("ZZZ") && DL<DF){
            
            vecPartido[DL]= new cla.Partido();
            vecPartido[DL].setVisitante(nomVisitante);
            vecPartido[DL].setGolesVisitante(GeneradorAleatorio.generarInt(5));
            vecPartido[DL].setLocal(GeneradorAleatorio.generarString(3).toUpperCase());
            vecPartido[DL].setGolesLocal(GeneradorAleatorio.generarInt(5));
            DL++;
            nomVisitante = GeneradorAleatorio.generarString(3).toUpperCase();
        }
        
        for(int i=0;i<DL;i++){
            System.out.println("EQUIPO-LOCAL:"+vecPartido[i].getLocal()+" GOLES:"+vecPartido[i].getGolesLocal()+" VS EQUIPO-VISITANTE:"+vecPartido[i].getVisitante()+" GOLES:"+vecPartido[i].getGolesVisitante());
        }
        int cantRiver=0;
        for(int i=0;i<DL;i++){
           if(vecPartido[i].getGanador().equals("River"))
                cantRiver++;
        }
        System.out.println("esta es la cantidad de partido que gano river:"+cantRiver);
        int canTotalGoles=0;
        for(int i=0;i<DL;i++){
            if(vecPartido[i].getLocal().equals("Boca"))
                canTotalGoles+=vecPartido[i].getGolesLocal();
        }
        System.out.println("esta es la cantidad de goles que boca metio de local:"+canTotalGoles);
    }
}