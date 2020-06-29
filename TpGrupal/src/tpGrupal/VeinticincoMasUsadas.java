package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class VeinticincoMasUsadas implements Criterio {

	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i) {
		ArrayList<Encuesta> veinticincoMasUsadasArray = new ArrayList<Encuesta>() ;
		HashSet<Encuesta> veinticincoMasUsadas = new HashSet<Encuesta>() ;
		ArrayList<Encuesta> todasLasEncuestas = new ArrayList<Encuesta>() ;
			for ( Proyecto p : i.getProyectos() ) {
				todasLasEncuestas.addAll(p.getEncuestasFinalizadasRepetidas()) ;
			}
			
			for ( Encuesta e : todasLasEncuestas ) {
				veinticincoMasUsadas.add(e) ;
			}
			
			for ( Encuesta e : veinticincoMasUsadas ) {
				veinticincoMasUsadasArray.add(e) ;
			}
			
			Collections.sort(veinticincoMasUsadasArray, (e1, e2) -> e1.getCantidadDeUsos().compareTo(e1.getCantidadDeUsos()));
			
			
			
		return veinticincoMasUsadasArray; 
	}

}
