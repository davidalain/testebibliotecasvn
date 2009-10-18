package br.com.bibliotecavirtual.lib.livros;

import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;

public class LivroDAO {
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCAR = "buscar";
	private static final String MAPEAMENTO = Funcionario.class.getName();
	private IConexao conexao;
	
	public LivroDAO(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.conexao = factory.getConexao();
	}
	
	public void inserir (Livro livro){
		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String isbn = livro.getIsbn();
		String area = livro.getArea();
		String ano = livro.getAno();
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		

		
		
	}
	
	
}
