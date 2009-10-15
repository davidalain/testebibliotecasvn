package br.com.bibliotecavirtual.lib.filaEspera;

import java.sql.Date;

public class ElementoEspera {
	private Date data;
	private String alunoId;
	private String livroId;
	
	public ElementoEspera(Date data, String alunoId, String livroId) {
		super();
		this.data = data;
		this.alunoId = alunoId;
		this.livroId = livroId;
	}
	public String getLivroId() {
		return livroId;
	}
	public void setLivroId(String livroId) {
		this.livroId = livroId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(String alunoId) {
		this.alunoId = alunoId;
	}
	
	
	

}
