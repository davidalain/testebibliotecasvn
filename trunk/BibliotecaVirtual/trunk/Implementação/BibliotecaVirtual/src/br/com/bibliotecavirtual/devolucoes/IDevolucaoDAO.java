package br.com.bibliotecavirtual.devolucoes;

import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public interface IDevolucaoDAO {
	public int buscarPorExemplarCont(Exemplar exemplar);
}
