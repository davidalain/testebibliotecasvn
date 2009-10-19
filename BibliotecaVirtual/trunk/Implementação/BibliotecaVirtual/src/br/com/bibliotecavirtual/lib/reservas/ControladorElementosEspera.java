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
		Reserva elemento = new Reserva(null, "", livro.getIsbn());
		return (repositorio.buscar(elemento) != null);
	}

	public void cadastrar(Reserva fila) {

	}

	public void remover(Reserva fila) {

	}

	public boolean existe(Reserva fila) {

	}

	public List<Reserva> procurar(String livroId) {

	}

}
