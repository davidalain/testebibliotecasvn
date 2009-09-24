package Exercicio5ListaEncadeada;

import util.LinkedList;
import util.ListIterator;
import util.Node;

public class ListaOrdenadaInteiros{

	private Node first;
	private Node last;
	private int tamanho;

	public ListaOrdenadaInteiros (Integer a){
		this.first = new Node(a);
		this.last = this.first;
		this.tamanho = 1;
	}

	public void inserir (int valor){

		if (exists(valor)){
			throw new RuntimeException("Valor já existe, não pode adicionar");
		}
		//a lista esta vazia
		if (this.first == null){
			this.first = new Node(new Integer(valor));
			this.last = this.first;
		}
		else {

			Node inser = new Node(new Integer(valor));

			//o primeiro elemento da lista é maior do que o que queremos add
			//logo o valor que queremos inserir tem que ir para o começo da lista
			if (((Integer)this.first.getInfo()).intValue() > valor){
				inser.setNext(this.first);
				this.first = inser;
			}
			else {

				// se o elemento que eu quero adicionar é o último
				if (((Integer)this.last.getInfo()).intValue() < valor){
					this.last.setNext(inser);
					this.last = inser;

				}
				else {
					Node previous = null;
					Node atual = this.first;

					while(atual != null){
						if (((Integer)atual.getInfo()).intValue() < valor  ){
							previous = atual;
							atual = atual.getNext();
						}
						else {
							previous.setNext(inser);
							inser.setNext(atual);
							break;
						}
					}//while
				}
			}

		}//casos gerais



		this.tamanho ++;
	}

	public void imprimirLista(){

		if (this.first == null){
			System.out.println("lista vazia");
		}
		else {
			Node atual = this.first;

			while(atual != null){
				System.out.println(atual.getInfo());
				atual = atual.getNext();
			}

		}

	}

	public void remover (int valor){

		if (exists(valor)){

			// caso o valor a ser removido esteja na primeira posição
			if (((Integer)first.getInfo()).intValue() == valor){
				this.first = first.getNext();
			}
			//caso geral
			else {
				Node atual = this.first;
				Node previous = null;

				while (((Integer)atual.getInfo()).intValue() != valor ){
					previous = atual;
					atual = atual.getNext();
				}
				if (atual == this.last){
					this.last = previous;

				}
				previous.setNext(atual.getNext());
				atual.setNext(null);

			}

		}
		else {
			throw new RuntimeException("O valor não existe");
		}


		this.tamanho--;
	}

	public boolean exists (int valor){

		Node atual = this.first;
		boolean flag = false;

		while(atual != null){
			if (((Integer)atual.getInfo()).intValue() == valor )
				return true;

			atual = atual.getNext();

		}
		return flag;

	}


	public int encontrarEm(int posicao){
		if (this.first == null || posicao > this.tamanho || posicao < 0){
			throw new RuntimeException("Posicao invalida");
		}
		ListIterator it = getIterator();
		int i = 0;
		while (i != posicao-1){
			it.advance();
			i++;
		}

		return ((Integer)it.retrieve()).intValue();


	}

	public void removerEm (int posicao) {

		if (posicao < 0 || posicao > this.tamanho){
			throw new RuntimeException("Posicao é invalida");
		}
		else {
			
			this.remover(encontrarEm(posicao));
		}
		

	}

	public ListIterator getIterator(){
		return new ListIterator(this.first);
	}


}
