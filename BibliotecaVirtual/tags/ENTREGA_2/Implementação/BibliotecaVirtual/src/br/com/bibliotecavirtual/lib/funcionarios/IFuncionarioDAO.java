package br.com.bibliotecavirtual.lib.funcionarios;

import java.sql.SQLException;

public interface IFuncionarioDAO {

	public void atualizar (Funcionario funcionario) throws SQLException;
	public void inserir (Funcionario funcionario) throws SQLException;
	public Funcionario buscarPorMatricula (String matricula) throws SQLException;
	public Funcionario buscarPorID (int id) throws SQLException;
	public void remover (String matricula) throws SQLException;
	public boolean existe (String matricula) throws SQLException;


}
