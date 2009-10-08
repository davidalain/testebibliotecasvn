package repositorio;

import basicas.Endereco;

public class RepositorioEnderecos {
	
	private BancoDados bancoDados;
	
	public RepositorioEnderecos(BancoDados bancoDados) {
		super();
		this.bancoDados = bancoDados;
	}

	public void inserir (Endereco endereco){
		bancoDados.inserir(endereco);
		
	}
	
	public void remover (Endereco endereco){
		bancoDados.remover(endereco);
	}
	
	public Endereco buscar (Endereco endereco){
		return bancoDados.buscar(endereco);
		
	}
	
	public void atualizar (Endereco endereco){
		bancoDados.atualizar(endereco);
		
	}

}
