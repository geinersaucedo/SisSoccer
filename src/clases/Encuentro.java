/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lsandoval
 */
public class Encuentro {
   private int idEncuentro;
   private int IdEquipoLocal;
   private String NombreEquipoLocal;
   private int idEquipoVisita;
   private String NombreEquipoVisita;
   private ArrayList<Gol> listaGoles;
   private ArrayList<Tarjeta> listatarjeta;
   private Date FechaEncuentro;
   private String Observaciones;
   private int walkover;
   private String equipoWalkover;
   private String estado;

    public Encuentro() {
        this.listaGoles = new ArrayList<Gol>();
        this.listatarjeta = new ArrayList<Tarjeta>();
    }

   
    public String getNombreEquipoLocal() {
        return NombreEquipoLocal;
    }

    public void setNombreEquipoLocal(String NombreEquipoLocal) {
        this.NombreEquipoLocal = NombreEquipoLocal;
    }

    public String getNombreEquipoVisita() {
        return NombreEquipoVisita;
    }

    public void setNombreEquipoVisita(String NombreEquipoVisita) {
        this.NombreEquipoVisita = NombreEquipoVisita;
    }

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public int getIdEquipoLocal() {
        return IdEquipoLocal;
    }

    public void setIdEquipoLocal(int IdEquipoLocal) {
        this.IdEquipoLocal = IdEquipoLocal;
    }

    public int getIdEquipoVisita() {
        return idEquipoVisita;
    }

    public void setIdEquipoVisita(int idEquipoVisita) {
        this.idEquipoVisita = idEquipoVisita;
    }

    public ArrayList<Gol> getListaGoles() {
        return listaGoles;
    }

    public void setListaGoles(ArrayList<Gol> listaGoles) {
        this.listaGoles = listaGoles;
    }

    public ArrayList<Tarjeta> getListatarjeta() {
        return listatarjeta;
    }

    public void setListatarjeta(ArrayList<Tarjeta> listatarjeta) {
        this.listatarjeta = listatarjeta;
    }

    public Date getFechaEncuentro() {
        return FechaEncuentro;
    }

    public void setFechaEncuentro(Date FechaEncuentro) {
        this.FechaEncuentro = FechaEncuentro;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getWalkover() {
        return walkover;
    }

    public void setWalkover(int walkover) {
        this.walkover = walkover;
    }

    public String getEquipoWalkover() {
        return equipoWalkover;
    }

    public void setEquipoWalkover(String equipoWalkover) {
        this.equipoWalkover = equipoWalkover;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   public void setAgregarGol(Gol objGol){
       listaGoles.add(objGol);
   }

   public void setAgregartarjeta(Tarjeta objtarjeta){
       listatarjeta.add(objtarjeta);
   }
   
   public void RegistrarResultado( Encuentro ObjEncuentro ){
       setWalkover(ObjEncuentro.getWalkover());
       setEquipoWalkover(ObjEncuentro.getEquipoWalkover());
       setListaGoles(ObjEncuentro.getListaGoles());
       setListatarjeta(ObjEncuentro.getListatarjeta());
       setObservaciones(ObjEncuentro.getObservaciones());
       setEstado(ObjEncuentro.getEstado());
   }
   
   public int getGoles_x_Equipo(int pIdEquipo){
       int TotalGoles=0;
       for (Gol g: listaGoles) {
           if(g.getIdEquipo()==pIdEquipo) TotalGoles++;
       }       
       return TotalGoles;
   }
   public int getGolesEnContra_x_Equipo(int pIdEquipo){
       return listaGoles.size()-getGoles_x_Equipo(pIdEquipo);
   }
}
