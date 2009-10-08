package repositorio;

import basicas.Funcionario;

public class RepositorioFuncionarios {
	private BancoDados bancoDados;
	
	public RepositorioFuncionarios()
	{
		
	}
	
	public void inserir (Funcionario funcionario){
		bancoDados.inserir(funcionario);
		
	}
	
	public void remover (Funcionario funcionario){
		bancoDados.remover(funcionario);
	}
	
	public Funcionario buscar (Funcionario funcionario){
		return bancoDados.buscar(funcionario);
		
	}
	
	public void atualizar (Funcionario funcionario){
		bancoDados.atualizar(funcionario);
		
	}
	
}
