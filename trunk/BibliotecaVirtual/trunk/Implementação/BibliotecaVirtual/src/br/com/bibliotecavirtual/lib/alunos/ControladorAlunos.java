package br.com.bibliotecavirtual.lib.alunos;

public class ControladorAlunos {
	private AlunoDAO repAlunos;

	public ControladorAlunos() {
		this.repAlunos = new AlunoDAO();
	}

	public boolean validarSituacaoCadastral(Aluno aluno) {

		/*if (repAlunos.buscar(aluno) == null) {
			return false;
		}*/
		return true;
	}

	public boolean validarSituacaoFinanceira(Aluno aluno) {
		// ?????
		return true;
	}

}
