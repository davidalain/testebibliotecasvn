package br.com.bibliotecavirtual.lib.exemplares;

import br.com.bibliotecavirtual.lib.livros.Livro;

public class Exemplar {

	public Exemplar(Livro livro, int estado) {
		super();
		this.livro = livro;
		this.estado = estado;
	}

	public Exemplar(int id, Livro livro, int estado) {
		super();
		this.id = id;
		this.livro = livro;
		this.estado = estado;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Livro livro;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	private int estado;

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
