package clases;


import java.util.ArrayList;
import java.util.Date;
/**
 * Clase que contiene los atributos y metodos necesario para un campeonato de
 * fulbito.Además, contiene una lista de los equipos participantes.
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
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


    public Campeonato(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public Campeonato() {
        listaEquipos=new ArrayList<>();
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
     * Metodo que permite Buscar un equipo por su ID
     * @param idEquipo Id del Equipo
     * @return Objeto Equipo
     */
    public Equipo buscarEquipo(int idEquipo){
        for (Equipo objEquipo : listaEquipos) {
            if(objEquipo.getIdEquipo()== idEquipo){
                return objEquipo;
            }
        }
        return null;
    }
    
    /**
     * Metodo que devuelve el Fixture del campeonato
     * @return Objeto Fixture
     */
    public Fixture getObjFixture() {
        return objFixture;
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
    
    /**
     * Metodo que permite agrega un equipo a la Lista de equipos relacinado al campeonato
     * @param equipo Objeto Equipo
     */
    public void agregarEquipo(Equipo equipo){
        //Agregar validación, para agregar equipo el size de lista jugadores debe ser max de 12, min de 8
        listaEquipos.add(equipo);
    }
    
    /**
     * Metodo que permite actualiza los atributos de un equipo espesifico según si ID
     * @param pEquipo Objeto Equipo
     */
    public void ActualizarEquipo(Equipo pEquipo){
        buscarEquipo(pEquipo.getIdEquipo()).setNomEquipoCorto(pEquipo.getNomEquipoCorto());
        buscarEquipo(pEquipo.getIdEquipo()).setNomEquipoLargo(pEquipo.getNomEquipoLargo());           
        buscarEquipo(pEquipo.getIdEquipo()).setDelegado(pEquipo.getDelegado());
        buscarEquipo(pEquipo.getIdEquipo()).setListaJugadores(pEquipo.getListaJugadores());  
    }    
    
    /**
     * Metodo que busca un equipo y deveulve el nombre corto del equipo según su ID
     * @param pIdEquipo Id del Equipo
     * @return  String getNomEquipoCorto
     */
    public String getNomEquipoCorto_ById(int pIdEquipo) {
        for (Equipo e:listaEquipos) {
            if(e.getIdEquipo()==pIdEquipo) return e.getNomEquipoCorto();
        }
        return "-";
    }
     
    /**
     * Metodo que buscar un equipo según su nombre corto
     * @param nomEquipoCorto Nombre del Equipo
     * @return Objeto Equipo
     */
    public Equipo getEquipo_ByNomEquipoCorto(String nomEquipoCorto) {
        for (Equipo e:listaEquipos) {
            if(e.getNomEquipoCorto().equals(nomEquipoCorto)) return e;
        }
        return new Equipo();
    }
    
    /**
     * Metodo que devuelve la cantidad de goles anotados por el goleador
     * @return int max
     */
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
    
    /**
     * Metodoco que devuelve el nombre del equipo del goleador
     * @return String getNomEquipoCorto
     */
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
    
    /**
     *Metodo que permite obtener la lista de tarjetas Rojas de todo el campeonato
     * @return ArrayList de Tarjetas
     */
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
    
    /**
     * Metodo que permite eliminar un equipo del campeonato
     * @param pIdEquipo Id del Equipo
     */
    public void EliminarEquipo(int pIdEquipo){
        for (Equipo e: listaEquipos) {
            if(e.getIdEquipo()==pIdEquipo){
                listaEquipos.remove(e);
                return;
            }
        }
    }

    /**
     * Metodo que Reorndena la lista de Equipos y asigna un codigo correlativo
     */
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
