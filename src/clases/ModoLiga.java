/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import static proyectosissocer.frmPrincipal.gestor;

/**
 *
 * @author lsandoval
 */
public class ModoLiga extends Fixture {
    
    static public class Partido {
        public int local = -1, visitante = -1;
    }
    
    @Override
    public void generarFixture(){
        try{
            ArrayList<Equipo> objListaEquipos = gestor.buscarCampeonatoById(getIdCampeonato()).getListaEquipos();
            Partido[][] FixtureAleatorio = calcularLiga(objListaEquipos.size());                
            setIdFixture(1);
             Date date = new Date();       

            for (int i = 0; i < FixtureAleatorio.length; i ++)
            {            
                Jornada ObjJornada = new Jornada();
                ObjJornada.setIdJornada(i+1);
                ObjJornada.setNumFecha(i+1);

                for (int j = 0; j < FixtureAleatorio[i].length; j ++)
                {   Encuentro ObjEncuentro = new Encuentro();  
                    ObjEncuentro.setIdEncuentro(j+1);
                    ObjEncuentro.setFechaEncuentro(date);
                    ObjEncuentro.setIdEquipoLocal(FixtureAleatorio[i][j].local + 1);
                    ObjEncuentro.setNombreEquipoLocal(gestor.buscarCampeonatoById(getIdCampeonato()).buscarEquipo(ObjEncuentro.getIdEquipoLocal()).getNomEquipoCorto());

                    ObjEncuentro.setIdEquipoVisita(FixtureAleatorio[i][j].visitante + 1);
                    ObjEncuentro.setNombreEquipoVisita(gestor.buscarCampeonatoById(getIdCampeonato()).buscarEquipo(ObjEncuentro.getIdEquipoVisita()).getNomEquipoCorto());

                    ObjJornada.agregarEncuentro(ObjEncuentro);
                }            
                agregarJornada(ObjJornada);
            }        
        }catch(Exception ex ){
        
        }
        
    }    

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
    
    static public Partido[][] calcularLiga(int numEquipos)
    {
        if (numEquipos % 2 == 0)
            return calcularLigaNumEquiposPar(numEquipos);
        else
            return calcularLigaNumEquiposImpar(numEquipos);
    }
      
}