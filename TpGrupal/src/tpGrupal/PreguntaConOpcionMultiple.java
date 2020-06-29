package tpGrupal;

import java.util.ArrayList; 
import java.util.List;

public class PreguntaConOpcionMultiple extends Pregunta {
	
	protected List<RespuestaSimple> respuestasPosibles = new ArrayList<RespuestaSimple>() ;
	
	public PreguntaConOpcionMultiple(String enunciado, ArrayList<RespuestaSimple> respuestasPosiblesP) {
		super(enunciado);
		respuestasPosibles = respuestasPosiblesP; 
	}
	
	public List<RespuestaSimple> getRespuestasPosibles() {
		return respuestasPosibles; 
	}

	public void responder(RespuestaMultiple rta) {
		PreguntaRespuesta pr;
		if(this.getEncuestaALaQuePertenece().getEstado().puedeResponder()) {  
			Encuesta encuesta = this.getEncuestaALaQuePertenece();
			Integer indice = encuesta.getPreguntas().indexOf(this) + rta.getDesplazamiento() ;
			Pregunta siguientePregunta = encuesta.getPreguntas().get(indice) ; 
			this.setindiceDeDesplazamiento(rta.getDesplazamiento());
			encuesta.setPreguntaActual(siguientePregunta);
			pr = new PreguntaRespuesta (this, rta);
			this.notificarObservers(rta);
			encuesta.guardarPreguntaRespondida(pr);
		}
	}

}
	
