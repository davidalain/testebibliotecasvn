package br.com.bibliotecavirtual.lib.filaEspera;

import java.util.List;

import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorElementosEspera {
	private RepositorioElementosEspera repositorio;

	public ControladorElementosEspera(RepositorioElementosEspera repositorio) {
		super();
		this.repositorio = new RepositorioElementosEspera();
	}

	public boolean possuiFilaEspera(Livro livro) {
		ElementoEspera elemento = new ElementoEspera(null, "", livro.getIsbn());
		return (repositorio.buscar(elemento) != null);
	}

	public void cadastrar(ElementoEspera fila) {

	}

	public void remover(ElementoEspera fila) {

	}

	public boolean existe(ElementoEspera fila) {

	}

	public List<ElementoEspera> procurar(String livroId) {

	}

}
