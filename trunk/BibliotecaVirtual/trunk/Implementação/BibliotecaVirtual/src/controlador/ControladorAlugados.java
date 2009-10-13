package controlador;

import alunos.Aluno;
import alunos.ControladorAluno;
import exceptions.AlunoDevendoException;
import exceptions.AlunoNaoCadastradoException;
import exceptions.ExemplarNaoDisponivelException;
import exemplares.ControladorExemplares;
import exemplares.Exemplar;

public class ControladorAlugados {
	ControladorAluno ctrlAluno;
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
