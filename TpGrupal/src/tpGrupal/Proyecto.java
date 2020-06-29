package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Proyecto implements IProyecto{
	
	private String descripcion, proposito ;
	private List<Encuesta> encuestasDisponibles, encuestasFinalizadas, encuestasFinalizadasRepetidas;
	private List<Investigador> investigadoresInteresados = new ArrayList<Investigador>();
	
	
	public Proyecto (String descripcion, String proposito, ArrayList <Encuesta> encuestas) {
		encuestasDisponibles = new ArrayList<Encuesta>() ; 
		encuestasFinalizadasRepetidas = new ArrayList<Encuesta>();
		encuestasFinalizadas = new ArrayList<Encuesta>() ;
		this.setDescripcion(descripcion);
		this.proposito = proposito;
		this.encuestasDisponibles = encuestas; 
		this.setProyectoParaEncuestas(encuestas); 
	}
	
	public void addInvestigadorInteresado(Investigador i) {
		this.investigadoresInteresados.add(i);
	}
	
	public List<Investigador> getInvestigadoresInteresados() {
		return investigadoresInteresados;
	}
	
	private void setProyectoParaEncuestas(ArrayList <Encuesta> encuestas) {
		for ( Encuesta e : encuestas) {
			e.setProyectoDePertenencia(this);
		}
	}

	public List<Encuesta> getEncuestasDisponibles() {
		return encuestasDisponibles ;
	} 

	public List<Encuesta> getEncuestasFinalizadas() {
		return encuestasFinalizadas;
	}
	
	public List<Encuesta> getEncuestasFinalizadasRepetidas() {
		return encuestasFinalizadasRepetidas;
	}


	public void agregarEncuestaFinalizada(Encuesta encuesta) {
		encuestasFinalizadasRepetidas.add(encuesta) ;
	} 

	public void ordenarEncuestasFinalizadas() {
		ArrayList <Encuesta> encuestaFinalizadasSinRepetidosArray = new ArrayList <Encuesta>();
		HashSet<Encuesta> encuestasFinalizadasSinRepetidos = new HashSet <Encuesta>();
		
		for ( Encuesta e : encuestasFinalizadasRepetidas) {
			encuestasFinalizadasSinRepetidos.add(e);
		}
		
		for ( Encuesta e : encuestasFinalizadasSinRepetidos) {
			encuestaFinalizadasSinRepetidosArray.add(e);
		}
		encuestasFinalizadas = encuestaFinalizadasSinRepetidosArray;
		Collections.sort(encuestasFinalizadas, Collections.reverseOrder());	
	}

	public void desactivarEncuesta(Encuesta encuesta) { 
	encuestasDisponibles.remove(encuesta);
	
	}

	public void finalizarProyecto() {
		while ( this.getEncuestasDisponibles().size() >= 1 ) {
			this.desactivarEncuesta(this.getEncuestasDisponibles().get(0));
		}
	}
	
	public Boolean esFinalizado() {
		return this.getEncuestasDisponibles().size() == 0 ;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Encuesta> getUltimasEncuestas(int fecha) {
		List<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		for ( Encuesta e : this.getEncuestasDisponibles()) {
			if ( e.getAñoCreacion() == fecha ) {
				lsEncuestas.add(e) ;
			}
		}
		return lsEncuestas ;
	}
	
	public Integer compare(Proyecto p) {
		return new Integer(this.getDescripcion().compareTo(p.getDescripcion())) ;
	}

}
