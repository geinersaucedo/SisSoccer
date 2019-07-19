package clases;

import java.util.ArrayList;
import java.util.Calendar;
import static proyectosissocer.frmPrincipal.gestor;

/**
 * Clase que contiene los atributos y metodos necesario para un ..............
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public class ModoLiga extends Fixture {
    
    static public class Partido {
        public int local = -1, visitante = -1;
    }
    
    @Override
    /**
     * Metodo que permite generar el Fixture del Modo Liga
     */
    public void generarFixture(){
        try{
            ArrayList<Equipo> objListaEquipos = gestor.buscarCampeonatoById(getIdCampeonato()).getListaEquipos();
            Partido[][] FixtureAleatorio = calcularLiga(objListaEquipos.size());                
            setIdFixture(1);
            setCantidadJornadas(FixtureAleatorio.length);
            Calendar c = Calendar.getInstance();    
            for (int i = 0; i < FixtureAleatorio.length; i ++)
            {            
                Jornada ObjJornada = new Jornada();
                ObjJornada.setIdJornada(i+1);
                ObjJornada.setNumFecha(i+1);
                ObjJornada.setCantEncuentros_x_Jornada(FixtureAleatorio[i].length);
                ObjJornada.setIdCampeonato(getIdCampeonato());
                c.add(Calendar.DATE, 7);
                for (int j = 0; j < FixtureAleatorio[i].length; j ++)
                {
                    Encuentro ObjEncuentro = new Encuentro();  
                    ObjEncuentro.setIdEncuentro(j+1);
                    ObjEncuentro.setFechaEncuentro(c.getTime());
                    ObjEncuentro.setIdEquipoLocal(FixtureAleatorio[i][j].local + 1);
                    ObjEncuentro.setNombreEquipoLocal(gestor.buscarCampeonatoById(getIdCampeonato()).buscarEquipo(ObjEncuentro.getIdEquipoLocal()).getNomEquipoCorto());
                    
                    ObjEncuentro.setIdEquipoVisita(FixtureAleatorio[i][j].visitante + 1);
                    ObjEncuentro.setNombreEquipoVisita(gestor.buscarCampeonatoById(getIdCampeonato()).buscarEquipo(ObjEncuentro.getIdEquipoVisita()).getNomEquipoCorto());
                    ObjEncuentro.setEstado("P");
                    ObjJornada.agregarEncuentro(ObjEncuentro);
                }            
                agregarJornada(ObjJornada);
            }        
        }catch(Exception ex ){
             
        }
        
    }    

    /**
     * Metodo que calcula el fixture cuando la cantidad de equipos es Par
     * @param numEquipos
     * @return Partido[][]
     */
    private static Partido[][] calcularLigaNumEquiposPar(int numEquipos)
    {
        int numRondas = numEquipos - 1;
        int numPartidosPorRonda = numEquipos / 2;
        
        Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];
        
        for (int i = 0, k = 0; i < numRondas; i ++)
        {
            for (int j = 0; j < numPartidosPorRonda; j ++)
            {
                rondas[i][j] = new Partido();
                
                rondas[i][j].local = k;

                k ++;

                if (k == numRondas)
                    k = 0;
            }
        }
        
        for (int i = 0; i < numRondas; i ++)
        {
            if (i % 2 == 0)
            {
                rondas[i][0].visitante = numEquipos - 1;
            }
            else
            {
                rondas[i][0].visitante = rondas[i][0].local;
                rondas[i][0].local = numEquipos - 1;
            }
        }
        
        int equipoMasAlto = numEquipos - 1;
        int equipoImparMasAlto = equipoMasAlto - 1; 
        
        for (int i = 0, k = equipoImparMasAlto; i < numRondas; i ++)
        {
            for (int j = 1; j < numPartidosPorRonda; j ++)
            {
                rondas[i][j].visitante = k;

                k --;

                if (k == -1)
                    k = equipoImparMasAlto;
            }
        }
        
        return rondas;
    }
    
    /**
      * Metodo que calcula el fixture cuando la cantidad de equipos es Inpar
     * @param numEquipos
     * @return Partido[][]
     */
    private static Partido[][] calcularLigaNumEquiposImpar(int numEquipos)
    {
        int numRondas = numEquipos;
        int numPartidosPorRonda = numEquipos / 2;
        
        Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];
        
        for (int i = 0, k = 0; i < numRondas; i ++)
        {
            for (int j = -1; j < numPartidosPorRonda; j ++)
            {
                if (j >= 0)
                {
                    rondas[i][j] = new Partido();
                    
                    rondas[i][j].local = k;
                }
                
                k ++;

                if (k == numRondas)
                    k = 0;
            }
        }
        
        int equipoMasAlto = numEquipos - 1;
        
        for (int i = 0, k = equipoMasAlto; i < numRondas; i ++)
        {
            for (int j = 0; j < numPartidosPorRonda; j ++)
            {
                rondas[i][j].visitante = k;

                k --;

                if (k == -1)
                    k = equipoMasAlto;
            }
        }
        
        return rondas;
    }
    
    /**
     * Metodo que calcula el fixture
     * @param numEquipos
     * @return 
     */
    static public Partido[][] calcularLiga(int numEquipos)
    {
        if (numEquipos % 2 == 0)
            return calcularLigaNumEquiposPar(numEquipos);
        else
            return calcularLigaNumEquiposImpar(numEquipos);
    }
      
}
