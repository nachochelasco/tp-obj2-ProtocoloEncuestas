package tpGrupal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pregunta { 
	
	protected String enunciado ;
	private Encuesta encuestaDePertenencia; 
	private Integer indiceDeDesplazamiento; 
	
	public Pregunta(String enunciado) {  
		this.enunciado = enunciado ;
	}
	
	public String getContenido() {
		return enunciado;
	}

	public Encuesta getEncuestaALaQuePertenece() {
		return encuestaDePertenencia;
	}
	
	public void setEncuesta(Encuesta encuesta) {
		encuestaDePertenencia = encuesta;
	}

	public void setindiceDeDesplazamiento(Integer indiceDeDesplazamientoP) {
		indiceDeDesplazamiento = indiceDeDesplazamientoP;	
	}
	
	public Integer getIndiceDeDesplazamiento() {
		return indiceDeDesplazamiento ;
	}

	public void notificarObservers(Respuesta respuesta) { 
		if ( this.getEncuestaALaQuePertenece().getProyectoDePertenencia().getInvestigadoresInteresados().size() >= 1 ) {
	     for( Investigador i : this.getEncuestaALaQuePertenece().getProyectoDePertenencia().getInvestigadoresInteresados()) {
			i.notificar(this,respuesta); 
		 }
		}
     }
	
}

