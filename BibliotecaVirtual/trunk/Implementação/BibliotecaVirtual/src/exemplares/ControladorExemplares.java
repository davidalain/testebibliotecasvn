package exemplares;


public class ControladorExemplares {

	private RepositorioExemplares repExemplares;

	public boolean existeExemplarDisponivel(Exemplar exemplar) {
		return !(repExemplares.existeFilaEspera(exemplar));
	}

}
