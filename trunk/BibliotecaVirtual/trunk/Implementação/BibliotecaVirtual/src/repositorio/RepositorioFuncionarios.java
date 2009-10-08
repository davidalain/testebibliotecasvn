package repositorio;

import basicas.Aluno;
import basicas.Funcionario;

public class RepositorioFuncionarios {
	private BancoDados bancoDados;
	
	public void inserir (Funcionario funcionario){
		bancoDados.inserir(funcionario);
		
	}
	
	public void remover (Funcionario funcionario){
		bancoDados.remover(funcionario);
	}
	
	public Aluno buscar (Funcionario funcionario){
		return bancoDados.buscar(funcionario);
		
	}
	
	public void atualizar (Funcionario funcionario){
		bancoDados.atualizar(funcionario);
		
	}
	
}
