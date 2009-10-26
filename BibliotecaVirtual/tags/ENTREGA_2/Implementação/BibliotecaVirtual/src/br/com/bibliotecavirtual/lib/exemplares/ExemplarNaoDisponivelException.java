package br.com.bibliotecavirtual.lib.exemplares;

public class ExemplarNaoDisponivelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExemplarNaoDisponivelException() {
		super("Exemplar não disponível!");
	}
}
