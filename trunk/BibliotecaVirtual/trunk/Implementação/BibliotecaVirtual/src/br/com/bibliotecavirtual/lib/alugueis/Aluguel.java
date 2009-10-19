package br.com.bibliotecavirtual.lib.alugueis;

import java.sql.Date;

public class Aluguel {
	private String idAluno;
	private String idFuncionario;
	private String idExemplar;
	private Date dataAluguel;
	private Date dataDevolucao;

	public Aluguel(String idAluno, String idExemplar, String idFuncionario,
			Date dataAluguel, Date dataDevolucao) {
		this.idAluno = idAluno;
		this.idExemplar = idExemplar;
		this.idFuncionario = idFuncionario;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	public String getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(String idExemplar) {
		this.idExemplar = idExemplar;
	}

	public String getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
