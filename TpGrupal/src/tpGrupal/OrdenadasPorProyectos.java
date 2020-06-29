package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenadasPorProyectos  implements Criterio{

	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i){
		ArrayList<Encuesta> lsRet = new ArrayList<Encuesta>();
		
		Collections.sort(i.getProyectos(),(o1, o2) -> o1.getDescripcion().compareTo(o2.getDescripcion()));
		
		for(Proyecto p : i.getProyectos()){
			lsRet.addAll(p.getEncuestasDisponibles());
		}
		
		return lsRet; 
	}

	
}
