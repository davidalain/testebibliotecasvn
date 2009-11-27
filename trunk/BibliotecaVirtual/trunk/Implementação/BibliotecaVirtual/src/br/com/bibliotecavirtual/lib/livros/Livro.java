package br.com.bibliotecavirtual.lib.livros;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private String isbn;
	private String area;
	private int ano;
	private String resumo;

	public Livro(int id, String titulo, String autor, String isbn, String area,
			int ano, String resumo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.area = area;
		this.ano = ano;
		this.resumo = resumo;
	}

	public Livro(String titulo, String autor, String isbn, String area,
			int ano, String resumo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.area = area;
		this.ano = ano;
		this.resumo = resumo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
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

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}
}
