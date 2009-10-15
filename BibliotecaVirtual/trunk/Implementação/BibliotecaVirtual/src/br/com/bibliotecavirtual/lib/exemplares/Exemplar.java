package br.com.bibliotecavirtual.lib.exemplares;

import bir.com.bibliotecavirtual.lib.livros.Livro;

public class Exemplar extends Livro {
	private int idExemplar;

	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}

	public int getIdExemplar() {
		return idExemplar;
	}
}
