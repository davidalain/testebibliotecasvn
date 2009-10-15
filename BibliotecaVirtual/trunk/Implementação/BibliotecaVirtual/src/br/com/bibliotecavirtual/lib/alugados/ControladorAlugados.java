package br.com.bibliotecavirtual.lib.alugados;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.AlunoDevendoException;
import br.com.bibliotecavirtual.lib.alunos.AlunoNaoCadastradoException;
import br.com.bibliotecavirtual.lib.alunos.ControladorAlunos;
import br.com.bibliotecavirtual.lib.exemplares.ControladorExemplares;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.exemplares.ExemplarNaoDisponivelException;

public class ControladorAlugados {
	ControladorAlunos ctrlAluno;
	ControladorExemplares ctrlExemplares;

	public ControladorAlugados() {

	}

	public void Alugar(Aluno aluno, Exemplar exemplar)
			throws AlunoNaoCadastradoException, AlunoDevendoException,
			ExemplarNaoDisponivelException {
		if (!ctrlAluno.validarSituacaoCadastral(aluno))
			throw new AlunoNaoCadastradoException();

		if (!ctrlAluno.validarSituacaoFinanceira(aluno))
			throw new AlunoDevendoException(aluno.getDivida());

		if (!ctrlExemplares.existeExemplarDisponivel(exemplar))
			throw new ExemplarNaoDisponivelException();

	}
}
