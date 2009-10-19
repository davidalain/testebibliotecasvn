package br.com.bibliotecavirtual.lib.alugueis;



import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;

public class Aluguel {
	private Aluno aluno;
	private Funcionario funcionario;
	private Exemplar exemplar;
	private Date dataAluguel;
	private Date dataDevolucao;

	public Aluguel(Aluno aluno, Exemplar exemplar, Funcionario funcionario,
			Date dataAluguel, Date dataDevolucao) {
		this.aluno = aluno;
		this.exemplar = exemplar;
		this.funcionario = funcionario;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
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
