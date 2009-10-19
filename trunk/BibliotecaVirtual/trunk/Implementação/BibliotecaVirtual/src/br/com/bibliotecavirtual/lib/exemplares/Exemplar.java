package br.com.bibliotecavirtual.lib.exemplares;

public class Exemplar {
	public Exemplar(int idLivro, String estado) {
		this.idLivro = idLivro;
		this.estado = estado;
	}

	public Exemplar(int id, int idLivro, String estado) {
		this.id = id;
		this.idLivro = idLivro;
		this.estado = estado;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	private int idLivro;
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
