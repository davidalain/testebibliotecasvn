package controlador;

import basicas.Exemplar;
import repositorio.RepositorioExemplares;

public class ControladorExemplares {
	
	private RepositorioExemplares repExemplares;
	
	public boolean existeExemplarDisponivel(Exemplar exemplar){
		return !(repExemplares.existeFilaEspera(exemplar));
	}

}
