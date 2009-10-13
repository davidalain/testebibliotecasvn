package br.com.bibliotecavirtual.lib.exemplares;


public class ControladorExemplares {

	private RepositorioExemplares repExemplares;

	public boolean existeExemplarDisponivel(Exemplar exemplar) {
		return !(repExemplares.existeFilaEspera(exemplar));
	}

}
