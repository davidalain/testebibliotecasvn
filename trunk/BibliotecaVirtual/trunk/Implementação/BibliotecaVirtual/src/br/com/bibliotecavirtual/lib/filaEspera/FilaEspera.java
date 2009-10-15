package br.com.bibliotecavirtual.lib.filaEspera;

import java.sql.Date;

public class FilaEspera {
	private Date data;
	private String alunoId;
	private String funcionarioID;
	public FilaEspera(Date data, String alunoId, String funcionarioID) {
		super();
		this.data = data;
		this.alunoId = alunoId;
		this.funcionarioID = funcionarioID;
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
	public String getFuncionarioID() {
		return funcionarioID;
	}
	public void setFuncionarioID(String funcionarioID) {
		this.funcionarioID = funcionarioID;
	}
	
	
	

}
