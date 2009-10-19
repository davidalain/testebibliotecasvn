package br.com.bibliotecavirtual.lib.alugueis;



import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;

public class Aluguel 
{
	private int id;
	private Aluno aluno;
	private Funcionario funcionario;
	private Exemplar exemplar;
	private Data dataAluguel;
	private Data dataDevolucao;

	public Aluguel()
	{
		
	}
	
	public Aluguel(int id, Aluno aluno, Exemplar exemplar, Funcionario funcionario,
			Data dataAluguel, Data dataDevolucao)
	{
		this.id = id;
		this.aluno = aluno;
		this.exemplar = exemplar;
		this.funcionario = funcionario;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Aluguel(Aluno aluno, Exemplar exemplar, Funcionario funcionario,
			Data dataAluguel, Data dataDevolucao) {
		this.aluno = aluno;
		this.exemplar = exemplar;
		this.funcionario = funcionario;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setDataAluguel(Data dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	
}
