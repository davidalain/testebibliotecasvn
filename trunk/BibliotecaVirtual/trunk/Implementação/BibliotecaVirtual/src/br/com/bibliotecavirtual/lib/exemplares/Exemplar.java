package br.com.bibliotecavirtual.lib.exemplares;

import br.com.bibliotecavirtual.lib.livros.Livro;

public class Exemplar {

	public Exemplar(Livro livro, String estado) {
		super();
		this.livro = livro;
		this.estado = estado;
	}

	public Exemplar(int id, Livro livro, String estado) {
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

	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
