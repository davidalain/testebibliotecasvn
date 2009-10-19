package fachada;

import java.sql.SQLException;

import br.com.bibliotecavirtual.devolucoes.ControladorDevolucao;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;
import br.com.bibliotecavirtual.lib.exemplares.ControladorExemplar;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class Fachada {
	private static Fachada instance;

	private ControladorAluno controladorAluno;
	private ControladorExemplar controladorExemplar;
	private ControladorDevolucao controladorDevolucao;

	private Fachada() {
		this.controladorAluno = new ControladorAluno();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public boolean validarSituacaoCadastralAluno(String matricula)
			throws SQLException {
		return this.controladorAluno.validarSituacaoCadastral(matricula);
	}

	public void cadastrarAluno(Aluno a) throws SQLException {
		this.controladorAluno.cadastrarAluno(a);
	}

	public boolean existeExemplarDisponivel(Exemplar exemplar)
			throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		int numExemplares = controladorExemplar.quantidadeExemplares(exemplar);
		int numAlugueis = controladorAluguel.quantidadeAlugueis(exemplar);
		int numDevolucoes = controladorDevolucao.quantidadeDevolucao(exemplar);

		return (numAlugueis - numDevolucoes < numExemplares);
	}

}
