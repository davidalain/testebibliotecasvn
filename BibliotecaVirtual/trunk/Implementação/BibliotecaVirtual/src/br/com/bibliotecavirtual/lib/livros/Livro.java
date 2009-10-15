package br.com.bibliotecavirtual.lib.livros;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private String area;
	private String ano;

	public Livro(String titulo, String autor, String isbn, String area,
			String ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.area = area;
		this.ano = ano;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAno() {
		return ano;
	}
}
