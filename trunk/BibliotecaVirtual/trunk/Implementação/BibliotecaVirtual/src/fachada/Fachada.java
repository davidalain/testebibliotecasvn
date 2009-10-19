package fachada;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.alugueis.ControladorAluguel;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;
import br.com.bibliotecavirtual.lib.devolucoes.ControladorDevolucao;
import br.com.bibliotecavirtual.lib.exemplares.ControladorExemplar;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class Fachada {
	private static Fachada instance;

	private ControladorAluno controladorAluno;
	private ControladorExemplar controladorExemplar;
	private ControladorDevolucao controladorDevolucao;
	private ControladorAluguel controladorAluguel;

	private Fachada() {
		this.controladorAluno = new ControladorAluno();
		this.controladorExemplar = new ControladorExemplar();
		this.controladorDevolucao = new ControladorDevolucao();
		this.controladorAluguel = new ControladorAluguel();
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
		int numExemplares = controladorExemplar.quantidadeExemplares(exemplar);
		int numAlugueis = controladorAluguel.quantidade(exemplar);
		int numDevolucoes = controladorDevolucao.quantidadeDevolucao(exemplar);

		return (numAlugueis - numDevolucoes < numExemplares);
	}

}
