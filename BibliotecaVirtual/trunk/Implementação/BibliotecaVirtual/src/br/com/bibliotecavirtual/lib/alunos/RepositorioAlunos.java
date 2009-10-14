package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioAlunos {
	
	private Conexao conexao = new Conexao();
	
	public RepositorioAlunos(){
		conexao = this.conexao;
	}
	
	public void inserir(Aluno a){
		
	}
	
	public void remover (Aluno a){
		
	}
	
	public void atualizar(Aluno a){
		
	}
	
	public ResultSet buscar (String cpf){
		
		
		return null;
	}

	
	
	
}
