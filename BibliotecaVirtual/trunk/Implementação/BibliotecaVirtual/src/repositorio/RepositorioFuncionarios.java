package repositorio;

import basicas.Funcionario;

public class RepositorioFuncionarios {
	private BancoDados bancoDados;
	
	public void inserir(Funcionario f)
	{
		bancoDados.inserir(f);
	}
	
}
