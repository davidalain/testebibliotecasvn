package br.com.bibliotecavirtual.lib.exemplares;

public class Exemplar {
	public Exemplar(int idExemplar, String isbn, String estado) {
		this.idExemplar = idExemplar;
		this.isbn = isbn;
		this.estado = estado;
	}

	private int idExemplar;
	private String isbn;
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}

	public int getIdExemplar() {
		return idExemplar;
	}
}
