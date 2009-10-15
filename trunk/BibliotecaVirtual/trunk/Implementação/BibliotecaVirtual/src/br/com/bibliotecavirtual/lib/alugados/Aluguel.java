package br.com.bibliotecavirtual.lib.alugados;

import java.sql.Date;

public class Aluguel {
	private String idAluno;
	private String idFuncionario;
	private String idLivro;
	private Date dataAluguel;
	private Date dataDevolucao;

	public Aluguel(String idAluno, String idLivro, String idFuncionario,
			Date dataAluguel, Date dataDevolucao) {
		this.idAluno = idAluno;
		this.idLivro = idLivro;
		this.idFuncionario = idFuncionario;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	public String getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
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
