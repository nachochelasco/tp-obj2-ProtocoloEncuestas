package testbla;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Criterio;
import tpGrupal.Encuesta;
import tpGrupal.Investigador;
import tpGrupal.OrdenadasPorProyectos;
import tpGrupal.Proyecto;
import tpGrupal.VeinteCreadasUltimamente;
import tpGrupal.VeinticincoMasUsadas;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class testCriterio {

	private Investigador i;
	private Proyecto pA;
	private Proyecto pB;
	private Proyecto pC;
	private ArrayList<Proyecto> lsProy = new ArrayList<Proyecto>();
	private ArrayList<Encuesta> lsEnc1 = new ArrayList<Encuesta>();
	private ArrayList<Encuesta> lsEnc = new ArrayList<Encuesta>();
	private Encuesta e1;
	private Encuesta e2;
	private Encuesta e3;
	private Encuesta e4;
	private Encuesta e5;
	private Encuesta e6;
	private Encuesta e7;
	private Encuesta e8;
	private Encuesta e9;
	private Encuesta e10;
	private Encuesta e11;
	private Encuesta e12;
	private Encuesta e13;
	private Encuesta e14;
	private Encuesta e15;
	private Encuesta e16;
	private Encuesta e17;
	private Encuesta e18;
	private Encuesta e19;
	private Encuesta e20;
	private Encuesta e21;
	private Encuesta e22;
	private Encuesta e23;
	private Encuesta e24;
	private Encuesta e25;
	private Encuesta e26;
	private Encuesta e27;
	private Encuesta e28;
	
	private Criterio ordenadasPorProyectos = new OrdenadasPorProyectos();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		e1 = mock(Encuesta.class);
		e2 = mock(Encuesta.class);
		e3 = mock(Encuesta.class);
		
		lsEnc.add(e1);
		lsEnc.add(e2);
		lsEnc.add(e3);
		
		pA = mock(Proyecto.class);
		when(pA.getDescripcion()).thenReturn("a");	
		when(pA.getEncuestasDisponibles()).thenReturn(lsEnc);
		
		pB = mock(Proyecto.class);
		when(pB.getDescripcion()).thenReturn("b");
		when(pB.getEncuestasDisponibles()).thenReturn(lsEnc);
		
		pC = mock(Proyecto.class);
		when(pC.getDescripcion()).thenReturn("c");
		when(pC.getEncuestasDisponibles()).thenReturn(lsEnc);
		

		lsProy.add(pB);
		lsProy.add(pC);
		lsProy.add(pA);
		
		i = new Investigador(lsProy);
	}

	@Test
	void testCriterioDeEncuestasOrdenadasPorProyectosOrdenaLaListaDeProyectosAlfabeticamente() {
		i.ordenarSegun(ordenadasPorProyectos);
		
		assertEquals(i.getProyectos().get(0), pA);
		assertEquals(i.getProyectos().get(1), pB);
		assertEquals(i.getProyectos().get(2), pC);
	}
	
	
	/*@Test
	void testCriterioDeEncuestas20CreadasUltimamente() {
		ArrayList<Encuesta> lsAux ;
		VeinteCreadasUltimamente veinteCreadas = new VeinteCreadasUltimamente() ;
		i = new Investigador(lsProy);
		
		pA = mock(Proyecto.class);	
		when(pA.getEncuestasDisponibles()).thenReturn(lsEnc);
		
		pB = mock(Proyecto.class);
		when(pB.getEncuestasDisponibles()).thenReturn(lsEnc1);
		
		lsProy.add(pB);
		lsProy.add(pA);
		
		e1 = mock(Encuesta.class);
		when(e1.getAñoCreacion()).thenReturn(2019);
		e2 = mock(Encuesta.class);
		when(e2.getAñoCreacion()).thenReturn(2018);
		e3 = mock(Encuesta.class);
		when(e3.getAñoCreacion()).thenReturn(2017);
		
		
		lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ;
		lsEnc.add(e1);lsEnc.add(e1) ; lsEnc.add(e1);lsEnc.add(e2) ; lsEnc.add(e2); lsEnc.add(e2) ;
		lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ;
		
		lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ;
		lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ;
		lsEnc1.add(e3) ; lsEnc1.add(e3) ; lsEnc1.add(e3) ; lsEnc1.add(e3) ;
		
		
		i.ordenarSegun(veinteCreadas) ;
		lsAux = veinteCreadas.devolverEncuestasPorCriterio(i) ;
		assertEquals(lsAux.size(),20) ;
	}
	*/
	
	@Test
	void testVeinticincoMasUsadasDevuelveLasVeinticincoMasUsadas() {

	ArrayList<Proyecto> lsProyectos = new ArrayList <Proyecto>();

	ArrayList<Encuesta> encuestasFinalizadasRepetidas1 = new ArrayList<Encuesta>();
	ArrayList<Encuesta> encuestasFinalizadasRepetidas2 = new ArrayList<Encuesta>();

	e1 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(14) ;
	e2 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(12) ;
	e3 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(6) ;
	e4 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(7) ;
	e5 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(5) ;
	e6 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(8) ;
	e7 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(9) ;
	e8 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e9 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(4) ;
	e10 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(3) ;
	e11 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e12 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e13 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e14 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e15 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(2) ;
	e16 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(10) ;
	e17 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(4) ;
	e18 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(32) ;
	e19 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(20) ;
	e20 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(6) ;
	e21 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(0) ;
	e22 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(0) ;
	e23 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(0) ;
	e24 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(18) ;
	e25 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(12) ;
	e26 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(16) ;
	e27 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(3) ;
	e28 = mock(Encuesta.class);
	when(e1.getCantidadDeUsos()).thenReturn(0) ;


	encuestasFinalizadasRepetidas1.add(e1);

	encuestasFinalizadasRepetidas1.add(e2);
	encuestasFinalizadasRepetidas1.add(e2);

	encuestasFinalizadasRepetidas1.add(e3);
	encuestasFinalizadasRepetidas1.add(e3);
	encuestasFinalizadasRepetidas1.add(e3);

	encuestasFinalizadasRepetidas1.add(e4);
	encuestasFinalizadasRepetidas1.add(e4);
	encuestasFinalizadasRepetidas1.add(e4);
	encuestasFinalizadasRepetidas1.add(e4);
	encuestasFinalizadasRepetidas1.add(e4);

	encuestasFinalizadasRepetidas1.add(e5);
	encuestasFinalizadasRepetidas1.add(e5);


	encuestasFinalizadasRepetidas1.add(e6);
	encuestasFinalizadasRepetidas1.add(e6);
	encuestasFinalizadasRepetidas1.add(e6);


	encuestasFinalizadasRepetidas1.add(e7);
	encuestasFinalizadasRepetidas1.add(e7);
	encuestasFinalizadasRepetidas1.add(e7);


	encuestasFinalizadasRepetidas1.add(e8);


	encuestasFinalizadasRepetidas1.add(e9);
	encuestasFinalizadasRepetidas1.add(e9);

	encuestasFinalizadasRepetidas1.add(e10);
	encuestasFinalizadasRepetidas1.add(e10);

	encuestasFinalizadasRepetidas1.add(e11);
	encuestasFinalizadasRepetidas1.add(e11);

	encuestasFinalizadasRepetidas1.add(e12);

	encuestasFinalizadasRepetidas1.add(e13);

	encuestasFinalizadasRepetidas1.add(e14);

	encuestasFinalizadasRepetidas1.add(e15);

	encuestasFinalizadasRepetidas1.add(e16);

	encuestasFinalizadasRepetidas1.add(e17);

	encuestasFinalizadasRepetidas1.add(e18);

	encuestasFinalizadasRepetidas1.add(e19);

	encuestasFinalizadasRepetidas1.add(e20);

	encuestasFinalizadasRepetidas1.add(e21);

	encuestasFinalizadasRepetidas1.add(e22);

	encuestasFinalizadasRepetidas1.add(e23);

	encuestasFinalizadasRepetidas1.add(e25);

	encuestasFinalizadasRepetidas1.add(e24); 

	encuestasFinalizadasRepetidas2.add(e2);

	encuestasFinalizadasRepetidas2.add(e2);

	encuestasFinalizadasRepetidas2.add(e2);

	encuestasFinalizadasRepetidas2.add(e2);

	pA = mock(Proyecto.class);
	when(pA.getEncuestasFinalizadasRepetidas()).thenReturn(encuestasFinalizadasRepetidas1);

	pB = mock(Proyecto.class);
	when(pB.getEncuestasFinalizadasRepetidas()).thenReturn(encuestasFinalizadasRepetidas2);

	lsProyectos.add(pA);

	lsProyectos.add(pB);

	i = new Investigador(lsProyectos);

	VeinticincoMasUsadas veinticinco = new VeinticincoMasUsadas();

	i.ordenarSegun(veinticinco);

	assertEquals(veinticinco.devolverEncuestasPorCriterio(i).size() , 25);
	//assertEquals(veinticinco.devolverEncuestasPorCriterio(i).get(0), e18);


	}
	
	@Test
	void testCriterio() {
		OrdenadasPorProyectos oPP = new OrdenadasPorProyectos() ;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>() ;
		pA = mock(Proyecto.class);
		pB = mock(Proyecto.class);
		proyectos.add(pA) ;
		proyectos.add(pB) ;
		
		Investigador i = new Investigador(proyectos) ;
		i.setCriterioDeOrdenamiento(oPP);
		
		assertTrue(i.getCriterioDeOrdenamiento() instanceof OrdenadasPorProyectos) ;
	}
	

}
