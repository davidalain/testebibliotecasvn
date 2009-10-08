package controlador;

import repositorio.RepositorioExemplares;
import basicas.Exemplar;

public class ControladorExemplares {

	private RepositorioExemplares repExemplares;

	public boolean existeExemplarDisponivel(Exemplar exemplar) {
		return !(repExemplares.existeFilaEspera(exemplar));
	}

}
