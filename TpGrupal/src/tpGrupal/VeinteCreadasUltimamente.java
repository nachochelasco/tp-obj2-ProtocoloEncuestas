package tpGrupal;

import java.util.ArrayList;
import java.util.Calendar;

public class VeinteCreadasUltimamente  implements Criterio {
	
	public Integer getAñoActual(Integer año) {
		return año ;
	}

	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i) {
		Calendar cal = Calendar.getInstance() ; 
		int fecha = cal.get(Calendar.YEAR) ;
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		/*while(lsEncuestas.size() < 20 ) {
			lsEncuestas = this.ultimasEncuestasDeCadaProyectoSegunElAño(i,fecha) ;
			fecha -= 1 ;	
			}
		return this.recortarLista(lsEncuestas) ;			
		}

	
	private ArrayList<Encuesta> recortarLista(ArrayList<Encuesta> lsEncuestas) {
		ArrayList<Encuesta> lsEncuestas1 = lsEncuestas ;
			while ( lsEncuestas1.size() > 20 ) {
				lsEncuestas1.remove(lsEncuestas1.size()-1) ;
			}
		return lsEncuestas1 ;
	}

	
	
	public ArrayList<Encuesta> ultimasEncuestasDeCadaProyectoSegunElAño(Investigador i,Integer fecha) {
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
			for ( Proyecto p : i.getProyectos() ) {
				if (  lsEncuestas.size() < 20 ) {
					lsEncuestas.addAll(p.getUltimasEncuestas(fecha)) ;
				}
			}
		return lsEncuestas ;	
	}
	*/
		return lsEncuestas;
	}
}
