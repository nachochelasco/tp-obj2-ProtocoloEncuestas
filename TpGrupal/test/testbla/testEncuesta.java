package testbla;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Activa;
import tpGrupal.Desactivada;
import tpGrupal.EnEdicion;
import tpGrupal.Encuesta;
import tpGrupal.EstadoDeEncuesta;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaConOpcionMultiple;
import tpGrupal.PreguntaConOpcionSimple;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;
import tpGrupal.Respuesta;
import tpGrupal.RespuestaAbierta;
import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;

class testEncuesta {  
	
	private Encuesta encuesta;
	
	private Pregunta pregunta;
	private PreguntaAbierta pregunta3;
	private RespuestaSimple respuestaSimple;
	private ArrayList<Pregunta> preguntas;
	private RespuestaMultiple respuestasFinales;
	
	private PreguntaConOpcionSimple preguSimple;
	private ArrayList<RespuestaSimple> respuestasPosibles = new ArrayList<RespuestaSimple>(); 
	
	private RespuestaMultiple rtaMultiple;
	private Proyecto proyecto1; 
	
	private RespuestaSimple rtaDet = new RespuestaSimple("enunciado");
	
	private PreguntaConOpcionSimple preguSimple1 ;
	
	@BeforeEach
	void setUp() throws Exception {
										
		rtaMultiple = new RespuestaMultiple(respuestasPosibles);
		rtaMultiple.agregarRespuesta(respuestaSimple);
		respuestasFinales = new RespuestaMultiple(respuestasPosibles);
	
		preguSimple = new PreguntaConOpcionSimple ("hola",respuestasPosibles, rtaDet);
		preguSimple1 = new PreguntaConOpcionSimple ("hola",respuestasPosibles, rtaDet);
		 
		pregunta = new PreguntaAbierta("asd?");
		pregunta3 = new PreguntaAbierta("asd?");
		respuestaSimple = new RespuestaSimple("asd1");
		preguntas = new ArrayList<Pregunta>();
		respuestasFinales.agregarRespuesta(respuestaSimple);
		
		preguntas.add(preguSimple);
		preguntas.add(preguSimple1);
		preguntas.add(pregunta);
		preguntas.add(pregunta3) ;
		preguntas.add(pregunta) ;
		preguntas.add(pregunta) ;

		encuesta = new Encuesta(preguntas);
	}
	
	@Test
	void testEncuestaSeInicializaConLaPrimerPreguntaProtocolar() {
		assertEquals(encuesta.getPreguntaActual(), preguSimple);
	}

		
	@Test 
	void testEncuestaContienePregunta() {
		assertTrue(encuesta.getPreguntas().contains(pregunta));
	}
	
	@Test
	void testConstructorAsignaLosValoresDeParametrosAAtributos() {
		assertEquals(encuesta.getPreguntas(), preguntas);
		assertEquals(encuesta.getPreguntaActual(), preguSimple);
	}
	
	@Test
	void testSetPreguntaActual() {
		encuesta.setPreguntaActual(pregunta);
		assertEquals (encuesta.getPreguntaActual(), pregunta ) ;
	}
	
	@Test
	void testEncuestaDevuelveSiguientePreguntaAResponder() {
		encuesta.setPreguntaActual(preguSimple);
		preguSimple.setindiceDeDesplazamiento(1);
		assertEquals (encuesta.getSiguientePregunta(), preguSimple1) ;
	}
	
	@Test
	void testEncuestaFinalizada() {
	
		ArrayList <Encuesta> encuestas = new ArrayList<Encuesta>();
		
		proyecto1 = new Proyecto("hola","chau", encuestas );
		encuesta.completarEn(proyecto1);
		
		assertTrue (proyecto1.getEncuestasFinalizadas().contains(encuesta));
	}
	
	@Test
	void testEncuestaFinalizadaNoEstaDisponible() {
		
		ArrayList <Encuesta> encuestas = new ArrayList<Encuesta>();
		
		proyecto1 = new Proyecto("hola","chau", encuestas );
		encuesta.completarEn(proyecto1);
		
		assertFalse (proyecto1.getEncuestasDisponibles().contains(encuesta));
	}
	
	@Test
	void testEncuestaLePuedeAsignarLaEncuestaDePertenenciaAUnaPregunta() {
		Pregunta preguntaA;
		Pregunta pregunta1;
		preguntaA = new PreguntaAbierta("enunciado");
		pregunta1 = new PreguntaAbierta("encunciaso");
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		preguntas.add(pregunta1);
		preguntas.add(preguntaA);
		Encuesta encuestaX = new Encuesta(preguntas);
		
		assertEquals(pregunta1.getEncuestaALaQuePertenece(), encuestaX);
		assertEquals(preguntaA.getEncuestaALaQuePertenece(), encuestaX);
	}
	
	@Test
	void testListaDePreguntasPuedenConocerAUnaEncuesta() {
		encuesta.setEncuestaParaPreguntas(preguntas);
		assertEquals(pregunta.getEncuestaALaQuePertenece(), encuesta);
		assertEquals(preguSimple.getEncuestaALaQuePertenece(), encuesta); 
	}
	 
	@Test
	void testProyectoOrdenaDeMasRespondidaAMenosRespondidaUnaEncuestaCuandoEstaSeFinaliza() {
		PreguntaAbierta preg1 = new PreguntaAbierta("p");
		
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
		
		enc1.completarEn(proy1);
		enc3.completarEn(proy1);
		enc3.completarEn(proy1); 
		
		enc2.completarEn(proy1);
		enc3.completarEn(proy1);
		
		enc2.completarEn(proy1);
		
		
		assertEquals(proy1.getEncuestasFinalizadas().get(0), enc3);
		assertEquals(proy1.getEncuestasFinalizadas().get(1), enc2);
		assertEquals(proy1.getEncuestasFinalizadas().get(2), enc1);
	}
	
	@Test
	void testSiguientePregunta() {
	  RespuestaSimple rtaDeterminante = new RespuestaSimple("respuesta") ;
	  PreguntaConOpcionSimple preg3 = new PreguntaConOpcionSimple("asd",respuestasPosibles,rtaDeterminante) ;
	  ArrayList<Pregunta> preguntas1 = new ArrayList<Pregunta>() ;
	  
	  preguntas1.add(preg3) ;
	  preguntas1.add(pregunta) ;
	  preguntas1.add(pregunta3) ;
	  
	  preg3.setindiceDeDesplazamiento(1);
	  
	  respuestasPosibles.add(rtaDeterminante) ;
	  respuestasPosibles.add(rtaDeterminante) ;
	  
	  Encuesta encuesta1 = new Encuesta(preguntas1) ;
	  
	  assertEquals(encuesta1.getSiguientePregunta(),pregunta) ;
	  
	}
	
	@Test
	void testRedireccionSiCumpleRespuestaEsperada() {
		 PreguntaAbierta pregunta1 = new PreguntaAbierta("asd") ;
		 PreguntaAbierta pregunta2 = new PreguntaAbierta("asd") ;
		 PreguntaAbierta pregunta4 = new PreguntaAbierta("asd") ;
		 RespuestaSimple rtaDeterminante = new RespuestaSimple("respuesta",3) ;
		 RespuestaSimple rtaNoDeterminante = new RespuestaSimple("respuesta") ;
		 PreguntaConOpcionSimple pregSimple = new PreguntaConOpcionSimple("asd",respuestasPosibles,rtaDeterminante) ;
		 ArrayList<Pregunta> preguntas1 = new ArrayList<Pregunta>() ;
		 
		 preguntas1.add(pregSimple) ;
		 preguntas1.add(pregunta1) ;
		 preguntas1.add(pregunta2) ;
		 preguntas1.add(pregunta1) ;
		 preguntas1.add(pregunta1) ;
		 
		 respuestasPosibles.add(rtaDeterminante) ;
		 respuestasPosibles.add(rtaNoDeterminante) ; 
		 ArrayList<Encuesta> encuestasPipi = new ArrayList<Encuesta>() ; 
		 Encuesta encuesta1 = new Encuesta(preguntas1) ;
		 encuestasPipi.add(encuesta1) ;
		 Proyecto proy = new Proyecto("s","a",encuestasPipi) ;
		 
		 encuesta1.setEstado();
		 
		 pregSimple.responder(rtaDeterminante);
		 
		 
		 assertEquals(encuesta1.getPreguntaActual(),pregunta1) ; 
	}
	
	@Test
	void testPreguntaGuardaRespuestaEnObjetoPreguntaRespuesta() {
		ArrayList<Pregunta> preguntas1 = new ArrayList<Pregunta>() ;
		 PreguntaAbierta p = new PreguntaAbierta("asd");
		 RespuestaSimple r = new RespuestaSimple("asd");
		 PreguntaRespuesta pr;
		 preguntas1.add(p) ;
		 preguntas1.add(p) ;
		 Encuesta encuesta2 = new Encuesta(preguntas1) ;
		 new PreguntaRespuesta(p,r);
		 //pr = p.responder(r);
		 
		// assertEquals(pr.getPregunta(), p);
		// assertEquals(pr.getDevolucion(), r);
	}
  
	@Test
	void testEncuestaSeInicializaEnEdicion() {
		Encuesta e = new Encuesta(preguntas);
		assertTrue(e.getEstado() instanceof EnEdicion );
	}
	
	@Test
	void testUnaEncuestaEnEdicionNoPuedeSerRespondida() { //ninguna pregunta que pertenezca a esta encuesta se peude responder
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		RespuestaAbierta rta = new RespuestaAbierta("rta");
		lsPreguntas.add(pregunta);
		Encuesta enc = new Encuesta(lsPreguntas);
		
		pregunta.responder(rta);
		
		assertTrue(enc.getPreguntasRespondidas().isEmpty());
		assertFalse(enc.puedeResponder());
	}
	
	@Test
	void testEncuestaPasaDeEstarEnEdicionAEstarActiva() {
		Encuesta e = new Encuesta(preguntas);
		e.setEstado();
		assertTrue(e.getEstado() instanceof Activa );
	}
	
	@Test
	void testUnaEncuestaActivaPuedeSerRespondida() {//cualquier pregunta que pertenezca a esta encuesta se peude responder
		
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		PreguntaAbierta pregunta2 = new PreguntaAbierta("enunciado");
		PreguntaAbierta preguntaBorde = new PreguntaAbierta("enunciado");
		RespuestaAbierta rta = new RespuestaAbierta("rta");
		
		RespuestaAbierta rtaBorde = new RespuestaAbierta("rta",0);
		lsPreguntas.add(pregunta);
		lsPreguntas.add(pregunta2);
		lsPreguntas.add(preguntaBorde);
		Encuesta enc = new Encuesta(lsPreguntas);
		ArrayList<Encuesta> encuestasPipi = new ArrayList<Encuesta>() ; 
		encuestasPipi.add(enc) ;
		Proyecto proy = new Proyecto("s","a",encuestasPipi) ;
		
		enc.setEstado();
		
		pregunta.responder(rta);
		pregunta2.responder(rta);
		preguntaBorde.responder(rtaBorde);
		
		assertEquals(enc.getPreguntasRespondidas().size(), 3);
		assertTrue(enc.puedeResponder());
	}
		
	@Test
	void testEncuestaPasaDeEstarActivaAEstarDesactivada() {
		Encuesta e = new Encuesta(preguntas);
		e.setEstado();
		e.setEstado();
		assertTrue(e.getEstado() instanceof Desactivada );
	}
	
	@Test
	void testUnaEncuestaDesactivadaQuedaPermanentementeEnEseEstado() {
		Encuesta e = new Encuesta(preguntas);
		e.setEstado();
		e.setEstado();
		e.setEstado();
		assertTrue(e.getEstado() instanceof Desactivada);
	}
	
	@Test
	void testUnaEncuestaDesactivadaNoPuedeSerRespondida() {//ninguna pregunta que pertenezca a esta encuesta se peude responder
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		PreguntaAbierta pregunta2 = new PreguntaAbierta("enunciado");
		PreguntaAbierta preguntaBorde = new PreguntaAbierta("enunciado");
		RespuestaAbierta rta = new RespuestaAbierta("rta");
		RespuestaAbierta rtaBorde = new RespuestaAbierta("rta");
		lsPreguntas.add(pregunta);
		lsPreguntas.add(pregunta2);
		lsPreguntas.add(preguntaBorde);
		
		Encuesta e = new Encuesta(lsPreguntas);
		e.setEstado();
		e.setEstado();
		
		pregunta.responder(rta);
		pregunta2.responder(rta);
		preguntaBorde.responder(rtaBorde);
		
		assertEquals(e.getPreguntasRespondidas().size(), 0);
		assertFalse(e.puedeResponder());
	}
	
	@Test
	void testCantidadPreguntasDeEncuesta() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		PreguntaAbierta pregunta2 = new PreguntaAbierta("enunciado");
		PreguntaAbierta preguntaBorde = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		lsPreguntas.add(pregunta2);
		lsPreguntas.add(preguntaBorde);
		Encuesta e = new Encuesta(lsPreguntas);
		assertEquals(e.getCantidadDePreguntas(),3) ;
	}
	
	@Test
	void testSePuedeAgregarUnaPreguntaALaEncuestaEnEdicion() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		PreguntaAbierta pregunta2 = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.agregarPregunta(pregunta2);
		
		assertTrue(e.getEstado() instanceof EnEdicion) ;
		assertEquals(e.getCantidadDePreguntas(),2) ;
	}
	
	
	
	@Test
	void testSePuedeEliminarUnaPreguntaALaEncuestaEnEdicion() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		PreguntaAbierta pregunta2 = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.eliminarPregunta(pregunta);
		
		assertTrue(e.getEstado() instanceof EnEdicion) ;
		assertEquals(e.getCantidadDePreguntas(),1) ;
	}
	 
	@Test
	void testAUnaEncuestaActivaNoSePuedeAgregarPreguntas() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.setEstado();
		e.agregarPregunta(pregunta);
		//e.eliminarPregunta(pregunta);
		
		assertTrue(e.getEstado() instanceof Activa ) ; 
		assertEquals(e.getPreguntas(), lsPreguntas) ;
	}
	
	@Test
	void testAUnaEncuestaActivaNoSePuedeEliminarPreguntas() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.setEstado();
		//e.agregarPregunta(pregunta);
		e.eliminarPregunta(pregunta);
		
		assertTrue(e.getEstado() instanceof Activa ) ; 
		assertEquals(e.getPreguntas(), lsPreguntas) ;
	}
	
	@Test
	void testAUnaEncuestaDesactivadaNoSeLePuedeAgregarPregunta() {
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.setEstado();
		e.setEstado();
		e.agregarPregunta(pregunta);
		
		assertTrue(e.getEstado() instanceof Desactivada ) ; 
		assertEquals(e.getPreguntas(), lsPreguntas) ;
	}
	
	@Test
	void testAUnaEncuestaDesactivadaNoSeLePuedeEliminarPregunta() { 
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		lsPreguntas.add(pregunta);
		Encuesta e = new Encuesta(lsPreguntas);
		e.setEstado();
		e.setEstado();
		e.eliminarPregunta(pregunta);
		
		assertTrue(e.getEstado() instanceof Desactivada ) ; 
		assertEquals(e.getPreguntas(), lsPreguntas) ;
	}
	
	
}
