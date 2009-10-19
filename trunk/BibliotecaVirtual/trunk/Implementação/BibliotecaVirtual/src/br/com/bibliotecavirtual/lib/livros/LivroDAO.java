package br.com.bibliotecavirtual.lib.livros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;

public class LivroDAO implements ILivroDAO{
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCARPORISBN = "buscarPorISBN";
	private static final String BUSCARPORID = "buscarPorID";
	
	private static final String MAPEAMENTO = Livro.class.getName();
	private IConexao conexao;
	
	public LivroDAO(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.conexao = factory.getConexao();
	}
	
	public void inserir (Livro livro) throws SQLException{
		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String isbn = livro.getIsbn();
		String area = livro.getArea();
		String ano = livro.getAno();
		String resumo = livro.getResumo();
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(titulo);
		parametros.add(autor);
		parametros.add(area);
		parametros.add(ano);
		parametros.add(resumo);
		parametros.add(isbn);
		conexao.executeNonQuery(MAPEAMENTO, LivroDAO.INSERIR, parametros);
	}
	
	public void remover (String isbn) throws SQLException{
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(isbn);
		conexao.executeNonQuery(MAPEAMENTO, LivroDAO.REMOVER, parametros);
	}
	
	public void atualizar (Livro livro) throws SQLException{
		
		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String isbn = livro.getIsbn();
		String area = livro.getArea();
		String ano = livro.getAno();
		String resumo = livro.getResumo();
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(titulo);
		parametros.add(autor);
		parametros.add(area);
		parametros.add(ano);
		parametros.add(resumo);
		parametros.add(isbn);
		parametros.add(isbn);
		
		conexao.executeNonQuery(MAPEAMENTO, LivroDAO.ATUALIZAR, parametros);
	}
	
	public Livro buscarPorISBN (String isbn) throws SQLException{
	
		Livro livroRetorno = null;
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(isbn);
		ResultSet rs = conexao.executeQuery(MAPEAMENTO, LivroDAO.BUSCARPORISBN, parametros);
		
		if (rs.next()){
			livroRetorno = new Livro(rs.getInt("ID"),rs.getString("TITULO"), rs.getString("AUTOR"), 
					rs.getString("ISBN"), rs.getString("AREA"), 
					rs.getString("ANO"), rs.getString("RESUMO"));
		}
		return livroRetorno;
	}

	public Livro buscarPorID (int id) throws SQLException{
		
		Livro livroRetorno = null;
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		ResultSet rs = conexao.executeQuery(MAPEAMENTO, LivroDAO.BUSCARPORID, parametros);
		
		if (rs.next()){
			livroRetorno = new Livro(rs.getInt("ID"),rs.getString("TITULO"), rs.getString("AUTOR"), 
					rs.getString("ISBN"), rs.getString("AREA"), 
					rs.getString("ANO"), rs.getString("RESUMO"));
		}
		
		return livroRetorno;
	}
	
	public boolean existe (String isbn) throws SQLException{
		return this.buscarPorISBN(isbn) != null;
	}
	
	
	
}
