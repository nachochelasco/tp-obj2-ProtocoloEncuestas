package testbla;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;

class testRespuesta {
	
	private RespuestaSimple rta1;
	private RespuestaSimple rta2;
	private RespuestaSimple rta3;
	private RespuestaMultiple rtaMul;
	private ArrayList<RespuestaSimple> lsRespuestas = new ArrayList<RespuestaSimple>();

	@BeforeEach
	void setUp() throws Exception {
		rta1 = new RespuestaSimple("rta");
		rta2 = new RespuestaSimple("rta2");
		rta3 = new RespuestaSimple("rta3");
		rtaMul = new RespuestaMultiple(lsRespuestas);
		
		rtaMul.agregarRespuesta(rta1);
		rtaMul.agregarRespuesta(rta2);
		rtaMul.agregarRespuesta(rta3);
	}
	

	@Test
	void testSeAgreganLasRespuestas() {
		
		
		assertEquals(rtaMul.cantidadDeRespuestas(), 3);
	}
	
	@Test
	void testRespuestaMultipleDevuelveLaListaDeRespuestas() {
		assertTrue(rtaMul.getRespuestas().contains(rta1));
		assertTrue(rtaMul.getRespuestas().contains(rta2));
		assertTrue(rtaMul.getRespuestas().contains(rta3));
	} 

	@Test
	void testRespuestaSimpleDevuelveUnString() {
		assertEquals(rta1.getRespuesta(), "rta");
	}

}
