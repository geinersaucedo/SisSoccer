
package clases;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Geiner Saucedo
 */
public class Campeonato{
    private int idCampeonato;
    private String nombreCampeonato;
    private String organizador;
    private int cantidadEquipos;
    private int tipoCampeonato;
    private String montoPremio;
    private ArrayList<Equipo> listaEquipos;
    private Date fechaInicio;

    private int golesWalkover;
    private Fixture objFixture;

    public Fixture getObjFixture() {
        return objFixture;
    }

    public void setObjFixture(Fixture objFixture) {
        this.objFixture = objFixture;
    }

    public int getGolesWalkover() {
        return golesWalkover;
    }

    public void setGolesWalkover(int golesWalkover) {
        this.golesWalkover = golesWalkover;
    }

    
    public Equipo buscarEquipo(int idEquipo){
        for (Equipo objEquipo : listaEquipos) {
            if(objEquipo.getIdEquipo()== idEquipo){
                return objEquipo;
            }
        }
        return null;
    }

    public Campeonato(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public Campeonato() {
        listaEquipos=new ArrayList<>();
    }

    
    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }

    public void setNombreCampeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public int getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(int tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public String getMontoPremio() {
        return montoPremio;
    }

    public void setMontoPremio(String montoPremio) {
        this.montoPremio = montoPremio;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    /**
     * Método que permite validar que los datos del campeonato sean correctos
     * @return verdadero si pasa la validación
     */
    public boolean validaCampeonato(){
        if (fechaInicio!=null &&idCampeonato>=0&&
                !nombreCampeonato.equals("")&& !organizador.equals("")&&!montoPremio.equals("")) {
            return true;
        }else return false;
    }
    
    public void agregarEquipo(Equipo equipo){
        //Agregar validación, para agregar equipo el size de lista jugadores debe ser max de 12, min de 8
        listaEquipos.add(equipo);
    }
    
    public String getNomEquipoCorto_ById(int pIdEquipo) {
        for (Equipo e:listaEquipos) {
            if(e.getIdEquipo()==pIdEquipo) return e.getNomEquipoCorto();
        }
        return "-";
    }
        
    public Equipo getEquipo_ByNomEquipoCorto(String nomEquipoCorto) {
        for (Equipo e:listaEquipos) {
            if(e.getNomEquipoCorto().equals(nomEquipoCorto)) return e;
        }
        return new Equipo();
    }
    public int getGolesDelGoleador(){
        //Concatenar todos los goles de todas las jornadas en una sola lista
        ArrayList<Gol> listaGolesTotales=new ArrayList<Gol>();
        for(Jornada j: objFixture.getListaJornadas()){
            for(Encuentro e:j.getListaEncuentro()){
                listaGolesTotales.addAll(e.getListaGoles());
            }
        }
        if (listaGolesTotales.size()>0) {
            //Listar los nombres de los jugadores por cada gol marcado
            ArrayList<String> listaNombreJugadores=new ArrayList<String>();
            for (Gol g:listaGolesTotales) {
                listaNombreJugadores.add(g.getNomJugador());
            }
            //busco el goleador, asumo que es el primero para iniciar busqueda
            int contador1=0;
            int contador2=0;
            int max=0;
            for (int i = 0; i < listaNombreJugadores.size()-1; i++) {
                contador1=contador2=0;
                for (int j = 0; j < listaNombreJugadores.size(); j++) {
                    if (listaNombreJugadores.get(i).equals(listaNombreJugadores.get(j))){
                        contador1++;
                    }
                }
                for (int j = 0; j < listaNombreJugadores.size(); j++) {
                    if (listaNombreJugadores.get(i+1).equals(listaNombreJugadores.get(j))){
                        contador2++;
                    }
                }
                if (i==0) {
                    max=contador1;
                }else{
                    if (contador1>contador2) {
                        if (contador1>max) {
                            max=contador1;
                        }
                    }    
                    else{
                        if (contador2>contador1) {
                            max=contador2;
                        }
                    }
                } 
            }
            return max;
        }
        return 0;
    }
    public String getEquipoDelGoleador(){
        String goleador=getGoleadorDelCampeonato();
        for (Equipo equi: listaEquipos) {
            for (Jugador jug: equi.getListaJugadores()) {
                if((jug.getNombre()+" "+jug.getApellidos()).equals(goleador))
                    return equi.getNomEquipoCorto();
            }
        }
        return null;
    }
    /**
     * Metodo que permite saber el nombre del goleador del campeonato
     * @return String con el nombre del goleador
     */
    public String getGoleadorDelCampeonato(){
        //Concatenar todos los goles de todas las jornadas en una sola lista
        ArrayList<Gol> listaGolesTotales=new ArrayList<Gol>();
        for(Jornada j: objFixture.getListaJornadas()){
            for(Encuentro e:j.getListaEncuentro()){
                listaGolesTotales.addAll(e.getListaGoles());
            }
        }
        if (listaGolesTotales.size()>0) {
            //Listar los nombres de los jugadores por cada gol marcado
            ArrayList<String> listaNombreJugadores=new ArrayList<String>();
            for (Gol g:listaGolesTotales) {
                listaNombreJugadores.add(g.getNomJugador());
            }
            //busco el goleador, asumo que es el primero para iniciar busqueda
            String nomGoleador=listaGolesTotales.get(0).getNomJugador();
            int contador1=0;
            int contador2=0;
            int max=0;
            for (int i = 0; i < listaNombreJugadores.size()-1; i++) {
                contador1=contador2=0;
                for (int j = 0; j < listaNombreJugadores.size(); j++) {
                    if (listaNombreJugadores.get(i).equals(listaNombreJugadores.get(j))){
                        contador1++;
                    }
                }
                for (int j = 0; j < listaNombreJugadores.size(); j++) {
                    if (listaNombreJugadores.get(i+1).equals(listaNombreJugadores.get(j))){
                        contador2++;
                    }
                }
                if (i==0) {
                    max=contador1;
                    nomGoleador=listaNombreJugadores.get(i);
                }else{
                    if (contador1>contador2) {
                        if (contador1>max) {
                            max=contador1;
                            nomGoleador=listaNombreJugadores.get(i);
                        }
                    }    
                    else{
                        if (contador2>contador1) {
                            max=contador2;
                            nomGoleador=listaNombreJugadores.get(i+1);
                        }
                    }
                } 
            }
            return nomGoleador;
        }
        return null;
    }
    
    public ArrayList<Tarjeta> getListaTarjetasRojas(){
        ArrayList<Tarjeta> lista=new ArrayList<Tarjeta>();
        for (Jornada j: objFixture.getListaJornadas()) {
            for (Encuentro e: j.getListaEncuentro()) {
                for (Tarjeta t: e.getListatarjeta()) {
                    if (t.getColorTarjeta().equals("Roja")) {
                        lista.add(t);
                    }
                }
            }
        }
        return lista;
    }
    
    public void EliminarEquipo(int pIdEquipo){
        for (Equipo e: listaEquipos) {
            if(e.getIdEquipo()==pIdEquipo){
                listaEquipos.remove(e);
                return;
            }
        }
    }

    public void ReordenarLista(){
        ArrayList<Equipo> OrderListaEquipos = new ArrayList<Equipo>();
        int row=1;
        for (Equipo e:listaEquipos) {
            e.setIdEquipo(row);
            OrderListaEquipos.add(e);           
            row++;
        }
        setListaEquipos(OrderListaEquipos);
    }      
}
