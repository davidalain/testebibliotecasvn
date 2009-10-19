package br.com.bibliotecavirtual.lib.reservas;

import java.util.List;

import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorElementosEspera {
	private RepositorioElementosEspera repositorio;

	public ControladorElementosEspera(RepositorioElementosEspera repositorio) {
		super();
		this.repositorio = new RepositorioElementosEspera();
	}

	public boolean possuiFilaEspera(Livro livro) {
		ElementoReserva elemento = new ElementoReserva(null, "", livro.getIsbn());
		return (repositorio.buscar(elemento) != null);
	}

	public void cadastrar(ElementoReserva fila) {

	}

	public void remover(ElementoReserva fila) {

	}

	public boolean existe(ElementoReserva fila) {

	}

	public List<ElementoReserva> procurar(String livroId) {

	}

}
