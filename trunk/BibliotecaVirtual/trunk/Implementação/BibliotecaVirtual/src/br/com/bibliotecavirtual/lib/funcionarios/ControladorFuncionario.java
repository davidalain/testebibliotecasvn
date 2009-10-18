package br.com.bibliotecavirtual.lib.funcionarios;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.sqlserver.SqlServerDAOFactory;

public class ControladorFuncionario {
	
	private IFuncionarioDAO repositorioFuncionario;
	
	public ControladorFuncionario(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.repositorioFuncionario = factory.getFuncionarioDAO();
	}
	
	
	public void Cadastrar(Funcionario funcionario) throws SQLException{
		if (this.repositorioFuncionario.existe(funcionario.getCpf())){
			
		}
		else{
			this.repositorioFuncionario.inserir(funcionario);
		}
		
	}

}
