package br.com.bibliotecavirtual.lib.alugueis;

import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public interface IAluguelDAO 
{
	public void inserir(Aluguel aluguel);
	
	public void remover(int id);
	
	public void atualizar(Aluguel aluguel);
	
	public void buscarPorID(int id);
	
	public Collection<Aluguel> buscarPorPeriodo(Date dataInicial, Date dataFinal);
	
	public Collection<Aluguel> buscarPorAluno(Aluguel aluguel);

	public Collection<Aluguel> buscarPorExemplar(Exemplar exemplar);	
}
