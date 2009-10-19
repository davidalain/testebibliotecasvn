package br.com.bibliotecavirtual.lib.sqlserver;

import br.com.bibliotecavirtual.lib.alunos.AlunoDAO;
import br.com.bibliotecavirtual.lib.alunos.IAlunoDAO;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.exemplares.ExemplarDAO;
import br.com.bibliotecavirtual.lib.exemplares.IExemplarDAO;
import br.com.bibliotecavirtual.lib.funcionarios.FuncionarioDAO;
import br.com.bibliotecavirtual.lib.funcionarios.IFuncionarioDAO;
import br.com.bibliotecavirtual.lib.livros.ILivroDAO;
import br.com.bibliotecavirtual.lib.livros.LivroDAO;

public class SqlServerDAOFactory extends DAOFactory {
	public IConexao getConexao() {
		return Conexao.getInstance();
	}

	@Override
	public IAlunoDAO getAlunoDAO() {
		return new AlunoDAO();
	}

	public IFuncionarioDAO getFuncionarioDAO() {
		return new FuncionarioDAO();
	}

	@Override
	public ILivroDAO getLivroDAO() {
		return new LivroDAO();
	}

	public IExemplarDAO getExemplarDAO() {
		return new ExemplarDAO();
	}

}
