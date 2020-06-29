package testbla;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;

import tpGrupal.Encuesta;
import tpGrupal.Investigador;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;
import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;
import tpGrupal.VeinteCreadasUltimamente;

class testProyecto { 
	
	private Proyecto proyecto1;
	private PreguntaAbierta preguntaAbierta;
	private RespuestaSimple respuesta1;
	private PreguntaRespuesta preguntaRespuesta;
	
	private RespuestaMultiple listaRespuestas;
	private ArrayList <Encuesta>encuestas = new ArrayList<Encuesta>();
	
	private Encuesta encuesta1;
	
	private ArrayList<RespuestaSimple> lsRespuestas = new ArrayList<RespuestaSimple>();
	
	
	
	private ArrayList <Pregunta>preguntas = new ArrayList<Pregunta>();
	private ArrayList <PreguntaRespuesta>preguntasRespuestas = new ArrayList<PreguntaRespuesta>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		preguntaAbierta = new PreguntaAbierta ("lol");
		respuesta1 = new RespuestaSimple ("Esta es la respuesta");
		listaRespuestas = new RespuestaMultiple(lsRespuestas);
		
		preguntas.add(preguntaAbierta);
		preguntas.add(preguntaAbierta);
		listaRespuestas.agregarRespuesta(respuesta1);
		encuesta1 = new Encuesta (preguntas);
		preguntaRespuesta = new PreguntaRespuesta(preguntaAbierta,listaRespuestas);
		
		preguntasRespuestas.add(preguntaRespuesta);
		
		encuestas.add(encuesta1);
		
		proyecto1 = new Proyecto ("dasdas", "lassdaso", encuestas );
		
		
	}

	@Test 
	void testGetterEncuesta() {
		assertEquals (1, proyecto1.getEncuestasDisponibles().size());
	}
	
	@Test
	void testProyectoTieneEncuestaFinalizada() {
		
		proyecto1.agregarEncuestaFinalizada(encuesta1);
		
		assertTrue (proyecto1.getEncuestasFinalizadasRepetidas().contains(encuesta1));
	}
	
	@Test
	void testCuandoProyectoDesactivaUnaEncuestaSeRetiraDeLaListaDeEncuestasDisponibles() {
		
		
		
		
				
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		Investigador investigador1 = new Investigador(proyectos);
		
		investigador1.desactivarEncuesta(encuesta1);
		
		assertFalse(encuesta1.getProyectoDePertenencia().getEncuestasDisponibles().contains(encuesta1));
		
	}
	

	@Test
	void testProyectoPuedeOrdenarSuListaDeEncuestasFinalizadas() {
		PreguntaAbierta preg1= new PreguntaAbierta("p");
		PreguntaAbierta preg2 = new PreguntaAbierta("e");
		PreguntaAbierta preg3 = new PreguntaAbierta("r");
		PreguntaAbierta preg4 = new PreguntaAbierta("t");
		PreguntaAbierta preg5 = new PreguntaAbierta("y");
		PreguntaAbierta preg6 = new PreguntaAbierta("u");
		
		ArrayList<Pregunta> prs1 = new ArrayList<Pregunta>();
		ArrayList<Pregunta> prs2 = new ArrayList<Pregunta>();
		ArrayList<Pregunta> prs3 = new ArrayList<Pregunta>();
		
		prs1.add(preg1);
		
		prs2.add(preg2);
		prs2.add(preg3);
		
		prs3.add(preg4);
		prs3.add(preg5);
		prs3.add(preg6);
		
		Encuesta enc1 = new Encuesta(prs1);
		Encuesta enc2 = new Encuesta(prs2);
		Encuesta enc3 = new Encuesta(prs3);
		
		ArrayList<Encuesta> encs1 = new ArrayList<Encuesta>();
		
		encs1.add(enc1);
		encs1.add(enc2);
		encs1.add(enc3);
		
		Proyecto proy1 = new Proyecto("dasdas", "lassdaso", encs1 );
		 
		proy1.agregarEncuestaFinalizada(enc2);
		proy1.agregarEncuestaFinalizada(enc1);
		proy1.agregarEncuestaFinalizada(enc3);
		
		proy1.ordenarEncuestasFinalizadas();
		
		enc1.completarEn(proy1); 
		enc2.completarEn(proy1);
		enc2.completarEn(proy1);
		
		enc3.completarEn(proy1);
		enc3.completarEn(proy1);
		enc3.completarEn(proy1);
		
		assertEquals(proy1.getEncuestasFinalizadas().get(0), enc3);
		assertEquals(proy1.getEncuestasFinalizadas().get(1), enc2);
		assertEquals(proy1.getEncuestasFinalizadas().get(2), enc1);
	}
	 
	
	@Test
	void testFinalizarProyecto() {
		ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>() ;
		listaPreguntas.add(preguntaAbierta) ;
		listaPreguntas.add(preguntaAbierta) ;
		Encuesta enc = new Encuesta(listaPreguntas) ;
		ArrayList<Encuesta> listaEncuestas = new ArrayList<Encuesta>() ;
		listaEncuestas.add(enc) ;
		listaEncuestas.add(enc) ;
		Proyecto proyecto = new Proyecto("asd","asd",listaEncuestas) ;
		proyecto.finalizarProyecto();
		assertTrue(proyecto.esFinalizado()) ;
	}
	
	@Test
	void testDosProyectosSeComparanSegunSuInicial() {
		Proyecto p1;
		Proyecto p2;
		
		String a = "a";
		String b = "b";
		
		p1 = mock(Proyecto.class);
		when(p1.getDescripcion()).thenReturn("b");
		
		p2 = mock(Proyecto.class);
		when(p2.getDescripcion()).thenReturn("a");
		
		assertEquals(p1.getDescripcion().compareTo(p2.getDescripcion()),1);
		
		/*
		 * si a1> a2, devuelve un número negativo

			si a1 <a2, devuelve un número positivo

			si a1 == a2, devuelve 0
		 */
	}
	
	@Test
	void testProyectoDevuelveLasEncuestasDelMismoAño() {
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>() ;
		preguntaAbierta = mock(PreguntaAbierta.class) ;
		lsPreguntas.add(preguntaAbierta) ;
		Encuesta enc = new Encuesta(lsPreguntas,2019) ; 
		lsEncuestas.add(enc) ; 
		lsEncuestas.add(enc) ; 
		Proyecto p = new Proyecto("asd","asd",lsEncuestas) ;
		
		assertEquals(p.getUltimasEncuestas(2019).size(),2) ;
	}

	@Test
	void testComparacionDeDosProyectos() {
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		Proyecto p = new Proyecto("b","asd",lsEncuestas) ;
		Proyecto p1 = new Proyecto("a","asd",lsEncuestas) ;
		assertEquals(p.compare(p1),1) ;
	}
	
}
