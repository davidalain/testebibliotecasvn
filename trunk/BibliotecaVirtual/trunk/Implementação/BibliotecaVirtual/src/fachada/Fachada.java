package fachada;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;


public class Fachada 
{
	private static Fachada instance ;
	
	private ControladorAluno controladorAluno;
	
	private Fachada()
	{
		this.controladorAluno = new ControladorAluno();
	}
	
	public static Fachada getInstance()
	{
		if(instance == null)
		{
			instance = new Fachada();
		}
		return instance;
	}
	
	public boolean validarSituacaoCadastralAluno(String matricula) throws SQLException
	{
		return this.controladorAluno.validarSituacaoCadastral(matricula);
	}
	
	public void cadastrarAluno(Aluno a) throws SQLException
	{
		this.controladorAluno.cadastrarAluno(a);
	}
	
	
}
